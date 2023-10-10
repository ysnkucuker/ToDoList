package com.yasinkucuker.todolist.repository;

import com.yasinkucuker.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM TASK t WHERE t.completed = true", nativeQuery = true)
    List<Task> getCompletedTask(Boolean completed);

    @Query(value = "SELECT * FROM TASK", nativeQuery = true)
    List<Task> getAllTask();

}
