package com.example.pfeesprit.controllers;

import com.codahale.metrics.annotation.Timed;
import com.example.pfeesprit.entities.CountTaskByStatusDTO;
import com.example.pfeesprit.entities.Task;
import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.repositories.TaskRepository;
import com.example.pfeesprit.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Task")
public class TaskController {
    @Autowired
    ITaskService iTaskService;
    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/findalltask")
    public List<Task> getAllTask() {
        return iTaskService.getAllTask();

    }

    // @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/taskbyid/{idTask}")
    public Task findTaskById(@PathVariable("idTask") Long idTask) {
        return iTaskService.findTaskById(idTask);
    }

    @PostMapping("/AddTask")
    // @ResponseBody
    public Task addTask(@RequestBody Task task) {
        return iTaskService.addTask(task);

    }


    @PutMapping("/UpdateTask")
    @ResponseBody
    public Task updateTask(@RequestBody Task task) {
        return iTaskService.editTask(task);
    }


    @DeleteMapping("/deleteTaskById/{idTask}")
    public void deleteTask(@PathVariable("idTask") Long idTask) {
        iTaskService.deleteTask(idTask);
    }

    @PutMapping("/affectUserToTask/{idTask}")
    public void affectUserToTask(@RequestBody User user, @PathVariable Long idTask) {
        this.iTaskService.affectUsertoTask(user, idTask);
    }

    @PutMapping("/deleteUserFromTask/{idTask}")
    public void deleteUserFromTask(@PathVariable Long idTask) {
        this.iTaskService.deleteUserFromTask(idTask);
    }

    @GetMapping("/findByUserId/{login}")
    public List<Task> findByUserId(@PathVariable String login) {
        return this.iTaskService.getTaskbyUser(login);
    }

    @RequestMapping("/countTask")
    public Long countTask(Model model) {
        model.addAttribute("countTask", taskRepository.countTask());
        return taskRepository.countTask();
    }
    @GetMapping("/countByStatus")
    @Timed
    public CountTaskByStatusDTO countTaskByStatus() {
        //og.debug("get count of status from stored admissionForm");
        return iTaskService.TaskByStatus();
    }

    @PutMapping("/updateStatus/{taskId}/{statusType}")
    public void updateStatus(@PathVariable String statusType, @PathVariable Long taskId) {


        this.iTaskService.updateStatus(statusType, taskId);
    }


}
