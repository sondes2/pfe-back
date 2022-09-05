package com.example.pfeesprit.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.example.pfeesprit.security.services.EmailService;
import org.springframework.mail.SimpleMailMessage;

import com.example.pfeesprit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pfeesprit.entities.Role;
import com.example.pfeesprit.entities.RoleType;
//import esprit.pidev.entities.SMS;
//import esprit.pidev.entities.User;
import com.example.pfeesprit.repositories.RoleRepository;
import com.example.pfeesprit.security.JwtResponse;
import com.example.pfeesprit.security.LoginRequest;
import com.example.pfeesprit.security.MessageResponse;
import com.example.pfeesprit.security.jwt.JwtUtils;
import com.example.pfeesprit.services.MailService;
import com.example.pfeesprit.security.services.UserDetailsImpl;
import com.example.pfeesprit.services.IRoleservice;
import com.example.pfeesprit.services.IUserservice;
import com.example.pfeesprit.services.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/User/Access")
public class AutController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	IUserservice iuserservice;

	@Autowired
	IRoleservice iroleservice;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	RoleRepository rolerepos;
	@Autowired
	private EmailService emailService;
	@PostMapping("/login")

	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		//SMS sms =new SMS(loginRequest.getUsername()+"vous etes authentifier");
		//System.out.println(user.setLastName(lastName)+x);
		//sms.send();
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getUsername(),
				roles.get(0).toString()));

	}
	@PostMapping("/signup/{roletype}")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody User user  , @PathVariable("roletype")RoleType roletype) throws Exception
	{

		if (user == null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: please add values!"));
		}
		if (user.getAddress().equals("")) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: please add address!"));
		}
		if (user.getAddress().equals("")) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: please add bithday date!"));
		}
		if (!(user.getBirthdate() instanceof Date)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: please add bithday date!"));
		}
		if (user.getFirstName().equals("")) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: please add your first name!"));
		}
		if (user.getMail().equals("") || !UserService.validate(user.getMail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: please check your mail!"));
		}
		if (iuserservice.findUserBylogin(user.getLogin()) != null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		List <String> list = rolerepos.getRoleType();



		System.out.println(list);

	/*	Role r=new Role();
		System.out.println(r);
		r.setRoleType(roletype);
		r.setDescription("ooooo");
		if(r.getRoleType().toString()=="Admin"){

			user.setRole(r);
		}*/
		//rolerepos.save(r);
		user.setPassword(encoder.encode(user.getPassword()));
		//user.setRole(r);
		user.setValid(true);
		user.setAccountNonLocked(true);
		user.setFailedAttempt(0);
		iuserservice.createUser(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}


	@PostMapping("/forgot/{login}")
	public String processForgotPasswordForm(@PathVariable("login") String login,
											HttpServletRequest request) throws Exception {
		User user = iuserservice.findUserBylogin(login);

		if (user == null) {
			return "user not found";
		} else {
			// Generate random 36-character string token for reset password
			user.setResettoken(UUID.randomUUID().toString());

			// Save token to database
			iuserservice.updateUser(user);

			String appUrl = request.getServerName()+":"+request.getServerPort()+request.getContextPath();

			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setTo(user.getMail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl + "/User/Access/reset/"
					+ user.getResettoken());

			emailService.sendEmail(passwordResetEmail);
		}
		return "mail sent";

	}

	// Process reset password form
	@PostMapping("/reset/{token}/{newpassword}")
	public String setNewPassword(@PathVariable("token") String token,@PathVariable("newpassword") String newpassword ) throws Exception {
		User user = iuserservice.findUserByResetToken(token);
		if (user != null) {
			user.setPassword(encoder.encode(newpassword));
			user.setResettoken(null);
			iuserservice.updateUser(user);
			return "passwored reseted";

		} else {
			return "operation regected";
		}
	}


}
