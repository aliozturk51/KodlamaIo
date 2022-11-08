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
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetTechnologyLanguageByIdResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.devs.dataAccess.abstracts.TechnologyLanguageDao;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.TechnologyLanguage;

@Service
public class TechnologyLanguageManager implements TechnologyLanguageService {

	private TechnologyLanguageDao technologyLanguageDao;
	private ProgrammingLanguageDao programmingLanguageDao;

	@Autowired
	public TechnologyLanguageManager(TechnologyLanguageDao technologyLanguageDao,
			ProgrammingLanguageDao programmingLanguageDao) {
		this.technologyLanguageDao = technologyLanguageDao;
		this.programmingLanguageDao = programmingLanguageDao;
	}

	public List<GetAllTechnologyLanguagesResponse> getAll() {
		List<TechnologyLanguage> technologyLanguages = technologyLanguageDao.findAll();
		List<GetAllTechnologyLanguagesResponse> technologyLanguagesResponse = new ArrayList<GetAllTechnologyLanguagesResponse>();

		for (TechnologyLanguage technologyLanguage : technologyLanguages) {
			GetAllTechnologyLanguagesResponse technologyResponseItem = new GetAllTechnologyLanguagesResponse();

			ProgrammingLanguage programmingLanguage = programmingLanguageDao
					.getReferenceById(technologyLanguage.getProgrammingLanguage().getId());

			technologyResponseItem.setId(technologyLanguage.getId());
			technologyResponseItem.setProgrammingLanguage(programmingLanguage.getName());
			technologyResponseItem.setName(technologyLanguage.getName());

			technologyLanguagesResponse.add(technologyResponseItem);

		}

		return technologyLanguagesResponse;
	}

	@Override
	public GetTechnologyLanguageByIdResponse getTechnologyLanguageById(int id) throws Exception {
		
		TechnologyLanguage techLanguage = technologyLanguageDao.getReferenceById(id);

		ProgrammingLanguage programmingLanguage = programmingLanguageDao
				.getReferenceById(techLanguage.getProgrammingLanguage().getId());

		GetTechnologyLanguageByIdResponse getTechnologyLanguageByIdResponse = new GetTechnologyLanguageByIdResponse();
		getTechnologyLanguageByIdResponse.setId(techLanguage.getId());
		getTechnologyLanguageByIdResponse.setProgrammingLanguage(programmingLanguage.getName());
		getTechnologyLanguageByIdResponse.setName(techLanguage.getName());

		return getTechnologyLanguageByIdResponse;
	}

	@Override
	public void add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) throws Exception {
		if (createTechnologyLanguageRequest.getName().isBlank()
				|| isNameExist(createTechnologyLanguageRequest.getName())) {
			throw new Exception("Koşullar sağlanamadı.İsim alanı boş veya sistemimize daha önce kaydedilmiştir.");
		}

		TechnologyLanguage technologyLanguage = new TechnologyLanguage();
		technologyLanguage.setName(createTechnologyLanguageRequest.getName());

		this.technologyLanguageDao.save(technologyLanguage);

	}

	@Override
	public void update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) throws Exception {

		ProgrammingLanguage programmingLanguage = programmingLanguageDao
				.getReferenceById(updateTechnologyLanguageRequest.getProgrammingLanguageId());

		TechnologyLanguage technologyLanguage = new TechnologyLanguage();
		technologyLanguage.setId(updateTechnologyLanguageRequest.getId());
		technologyLanguage.setName(updateTechnologyLanguageRequest.getName());
		technologyLanguage.setProgrammingLanguage(programmingLanguage);

		if (updateTechnologyLanguageRequest.getName().isEmpty()
				|| isNameExist(updateTechnologyLanguageRequest.getName())) {
			throw new Exception("Koşulları uygun değildir.");
		}

		TechnologyLanguage updateTechnologyLanguage = technologyLanguageDao
				.getReferenceById(technologyLanguage.getId());
		updateTechnologyLanguage.setName(technologyLanguage.getName());
		updateTechnologyLanguage.setProgrammingLanguage(programmingLanguage);

		this.technologyLanguageDao.save(updateTechnologyLanguage);

	}

	@Override
	public void delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest) {
		TechnologyLanguage technologyLanguage = new TechnologyLanguage();
		technologyLanguage.setId(deleteTechnologyLanguageRequest.getId());
		technologyLanguageDao.delete(technologyLanguage);

	}

	private boolean isNameExist(String name) {
		for (TechnologyLanguage tech : technologyLanguageDao.findAll()) {
			if (tech.getName().equals(name)) {
				return true;
			}

		}
		return false;
	}

	private boolean isIdExist(int id) {
		for (TechnologyLanguage tech : technologyLanguageDao.findAll()) {
			if (tech.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
