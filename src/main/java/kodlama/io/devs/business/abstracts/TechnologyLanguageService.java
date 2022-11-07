package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technologyLanguageRequests.CreateTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.DeleteTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.UpdateTechnologyLanguageRequest;
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetAllTechnologyLanguagesResponse;
import kodlama.io.devs.entities.concretes.TechnologyLanguage;


public interface TechnologyLanguageService {
	
	List<GetAllTechnologyLanguagesResponse> getAll();
	TechnologyLanguage getTechnologyLanguageById(int id);
	void add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest);
	void update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest);
	void delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest);

}
