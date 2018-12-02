package com.example.demo

import spock.lang.Specification

class GreetingTest extends Specification {
    def id = 1
    def content = "hello"
    def greeting = Greeting.of(id, content)

    void setup() {
    }

    void cleanup() {
    }

    def "GetId"() {
        expect:
        greeting.id == id
    }

    def "GetContent"() {
        expect:
        greeting.content == content
    }
}
