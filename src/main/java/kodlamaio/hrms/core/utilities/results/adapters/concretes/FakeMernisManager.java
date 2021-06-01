package kodlamaio.hrms.core.utilities.results.adapters.concretes;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisManager {

	public boolean fakeMernisVerify(Long nationalityId, String firstName, String lastName, int birthYear) {
		
		FakeMernisManager fakeMernis= new FakeMernisManager();
		return fakeMernis.fakeMernisVerify(nationalityId, firstName, lastName, birthYear);
	}
	
	
}
