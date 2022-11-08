package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technologyLanguageRequests.CreateTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.DeleteTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.UpdateTechnologyLanguageRequest;
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetAllTechnologyLanguagesResponse;
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetTechnologyLanguageByIdResponse;


public interface TechnologyLanguageService {
	
	List<GetAllTechnologyLanguagesResponse> getAll();
	GetTechnologyLanguageByIdResponse getTechnologyLanguageById(int id) throws Exception;
	void add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) throws Exception;
	void update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) throws Exception;
	void delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest);

}
