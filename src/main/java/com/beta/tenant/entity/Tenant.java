package com.beta.tenant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tenant")
public class Tenant {
	
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="tenant_seq",allocationSize=1)
	@Column(name="tenantid")
	private int tenantId ;

	@Column(name="tenantname",length=40)
	private String tenantName ;

	@Column(name="tenantproper",length=100)
	private String tenantProper ;
	
	@Column(name="tenantnumber")
	private long tenantNumber ;
	
	@Column(name="tenantaadhar")
	private long tenantAadhar ;
	
	@Column(name="tenantrent")
	private long tenantRent ;
	
	@Column(name="tenantlocation",length=40)
	private String tenantLocation ;
	
	@ManyToOne
	@JoinColumn(name="ownerid")
	private Owner owner;

	public Tenant(int tenantId, String tenantName, String tenantProper, long tenantNumber, long tenantAadhar,
			long tenantRent, String tenantLocation, Owner owner) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantProper = tenantProper;
		this.tenantNumber = tenantNumber;
		this.tenantAadhar = tenantAadhar;
		this.tenantRent = tenantRent;
		this.tenantLocation = tenantLocation;
		this.owner = owner;
	}

	public Tenant() {
		super();
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantProper() {
		return tenantProper;
	}

	public void setTenantProper(String tenantProper) {
		this.tenantProper = tenantProper;
	}

	public long getTenantNumber() {
		return tenantNumber;
	}

	public void setTenantNumber(long tenantNumber) {
		this.tenantNumber = tenantNumber;
	}

	public long getTenantAadhar() {
		return tenantAadhar;
	}

	public void setTenantAadhar(long tenantAadhar) {
		this.tenantAadhar = tenantAadhar;
	}

	public long getTenantRent() {
		return tenantRent;
	}

	public void setTenantRent(long tenantRent) {
		this.tenantRent = tenantRent;
	}

	public String getTenantLocation() {
		return tenantLocation;
	}

	public void setTenantLocation(String tenantLocation) {
		this.tenantLocation = tenantLocation;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
	
