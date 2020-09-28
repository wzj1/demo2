package com.example.demo1.bean.entity

import org.springframework.stereotype.Repository

/**
 * 新用户信息
 */
@Repository
class UserInfo {
    //id
    var id: Int = 0
    //用户账号
    var account: String? = null
    //用户姓名
    var userName: String? = null
    //用户性别
    var userSex: String? = null
    //用户年龄
    var userAge: Int = 0
    //身份证姓名
    var userCardName: String? = null
    //身份证号
    var userCardID: String? = null
    //用户邮箱号
    var userEmail: String? = null
    //用户手机号
    var userPhone: String? = null
    //用户固定电话
    var userCall: String? = null
    //注册地址
    var registerAddress: String? = null
    //默认地址
    var defaultAddress: String? = null
}