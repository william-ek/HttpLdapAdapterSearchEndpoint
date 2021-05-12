package edu.bostonu.aws.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.bostonu.aws.models.SearchDto;


@Service
public class SearchDtoValidator implements ConstraintValidator<ValidSearchDto, SearchDto> {
	
	private final Logger logger = LoggerFactory.getLogger(SearchDtoValidator.class);
	

	@Override
	/**
	 * Validate a Search Request:
	 * 
	 * At least one 
	 * 
	 */
	public boolean isValid(SearchDto searchDto, ConstraintValidatorContext context) {

        if (searchDto != null
        	&& (searchDto.getBuid() != null
        		||
        		searchDto.getPersonFirstName() != null
        		||
        		searchDto.getPersonLastName() != null
        		||
        		searchDto.getPersonDateOfBirth() != null
        		||
        		searchDto.getPersonEmail() != null
        		||
        		searchDto.getPersonPassport() != null
        		||
        		searchDto.getPersonSsn() != null)) {
        		return true;
        }


		return false;
	}

}
