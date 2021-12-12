package com.example.demo.tasks;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/tasks")
public class TasksController {

    private static ArrayList<Task> list = new ArrayList<Task>(); 
    
    public TasksController() {
        list.add(new Task("Task 1", false));
    }

    @GetMapping
    public ArrayList<Task> getAll() {
        return list;
    }

    @PutMapping
    public Task add(@RequestBody Task newTask) {
        list.add(new Task(newTask.getContent(), false));
        return list.get(list.size() - 1);
    }

    @DeleteMapping
    public void delete(@RequestParam(value = "taskIndex") int taskIndex) {
        // throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST);
        list.remove(taskIndex);
    }

    @PostMapping
    public void updateIsDone(
        @RequestParam(value = "taskIndex") int taskIndex,
        @RequestParam(value = "isDone") boolean isDone ) {
            list.get(taskIndex).setIsDone(isDone);
    }

}
