package com.smartfox.todoshell.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TodoCli {

    @ShellMethod(value = "add two integers together", group = "Mathematical Commands")
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
}
