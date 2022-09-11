package com.example.pfeesprit.repositories;

import com.example.pfeesprit.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("UPDATE Task t SET t.user = ?1 WHERE t.idTask = ?2")
    @Modifying
    @Transactional
    public void affectUsertoTask(User user, Long idTask);

    @Query("UPDATE Task t SET t.user = null WHERE t.idTask= ?1")
    @Modifying
    @Transactional
    public void deleteUserFromTask(Long idTask);

    @Query("UPDATE Task t SET t.statustype = ?1 WHERE t.idTask = ?2")
    @Modifying
    @Transactional
    public void updateStatus(StatusTypes statusTypes, Long idTask);

    List<Task> findByUser(User user);

    @Query("SELECT COUNT(t) FROM Task t")
    Long countTask();

    @Query("select new com.example.pfeesprit.entities.CountTaskByStatusDTO(" +
            "SUM(CASE WHEN t.statustype='DONE' then 1 else 0 END)," +
            "SUM(CASE WHEN t.statustype='DOING' then 1 else 0 END)," +
            "SUM(CASE WHEN t.statustype='TODO' then 1 else 0 END)" +
            ") from Task t")
    CountTaskByStatusDTO CountTaskByStatus();


}
