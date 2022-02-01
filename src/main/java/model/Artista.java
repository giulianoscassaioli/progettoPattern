package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="artista")

@NamedQuery(name="artista.dipinti.getAll",query = "SELECT a.nome,a.cognome,d.titolo FROM Artista a JOIN a.dipinti d")


public class Artista implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String cognome;
	private String dataN;
	
	private List<Dipinto> dipinti; //lo richiamo con l'alias d nella query senza dover passare nella terza tabella Realizza come facevamo in SQL normale di pgAdmin
	
	
	@Id
	@Column(name="id_artista")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column(name="datanascita")
	public String getDataN() {
		return dataN;
	}
	public void setDataN(String dataN) {
		this.dataN = dataN;
	}
	
	
	//lo faccio senza il reference perche è chiaro il nome della tabella a qui mi riferisco
	//il reference si utilzza per specificare il nome della tabella dell entity che contiene la chiave esterna
	//quindi nel caso di name="id_artista"  avrei dovuto mettere reference="artista"
	@ManyToMany
	@JoinTable(name="realizza",
	joinColumns = @JoinColumn(name="id_artista"),
	inverseJoinColumns = @JoinColumn(name="id_dipinto")
    )
	public List<Dipinto> getDipinti() {
		return dipinti;
	}
	public void setDipinti(List<Dipinto> dipinti) {
		this.dipinti = dipinti;
	}
	
	
	
	
	
	

}
