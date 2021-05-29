package kodlamaio.hrms.core.utilities.results.adapters.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.adapters.abstracts.EmailVerifyAndValidService;

@Service
public class EmailVerifyManager implements EmailVerifyAndValidService{

	@Override
	public boolean emailVerify(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.com", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}

	@Override
	public boolean emailValid(String email) {
		System.out.println("Eposta doğrulaması başarılı "+email);
		return true;
	}

}
