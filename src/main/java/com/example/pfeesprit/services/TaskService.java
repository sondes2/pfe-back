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
        task.setStatustype(StatusTypes.TODO);
        return taskRepository.save(task);
    }

    @Override
    public Task editTask(Task task) {
        switch (task.getStatustype()) {
            case DOING:
                task.setStartDate(new Date());
                break;
            case DONE:
                task.setEndDate(new Date());
                task.setTimeSpent(getDateDiff(task.getStartDate(), task.getEndDate(), TimeUnit.DAYS));
                break;
            default:
                break;
        }
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long idTask) {
        taskRepository.deleteById(idTask);
    }

    @Override
    public Task findTaskById(Long idTask) {
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

    /**
    * Get a diff between two dates
    * @param date1 the oldest date
    * @param date2 the newest date
    * @param timeUnit the unit in which you want the diff
    * @return the diff value, in the provided unit
    */
    private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

}
