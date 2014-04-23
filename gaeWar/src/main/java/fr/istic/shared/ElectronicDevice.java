package fr.istic.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="ED")
public class ElectronicDevice  implements IsSerializable{
	private long id;
	
	private String name;
	
	private String brand;
	
	/**
	 * Constructeur de la classe 
	 * @param name
	 * @param brand
	 */
	public ElectronicDevice( String name, String brand) {
		this.name = name;
		this.brand = brand;
	}

	/**
	 * Constructeur vide de la classe
	 */
	public ElectronicDevice(){
		
	}

	/**
	 * retourne l'id d'un appareil electromenager
	 * @return
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * modifie l'id d'un appareil electromenager (deconseille, car géré de maniere auto)
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * retourne le nom de l'appareil
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * modifie le nom de l'appareil
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * retourne la marque de l'appareil
	 * @return
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * modifie la marque de l'appareil
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * retourne un objet de type ElectronicDevice sous forme de chaine de caractere
	 */
	@Override
	public String toString() {
		return "ElectronicDevice [id=" + id + ", name=" + name + ", brand="
				+ brand + "]";
	}
}
