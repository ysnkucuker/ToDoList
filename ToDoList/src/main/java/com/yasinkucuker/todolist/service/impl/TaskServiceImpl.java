package com.yasinkucuker.todolist.service.impl;

import com.yasinkucuker.todolist.model.Task;
import com.yasinkucuker.todolist.repository.TaskRepository;
import com.yasinkucuker.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TaskServiceImpl")
@Primary
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getCompletedTask(Boolean completed) {
        return taskRepository.getCompletedTask(completed);
    }

    @Override
    public List<Task> saveAllTasks(List<Task> taskList) {
        return taskRepository.saveAll(taskList);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.getAllTask();
    }


}
