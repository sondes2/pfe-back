package com.example.pfeesprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class ChatMessagePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idChatRoom;
	
	private int idUser;
	
	

	public ChatMessagePK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatMessagePK(int idChatRoom, int idUser, String message, Date dateCreation) {
		super();
		this.idChatRoom = idChatRoom;
		this.idUser = idUser;
		
	}

	public int getIdChatRoom() {
		return idChatRoom;
	}

	public void setIdChatRoom(int idChatRoom) {
		this.idChatRoom = idChatRoom;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idChatRoom;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatMessagePK other = (ChatMessagePK) obj;
		if (idChatRoom != other.idChatRoom)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChatMessagePK [idChatRoom=" + idChatRoom + ", idUser=" + idUser +  "]";
	}

	
	
	
}
