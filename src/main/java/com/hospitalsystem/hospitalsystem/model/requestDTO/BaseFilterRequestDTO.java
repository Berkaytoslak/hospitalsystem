package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.model.SortDTO;
import com.hospitalsystem.hospitalsystem.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
