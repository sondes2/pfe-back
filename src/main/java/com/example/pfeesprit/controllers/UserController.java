package com.example.pfeesprit.controllers;

import java.util.List;

import com.example.pfeesprit.entities.Groupe;
import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.repositories.UserRepository;
import com.example.pfeesprit.services.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PUT;

@CrossOrigin(origins ="*",allowedHeaders="*")
@RestController

@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserservice iuserservice;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/findall")
	public List<User> getAllUsers() {
		return iuserservice.getAllUsers();

	}
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/userbyid/{idUser}")
	public User getUserById(@PathVariable("idUser") Long idUser) throws Exception {
		return iuserservice.getUserById(idUser);
	}

	@PostMapping("/AddUser")
	@ResponseBody
	public User addUser(@RequestBody User user) throws Exception {
		return iuserservice.createUser(user);
	}



	@PutMapping("/UpdateUser")
	@ResponseBody
	public User updateUser(@RequestBody User user) throws Exception {
		return iuserservice.updateUser(user);
	}


	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteUserById(@PathVariable("userId") Long userId) throws Exception {
		iuserservice.deleteUserById(userId);
	}

	@PreAuthorize("hasAuthority('Admin')")
	@PutMapping("/activateUser")
	public User activateUser(@RequestBody User user) throws Exception {
		return iuserservice.activateUser(user);
	}



	@PreAuthorize("hasAuthority('Admin')")
	@PutMapping("/desactivateUser")
	public User desactivateUser(@RequestBody User user) throws Exception {
		return iuserservice.desactivateUser(user);
	}

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/findUserLastName/{username}")
	public List<User> findUserLastName(@PathVariable("username") String username) throws Exception {
		return iuserservice.findUserLastName(username);
	}

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/findUserBylogin/{username}")
	public User findUserBylogin(@PathVariable("username") String username) throws Exception {
		return iuserservice.findUserBylogin(username);
	}

	@GetMapping("/findByGroupe/{gropeId}")
	public List<User> findByGroupeId(@PathVariable Long gropeId){
		return iuserservice.findByGroupId(gropeId);
	}

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/findUserRole/{IdUser}")
	public String findUserRole(@PathVariable("IdUser") Long IdUser) throws Exception {
		return iuserservice.getUserRoleDescription(IdUser);
	}

	@GetMapping("/findActivatedUser")
	public List<String> findUserActivated() throws Exception {
		return iuserservice.findUsersActivated();
	}

	@PutMapping("/affectGroup/{userId}")
	public String affectGroupe(@RequestBody Groupe groupe, @PathVariable Long userId) {
		iuserservice.affectGroup(groupe, userId);
		return "success";
	}

	@PutMapping("/deleteGroup/{userId}")
	public String deleteUserFromGroup(@PathVariable Long userId) {
		iuserservice.deleteUserFromGroup(userId);
		return "success";
	}

	@GetMapping("/findDisabledUser")
	public List<String> findUserDisabled() throws Exception {
		return iuserservice.getUsersFromDisabled();
	}


	@RequestMapping("/Countuser")
	public Long countUsers(Model model) {
		model.addAttribute("countUsers", userRepository.countUsers());
		return userRepository.countUsers();
	}

	@GetMapping("/findUsersOfSameGroupByUserId/{login}")
	public List<User> findUsersOfSameGroupByUserId(@PathVariable String login) {
		return iuserservice.findUsersOfSameGroupByUserId(login);
	}
	
	/*@PostMapping("/sendSMS")
	public void sendSMS(@RequestBody String messageToSend){
		SMS sms =new SMS(messageToSend);
		sms.send();
	}*/
}
