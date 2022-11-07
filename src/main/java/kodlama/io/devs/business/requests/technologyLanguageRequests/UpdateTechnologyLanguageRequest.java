package kodlama.io.devs.business.requests.technologyLanguageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyLanguageRequest {
	private int id;
	private String name;
}
