package com.redash.controller;


import com.redash.dto.DataSourceDTO;
import com.redash.service.DataSourceService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dancoder
 */
@Component
@RestController
public class DataSourceController {

    private final DataSourceService dataSourceService;

    public DataSourceController(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @GetMapping("/data_sources")
    public List<DataSourceDTO> getList(){
        return dataSourceService.getList();
    }
}
