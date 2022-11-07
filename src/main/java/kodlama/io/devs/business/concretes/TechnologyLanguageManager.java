package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyLanguageService;
import kodlama.io.devs.business.requests.technologyLanguageRequests.CreateTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.DeleteTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.UpdateTechnologyLanguageRequest;
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetAllTechnologyLanguagesResponse;
import kodlama.io.devs.dataAccess.abstracts.TechnologyLanguageDao;
import kodlama.io.devs.entities.concretes.TechnologyLanguage;

@Service
public class TechnologyLanguageManager implements TechnologyLanguageService{

	private TechnologyLanguageDao technologyLanguageDao;
	
	
	@Autowired
	public TechnologyLanguageManager(TechnologyLanguageDao technologyLanguageDao) {
		this.technologyLanguageDao = technologyLanguageDao;
	}

	@Override
	public List<GetAllTechnologyLanguagesResponse> getAll() {
		List<TechnologyLanguage> technologyLanguages = technologyLanguageDao.findAll();
		List<GetAllTechnologyLanguagesResponse> technologyLanguagesResponse = new ArrayList<GetAllTechnologyLanguagesResponse>();
		
		for (TechnologyLanguage technologyLanguage : technologyLanguages) {
			GetAllTechnologyLanguagesResponse responseItem = new GetAllTechnologyLanguagesResponse();
			responseItem.setId(technologyLanguage.getId());
			responseItem.setName(technologyLanguage.getName());
			
			technologyLanguagesResponse.add(responseItem);
		}
	return technologyLanguagesResponse;
	}

	@Override
	public TechnologyLanguage getTechnologyLanguageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) {
		TechnologyLanguage technologyLanguage = new TechnologyLanguage();
		technologyLanguage.setName(createTechnologyLanguageRequest.getName());
		
		this.technologyLanguageDao.save(technologyLanguage);
		
		
		
	}

	@Override
	public void update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) {
		TechnologyLanguage technologyLanguage = new TechnologyLanguage();
		technologyLanguage.setId(updateTechnologyLanguageRequest.getId());
		technologyLanguage.setName(updateTechnologyLanguageRequest.getName());
		
		this.technologyLanguageDao.save(technologyLanguage);
		
	}

	@Override
	public void delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest) {
		// TODO Auto-generated method stub
		
	}



}
