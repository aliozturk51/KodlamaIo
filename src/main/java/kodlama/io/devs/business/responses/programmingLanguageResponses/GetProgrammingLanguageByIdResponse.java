package kodlama.io.devs.business.responses.programmingLanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgrammingLanguageByIdResponse {
	private int id;
	private String name;
}
