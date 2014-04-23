package fr.istic.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface GreetingServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void greetServer( java.lang.String name, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void createPerson( java.lang.String nom, java.lang.String prenom, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void affichePerson( int id, AsyncCallback<java.util.List<fr.istic.shared.Person>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void pushConso( java.lang.String value, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void deletePerson( int id, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void addHome( java.lang.String adresse, java.lang.String ville, int id, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void deleteHome( int id, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void addEd( java.lang.String type, java.lang.String brand, int id, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void deleteEd( int id, int pers, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void addConso( java.lang.String conso, int index, int pers, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void deleteConso( int id_conso, int pers, int index_maison, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void addFriend( int id_friend, int pers, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void deleteFriend( int id_friend, int pers, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void createListAddFriend( int pers, AsyncCallback<java.util.List<fr.istic.shared.Person>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GreetingServiceAsync instance;

        public static final GreetingServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GreetingServiceAsync) GWT.create( GreetingService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "greet" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
