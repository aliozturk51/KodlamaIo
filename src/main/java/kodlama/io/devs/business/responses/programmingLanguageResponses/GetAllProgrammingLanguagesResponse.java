package kodlama.io.devs.business.responses.programmingLanguageResponses;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {
	
	private int id;
	private String name;

}
