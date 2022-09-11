package com.example.pfeesprit.services;
import com.example.pfeesprit.entities.CountTaskByStatusDTO;
import com.example.pfeesprit.entities.User;

import com.example.pfeesprit.entities.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> getAllTask();
   public List<Task> getTaskbyUser(String login);

    Task addTask(Task task);

    public Task editTask(Task task);

    public void deleteTask(Long idTask);

    public Task findTaskById(Long idTask);
    public void affectUsertoTask(User user, Long idTask);
    public void deleteUserFromTask(Long idTask);
    public CountTaskByStatusDTO TaskByStatus();

}
