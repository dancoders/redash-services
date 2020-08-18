package com.dancoder.redash.framework.config;

import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

@Component
@MapperScan("com.dancoder.redash.dao.mapper")
public class MybatisConfig {
}
