package com.example.pfeesprit.services;

import com.example.pfeesprit.entities.CountTaskByStatusDTO;
import com.example.pfeesprit.entities.StatusTypes;
import com.example.pfeesprit.entities.Task;
import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.repositories.TaskRepository;
import com.example.pfeesprit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TaskService implements ITaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public List<Task> getAllTask() {


        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTaskbyUser(String login) {
        return this.taskRepository.findByUser(this.userRepository.findBylogin(login));
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task editTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long idTask) {
        taskRepository.deleteById(idTask);
    }
    @Override
    public Task findTaskById(Long idTask) {
        Date startDate = new Date();
        Date endDate = new Date();
        Long dateBeforeInMs = startDate.getTime();
        Long dateAfterInMs = endDate.getTime();
        Long timeDiff = Math.abs(dateAfterInMs -dateBeforeInMs);
        Long timeSpent = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);



        return taskRepository.findById(idTask).get();
    }

    @Override
    public void affectUsertoTask(User user, Long idTask) {

        taskRepository.affectUsertoTask(user, idTask);
    }

    @Override
    public void deleteUserFromTask(Long idTask) {
        taskRepository.deleteUserFromTask(idTask);
    }
    public CountTaskByStatusDTO TaskByStatus(){
       // log.debug("Request to get count of AdmissionForm by it's Status ");
        return taskRepository.CountTaskByStatus();
    }

    @Override
    public void updateStatus(String statusTypes,Long idTask) {
        StatusTypes statusTypes1 = StatusTypes.TODO;
        switch (statusTypes) {
            case "DONE":
                statusTypes1 = StatusTypes.DONE;
                break;
            case "DOING":

                statusTypes1 = StatusTypes.DOING;
                break;
        }

        this.taskRepository.updateStatus(statusTypes1, idTask);
    }


}
