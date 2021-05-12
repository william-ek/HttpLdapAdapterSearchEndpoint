package edu.bostonu.aws.application;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import edu.bostonu.aws.models.ResponseDto;
import edu.bostonu.aws.models.SearchDto;
import edu.bostonu.aws.services.LdapService;

@ComponentScan(basePackages = "edu.bostonu.aws")
@SpringBootApplication
public class HttpLdapSearchEndpointApplication {
	
	@Value("${LDAP_BIND_URL}")
	String ldapUrl;
	
	@Value("${LDAP_BIND_DN}")
	String ldapBindDn;
	
	@Value("${LDAP_BIND_PASSWORD}")
	String ldapBindPassword;
	
	@Autowired
	LdapService service;

	public static void main(String[] args) {
		SpringApplication.run(HttpLdapSearchEndpointApplication.class, args);
	}
	
	    @Bean
	    public Function<SearchDto, ResponseDto> searchUsers() {
	    	return (input) -> service.searchUsers(input);
	    }
	    
	    @Bean
	    public Validator getValidator() {
	    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    	Validator validator = factory.getValidator();
	    	return validator;
	    }
		
	
	   @Bean
	    public LdapContextSource contextSource() throws Exception {
	    	
	        LdapContextSource contextSource= new LdapContextSource();
	        contextSource.setUrl(ldapUrl);
	        contextSource.setUserDn(ldapBindDn);
	        contextSource.setPassword(ldapBindPassword);
	        return contextSource;
	    }

	    @Bean
	    public LdapTemplate ldapTemplate() throws Exception {
	        return new LdapTemplate(contextSource());        
	    }
	    

}
