package com.ivangrod.needlehackpost.infrastructure

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class NeedlehackPostAnalyzerApplication

fun main(args: Array<String>) {
    SpringApplication.run(NeedlehackPostAnalyzerApplication::class.java, *args)
}
