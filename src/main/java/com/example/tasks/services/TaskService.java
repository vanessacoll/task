package com.example.tasks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tasks.models.Task;
import com.example.tasks.mappers.TaskMapper;
import java.util.List;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public void saveTask(Task task) {
        taskMapper.insertTask(task);
    }

    public void updateTask(Task task) {
        taskMapper.updateTask(task);
    }

    public void deleteTask(int id) {
        taskMapper.deleteTask(id);
    }

    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }

    public Task getTaskById(int id) {
        return taskMapper.getTaskById(id);
    }

}
