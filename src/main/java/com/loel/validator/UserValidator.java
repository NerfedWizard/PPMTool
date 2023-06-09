package com.loel.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.loel.domain.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {

		User user = (User) object;

		if (user.getPassword().length() < 6) {
			errors.rejectValue("password", "Length", "Password needs to be longer sport!");
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Match", "These passwords aren't the same chief!");

		}

		// confirmPassword

	}
}