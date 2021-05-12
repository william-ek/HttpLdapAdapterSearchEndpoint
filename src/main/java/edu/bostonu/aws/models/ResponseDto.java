package edu.bostonu.aws.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseDto implements Serializable {
	
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	private String return_status_code;
	
	private List<String> errorMessages;
	
	private List<User> users;

	public String getReturn_status_code() {
		return return_status_code;
	}

	public void setReturn_status_code(String return_status_code) {
		this.return_status_code = return_status_code;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
