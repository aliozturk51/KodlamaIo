package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
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
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageDao.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageDao.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		
		programmingLanguageDao.add(programmingLanguage);
	}
	
	

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageDao.update(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		programmingLanguageDao.delete(id);

	}

}
