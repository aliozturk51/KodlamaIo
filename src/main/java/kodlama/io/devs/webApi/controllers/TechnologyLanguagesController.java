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
import kodlama.io.devs.business.responses.technologyLanguageResponses.GetTechnologyLanguageByIdResponse;

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
	
	@GetMapping("/getbyid")
	public GetTechnologyLanguageByIdResponse getById(int id) throws Exception {
		return technologyLanguageService.getTechnologyLanguageById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) throws Exception {
		this.technologyLanguageService.add(createTechnologyLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) throws Exception  {
		this.technologyLanguageService.update(updateTechnologyLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest) {
		this.technologyLanguageService.delete(deleteTechnologyLanguageRequest);
	}
	
	

}
