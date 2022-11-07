package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;
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
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();

	}

	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getById(@PathVariable("id") int id) {
		return getById(id);
	}
	
	
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		 programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}

}
