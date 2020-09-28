package com.example.demo1.returndataUtils

import com.google.gson.JsonObject

/**
 * 返回数据 封装类
 */
object GetResultData {
    var json: JsonObject = JsonObject()

    fun success200(data: HashMap<String, Any?>, msg: String?): String {
        json.addProperty("code","200")
        json.addProperty("msg",msg)
        return json.toString()
    }

    fun success200(data:String?,msg: String?): String {
        json =JsonObject()
        json.addProperty("code","200")
        json.addProperty("data",data)
        json.addProperty("msg",msg)
        return log(json.toString())
    }

    fun success200(msg: String?): String {
        json =JsonObject()
        json.addProperty("code","200")
        json.addProperty("msg",msg)
        return log(json.toString())
    }

    fun success200(): String {
        json =JsonObject()
        json.addProperty("code","200")
        json.addProperty("msg","成功")
        return log(json.toString())
    }


     fun failure300(data: HashMap<String, Any?>, msg: String?): String {
         json =JsonObject()
         json.addProperty("code","300")
         json.addProperty("msg",msg)
         return log(json.toString())
    }

    fun failure300(data:String?,msg: String?): String {
        json =JsonObject()
        json.addProperty("code","300")
        json.addProperty("data",data)
        json.addProperty("msg",msg)
        return log(json.toString())
    }

    fun failure300(msg: String?): String {
        json =JsonObject()
        json.addProperty("code","300")
        json.addProperty("msg",msg)
        return log(json.toString())
    }

    fun failure300(): String {
        json =JsonObject()
        json.addProperty("code","300")
        json.addProperty("msg","失败")
        return log(json.toString())
    }

    fun  log(json:String):String{
        println("json:$json")
        return json
    }

}