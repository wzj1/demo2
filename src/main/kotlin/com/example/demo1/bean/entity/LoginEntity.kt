package com.example.demo1.bean.entity

import org.springframework.stereotype.Repository

/**
 * 登录 Bean类
 */
@Repository
class LoginEntity {
    //id
    var id:Int = 0
    //登录账号
    lateinit var account:String
    //登录密码
    lateinit var password:String
    var accountName:String?=""
    //登录类型: 0 手机号 1 邮箱账号 2 用户名  3 其他(暂不支持)
    var login_type:Int= 0
}