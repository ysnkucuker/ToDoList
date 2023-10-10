package com.yasinkucuker.todolist.initializer;

import com.yasinkucuker.todolist.model.Task;
import com.yasinkucuker.todolist.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer implements ApplicationRunner {

    private final TaskRepository taskRepository;

    @Autowired
    public TestDataInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception{
        System.out.println("Veriler kayıt ediliyor...");


        Task task = new Task(1000, 1000, "Görev1", true);
        taskRepository.save(task);


        System.out.println("Veriler kayıt edildi...");
    }
}
