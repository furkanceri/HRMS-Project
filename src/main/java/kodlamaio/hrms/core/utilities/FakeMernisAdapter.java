package kodlamaio.hrms.core.utilities;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisAdapter implements FakeMernisService {

	@Override
	public boolean validate(String nationalityId, String firstName, String lastName, String birthYear) {
		if (nationalityId.length() != 11) {
			System.out.println("Identity number must consist of 11 digits");
			return false;
		}
		if (firstName.length() < 2) {
			System.out.println("Please enter a valid name");
			return false;
		}
		if (lastName.length() < 2) {
			System.out.println("Please enter a valid surname");
			return false;
		}
		if (birthYear.length() <= 4 && (Integer.parseInt(birthYear) < 1920 && Integer.parseInt(birthYear) > 2021)) {
			System.out.println("Please enter a valid birth year");
			return false;
		}
		System.out.println("Credentials have been successfully verified");
		return true;
	}

}
