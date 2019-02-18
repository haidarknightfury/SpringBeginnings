package com.smartfox.todoactivi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.todoactivi.entity.Person;
import com.smartfox.todoactivi.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public void completeTask(String taskId) {
        this.taskService.complete(taskId);
    }

    public void createPersons() {
        if (this.personRepository.findAll().size() == 0) {

            this.personRepository.save(new Person("John", new Date()));
            this.personRepository.save(new Person("David", new Date()));
            this.personRepository.save(new Person("Katherin", new Date()));
        }
    }

    public List<Task> getTasks(String assignee) {
        return this.taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    private String processInfo() {
        List<Task> tasks = this.taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Number of process definitions " + this.repositoryService.createProcessDefinitionQuery().count());

        for (Task task : tasks) {
            stringBuilder.append(task + " | Assignee :" + task.getAssignee() + " | Description: " + task.getDescription());
        }

        return stringBuilder.toString();
    }

    public String startProcess(String assignee) {
        Person person = this.personRepository.findByName(assignee);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        this.runtimeService.startProcessInstanceByKey("simpleProcess", variables);
        return this.processInfo();
    }
}
