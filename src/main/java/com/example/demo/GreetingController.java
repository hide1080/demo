package com.example.demo;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.jooq.example.db.h2.Tables.GREETING;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private DSLContext dsl;

    @RequestMapping(method = RequestMethod.POST)
    Greeting register(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = Greeting.of(counter.incrementAndGet(), String.format(TEMPLATE, name));

        dsl.insertInto(GREETING, GREETING.ID, GREETING.CONTENT)
                .values(greeting.getId(), greeting.getContent())
                .execute();
        return greeting;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Greeting> list() {
        Result<Record> records = dsl.select()
                .from(GREETING)
                .fetch();
        List<Greeting> greetings = new ArrayList<>();
        for (Record r : records) {
            greetings.add(
                    Greeting.of(
                            r.getValue(GREETING.ID),
                            r.getValue(GREETING.CONTENT)
                    )
            );
        }
        return greetings;
    }
}
