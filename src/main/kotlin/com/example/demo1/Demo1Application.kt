package com.example.demo1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Demo1Application{
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Demo1Application>(*args)
        }
    }
}


