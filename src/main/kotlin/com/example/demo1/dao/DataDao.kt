package com.example.demo1.dao

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import javax.annotation.Resource


@Repository
class DataDao {
    @Resource
     lateinit var jdbc: JdbcTemplate

}