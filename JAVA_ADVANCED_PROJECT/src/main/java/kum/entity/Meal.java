package kum.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="meal")
public class Meal extends AbstractEntity {

	private String title;
	
	@Column(length=1023)
	private String description;
	
	private BigDecimal price;
	
	private String photoUrl;
	
	private int version;
	
	private String cuisine;
	
	private int weight;
	
	private List<String> ingredients;
	
}
