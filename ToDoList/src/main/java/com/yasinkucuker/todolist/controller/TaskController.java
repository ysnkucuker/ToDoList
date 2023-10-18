package com.yasinkucuker.todolist.controller;

import com.yasinkucuker.todolist.model.Task;
import com.yasinkucuker.todolist.repository.TaskRepository;
import com.yasinkucuker.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final RestTemplate restTemplate;
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    int check = 0;
    @GetMapping("/tasks")
    public List<Task> getAllPosts() {
        Task[] tasks = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos",
                Task[].class);
        List<Task> taskList = Arrays.asList(tasks);
        //taskRepository.saveAll(taskList);
        if(taskList != null){
            check = 1;
            if(check == 1){
                taskService.saveAllTasks(taskList);
            }
        }
        return taskList;
    }

    @GetMapping("tasks/all")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping("/tasks/{completed}")
    public List<Task> getCompletedTask(Boolean completed){
        return taskService.getCompletedTask(completed);
    }


}
