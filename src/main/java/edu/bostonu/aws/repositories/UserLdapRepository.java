package edu.bostonu.aws.repositories;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Repository;

import edu.bostonu.aws.models.SearchDto;
import edu.bostonu.aws.models.User;

import java.util.List;


@Repository
public class UserLdapRepository {
	
	protected static final Log logger = LogFactory.getLog(UserLdapRepository.class);
	
	
	@Value("${LDAP_BASE_DN}")
	String baseDn;
	

	@Autowired
	private LdapTemplate ldapTemplate;
	
	
    
	public List<User> find(SearchDto request) {
		
		StringBuilder filter = new StringBuilder();
		
		filter.append("(&");
		
	    if (request.getPersonFirstName() != null && request.getPersonFirstName().length() > 0) {
	    	
	    	filter.append("(personFirstName=" + request.getPersonFirstName() + ")");

	    }
	    
	    if (request.getPersonLastName() != null && request.getPersonLastName().length() > 0) {
	    	
	    	filter.append("(personLastName=" + request.getPersonLastName() + ")");

	    }
	    
	    if (request.getPersonDateOfBirth() != null && request.getPersonDateOfBirth().length() > 0) {
	    	
	    	filter.append("(personDateOfBirth=" + request.getPersonDateOfBirth() + ")");

	    }
	    
	    if (request.getPersonEmail() != null && request.getPersonEmail().length() > 0) {
	    	
	    	filter.append("(personEmail=" + request.getPersonEmail() + ")");

	    }
	    
	    if (request.getPersonPassport() != null && request.getPersonPassport().length() > 0) {
	    	
	    	filter.append("(personPassport=" + request.getPersonPassport() + ")");

	    }
	    
	    if (request.getPersonSsn() != null && request.getPersonSsn().length() > 0) {
	    	
	    	filter.append("(personSsn=" + request.getPersonSsn() + ")");

	    }
	    
	    
	    filter.append(")");
		
		LdapQuery query = LdapQueryBuilder.query().base(baseDn).filter(filter.toString());
		
		List<User> users = ldapTemplate.find(query, User.class);
		
		return users;
		
	}

    
}


