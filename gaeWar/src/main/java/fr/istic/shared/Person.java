package fr.istic.shared;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
// ne donne pas le nom de classe a la table mais celui indiqu� dans l'attribut name
@Table(name="PERSON")
public class Person implements IsSerializable{

	private long id;
	
	private String name;

	private String prenom;

	private List<Home> maison = new ArrayList<Home>();
	
	private List<ElectronicDevice> ed = new ArrayList<ElectronicDevice>();
	
	private List<Person> friends = new ArrayList<Person>();

	/**
	 * Constructeur complet de la classe Person
	 * @param name	Nom de la personne
	 * @param prenom	Prenom de la personn
	 * @param maison	Liste des maisons d'une personne
	 * @param ed	Liste des appareils electroniques d'une personne
	 * @param friends	Liste d'amis d'une personne
	 */
	public Person(String name, String prenom, List<Home> maison,
			List<ElectronicDevice> ed, List<Person> friends) {
		this.name = name;
		this.prenom = prenom;
		this.maison = maison;
		this.ed = ed;
		this.friends = friends;
	}

	/**
	 * Constructeur vide de la classe Person
	 */
	public Person(){
		
	}

	/**
	 * Constructeur de la classe Person 
	 * @param name
	 * @param prenom
	 */
	public Person(String name, String prenom){
		this.name = name;
		this.prenom = prenom;
	}
	
	/**
	 * Retourne l'ID d'une personne
	 * @return l'id
	 */
	@Id
	@GeneratedValue
	public long getId(){
		return id;
	}
	
	/**
	 * Permet de choisir l'id de la personne (non conseillé, géré automatiquement)
	 * @param un id
	 */
	public void setId(long id){
		this.id = id;
	}
	
	/**
	 * Retourne le nom de la personne
	 * @return une chaine de caractere contenant le nom
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Permet de changer le nom de la personne
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Retourne le prenom d'une personne
	 * @return une chaine de caractère contenant le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Permet de changer le prenom de la personne
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Obtenir la liste des maisons de la personne
	 * @return une liste d'objet Home
	 */
	@OneToMany(mappedBy = "personne", cascade = {CascadeType.ALL})
	public List<Home> getMaison() {
		return maison;
	}

	/**
	 * Modifie la liste de maisons
	 * @param maison (liste d'objet de type Home)
	 */
	public void setMaison(List<Home> maison) {
		this.maison = maison;
	}

	/**
	 * Obtenir la liste des appareils electromenagers d'une personne
	 * @return une liste d'objet de type ElectronicDevice
	 */
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="PERSON_ID")
	public List<ElectronicDevice> getEd() {
		return ed;
	}

	/**
	 * Modifie la liste des appareils electromenagers
	 * @param ed (liste d'objet de type ElectronicDevice)
	 */
	public void setEd(List<ElectronicDevice> ed) {
		this.ed = ed;
	}

	/**
	 * Obtenir la liste des amis d'une personne
	 * @return une liste d'objets de type Person
	 */
	@ManyToMany(cascade = {CascadeType.ALL})
	public List<Person> getFriends() {
		return friends;
	}

	/**
	 * Modifie a liste des amis d'une personne
	 * @param friends
	 */
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	/**
	 * Supprime un amis chez une personne et la personne qui était amis avec
	 * @param p
	 */
	public void supprimmerAmis(Person p){
		if(this.friends.contains(p)){
			this.friends.remove(p);
			p.supprimmerAmis(this);
		}
	}
	
	/**
	 * ajoute un ami a une personne et rajoute cette personne en tant qu'amis à l'autre personne
	 * @param p
	 */
	public void ajouterAmi(Person p){
		if(!this.friends.contains(p)){
			this.friends.add(p);
			p.ajouterAmi(this);
		}
	}
	
	/**
	 * ajouter a une personne plusieurs amis
	 * @param lp
	 */
	public void ajouterAmis(List<Person> lp){
		for(int i=0; i<lp.size(); i++){
			ajouterAmi(lp.get(i));
		}
	}
	
	/**
	 * retourne un objet de type Person sous forme d'une chaine de caractere
	 */
	 @Override
     public String toString() {
		 	String chfriends = new String();
		 	for(int i=0; i<friends.size(); i++){
		 		chfriends += friends.get(i).getName() + " " + friends.get(i).getPrenom();
		 	}
            return "Person [id=" + id + ", name=" + name + ", prenom="+ prenom +", amis=" + chfriends + "maison = " + maison.toString() + "]";
     }
}