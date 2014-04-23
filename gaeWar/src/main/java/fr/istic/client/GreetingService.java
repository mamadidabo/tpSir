package fr.istic.client;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.shared.Person;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService, Serializable {
  String greetServer(String name) throws IllegalArgumentException;
  
  void createPerson(String nom, String prenom);
  
  List<Person> affichePerson(int id);
  
  void pushConso(String value);
  
  void deletePerson(int id);
  
  void addHome(String adresse, String ville, int id);
  
  void deleteHome(int id);
  
  void addEd(String type, String brand, int id);
  
  void deleteEd(int id, int pers);
  
  void addConso(String conso, int index, int pers);
  
  void deleteConso(int id_conso, int pers, int index_maison);
  
  void addFriend(int id_friend, int pers);
  
  void deleteFriend(int id_friend, int pers);
  
  List<Person> createListAddFriend(int pers);
}
