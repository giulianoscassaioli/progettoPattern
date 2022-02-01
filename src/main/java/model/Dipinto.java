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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name= "dipinto")
@NamedQuery(name="dipinti.artista.getAll",query = "SELECT a.nome,a.cognome,d.titolo FROM Dipinto d JOIN d.artisti a")

public class Dipinto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titolo;
	private int anno;
	
	private Museo museo;
	
	private List<Artista> artisti; //lo richiamo con l'alias d nella query senza dover passare nella terza tabella Realizza come facevamo in SQL normale di pgAdmin
	
	

	@Id
	@Column(name="id_dipinto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="titolo")
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Column(name="anno")
	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

    //cè un museo e piu dipinti quindi la foreign key la specifichaimo qui
	//nella many to one gli diamo la foreing key
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_museo") //nome della foreing key
	
	public Museo getMuseo() {
		return museo;
	}

	public void setMuseo(Museo museo) {
		this.museo = museo;
	}

	@ManyToMany
	@JoinTable(name="realizza",
	joinColumns = @JoinColumn(name="id_dipinto"),
	inverseJoinColumns = @JoinColumn(name="id_artista"))
	public List<Artista> getArtisti() {
		return artisti;
	}

	public void setArtisti(List<Artista> artisti) {
		this.artisti = artisti;
	}
	
	
	
	

}
