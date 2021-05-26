package kodlamaio.hrms.core.adapters.abstracts;


public interface FakeMernisService {
	boolean validate(String nationalityId, String firstName, String lastName, String birthYear);
}
