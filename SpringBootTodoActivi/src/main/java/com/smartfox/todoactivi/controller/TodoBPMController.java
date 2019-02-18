package com.smartfox.todoactivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.todoactivi.service.PersonService;

@RestController
public class TodoBPMController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/completetask")
    public String completeTask(@RequestParam String id) {
        this.personService.completeTask(id);
        return id;
    }

    @RequestMapping(value = "/tasks/{assignee}")
    public String getTasks(@PathVariable("assignee") String assignee) {
        List<org.activiti.engine.task.Task> tasks = this.personService.getTasks(assignee);
        return tasks.toString();
    }

    @RequestMapping(value = "/process")
    public String startProcessInstance(@RequestParam String assignee) {
        return this.personService.startProcess(assignee);
    }

}
