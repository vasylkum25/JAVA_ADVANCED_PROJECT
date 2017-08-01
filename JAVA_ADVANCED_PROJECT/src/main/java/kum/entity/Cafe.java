package kum.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="cafe")
public class Cafe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
	
	private BigDecimal rate;
	
	private String name;
	
	private String photoUrl;
	
	private int version;
	
	private String address;
	
	private String shortDescription;
	
	@Lob
	private String fullDescription;
	
	@Enumerated
	private Type type;
	
	private String phone;
	
	private String email;
	
	private String open;
	
	private String close;

}
