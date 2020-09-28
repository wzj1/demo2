package com.example.demo.dao.sqlutil

import org.springframework.jdbc.core.JdbcTemplate

class FindData(val jdbc:JdbcTemplate):ISqlinfo() {

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

}