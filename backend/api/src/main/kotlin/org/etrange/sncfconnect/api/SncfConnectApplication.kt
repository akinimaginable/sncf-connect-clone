package org.etrange.sncfconnect.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["org.etrange.sncfconnect"])
class SncfConnectApplication

fun main(args: Array<String>) {
    runApplication<SncfConnectApplication>(*args)
}
