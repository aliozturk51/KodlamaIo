package kodlama.io.devs.business.responses.technologyLanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTechnologyLanguageByIdResponse {
	
	private int id;
	private String name;
}
