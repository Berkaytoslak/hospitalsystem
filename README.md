# Genel Konsept (Sağlık Turizmi Projesi)
### Sistem tasarımı
* Spring Initializr kullanarak proje oluşturulmuştur.
* Bağımlılıklar eklenmiştir. (Jpa, postgre, security, lombok, WEB vb.)
* JPA ile hastalar, doktorlar, otel,uçak ve uçuş bilgileri, randevevu, reçete, rezervasyon tabloları oluşturulmuştur.
* Varlıklar arasındaki ilişkiler kurulmuştur.(OneToMany, ManyToMany vb.)
* Kullanıcı kimlik doğrulaması ve yetkilendirme için Spring Security kullanılmıştır. (JWT)

### Kullanıcı tasarımı
* Hastaların, Doktorların ve Admin yetkisine sahip kullanıcılar bu sistemi kullanabilirler.
* Hastalar, istediği tarih aralığında müsait olan hastane ve doktorlarından randevu alabilirler.
* Aldıkları randevuya göre otel ve oda rezervasyonu yapabilirler.
* Hastane ve otel randevularına göre uygun olan uçuşu aynı şehirde olmak kaydı ile rezervasyon oluşturabilirler.
* Randevu sonucuna göre doktorlar hastlar için reçete oluşutup ilaç kaydı oluşturabilirler.
* Sistemde kaydı olmayanlar sadece hastane ve doktor sorgusu atabilirler fakat randevu alamazlar.
* Reçete oluşturulması için hastane randevusu gerekmektedir.

### ALL (Yetkisiz erişilebilen uzntılar)
```Java
private static final String[] AUTH_WHITELIST = {
        "/auth/**",
        "/swagger-ui/**",
        "v3/api-docs/**",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        "/v3/api-docs/**",
        "/api/public/**",
        "/api/public/authenticate",
        "/actuator/*",
        "/swagger-ui/**"

        };
......
        .requestMatchers(AUTH_WHITELIST).permitAll()
```
### Hasta (User)

User rolüne sahip kullanıcılar hastane, doktor, otel ve uçuş kaydı oluşturabilir:

* Spring security kullanılarak User yetkisine sahip kullanıcılar oluşturulabilir.
```Java
private static final String[] USER_AUTH_WHITELIST = {
        "/patient",
        "/patient/**",
        "/reservation",
        "/reservation/**",
        "/flight/**",
        "/room/**",
        "/hotel/**",
        "/doctor/**"

        };
......
.requestMatchers(USER_AUTH_WHITELIST).hasRole("user")
```
* Yukarda görüldüğü gibi kullanıcılar bu kayıtları oluşturabilmesi için yetkiler eklenmiştir.
* Hastlar randevu kaydı, otel ve uçuş rezervasyonları ekleyebilirler. Aşağıda örnek verilmiştir.
```Java
@PostMapping("reservation-doctor")
    public ResponseEntity<ReservationEntity> reservationHospitalAndDoctor(@RequestBody DoctorDTO doctorDTO, @RequestParam LocalDateTime dateTime){
        return new ResponseEntity<>(reservationService.reservationHospitalAndDoctor(doctorDTO,dateTime), HttpStatus.OK);
    }
    @PostMapping("reservation-flight")
    public ResponseEntity<ReservationEntity> reservationFlight(@RequestBody FlightDTO flightDTO, @RequestParam UUID uuid){
        return new ResponseEntity<>(reservationService.reservationFlight(flightDTO,uuid), HttpStatus.OK);
    }
    @PostMapping("reservation-room")
    public ResponseEntity<ReservationEntity> reservationRoom(@RequestBody RoomDTO roomDTO, @RequestParam UUID uuid){
        return new ResponseEntity<>(reservationService.reservationRoom(roomDTO,uuid), HttpStatus.OK);
    }
```
* Hastlar randevu oluştururken doktor ve hastnae müsaitliğine göre almalıdır.
* Randevu oluştuktan sonra otel ve oda rezervasyonu aynı tarih aralığında ve aynı şehirde olmak zorundadır.
* Uçuş randevusu da aynı şekilde randevu ve otel rezervasyonu tarih aralığında aynı şehire olacak şekilde olmalıdır.

```Java
@Scheduled(fixedRate = 100000)
public void reservationCheck(){
            List<ReservationEntity> reservationEntities = reservationEntityRepository.findAll();
                for (ReservationEntity reservationEntity : reservationEntities){
                if (reservationEntity.getHotelId() == null && reservationEntity.getFlightId() == null){
                reservationEntityRepository.delete(reservationEntity);
                log.info("Hotel kaydı olmayan rezervasyon silindi");
                }
            }
        }
```
* Eğer uçuş randevusu alırken 10 dk süre sınırı aşılırsa süreç iptal olmaktadır.

### Doktor (Doctor)

Doctor rolüne sahip kullanıcılar reçete ve hastane kaydı oluşturabilir:
* Spring security kullanılarak Doctor yetkisine sahip kullanıcılar oluşturulabilir.
```Java
private static final String[] DOCTOR_AUTH_WHITELIST = {
        "/prescriptions",
        "/prescriptions/**"

        };
......
.requestMatchers(DOCTOR_AUTH_WHITELIST).hasRole("doctor")
```
* Hastlar randevu oluşturduktan sonra doktorlara atanır.
* Doktorlar bu randevuya göre hastalar için reçete oluşturabilir.
```Java
@PostMapping("prescriptions-create")
    public ResponseEntity<PrescriptionsEntity> prescriptionsCreate(@RequestBody PrescriptionsRequestDTO prescriptionsRequestDTO,@RequestParam String tc ){
        return new ResponseEntity<>(prescriptionsService.prescriptionsCreate(prescriptionsRequestDTO,tc), HttpStatus.OK);
    }
```
* Reçete oluşturmak için doctor rolüne sahip olmak ve hastanın o doktor için randevu kaydı oluşturması gerekmektedir.

### Admin (Admin)

Admin rolüne sahip kullanıcılar hastane,doktor, otel ve uçuş kaydı oluşturabilir:

```Java
private static final String[] ADMIN_AUTH_WHITELIST = {
            "/patient",
            "/patient/**",
            "/hospital",
            "/hospital/**",
            "/doctor",
            "/doctor/**",
            "/hotel",
            "/hotel/**",
            "/room",
            "/room/**",
            "/flight",
            "/flight/**"

    };
......
.requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("admin")
```
* Admin yetkisine sahip kullanıcılar kayıt atması için BaseServie sınıfının içinde ki default metodları kullanmaktadır.

```Java
 @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDto requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageDTO<DTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        return new ResponseEntity<>(getService().getAll(baseFilterRequestDTO), HttpStatus.OK);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDto requestDTO) {
        if (getService().update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<Boolean> deleteByUUID(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().deleteByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{uuid}")
    public ResponseEntity<DTO> getByUUID(@PathVariable UUID uuid) {
        DTO dto = getService().getByUUID(uuid);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
```
* Admin kullanıcılar tüm sorguları atabilir ve değiştirme yetkisine sahiptir.
* Admin oda kayıtları oluşturabilir.
* Yeni hastane ve doktor kayıtları oluşturabilir.

```Java
@PostMapping("add-room")
    public ResponseEntity<RoomDTO> addOtherRelations(@RequestBody RoomRequestDTO roomRequestDTO){
        return new ResponseEntity<>(roomService.save(roomRequestDTO), HttpStatus.OK);

    }
```

### SQL DIAGRAM

![ss diagram.png](ss%20diagram.png)

