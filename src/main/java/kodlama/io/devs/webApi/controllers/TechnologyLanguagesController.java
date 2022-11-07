package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyLanguageService;
import kodlama.io.devs.business.requests.technologyLanguageRequests.CreateTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.DeleteTechnologyLanguageRequest;
import kodlama.io.devs.business.requests.technologyLanguageRequests.UpdateTechnologyLanguageRequest;
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetAllTechnologyLanguagesResponse;

@RestController
@RequestMapping("/api/technologylanguages")
public class TechnologyLanguagesController {
	
	private TechnologyLanguageService technologyLanguageService;
	
	@Autowired
	public TechnologyLanguagesController(TechnologyLanguageService technologyLanguageService) {
		this.technologyLanguageService = technologyLanguageService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllTechnologyLanguagesResponse> getAll() {
		return technologyLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) {
		this.technologyLanguageService.add(createTechnologyLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) {
		this.technologyLanguageService.update(updateTechnologyLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest) {
		this.technologyLanguageService.delete(deleteTechnologyLanguageRequest);
	}
	
	

}
