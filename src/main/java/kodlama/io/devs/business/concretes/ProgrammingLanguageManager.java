package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageDao programmingLanguageDao;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	// Sorunsuz
	public List<GetAllProgrammingLanguagesResponse> getAll() {

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageDao.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage prLang : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(prLang.getId());
			responseItem.setName(prLang.getName());
			programmingLanguagesResponse.add(responseItem);
		}

		return programmingLanguagesResponse;
	}

	// Hata düzeltilecek
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageDao.findAll();

		if (programmingLanguage.getName().isEmpty()) {
			throw new Exception("İsim bölümü boş geçilemez!");
		}

		for (ProgrammingLanguage progLang : programmingLanguages) {
			if (progLang.getName() == programmingLanguage.getName()) {
				throw new Exception("Programlama dili isimleri tekrar edemez.");
			}
		}

		this.programmingLanguageDao.save(programmingLanguage);

	}

	// Update yaparken isim tekrarı oluyor.
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());

		this.programmingLanguageDao.save(programmingLanguage);

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageDao.findAll();

		if (programmingLanguage.getName().isEmpty()) {
			throw new Exception("İsim bölümü boş geçilemez!");
		}

		for (ProgrammingLanguage prLangs : programmingLanguages) {
			if (prLangs.getName() == programmingLanguage.getName()) {
				throw new Exception("Programala dili isimleri tekrar edemez.");
			}
		}

		ProgrammingLanguage updateProgrammingLanguage = programmingLanguageDao
				.getReferenceById(programmingLanguage.getId());
		updateProgrammingLanguage.setName(programmingLanguage.getName());
		programmingLanguageDao.save(updateProgrammingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
