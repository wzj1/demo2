package com.example.demo1.controller

import com.example.demo1.bean.entity.LoginEntity
import com.example.demo1.bean.entity.ResultData
import com.example.demo1.dao.DataDao
import com.example.demo1.returndataUtils.GetResultData
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/demo")
class MainController {

    @Resource
    lateinit var service:DataDao

    @RequestMapping("/login")
    @ResponseBody
    fun getUserVO(@RequestBody data: ResultData<LoginEntity>?): String {
            if (data!=null){
                val loginEn = data.data




            }

        return GetResultData.failure300("参数错误")
    }



}