package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.utilities.results.Result;

public interface FakeMernisService {
	boolean validate(String nationalityId, String firstName, String lastName, String birthYear);
}
