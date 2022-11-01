package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageDao {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	
	void add(ProgrammingLanguage programmingLanguage);
	void update(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	
}
