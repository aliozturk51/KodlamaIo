package kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.TechnologyLanguage;

public interface TechnologyLanguageDao extends JpaRepository<TechnologyLanguage, Integer> {

}
