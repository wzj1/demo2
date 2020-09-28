package com.example.demo1.dao.sqlutil

import com.example.demo1.bean.entity.LoginEntity
import com.example.demo1.bean.entity.UserInfo
import com.example.demo1.returndataUtils.GetResultData
import org.springframework.jdbc.core.JdbcTemplate

class UpdateSql(val jdbc: JdbcTemplate) : ISqlinfo() {


    /**
     * 登录logininfo表
     * 更改及插入
     */
    fun updateUserInfo(t: LoginEntity?): String {
        if (t != null) {
            var sql = "INSERT INTO  $login_Table (account,password,accountName,login_type) VALUES('${t.account}','${t.password}','${t.accountName}','${t.login_type}')"
            printlnSqlLog(sql)
            val update = try {
                jdbc.update(sql) {
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
    fun updateLoginPwd(t: LoginEntity?): String {
        if (t != null) {
            // 封装 JDBC处理类
            val findByName = FindData(jdbc).findByName(t.account)
            if (findByName != 1) return "1"
            var sql = "UPDATE $login_Table SET password='${t.password}'  where account='${t.account}' "
            printlnSqlLog(sql)
            val update = try {
                jdbc.update(sql) {
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
    fun updateLogin(t: LoginEntity?): String {
        if (t != null) {
            // 封装 JDBC处理类
            val findByName = FindData(jdbc).findByName(t.account)
            if (findByName != 1) return "1"
            // 修改的参数
            val map = HashMap<String, Any>()
            map["login_type"] = t.login_type
            map["accountName"] = t.accountName.toString()
            //条件
            val map1 = HashMap<String, Any>()
            map1["account"] = t.account

            val sql = update(login_Table,login_SEQ, map, map1)
            printlnSqlLog(sql)
            val update = try {
                jdbc.update(sql) {
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
     *  插入数据
     */
    fun <T> updateTable(t: T): String {
        var mapOf = mutableMapOf<String, Any>()
        if (t is UserInfo) {
            val size = FindData(jdbc).findByName<UserInfo>(t)
            if (size > 0) {
                return GetResultData.failure300("当前用户已存在")
            }
            mapOf = mutableMapOf()
            for (i in t.javaClass.declaredFields) {
                try {
                    val synthetic = i.isSynthetic
                    i.isAccessible = true
                    val get = i.get(t)
                    if (get != null) {
                        mapOf[i.name] = get
                    }
                    i.isAccessible = synthetic
                } catch (e: Exception) {
                    return GetResultData.failure300("数据转map异常")
                }
            }
            if (t.account.isNullOrBlank()) {
                return GetResultData.failure300("账号出现错误")
            }
            val map1 = HashMap<String, Any>()
            map1["account"] = t.account!!

            val sql = update(userinfo_table, userInfo_SEQ,mapOf, map1, false)
            val status = updateSql(sql)
            if (status != 0) {
                return GetResultData.success200("保存成功")
            }
            return GetResultData.success200("保存失败")

        } else if (t is LoginEntity) {
            val size = FindData(jdbc).findByName<LoginEntity>(t)
            if (size > 0) {
                return GetResultData.failure300("当前用户已存在")
            }
            mapOf = mutableMapOf()
            for (i in t.javaClass.declaredFields) {
                try {
                    val synthetic = i.isSynthetic
                    i.isAccessible = true
                    val get = i.get(t)
                    if (get != null) {
                        mapOf[i.name] = get
                    }
                    i.isAccessible = synthetic
                } catch (e: Exception) {
                    return GetResultData.failure300("数据转map异常")
                }
            }
            if (t.account.isNullOrBlank()) {
                return GetResultData.failure300("账号出现错误")
            }
            val map1 = HashMap<String, Any>()
            map1["account"] = t.account

            val sql = update(userinfo_table,userInfo_SEQ, mapOf, map1, false)
            val status = updateSql(sql)
            if (status != 0) {
                return GetResultData.success200("保存成功")
            }
            return GetResultData.success200("保存失败")
        }

        return GetResultData.failure300("json数据类型转换错误")
    }

    /**
     * 插入和更新 数据SQL 语句
     */
    fun updateSql(sql: String): Int {
        var status = 0
        printlnSqlLog(sql)
        status = try {
            jdbc.update(sql) {
            }
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }

        return status
    }


}