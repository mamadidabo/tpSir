package fr.istic.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="HEATER")
public class Heater implements IsSerializable{
	
	private long id;
	
	private String consommation;

	/**
	 * constructeur vide de la classe heater
	 */
	public Heater(){
		
	}
	
	/**
	 * constructeur de la classe Heater
	 * @param consommation 
	 */
	public Heater(String consommation) {
		this.consommation = consommation;
	}

	/**
	 * retourne l'id d'une consommation
	 * @return ID
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * modifie l'id d'une consommation (deconseille car géré automatiquement)
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * retourne la valeur d'une consommation
	 * @return une chaine de caractere contenant la consommation
	 */
	public String getConsommation() {
		return consommation;
	}

	/**
	 * modifier une consommation
	 * @param consommation
	 */
	public void setConsommation(String consommation) {
		this.consommation = consommation;
	}

	/**
	 * retourne sous forme de chaine de caractere la valeur d'un objet de type Heater
	 */
	@Override
	public String toString() {
		return "Heater [id=" + id + ", consommation=" + consommation + "]";
	}

}
