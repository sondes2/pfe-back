package com.example.pfeesprit.controllers;

import java.util.List;

import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.services.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonBackReference;

@CrossOrigin(origins ="*",allowedHeaders="*")
@RestController

@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserservice iuserservice;

	@Autowired
	PasswordEncoder encoder;



	@GetMapping("/findall")
	public List<User> getAllUsers() {
		return iuserservice.getAllUsers();

	}
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/userbyid/{idUser}")
	public User getUserById(@PathVariable("idUser") int idUser) throws Exception {
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
	public void deleteUserById(@PathVariable("userId") Integer userId) throws Exception {
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
	public String findUserRole(@PathVariable("IdUser") int IdUser) throws Exception {
		return iuserservice.getUserRoleDescription(IdUser);
	}

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/findActivatedUser/")
	public List<String> findUserActivated() throws Exception {
		return iuserservice.findUsersActivated();
	}

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/findDisabledUser/")
	public List<String> findUserDisabled() throws Exception {
		return iuserservice.getUsersFromDisabled();
	}


	
	
	/*@PostMapping("/sendSMS")
	public void sendSMS(@RequestBody String messageToSend){
		SMS sms =new SMS(messageToSend);
		sms.send();
	}*/
}