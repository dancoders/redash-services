package com.dancoder.redash.web;

import com.dancoder.redash.api.DataSourceService;
import com.dancoder.redash.api.model.DataSourceModel;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping("/data_sources")
    public List<DataSourceModel> getList(){
        return dataSourceService.getList();
    }
}
