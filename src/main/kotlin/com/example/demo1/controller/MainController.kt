package com.example.demo1.controller

import com.example.demo1.bean.entity.LoginEntity
import com.example.demo1.bean.entity.ResultData
import com.example.demo1.dao.DataDao
import com.example.demo1.dao.LoginSqlUtil
import com.example.demo1.returndataUtils.GetResultData
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@Controller
@RequestMapping(value = ["/main"])
class MainController {

    @Resource
    lateinit var service:DataDao

    @PostMapping(value = ["/login"], consumes = ["application/json"])
    @ResponseBody
    fun login(@RequestBody data: ResultData<LoginEntity>): String {
        // 封装 JDBC处理类
        return LoginSqlUtil.setJdbcTemplate(service.jdbc).loginStr(data.data)
    }



}