package com.example.demo1.dao.sqlutil

import com.example.demo1.bean.entity.LoginEntity
import org.springframework.jdbc.core.JdbcTemplate

class  UpdateSql(val jdbc:JdbcTemplate) : ISqlinfo() {

    /**
     * 登录logininfo表
     * 更改及插入
     */
    fun  updateUserInfo(t: LoginEntity?):String{
         if (t!=null) {
             var sql ="INSERT INTO  $login_Table (account,password,accountName,login_type) VALUES('${t.account}','${t.password}','${t.accountName}','${t.login_type}')"
             printlnSqlLog(sql)
             val update = try {
                 jdbc.update(sql){
                 }
             } catch (e: Exception) {
                 return "1"
             }
             printlnSqlLog(update.toString())
             if (update > 0) {
                 return "0"
             }
         }
         return "1"


    }

    /**
     * 登录修改密码
     */
    fun  updateLoginPwd(t: LoginEntity?):String{
        if (t!=null) {
            // 封装 JDBC处理类
            val findByName = FindData(jdbc).findByName(t.account)
            if (findByName!=1) return "1"
            var sql ="UPDATE $login_Table SET password='${t.password}'  where account='${t.account}' "
            printlnSqlLog(sql)
            val update = try {
                jdbc.update(sql){
                }
            } catch (e: Exception) {
                return "1"
            }
            printlnSqlLog(update.toString())
            if (update > 0) {
                return "0"
            }
        }
        return "1"
    }

    /**
     * 登录修改密码
     */
    fun  updateLogin(t: LoginEntity?):String{
        if (t!=null) {
            // 封装 JDBC处理类
            val findByName = FindData(jdbc).findByName(t.account)
            if (findByName!=1) return "1"
            // 修改的参数
            val map = HashMap<String,Any>()
            map["login_type"] = t.login_type
            map["accountName"] = t.accountName.toString()
            //条件
            val map1 = HashMap<String,Any>()
            map1["account"] = t.account

            val sql = update(login_Table,map,map1)
            printlnSqlLog(sql)
            val update = try {
                jdbc.update(sql){
                }
            } catch (e: Exception) {
                return "1"
            }
            printlnSqlLog(update.toString())
            if (update > 0) {
                return "0"
            }
        }
        return "1"
    }
}