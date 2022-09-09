package com.example.pfeesprit.repositories;

import java.util.List;

import com.example.pfeesprit.entities.Groupe;
import com.example.pfeesprit.entities.Role;
import com.example.pfeesprit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findBylogin(String userName);

    List<User> findBylastName(String userName);

    List<User> findByGroupe(Groupe groupe);

    List<User> findByRole(Role role);

    User findByidUser(int idUser);

    @Query("SELECT r.roleType FROM User u INNER JOIN Role r on (u.role.idRole = r.idRole) where  u.idUser =:id")
    public String getUserRoleDescription(@Param("id") int id);

    @Query("UPDATE User u SET u.groupe = ?1 WHERE u.idUser = ?2")
    @Modifying
    @Transactional
    public void affectUserToGroup(Groupe groupe, int idUser);

    @Query("UPDATE User u SET u.groupe = null WHERE u.idUser = ?1")
    @Modifying
    @Transactional
    public void deleteUserFromGroup(int idUser);

    @Query("SELECT CONCAT(u.firstName,CONCAT(' ',u.lastName)) FROM User u where  u.valid =TRUE")
    public List<String> getUsersFromActivated();

    @Query("SELECT CONCAT(u.firstName,CONCAT(' ',u.lastName)) FROM User u where  u.valid =FALSE")
    public List<String> getUsersFromDisabled();

    @Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.login = ?2")
    @Modifying
    public void updateFailedAttempts(int failAttempts, String login);

    User findUserByresettoken(String login);

    @Query("SELECT u FROM User u INNER JOIN Groupe g on (u.groupe.id = g.id)where  u.idUser=?1")
    List<User> findUsersOfSameGroupByUserId(int userId);


}
