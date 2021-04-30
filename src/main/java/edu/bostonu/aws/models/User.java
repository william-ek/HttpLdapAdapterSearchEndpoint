package edu.bostonu.aws.models;

import javax.naming.Name;
import javax.naming.ldap.LdapName;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entry(objectClasses = {"BUPerson","top"})
public class User {
	
	@Id
	@JsonIgnore
	private Name dn;
	
    @DnAttribute(value = "buid", index=1)
	private String buid;
	
    @Attribute(name = "personFirstName")
	private String personFirstName;
	
    @Attribute(name = "personLastName")
	private String personLastName;
	
    @Attribute(name = "personDateOfBirth")
	private String personDateOfBirth;
	
    @Attribute(name = "personEmail")
	private String personEmail;
	
    @Attribute(name = "personSsn")
	private String personSsn;
	
    @Attribute(name = "personPassport")
	private String personPassport;

    
	
	public User() {
		super();
	}

	public User(String buid, String personFirstName, String personLastName, String personDateOfBirth,
			String personEmail, String personSsn, String personPassport) {
		super();
		this.buid = buid;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
		this.personDateOfBirth = personDateOfBirth;
		this.personEmail = personEmail;
		this.personSsn = personSsn;
		this.personPassport = personPassport;
	}
	
	public void setDn(LdapName buildDn) {

		this.dn = buildDn;
		
	}

	public Name getDn() {

		return this.dn;
	}

	public String getBuid() {
		return buid;
	}

	public void setBuid(String buid) {
		this.buid = buid;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	public String getPersonDateOfBirth() {
		return personDateOfBirth;
	}

	public void setPersonDateOfBirth(String personDateOfBirth) {
		this.personDateOfBirth = personDateOfBirth;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonSsn() {
		return personSsn;
	}

	public void setPersonSsn(String personSsn) {
		this.personSsn = personSsn;
	}

	public String getPersonPassport() {
		return personPassport;
	}

	public void setPersonPassport(String personPassport) {
		this.personPassport = personPassport;
	}

	
}
