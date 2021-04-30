package edu.bostonu.aws.services;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bostonu.aws.models.SearchDto;
import edu.bostonu.aws.models.User;
import edu.bostonu.aws.repositories.UserLdapRepository;

@Service
public class LdapService {

	private final Logger logger = LoggerFactory.getLogger(LdapService.class);
	
	
	@Autowired
	UserLdapRepository userRepository;
	
	
	public List<User> searchUsers(SearchDto request) {
		logger.debug("search Users");

		List<User> users = userRepository.find(request);

		return users;
	}


}

