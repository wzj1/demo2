package com.example.demo1.dao.impl

import com.example.demo1.dao.DataDao
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class DataImpl:DataDao() {
    @Resource
   lateinit var dataDao: DataDao



}