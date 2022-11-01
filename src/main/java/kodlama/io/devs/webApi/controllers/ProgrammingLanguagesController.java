package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();

	}

	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getById(@PathVariable("id") int id) {
		return programmingLanguageService.getById(id);
	}
	
	
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) {
		 programmingLanguageService.add(programmingLanguage);
	}
	
	
	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.update(programmingLanguage);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable ("id") int id) {
		programmingLanguageService.delete(id);
	}

}
