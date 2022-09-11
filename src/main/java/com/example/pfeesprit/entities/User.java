package com.example.pfeesprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	private Long idUser;
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
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Task> task;

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public User(Long idUser, String firstName, String lastName, int telNum, Date birthdate, String address, String mail, String login, String password, boolean accountNonLocked, int failedAttempt, Date lockTime, boolean valid, Role role, String stripeid, String resettoken, Groupe groupe, List<Task> task) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNum = telNum;
		this.birthdate = birthdate;
		this.address = address;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.valid = valid;
		this.role = role;
		this.stripeid = stripeid;
		this.resettoken = resettoken;
		this.groupe = groupe;
		this.task = task;
	}

	public void setRole(Role role) {
            this.role = role;
        }

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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
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
