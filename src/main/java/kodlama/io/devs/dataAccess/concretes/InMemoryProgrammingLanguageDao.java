package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageDao {

	List<ProgrammingLanguage> programmingLanguages;

	@Autowired
	public InMemoryProgrammingLanguageDao() {
		programmingLanguages = new ArrayList<>();
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
//		return programmingLanguages.get(id);
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {

		for (ProgrammingLanguage programmingLang : programmingLanguages) {
			if (programmingLang.getName() == programmingLanguage.getName()) {
				programmingLanguages.add(programmingLanguage);
			}

		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage programmingLang : programmingLanguages) {
			if (programmingLang.getId() == programmingLanguage.getId()) {
				programmingLang.setId(programmingLanguage.getId());
				programmingLang.setName(programmingLanguage.getName());
			}
		}

	}

	@Override
	public void delete(int id) {
		for (ProgrammingLanguage programmingLang : programmingLanguages) {
			if (programmingLang.getId() == id) {
				programmingLanguages.remove(programmingLang);
			}
		}

	}

}
