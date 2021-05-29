package kodlamaio.hrms.core.utilities.results.adapters.abstracts;

public interface EmailVerifyAndValidService {

	public boolean emailValid(String email);
	public boolean emailVerify(String email);
}
