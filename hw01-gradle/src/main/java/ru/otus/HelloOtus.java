package ru.otus;

import com.google.common.collect.ImmutableList;

public class HelloOtus {
    public static void main(String[] args) {
        ImmutableList<String> words = ImmutableList.of("Hello", "Otus");
        System.out.println(String.join(" ", words));
    }
}
