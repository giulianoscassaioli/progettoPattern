package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="museo")
public class Museo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String citta;
	
	private List <Dipinto> dipinti;
	
	
	public void aggiungiDipinto(Dipinto dipinto) {
		getDipinti().add(dipinto);
		dipinto.setMuseo(this);
		
	}
	
	
	@Id
	@Column(name="id_museo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="citta")
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	
	//nella one to many gli diamo il mapped by
	@OneToMany(mappedBy = "museo",cascade = CascadeType.PERSIST)
	public List<Dipinto> getDipinti() {
		
		if(dipinti==null) {
			dipinti=new ArrayList<>();
		}
		return dipinti;
	}
	public void setDipinti(List<Dipinto> dipinti) {
		this.dipinti = dipinti;
	}
	
	
	
	
	
	

}
