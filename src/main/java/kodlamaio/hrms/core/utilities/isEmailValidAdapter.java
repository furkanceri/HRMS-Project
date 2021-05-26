package kodlamaio.hrms.core.utilities;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class isEmailValidAdapter implements isEmailValid {

	@Override
	public boolean isEmailValidation(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_{|}~-]+)@(?:[a-z0-9](?:[a-z0-9-][a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.com",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

	@Override
	public boolean isEmailValidationOnClick(String email) {
		
		return true;
	}

}
