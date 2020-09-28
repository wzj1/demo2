package com.example.demo1.dao.sqlutil

import com.example.demo1.bean.entity.LoginEntity
import com.example.demo1.bean.entity.UserInfo
import org.springframework.jdbc.core.JdbcTemplate

class FindData(val jdbc:JdbcTemplate): ISqlinfo() {

    /**
     * 查找登录表中是否存在
     */
    fun findByName(account:String?):Int{
        if (!account.isNullOrBlank()) {
            val sql = "$select count(*) $from $login_Table  $where account='$account'"
            printlnSqlLog(sql)
            val i = jdbc.queryForObject(sql, Int::class.java)
            printlnSqlLog("查询登录查询的数据是否有数据 :$i")
            if (i != null) {
                return i
            }
        }
        return -1
    }
    /**
     * 查找登录表中是否存在
     */
    fun <T>findByName(cla:T?):Int{
        var tableStr:String = ""
        var account:T? = null
        when(cla){
            is UserInfo -> {
                tableStr = userinfo_table
                if (!cla.account.isNullOrBlank()) {
                    val sql = "$select count(*) $from $tableStr  $where account='${cla.account}'"
                    printlnSqlLog(sql)
                    val i = jdbc.queryForObject(sql, Int::class.java)
                    printlnSqlLog("查询登录查询的数据是否有数据 :$i")
                    if (i != null) {
                        return i
                    }
                }
            }
            is LoginEntity -> {
                tableStr = login_Table
                if (!cla.account.isNullOrBlank()) {
                    val sql = "$select count(*) $from $tableStr  $where account='${cla.account}'"
                    printlnSqlLog(sql)
                    val i = jdbc.queryForObject(sql, Int::class.java)
                    printlnSqlLog("查询登录查询的数据是否有数据 :$i")
                    if (i != null) {
                        return i
                    }
                }
            }

        }
        return -1
    }


    /**
     * 查找登录表中是否存在
     */
    fun findByName(table:String,account:String?):Int{
        if (!account.isNullOrBlank()) {
            val sql = "$select count(*) $from $table  $where account='$account'"
            printlnSqlLog(sql)
            val i = jdbc.queryForObject(sql, Int::class.java)
            printlnSqlLog("查询登录查询的数据是否有数据 :$i")
            if (i != null) {
                return i
            }
        }
        return -1
    }

}