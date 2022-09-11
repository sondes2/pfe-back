package com.example.pfeesprit.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusTypes statustype;
    private Long storypoint;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private Long timeSpent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;

    public Task() {

    }

    public Task(Long idTask, String description, StatusTypes statustype, Long storypoint, Date startDate, Date endDate, long timeSpent, User user) {
        this.idTask = idTask;
        this.description = description;
        this.statustype = statustype;
        this.storypoint = storypoint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeSpent = 0L;
        this.user = user;
    }

    public Long getStorypoint() {
        return storypoint;
    }

    public void setStorypoint(Long storypoint) {
        this.storypoint = storypoint;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusTypes getStatustype() {
        return statustype;
    }

    public void setStatustype(StatusTypes statustype) {
        this.statustype = statustype;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
