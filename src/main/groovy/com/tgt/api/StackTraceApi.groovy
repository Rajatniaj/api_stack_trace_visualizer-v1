package com.tgt.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

/**
 * Created by z001t7s on 2/21/17.
 */
@SpringBootApplication
@ComponentScan(basePackages = ['com.tgt.api'])
class StackTraceApi {

     static void main(String[] args) {
        SpringApplication.run(StackTraceApi.class, args)
    }
}
