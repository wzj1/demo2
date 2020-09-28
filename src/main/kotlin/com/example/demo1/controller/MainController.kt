package com.example.demo1.controller

import com.example.demo1.bean.entity.LoginEntity
import com.example.demo1.bean.entity.ResultData
import com.example.demo1.bean.entity.UserInfo
import com.example.demo1.dao.DataDao
import com.example.demo1.dao.LoginSqlUtil
import com.example.demo1.dao.impl.DataImpl
import com.example.demo1.dao.sqlutil.UpdateSql
import com.example.demo1.returndataUtils.GetResultData
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@Controller
//@RequestMapping(value = ["/main"])
class MainController {
    @Resource
    lateinit var service: DataImpl

    /**
     * 登录
     */
    @PostMapping(value = ["/main/login"], consumes = ["application/json"])
    @ResponseBody
    fun login(@RequestBody data: ResultData<LoginEntity>): String {
        // 封装 JDBC处理类
        return LoginSqlUtil.setJdbcTemplate(service.jdbc).loginStr(data.data)
    }


    /**
     * 修改密码
     */
    @PostMapping(value = ["/main/updatePwd"], consumes = ["application/json"])
    @ResponseBody
    fun updatePwd(@RequestBody data: ResultData<LoginEntity>): String {
        // 封装 JDBC处理类
        return UpdateSql(jdbc = service.jdbc).updateLoginPwd(data.data)
    }


    /**
     * 插入数据
     */
    @PostMapping(value = ["/main/addUserinfo"], consumes = ["application/json"])
    @ResponseBody
    fun insertData(@RequestBody data: ResultData<UserInfo?>): String {
        // 封装 JDBC处理类

        val data1 = data.data
        if (data1 !=null) {
           val str =UpdateSql(jdbc = service.jdbc).updateTable<UserInfo>(data1)
            return str
        }
        return GetResultData.failure300("参数错误")
    }



}