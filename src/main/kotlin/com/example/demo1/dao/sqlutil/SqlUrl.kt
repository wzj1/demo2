package com.example.demo1.dao.sqlutil

import com.example.demo.dao.sqlutil.ISqlinfo
import com.example.demo1.bean.entity.LoginEntity

/**
 * SQL 语句 拼接类
 */

object SqlUrl : ISqlinfo() {

    /**
     * 登录 sql
     * @param login  登录类对象
     */
    fun getLoginSql(login: LoginEntity):String{
        var sql:String = "select * from $login_Table where account='${login.account}'"
        println("getLoginSql :$sql")
        return printlnSqlLog(sql)
    }

    /**
     * 获取用户信息
     * @param login  登录类对象
     */
    fun getLoginInfoSql(account:String):String{
        var sql:String = "select * from $userinfo_table where account='$account'"
        return printlnSqlLog(sql)
    }

    /**
     * 注册账号
     */
    fun getRegisterSql(login: LoginEntity):String{
        var sql:String = "INSERT INTO  $login_Table (account,password,accountName,type) VALUES('${login.account}','${login.password}','${login.accountName}',${login.login_type})"
        return printlnSqlLog(sql)
    }

//    /**
//     * 注册用户信息
//     */
//    fun getRegisterInfoSql(userInfo: UserInfo):String{
//        var sql:String = "INSERT INTO  $userinfo_table " +
//                "(userName,userAge,userSex,userCardName,userCardID,userEmail,userPhone,userCall,registerAddress)" +
//                "VALUES('${userInfo.userName}',${userInfo.userAge},'${userInfo.userSex}','${userInfo.userCardName}'" +
//                ",'${userInfo.userCardID}','${userInfo.userEmail}','${userInfo.userPhone}','${userInfo.userCall}','${userInfo.registerAddress}')"
//        println("getRegisterInfoSql :$sql")
//        return printlnSqlLog(sql)
//    }

}