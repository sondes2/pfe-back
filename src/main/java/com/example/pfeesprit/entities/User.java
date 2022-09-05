package com.example.pfeesprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_user")
	private int idUser;
	private String firstName;
	private String lastName;
	private int telNum;
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	private String address;
	private String mail;
	private String login;
	private String password;
	@Column(name = "accountLocked", columnDefinition = "boolean default false")
	private boolean accountNonLocked;
	@Column(name = "failedAttempt", columnDefinition = "int default 0")
	private int failedAttempt;
	private Date lockTime;
	boolean valid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "idRole")
	private Role role;
	private String stripeid;
	@Column(name = "resettoken")
	private String resettoken;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Groupe groupe;

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Groupe getGroup() {
		return groupe;
	}

	public void setGroup(Groupe groupe) {
		this.groupe = groupe;
	}

	//@JsonIgnore
	//@JsonBackReference
	public User() {
		super();
	}

	public String getResettoken() {
		return resettoken;
	}

	public void setResettoken(String resettoken) {
		this.resettoken = resettoken;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTelNum() {
		return telNum;
	}

	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}


	public String getMail() {
		return mail;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}



	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/*public Set<RatingTopic> getRatingTopic() {
		return ratingTopic;
	}

	public void setRatingTopic(Set<RatingTopic> ratingTopic) {
		this.ratingTopic = ratingTopic;
	}*/
/*
	public List<Message> getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(List<Message> chatMessage) {
		this.chatMessage = chatMessage;
	}

	/*public List<RatingComment> getRatingComment() {
		return ratingComment;
	}*/

	/*public void setRatingComment(List<RatingComment> ratingComment) {
		this.ratingComment = ratingComment;
	}*/

}
