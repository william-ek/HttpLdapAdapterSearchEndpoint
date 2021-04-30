package edu.bostonu.aws.application;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;


import edu.bostonu.aws.models.SearchDto;
import edu.bostonu.aws.models.User;
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
	    public Function<SearchDto, List<User>> searchUsers() {
	    	return (input) -> service.searchUsers(input);
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
