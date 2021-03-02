package com.beta.tenant.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity//it will specify it as entity class for bean configuration
@Table(name = "owner")//it map table by name to database
public class Owner {
	
	@Id
	@GeneratedValue(generator="mygen1",strategy=GenerationType.SEQUENCE)
	//provides the requirements for id generation with name and type
	@SequenceGenerator(name="mygen1",sequenceName="owner_seq",allocationSize=1)
	//it will specify the sequence
	@Column(name="ownerid")
	private int ownerId ;

	@Column(name="ownername",length=40)//length is mentioned only when we use string
	private String ownerName ;

	@Column(name="ownerlocation",length=100)
	private String ownerLocation ;

	@Column(name="isadmin")
	private boolean isAdmin ;

	@Column(name="ownerpassword",length=20)
	private String ownerPassword;
	
	
	public Owner(int ownerId, String ownerName, String ownerLocation, boolean isAdmin, String ownerPassword) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerLocation = ownerLocation;
		this.isAdmin = isAdmin;
		this.ownerPassword = ownerPassword;
	}

	public Owner() {
		super();
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerLocation() {
		return ownerLocation;
	}

	public void setOwnerLocation(String ownerLocation) {
		this.ownerLocation = ownerLocation;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
	
	
	
}


