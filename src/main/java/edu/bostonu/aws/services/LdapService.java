package edu.bostonu.aws.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import edu.bostonu.aws.models.ResponseDto;
import edu.bostonu.aws.models.SearchDto;
import edu.bostonu.aws.models.User;
import edu.bostonu.aws.repositories.UserLdapRepository;

@Service
public class LdapService {

	private final Logger logger = LoggerFactory.getLogger(LdapService.class);
	
	@Autowired
	Validator validator;
	
	
	@Autowired
	UserLdapRepository userRepository;
	
	
	public ResponseDto searchUsers(SearchDto request) {
		logger.debug("search Users");
		
		ResponseDto response = new ResponseDto();
		
		Set<ConstraintViolation<SearchDto>> violations = validator.validate(request);
		
		if (violations == null) {
			logger.debug("violations is null");
		}
		
		if (violations != null && !violations.isEmpty()) {
			response.setErrorMessages(new ArrayList<String>());
			violations.forEach((v) -> {
				response.getErrorMessages().add(v.getMessage());
			});
			
			response.setReturn_status_code(HttpStatus.UNPROCESSABLE_ENTITY.toString());
			
			return response;
			
		}

		List<User> users = userRepository.find(request);
		
		if (users == null || users.isEmpty()) {
			response.setReturn_status_code(HttpStatus.NOT_FOUND.toString());
			return response;
		}
		
		response.setReturn_status_code(HttpStatus.OK.toString());
		response.setUsers(users);

		return response;
	}


}

