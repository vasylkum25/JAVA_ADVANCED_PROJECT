package kum.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch=FetchType.LAZY)
	private Cuisine cuisine;
	
	private int weight;
	
	private List<Ingredient> ingredients = new ArrayList<>();
	
}
