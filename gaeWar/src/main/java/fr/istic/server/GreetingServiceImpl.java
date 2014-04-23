package fr.istic.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.client.GreetingService;
import fr.istic.shared.ElectronicDevice;
import fr.istic.shared.Heater;
import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

	/**
	 * prend en entree une chaine de caractere
	 * et la retourne en majuscule
	 */
	  public String greetServer(String input) throws IllegalArgumentException {
		  return input.toUpperCase();
	  }

  
  private EntityManager manager;

  /**
   * Permet d'eviter les erreurs lorsque l'on retourne
   * des objet de type Person
   * @param p
   * @return
   */
  private Person serializePerson(Person p){
	  	List<Person> lp = new ArrayList<Person>();
		lp.addAll(p.getFriends());
		
		for (Person pers : lp){
			List<Person> lp2 = new ArrayList<Person>();
			lp2.addAll(pers.getFriends());
			
			List<ElectronicDevice> le2 = new ArrayList<ElectronicDevice>();
			le2.addAll(pers.getEd());
			
			List<Home> lh2 = new ArrayList<Home>();
			lh2.addAll(pers.getMaison());
			
			pers.setFriends(lp2);
			pers.setEd(le2);
			pers.setMaison(lh2);
		}
		
		List<ElectronicDevice> le = new ArrayList<ElectronicDevice>();
		le.addAll(p.getEd());
		List<Home> lh = new ArrayList<Home>();
		lh.addAll(p.getMaison());
		
		for (Home house : lh) {
			List<Heater> lhe = new ArrayList<Heater>();
			lhe.addAll(house.getConsommations());
			house.setConsommations(lhe);
		}
		
		p.setEd(le);
		p.setFriends(lp);
		p.setMaison(lh);
		
		return p;
  }
  /**
   * Cherche une personne dans la base
   * @param id
   * @return un objet de type Person
   */
  private Person findPerson(int id){
	  String text = "select e from Person e where e.id = '" + id +"'";
	  TypedQuery<Person> requete = manager.createQuery(text,Person.class);
	  return (Person)requete.getSingleResult();
  }
	/**
	 * @param args
	 * @throws ServletException 
	 */
	public  void init() throws ServletException {
		super.init();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		manager = factory.createEntityManager();
	}

	/**
	 * Ajout d'un utilisateur dans la base
	 */
	  public void createPerson(String nom, String prenom){
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			Person p = new Person(nom,prenom);
			manager.persist(p);
			tx.commit();
	  }
  	/**
  	 * retourne une liste de personne contenant un ou plusieurs objets Person
  	 */
	public List<Person> affichePerson(int id) {
		String text;
		if(id < 0){
			text = "select e from Person e";
		}else{
			text = "select e from Person e where e.id = '" + id +"'";
		}
		TypedQuery<Person> requete = manager.createQuery(text,Person.class);
		List<Person> liste = (List<Person>)requete.getResultList();
		List<Person> lp = new ArrayList<Person>();
		
		for (Person info : liste) {
			lp.add(serializePerson(info));
		}
		
		return lp;
	}

	/**
	 * Ajouter une consommation dans la base (pour le TP JNA)
	 */
	public void pushConso(String value) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Heater h = new Heater(value);
		manager.persist(h);
		tx.commit();
	}

	/**
	 * Supprimmer une personne de la base
	 */
	public void deletePerson(int id) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(findPerson(id));
		tx.commit();
	}
	
	/**
	 * ajouter une maison a une personne dans la base 
	 */
	public void addHome(String ad, String ville, int id) {
		Person p = findPerson(id);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Home h = new Home(ad, ville, p, new ArrayList<Heater>());
		manager.persist(h);
		manager.refresh(p);
		tx.commit();
	}
	
	/**
	 * Supprimer une maison de la base 
	 */
	public void deleteHome(int id) {
		String text = "select h from Home h where h.id = '" + id +"'";
		TypedQuery<Home> requete = manager.createQuery(text,Home.class);
		Home h = (Home)requete.getSingleResult();
		
		List<Home> lh = h.getPersonne().getMaison();
		lh.remove(h);
		h.getPersonne().setMaison(lh);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(h);
		tx.commit();
	}
	
	/**
	 * Ajouter un appareil electromenager a une personne dans la base 
	 */
	public void addEd(String type, String brand, int id) {
		Person p = findPerson(id);

		ElectronicDevice ed = new ElectronicDevice(type,brand);
		List<ElectronicDevice> le = p.getEd();
		le.add(ed);
		p.setEd(le);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(ed);
		tx.commit();
	}
	
	/**
	 * Supprimmer un appareil electromenager de la base 
	 */
	public void deleteEd(int id, int pers) {
		String text = "select e from  ElectronicDevice e where e.id = '" + id +"'";
		TypedQuery<ElectronicDevice> requete = manager.createQuery(text,ElectronicDevice.class);
		ElectronicDevice ed = (ElectronicDevice)requete.getSingleResult();
		
		Person p = findPerson(pers);
		
		List<ElectronicDevice> e = p.getEd();
		e.remove(ed);
		p.setEd(e);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(ed);
		tx.commit();
	}
	
	/**
	 * Ajouter une consommation a une personne dans la base
	 */
	public void addConso(String conso, int index, int pers) {
		Person p = findPerson(pers);
		
		Heater consommation = new Heater(conso);
		
		List<Heater> lh = p.getMaison().get(index).getConsommations();
		lh.add(consommation);
		p.getMaison().get(index).setConsommations(lh);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(consommation);
		tx.commit();
	}
	
	/**
	 * Supprimmer une consommation de la base 
	 */
	public void deleteConso(int id_conso, int index, int pers) {
		String text = "select h from  Heater h where h.id = '" + id_conso +"'";
		TypedQuery<Heater> requete = manager.createQuery(text,Heater.class);
		Heater h = (Heater)requete.getSingleResult();

		Person p = findPerson(pers);
		List<Heater> lh = p.getMaison().get(index).getConsommations();
		lh.remove(h);
		p.getMaison().get(index).setConsommations(lh);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(h);
		tx.commit();
	}
	
	/**
	 * Ajouter une personne comme ami
	 */
	public void addFriend(int id_friend, int pers) {
		Person p = findPerson(pers);
		List<Person> lp = p.getFriends();
		Person friend = findPerson(id_friend);
		lp.add(friend);
		p.ajouterAmis(lp);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(p);
		manager.persist(friend);
		tx.commit();
	}
	
	/**
	 * Supprimmer un ami
	 */
	public void deleteFriend(int id_friend, int pers) {
		Person p = findPerson(pers);
		Person friend = findPerson(id_friend);
		p.supprimmerAmis(friend);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(p);
		tx.commit();
	}
	
	/**
	 * retourne la liste des amis qu'une personne peut ajouter
	 */
	public List<Person> createListAddFriend(int pers) {
		String text = "SELECT p from Person p WHERE p.id != '" + pers + "'";
		TypedQuery<Person> requete = manager.createQuery(text,Person.class);
		List<Person> lf = (List<Person>)requete.getResultList();
		
		Person p = findPerson(pers);
		
		List<Person> lp = new ArrayList<Person>();

		for (Person info : lf) {
			if(!p.getFriends().contains(info)){
				lp.add(serializePerson(info));
			}
		}

		return lp;
	}
  
}
