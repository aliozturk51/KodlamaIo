package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;


public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	ProgrammingLanguage getProgrammingLanguageById(int id);	
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
}
