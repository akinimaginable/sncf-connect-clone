package org.etrange.sncfconnect.api

import org.etrange.multimodule.service.MyService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTest {
    @Autowired
    private val myService: MyService? = null

    @Test
    fun contextLoads() {
        assertThat(myService.message()).isNotNull()
    }
}
