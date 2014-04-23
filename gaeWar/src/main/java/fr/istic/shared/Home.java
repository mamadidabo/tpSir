package fr.istic.shared;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="HOME")
public class Home implements IsSerializable{
	private long id;
	
	private String rue;
	
	private String ville;
	
	private Person personne;

	private List<Heater> consommations = new ArrayList<Heater>();
	
	/**
	 * Constructeur vide de la classe Home
	 */
	public Home(){
		
	}
	
	/**
	 * Constructeur de la classe Home
	 * @param rue	chaine de caractere indiquant le nom de la rue
	 * @param ville	chaine de caractere indiquant la ville
	 * @param personne	objet Person à qui appartient la maison
	 * @param consommations Liste de consommation de la maison
	 */
	public Home(String rue, String ville, Person personne,
			List<Heater> consommations) {
		this.rue = rue;
		this.ville = ville;
		this.personne = personne;
		this.consommations = consommations;
	}

	/**
	 * Retourne l'id d'une maison
	 * @return ID
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * Choisir l'ID de la maison (géré automatiquement)
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtenir le nom de la rue
	 * @return chaine de caractere contenant le nom de la rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Modifie le nom de la rue
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * retourne la Ville de la maison
	 * @return une chaine de caractere contenant le nom de la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * modifie le nom de la ville
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * retourne les consommations de la maison
	 * @return une liste d'objet Heater
	 */
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="HOME_ID")
	public List<Heater> getConsommations() {
		return consommations;
	}

	/**
	 * modifie les consommations
	 * @param consommations
	 */
	public void setConsommations(List<Heater> consommations) {
		this.consommations = consommations;
	}
	
	/**
	 * retourne le proprietaire de la maison
	 * @return un objet de type Person
	 */
	@ManyToOne
	public Person getPersonne() {
		return personne;
	}

	/**
	 * modifie le proprietaire de la maison
	 * @param personne
	 */
	public void setPersonne(Person personne) {
		this.personne = personne;
	}

	/**
	 * retourne l'objet sous forme de chaine de caractere
	 */
	@Override
	public String toString() {
		return "Home [id=" + id + ", rue=" + rue + ", ville=" + ville
				+ ", consommations=" + consommations + "]";
	}
}
