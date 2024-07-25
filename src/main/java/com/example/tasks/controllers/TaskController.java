package com.example.tasks.controllers;

import com.example.tasks.models.Task;
import com.example.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView mav = new ModelAndView("create-task");
        mav.addObject("task", new Task());
        mav.addObject("isEdit", false);
        return mav;
    }

    @PostMapping("/create")
    public String createTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks/list";
    }

    @GetMapping("/list")
    public String listTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id.intValue());
        return "redirect:/tasks/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        Task task = taskService.getTaskById(id);
        ModelAndView mav = new ModelAndView("create-task");
        mav.addObject("task", task);
        mav.addObject("isEdit", true); // Indica que es una edición
        return mav;
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") Task task) {
        taskService.updateTask(task);
        return "redirect:/tasks/list";
    }
}
