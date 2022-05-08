package com.project.web.services;

import org.springframework.stereotype.Service;

@Service
public class RequestCounter {
    private static int counter;

    public RequestCounter() {
        counter = 0;
    }

    public static void increment() {
        counter++;
    }

    public static Integer getCounter() { return counter; }
}