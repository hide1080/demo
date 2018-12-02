package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class GreetingControllerTest extends Specification {
    @Autowired
    MockMvc mvc
    void setup() {
    }

    void cleanup() {
    }

    def "Greeting"() {
        expect:
        mvc.perform(
                get("/greeting").param("name", "hide1080")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string('{"id":1,"content":"Hello, hide1080!"}')
        )
    }
}
