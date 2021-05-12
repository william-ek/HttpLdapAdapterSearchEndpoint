package edu.bostonu.aws.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BuidValidator implements ConstraintValidator<Buid, String> {
	
	private final Logger logger = LoggerFactory.getLogger(BuidValidator.class);
	
	@Override
	/**
	 * Validate a BUID:
	 * 
	 * A BUID must begin with the letters: U
	 * A BUID must have a 6 digit integer numeric following the first character alpha
	 * 
	 */
	public boolean isValid(String value, ConstraintValidatorContext context) {
		logger.debug("Validator for Buid: " + value);
		
		//We will only verify non-null values
		if (value == null) return true;
		
		if (value.length() != 7) return false;
		
		if (! value.startsWith("U") ) return false;
		
		return value.substring(1).matches("-?\\d+");
		
	}

}
