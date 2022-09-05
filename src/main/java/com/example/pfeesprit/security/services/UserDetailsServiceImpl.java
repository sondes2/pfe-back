package com.example.pfeesprit.security.services;

import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.services.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	IUserservice iuserservice;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = new User();

		try {
			user = iuserservice.findUserBylogin(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return UserDetailsImpl.build(user);
	}

}
