package com.yasinkucuker.todolist.service;

import com.yasinkucuker.todolist.model.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);

    List<Task> getCompletedTask(Boolean completed);

    List<Task> saveAllTasks(List<Task> taskList);

    List<Task> getAllTask();
}
