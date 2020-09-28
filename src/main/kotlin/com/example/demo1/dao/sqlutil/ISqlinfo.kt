package com.example.demo1.dao.sqlutil

/**
 * sql 操作 抽象类
 * 定义 sql中语句中的一些公共方法和参数
 */
abstract class ISqlinfo {
    //登录表
    val login_Table: String = "logininfo"
    //登录表主键。自增
    val login_SEQ:String ="seq_logininfo.nextval,"

    // 用户表
    val user_table: String = "user"

    //用户信息表
    val userinfo_table: String = "user_info"
    //用户信息表主键。自增
    val userInfo_SEQ:String ="seq_userinfo.nextval,"

    val insert = "insert into "
    val update = "update "
    val select = "select "
    val delete = "delete "
    val where = " where "
    val from = " from "
    fun <T> getCount(str: T) = " count($str) "

    //删除表
    val deleteLogin = "$delete $login_Table "
    val deleteUser = "$delete $user_table "
    val deleteUserInfo = "$delete $userinfo_table "

    // 查询表
    val selectLogin = "$select * $from  $login_Table "
    val selectUser = "$select * $from $user_table "
    val selectUserInfo = "$select * $from $userinfo_table "
    //查询表中的数据
    val selectLoginCount = "$select count(*)  $from $login_Table "
    val selectUserCount = "$select count(*)  $from $user_table "
    val selectUserInfoCount = "$select count(*)  $from $userinfo_table "


    /**
     * 插入语句
     * key = value 形式
     */

    fun update(table: String,id_SEQ: String, map: MutableMap<String, Any>, map1: MutableMap<String, Any>): String {

        return  update(table,id_SEQ, map, map1,true)
    }


    /**
     * 插入语句
     * key = value 形式
     * @param id_SEQ 自增主键ID
     */

    fun update(table: String,id_SEQ: String, map: MutableMap<String, Any>, map1: MutableMap<String, Any>,isMap1:Boolean): String {
        val sb = StringBuffer()
        val sb1 = StringBuffer()
        var isID =0;
        var status:Int = 0
        var status1:Int = 0

            map.mapKeys {
                //判断是否为基本数据类型
                val isInteger = isAny(it.value!!)
                if (map.size > 1 && status != map.size - 1) {
                    if (it.key!="id"){


                    if (isInteger) {

                        sb.append("${it.key} = ${it.value},")
                    } else {
                        sb.append("${it.key} = '${it.value}',")
                    }
                    }
                } else {
                    if (it.key!="id") {
                        if (isInteger) {
                            sb.append("${it.key} = ${it.value} ")
                        } else {
                            sb.append("${it.key} = '${it.value}' ")
                        }
                    }
                }
                status++
            }

        if (isMap1) {

            map1.mapKeys {
                //判断是否为基本数据类型
                val isInteger = isAny(it.value)
                if (map1.size > 1 && status1 != map1.size - 1) {
                    if (isInteger) {
                        sb1.append("${it.key} = ${it.value}  and ")
                    } else {
                        sb1.append("${it.key} = '${it.value}'  and ")
                    }
                } else {
                    if (isInteger) {
                        sb1.append("${it.key} = ${it.value}   ")
                    } else {
                        sb1.append("${it.key} = '${it.value}'   ")
                    }
                }
                status1++
            }
        }
        var sql = ""
        if (!isMap1){
            return "update  $table set $sb "
        }
        sql = "update  $table set  $sb  where  $sb1"
        printlnSqlLog(sql)
        return  sql
    }



    /**
     * 打印输入sql语句
     * @param sql
     */
    fun printlnSqlLog(sql: String): String {
        println("sql:$sql")
        return sql
    }

    /**
     * //判断是否为基本数据类型
     * @param type 数据
     */
    fun isAny(type: Any): Boolean {

        when (type) {
            is Int -> return true
            is Double -> return true
            is Float -> return true
        }
        return false
    }


}
