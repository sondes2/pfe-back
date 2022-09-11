package com.example.pfeesprit.services;

import java.util.List;

import com.example.pfeesprit.entities.Groupe;
import com.example.pfeesprit.entities.Role;
import com.example.pfeesprit.entities.Task;
import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.repositories.GroupRepository;
import com.example.pfeesprit.repositories.IRoleRepository;
import com.example.pfeesprit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserService implements IUserservice {


	public static final int MAX_FAILED_ATTEMPTS = 3;
    
    private static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 heurs
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	@Autowired
	UserRepository userRepository;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	IRoleRepository roleRepository;
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
		
	}
	
	

	@Override
	public User getUserById(Long id) throws Exception {
		return userRepository.findByidUser(id);
	}

	@Override
	public User createUser(User entity) {
		return userRepository.save(entity);
	}
	
	@Override
	public User updateUser(User entity) throws Exception {
		User user = userRepository.findByidUser(entity.getIdUser());
		if (user!=null) {
			return userRepository.save(entity);
		} else {
			throw new Exception("No the user record exist");
		}
	}

	
	@Override
	public void deleteUserById(Long userId) throws Exception {
		userRepository.deleteById(userId);
	}
	
	@Override
	public User activateUser (User user) throws Exception {
		user.setValid(true);
		return updateUser(user);
	}
	
	@Override
	public User desactivateUser (User user) throws Exception {
		user.setValid(false);
		return updateUser(user);
	}
	
	@Override
	public User findUserBylogin (String user) throws Exception {

		return userRepository.findBylogin(user);
	}
	
	@Override
	public List<User> findUserLastName (String username) throws Exception {
		return userRepository.findBylastName(username);
	}
	
	public String getUserRoleDescription(Long id) {
		return userRepository.getUserRoleDescription(id);
		
	}
	
	@Override
	public List<String> findUsersActivated() throws Exception {
		return userRepository.getUsersFromActivated();
		
	}

	@Override
	public List<String> getUsersFromDisabled() {
		return userRepository.getUsersFromDisabled();
	}
	
	@Override
	public void increaseFailedAttempts(User user) {
      //  int newFailAttempts = user.getFailedAttempt() + 1;
      //  userRepository.updateFailedAttempts(newFailAttempts, user.getLogin());
    }
    @Override
    public void resetFailedAttempts(String email) {
    	//userRepository.updateFailedAttempts(0, email);
    }
    @Override
    public void lock(User user) {
        user.setAccountNonLocked(false);
        user.setLockTime(new Date());
         
        userRepository.save(user);
    }
    
	@Override
    public boolean unlockWhenTimeExpired(User user) {
        long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
         
        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
            user.setAccountNonLocked(true);
            user.setLockTime(null);
            user.setFailedAttempt(0);
            userRepository.save(user);
             
            return true;
        }
         
        return false;
    }

	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}

	
	
	//dhekra
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findBymail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllByOrderByIdAsc() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findUserByResetToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findUserByresettoken(token);
//		return null;
	}

	@Override
	public List<User> findByGroupId(Long groupId) {
		Groupe groupe = groupRepository.findById(groupId).get();
		return userRepository.findByGroupe(groupe);
	}

	@Override
	public void affectGroup(Groupe groupe, Long userId) {
		userRepository.affectUserToGroup(groupe, userId);
	}

	@Override
	public void deleteUserFromGroup(Long userId) {
		userRepository.deleteUserFromGroup(userId);
	}

	@Override
	public List<User> findByRoleId(int RoleId) {
		Role r = roleRepository.findById(RoleId).get();
		return userRepository.findByRole(r);
	}

	@Override
	public List<User> findUsersOfSameGroupByUserId(String login) {
		return userRepository.findUsersOfSameGroupByUserId(login);
	}


	/*@Override
	public User affectRole(Integer userId, int RoleId) {
		User u = userRepository.findByidUser(userId);
		u.setRole(roleRepository.getById(RoleId));
		return userRepository.save(u);
	}*/

}
