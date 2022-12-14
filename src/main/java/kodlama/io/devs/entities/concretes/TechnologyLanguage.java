package kodlama.io.devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name ="technologyLanguages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class TechnologyLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name= "name")
	private String name;
	
	
	//Tekrar yaz.
	@ManyToOne()
	@JoinColumn(name="programmingLanguageId")
	private ProgrammingLanguage programmingLanguage;

}
