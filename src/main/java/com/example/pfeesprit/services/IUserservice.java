package com.example.pfeesprit.services;
import java.util.List;

import com.example.pfeesprit.entities.User;
//import esprit.pidev.entities.User;


public interface IUserservice {

	public List<User> getAllUsers();
	public User getUserById(int id) throws Exception;
	public User activateUser (User user) throws Exception;
	public User desactivateUser (User user) throws Exception;
	public User createUser(User entity);
	public User updateUser(User entity) throws Exception;
	public void deleteUserById(Integer userId) throws Exception;
	public User findUserBylogin(String user) throws Exception;
	public List<User> findUserLastName(String user) throws Exception;
	public String getUserRoleDescription(int id);
	public List<String> findUsersActivated() throws Exception;
	public List<String> getUsersFromDisabled();
	public void increaseFailedAttempts(User user);
	boolean unlockWhenTimeExpired(User user);
	void resetFailedAttempts(String mail);
	public User findUserByResetToken(String token);
	List<User> findByGroupId(Long groupId);
	public User affectGroup(Integer userId, Long groupId );

	void lock(User user);

	User findById(int id);

	User findBymail(String mail);

	List<User> findAllByOrderByIdAsc();

}