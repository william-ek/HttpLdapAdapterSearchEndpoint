package edu.bostonu.aws.application;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import edu.bostonu.aws.models.SearchDto;
import edu.bostonu.aws.models.User;


public class UserSearchHandler extends SpringBootRequestHandler<SearchDto, List<User>> {
	

}
