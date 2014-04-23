package fr.istic.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;


import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import java.util.List;
import fr.istic.shared.ElectronicDevice;
import fr.istic.shared.Heater;
import fr.istic.shared.Home;
import fr.istic.shared.Person;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FirstGWT implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	//private final Messages messages = GWT.create(Messages.class);
	
	// definition du panneaux sur lequel on accroche les widgets
	final RootPanel rootPanel = RootPanel.get();
	
	// sauvegarde de l'emplacement du bouton ajouter consonmmation
	int empl_btnAddConso = 0;    
	
	// création des boutons
	private Button createPerson = new Button("Creer Personne");
	private Button btnAddHome = new Button("Ajouter une adresse");
	private Button btnSaveHome = new Button("Enregistrer");
	private Button btnAddConso = new Button("Ajouter une conso");
	private Button btnSaveConso = new Button("Enregistrer");
	private Button btnAddEd = new Button("Ajouter un equipement");
	private Button btnSaveEd = new Button("Enregistrer");
	private Button btnCancelMoreInfo = new Button("Annuler");
	private Button btnAddFriend = new Button("Ajouter un ami");
	private Button btnSaveFriend = new Button("Enregistrer");
	
	// création des labels
	private Label lblNom = new Label("nom");
	private Label lblPrnom = new Label("prenom");
	
	// création des textbox
	private TextBox nameField = new TextBox();
	private TextBox firstNameField = new TextBox();
	private TextBox txtbxAdresse = new TextBox();
	private TextBox txtbxVille = new TextBox();
	private TextBox txtbxEdBrand = new TextBox();
	private TextBox txtbxConso = new TextBox();
	
	//ListBox
	private ListBox lbEdType = new ListBox();
	private ListBox lbHome = new ListBox();
	private ListBox lbFriend = new ListBox();
	
	// creation d'un tableau
	private FlexTable ftAffiche = new FlexTable();
	private FlexTable ftMoreInfo = new FlexTable();
	private FlexTable ftHome= new FlexTable();
	private FlexTable ftEd = new FlexTable();
	private FlexTable ftFriends = new FlexTable();

	//creation du menu
	private MenuBar menuBar = new MenuBar(false);
	
	//creation du popup panel de chargement
	//private final PopupPanel popup = new PopupPanel(true);
	
	/**
	 * gestion de l'affichage au lancement de l'application
	 */
	private void initPanel(final RootPanel rootPanel){
		rootPanel.clear();
		rootPanel.setSize("1024", "768");
		rootPanel.add(menuBar, 0, 0);
		addPersonDisplay(rootPanel);
	}
	
	/**
	 * gestion affichage de la page créer personne
	 */
	private void addPersonDisplay(RootPanel rootPanel){
		rootPanel.clear();
		rootPanel.add(menuBar, 0, 0);
		rootPanel.add(createPerson, 56, 227);
		rootPanel.add(lblNom, 10, 132);
		rootPanel.add(lblPrnom, 10, 170);
		rootPanel.add(nameField, 59, 125);
		// on met le curseur dans la textbox du nom
		nameField.setFocus(true);
		rootPanel.add(firstNameField, 59, 163);
	}
	
	/**
	 * fonction qui affiche toutes les personnes de la base
	 */
	private void displayALLPersons(){
		rootPanel.clear();
		greetingService.affichePerson((-1),new AsyncCallback<List<Person>>() {
			
			public void onSuccess(List<Person> arg0) {
				rootPanel.clear();
				rootPanel.add(menuBar, 0, 0);
				rootPanel.add(ftAffiche, 0, 25);
				
				ftAffiche.getCellFormatter().setVisible(0, 0, false);
				ftAffiche.setText(0, 1, "Nom");
				ftAffiche.setText(0, 2, "Prenom");
				
				for(int i=0; i<arg0.size();i++){
					final Button btnSupprimer = new Button("Supprimer");
					final Button btnPlusDinfos = new Button("Plus d'infos");
					
					ftAffiche.getCellFormatter().setVisible(i+1, 0, false);
					ftAffiche.setText(i+1, 0, String.valueOf(arg0.get(i).getId()));
					ftAffiche.setText(i+1, 1, arg0.get(i).getName());
					ftAffiche.setText(i+1, 2, arg0.get(i).getPrenom());
					ftAffiche.setWidget(i+1, 3, btnSupprimer);
					ftAffiche.setWidget(i+1, 4, btnPlusDinfos);
					
					btnSupprimer.addClickHandler(new ClickHandler(){
						public void onClick(ClickEvent arg0) {
							Cell clickedCell = ftAffiche.getCellForEvent(arg0);
				            final int rowIndex = clickedCell.getRowIndex();
				            
				               greetingService.deletePerson(Integer.parseInt(ftAffiche.getText(rowIndex, 0)), new AsyncCallback<Void>(){
				            	   
				            	   public void onSuccess(Void arg0) {
				            		   ftAffiche.removeRow(rowIndex);
									}
									
									public void onFailure(Throwable arg0) {
										System.err.println("Erreur suppression personne: " + arg0.toString());
									}
				               });
						}
					});
					
					btnPlusDinfos.addClickHandler(new ClickHandler(){
						public void onClick(ClickEvent arg0){
							moreInfoDisplay(rootPanel);
							Cell clickedCell = ftAffiche.getCellForEvent(arg0);
				            final int rowIndex = clickedCell.getRowIndex();
							displayMoreDetails(Integer.parseInt(ftAffiche.getText(rowIndex, 0)));
						}
					});
				}
			}
			
			public void onFailure(Throwable arg0) {
				System.err.println(arg0.toString());
			}
		});
	}

	/**
	 * gestion de l'affichage plus d'infos
	 */
	private void moreInfoDisplay(RootPanel rootPanel){
		rootPanel.clear();
		rootPanel.add(menuBar, 0, 0);
		rootPanel.add(ftMoreInfo,0,25);
	}
	
	/**
	 * Remplir une flexTable avec des adresses
	 * @param ft , correspond a la flextable
	 * @param lh , liste de maisons
	 * @return une flextable contenant les adresses
	 */
	private FlexTable remplirFtHome(final FlexTable ft, List<Home> lh){
		int i;
		for(i=0; i<lh.size();i++){
			Image image = new Image("images/bullet_delete.png");
			image.setWidth("20px");
			image.setHeight("20px");
			PushButton btnSupHome = new PushButton(image);
			btnSupHome.setWidth("20px");
			btnSupHome.setHeight("20px");
			ft.getCellFormatter().setVisible(i+1, 0, false);
			ft.setText(i+1, 0, String.valueOf(lh.get(i).getId()));
			ft.setText(i+1, 1, lh.get(i).getRue());
			ft.setText(i+1, 2, lh.get(i).getVille());
			ft.setWidget(i+1, 3, btnSupHome);
			btnSupHome.addClickHandler(new ClickHandler(){

				public void onClick(ClickEvent event) {
					Cell clickedCell = ft.getCellForEvent(event);
		            final int rowIndex = clickedCell.getRowIndex();
		            greetingService.deleteHome(Integer.parseInt(ftHome.getText(rowIndex, 0)), new AsyncCallback<Void>(){

						public void onFailure(Throwable caught) {
							System.err.println("SupHome " + caught.toString());
						}

						public void onSuccess(Void result) {
							ft.removeRow(rowIndex);
							displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0, 0)));
						}
		            	
		            });
				}
				
			});
		}
		ft.setWidget(ft.getRowCount(), 0, btnAddHome);
		return ft;
	}
	
	/**
	 * affiche plus d'infos sur une personne
	 * @param rowIndex , numéro de la ligne sur laquelle le clic a eu lieu
	 */
	private void displayMoreDetails(int rowIndex){
		greetingService.affichePerson(rowIndex, new AsyncCallback<List<Person>>(){

			public void onFailure(Throwable arg0) {
				System.err.println("more info " + arg0.toString());
			}

			public void onSuccess(List<Person> result) {
				ftMoreInfo.clear(true);
				ftHome.clear(true);
				ftEd.clear(true);
				int cpt = 0;
				ftMoreInfo.getCellFormatter().setVisible(cpt, 0, false);
				ftMoreInfo.setText(cpt, 0, String.valueOf(result.get(0).getId()));
				cpt = cpt + 20;
				ftMoreInfo.setText(cpt, 1, "Informations:");
				ftMoreInfo.setText(cpt, 1, result.get(0).getName() + "   " + result.get(0).getPrenom());
				//ftMoreInfo.setText(cpt, 2, result.get(0).getPrenom());
				// affichage de la liste d'amis
				ftMoreInfo.setWidget(cpt, 4, remplirFtFriend(ftFriends, result.get(0).getFriends()));
				cpt = cpt + 20;
				ftMoreInfo.setText(cpt, 1, "Adresse");
				// remplir flextable avec adresse
				cpt++;
				ftMoreInfo.setWidget(cpt, 1,remplirFtHome(ftHome, result.get(0).getMaison()));
				cpt = cpt + 20;
				lbHome.clear();
				lbHome.addItem("Choisissez une maison");
				//remplir flextable avec consommation
				for(int i = 0; i<result.get(0).getMaison().size(); i++){
					ftMoreInfo.setText(cpt, 1, "maison du " + result.get(0).getMaison().get(i).getRue() + " à " + result.get(0).getMaison().get(i).getVille());
					ftMoreInfo.setWidget(cpt,2,remplirFtConso(new FlexTable(), i,result.get(0).getMaison().get(i).getConsommations()));
					lbHome.addItem(ftMoreInfo.getText(cpt, 1));
					cpt++;
				}
				cpt++;
				if(result.get(0).getMaison().size() > 0){
					ftMoreInfo.setWidget(cpt, 1, btnAddConso);
					empl_btnAddConso = cpt;
				}
				cpt = cpt + 20;
				ftMoreInfo.setText(cpt, 1, "Appareils electroménagers");
				cpt++;
				ftMoreInfo.setWidget(cpt, 1, remplirFtEd(ftEd,result.get(0).getEd()));
			}
			
		});
	}
	
	/**
	 * remplit une flextable avec des consommations
	 * @param ft	la flextable a remplir
	 * @param index	index a partir du quel on remplit la flextable
	 * @param lh	liste des consommations a mettre dans la flextable
	 * @return	une flextable remplit de consommations
	 */
	private FlexTable remplirFtConso(final FlexTable ft, final int index, List<Heater> lh){	
		int j = 0;
		int k = 0;
		for(int i=0; i<lh.size();i++){
			Image image = new Image("images/bullet_delete.png");
			image.setWidth("20px");
			image.setHeight("20px");
			PushButton btnSupConso = new PushButton(image);
			btnSupConso.setWidth("20px");
			btnSupConso.setHeight("20px");
			ft.getCellFormatter().setVisible(k, j, false);
			ft.setText(k, j, String.valueOf(lh.get(i).getId()));
			j++;
			ft.setText(k, j, lh.get(i).getConsommation() + " KwH");
			j++;
			ft.setWidget(k, j, btnSupConso);
			j++;
			if(j%15 == 0){
				j = 0;
				k++;
			}
			btnSupConso.addClickHandler(new ClickHandler(){

				public void onClick(ClickEvent event) {
					Cell clickedCell = ft.getCellForEvent(event);
		            final int rowIndex = clickedCell.getRowIndex();
		            final int columnIndex = clickedCell.getCellIndex();

		            greetingService.deleteConso(Integer.parseInt(ft.getText(rowIndex, (columnIndex-2))), index, Integer.parseInt(ftMoreInfo.getText(0, 0)), new AsyncCallback<Void>(){

						public void onFailure(Throwable caught) {
							Window.alert("Sup condo : " + caught.toString());
						}

						public void onSuccess(Void result) {
							ft.removeCell(rowIndex, (columnIndex));
							ft.removeCell(rowIndex, (columnIndex-1));
							ft.removeCell(rowIndex, columnIndex-2);
						}
		            	
		            });
				}
			});
		}
		return ft;
	}
	
	/**
	 * remplit une flextable avec des appareils electroménagers
	 * @param ft	la flextable a remplir
	 * @param le	les appareils a mettre dans la flextable
	 * @return		une flextable remplit d'appareils electroménagers
	 */
	private FlexTable remplirFtEd(final FlexTable ft, List<ElectronicDevice> le){
		int i;
		for(i=0; i<le.size();i++){
			Image image = new Image("images/bullet_delete.png");
			image.setWidth("20px");
			image.setHeight("20px");
			PushButton btnSupEd = new PushButton(image);
			btnSupEd.setWidth("20px");
			btnSupEd.setHeight("20px");
			ft.getCellFormatter().setVisible(i+1, 0, false);
			ft.setText(i+1, 0, String.valueOf(le.get(i).getId()));
			ft.setText(i+1, 1, le.get(i).getName());
			ft.setText(i+1, 2, le.get(i).getBrand());
			ft.setWidget(i+1, 3, btnSupEd);
			btnSupEd.addClickHandler(new ClickHandler(){

				public void onClick(ClickEvent event) {
					Cell clickedCell = ft.getCellForEvent(event);
		            final int rowIndex = clickedCell.getRowIndex();
					greetingService.deleteEd(Integer.parseInt(ft.getText(rowIndex, 0)), Integer.parseInt(ftMoreInfo.getText(0, 0)),new AsyncCallback<Void>(){

						public void onFailure(Throwable caught) {
							System.err.println("Sup ed " + caught.toString());
							
						}

						public void onSuccess(Void result) {
							ft.removeRow(rowIndex);
						}
						
					});
				}
			});
		}
		ft.setWidget(ft.getRowCount(), 0, btnAddEd);
		return ft;
	}
	
	/**
	 * remplit une flextable avec des amis
	 * @param ft	la flextable a remplir
	 * @param lp	liste des amis a mettre dans la flextable
	 * @return		une flextable remplit avec la liste d'amis
	 */
	private FlexTable remplirFtFriend(final FlexTable ft, List<Person> lp){
		int i;
		ft.clear(true);
		for(i=0; i<lp.size();i++){
			Image image = new Image("images/bullet_delete.png");
			image.setWidth("20px");
			image.setHeight("20px");
			PushButton btnSupFriend = new PushButton(image);
			btnSupFriend.setWidth("20px");
			btnSupFriend.setHeight("20px");
			ft.getCellFormatter().setVisible(i+1, 0, false);
			ft.setText(i+1, 0, String.valueOf(lp.get(i).getId()));
			ft.setText(i+1, 1, lp.get(i).getName());
			ft.setText(i+1, 2, lp.get(i).getPrenom());
			ft.setWidget(i+1, 3, btnSupFriend);
			btnSupFriend.addClickHandler(new ClickHandler(){

				public void onClick(ClickEvent event) {
					Cell clickedCell = ft.getCellForEvent(event);
		            final int rowIndex = clickedCell.getRowIndex();
		            greetingService.deleteFriend(Integer.parseInt(ft.getText(rowIndex, 0)), Integer.parseInt(ftMoreInfo.getText(0, 0)), new AsyncCallback<Void>(){

						public void onFailure(Throwable caught) {
							System.err.println("Erreur supression ajout ami : " + caught.toString());
						}

						public void onSuccess(Void result) {
							ft.removeRow(rowIndex);
						}
		            	
		            });
				}
				
			});
		}
		ft.setWidget(ft.getRowCount(), 0, btnAddFriend);
		return ft;
	}
	
	/**
	 * fonction qui sauvegarde une nouvelle adresse
	 */
	private void saveHome(){
		if(!(txtbxAdresse.getText().isEmpty()) && !(txtbxAdresse.getText().contains("Entrez votre Adresse")) && !(txtbxVille.getText().isEmpty()) && !(txtbxVille.getText().contains("Entrez votre ville"))){
			greetingService.addHome(txtbxAdresse.getText(), txtbxVille.getText(), Integer.parseInt(ftMoreInfo.getText(0,0)), new AsyncCallback<Void>(){
	
				public void onFailure(Throwable caught) {
					System.err.println(caught.toString());
				}
	
				public void onSuccess(Void result) {
					displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0,0)));
					txtbxAdresse.setVisible(false);
					txtbxVille.setVisible(false);
					btnSaveHome.setVisible(false);
					btnCancelMoreInfo.setVisible(false);
				}
			
			});
		}else{
			Window.alert("Veuillez remplir correctement les champs");
		}
	}
	
	/**
	 * fonction de sauvegarde d'un équipement
	 */
	private void saveEd(){
		if(lbEdType.getSelectedIndex() != 0 && !(txtbxEdBrand.getText().isEmpty()) && !(txtbxEdBrand.getText().contains("Entrez la marque"))){
			greetingService.addEd(lbEdType.getValue(lbEdType.getSelectedIndex()), txtbxEdBrand.getText(), Integer.parseInt(ftMoreInfo.getText(0,0)), new AsyncCallback<Void>(){
	
				public void onFailure(Throwable caught) {
					System.err.println(caught.toString());
				}
	
				public void onSuccess(Void result) {
					displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0,0)));
					lbEdType.setVisible(false);
					txtbxEdBrand.setVisible(false);
					btnSaveEd.setVisible(false);
					btnCancelMoreInfo.setVisible(false);
				}
			
			});
		}else{
			Window.alert("Veuillez remplir correctement les champs");
		}
	}
	/**
	 * Sauvegarde d'une consommation
	 */
	private void saveConso(){
		// lbHome.getSelectedIndex()-1 est l'index de la maison dans la liste de maison de la personne
		// case cachée du tableau ou se trouve l'id de la personne
		if(lbHome.getSelectedIndex() != 0 && !(txtbxConso.getText().isEmpty())){
			greetingService.addConso(txtbxConso.getText(), (lbHome.getSelectedIndex()-1), Integer.parseInt(ftMoreInfo.getText(0, 0)), new AsyncCallback<Void>(){
	
				public void onFailure(Throwable caught) {
					System.err.println("Fonction save conso : " + caught.toString());
				}
	
				public void onSuccess(Void result) {
					displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0,0)));
					txtbxConso.setVisible(false);
					lbHome.setVisible(false);
					btnSaveConso.setVisible(false);
					btnCancelMoreInfo.setVisible(false);
				}
				
			});
		}else{
			Window.alert("Veuillez remplir correctement les champs");
		}
	}
	/**
	 * ajouter un ami
	 */
	private void ajouterAmi(){
		greetingService.addFriend(Integer.parseInt(lbFriend.getValue(lbFriend.getSelectedIndex())), Integer.parseInt(ftMoreInfo.getText(0, 0)), new AsyncCallback<Void>(){

			public void onFailure(Throwable caught) {
				System.err.println("Fonction ajout amis : " + caught.toString());
			}

			public void onSuccess(Void result) {
				displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0,0)));
				lbFriend.setVisible(false);
				btnSaveFriend.setVisible(false);
				btnCancelMoreInfo.setVisible(false);
			}
			
		});
	}
	
	/**
	 * creation de la liste pour l'ajout d'amis
	 */
	private void ListAddFriend(){
		greetingService.createListAddFriend(Integer.parseInt(ftMoreInfo.getText(0, 0)), new AsyncCallback<List<Person>>(){

			public void onFailure(Throwable caught) {
				System.err.println("erreur creation liste d'ajout d'amis");
			}

			public void onSuccess(List<Person> result) {
				lbFriend.clear();
				for(int i = 0; i < result.size(); i++){
					lbFriend.addItem(result.get(i).getName() + result.get(i).getPrenom(), String.valueOf(result.get(i).getId()));
				}

				int cpt = ftFriends.getRowCount()-1;
				if(lbFriend.getItemCount() > 0){
					ftFriends.setWidget(cpt, 0, lbFriend);
					ftFriends.setWidget(cpt,2, btnSaveFriend);
					ftFriends.setWidget(cpt, 3, btnCancelMoreInfo);
					lbFriend.setVisible(true);
					btnSaveFriend.setVisible(true);
					btnCancelMoreInfo.setVisible(true);
				}else{
					Window.alert("Pas d'amis a ajouter");
					lbFriend.setVisible(false);
					btnSaveFriend.setVisible(false);
					btnCancelMoreInfo.setVisible(false);
				}
			}
			
		});
	}
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		/**
		 * initalise l'affichage au démarrage
		 */
		initPanel(rootPanel);
		
		// création du menu
		MenuItem mntmCrerUnUtilisateur = new MenuItem("Créer un utilisateur", false, new Command() {
			public void execute() {
				addPersonDisplay(rootPanel);
			}
		});
		menuBar.addItem(mntmCrerUnUtilisateur);
		
		MenuItem mntmRechercher = new MenuItem("Rechercher", false, new Command() {
			public void execute() {
				displayALLPersons();
			}
		});
		menuBar.addItem(mntmRechercher);
		/**
		 * popup de chargement lors de la connexion a la base
		 */
		
	

		/**
		 * Ajout d'une personne dans la base
		 */
		createPerson.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				nameField.setFocus(true);
				rootPanel.clear();
				greetingService.createPerson(nameField.getText(), firstNameField.getText(),new AsyncCallback<Void>() {
					
					public void onSuccess(Void arg0) {
						initPanel(rootPanel);
						nameField.setFocus(true);
						nameField.setText("");
						firstNameField.setText("");
					}
					
					public void onFailure(Throwable arg0) {
						System.err.println(arg0.toString());
					}
				});
			}
		});
		
		/**
		 * fait apparaitre un champ pour renseigner une adresse
		 * un autre pour la ville
		 * un bouton pour enregistrer
		 * et un bouton pour annuler
		 */
		btnAddHome.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				txtbxAdresse.setText("Entrez votre Adresse");
				txtbxVille.setText("Entrez votre ville");
				int cpt = ftHome.getRowCount()-1;
				ftHome.setWidget(cpt, 0, txtbxAdresse);
				ftHome.setWidget(cpt, 1, txtbxVille);
				ftHome.setWidget(cpt,2, btnSaveHome);
				ftHome.setWidget(cpt, 3, btnCancelMoreInfo);
				txtbxAdresse.setVisible(true);
				txtbxVille.setVisible(true);
				btnSaveHome.setVisible(true);
				btnCancelMoreInfo.setVisible(true);
			}
		});
		
		/**
		 * bouton sauvegarde d'une nouvelle maison dans la base
		 */
		btnSaveHome.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				saveHome();
			}
		});
		
		/**
		 * fait apparaitre une liste d'electronic device
		 * une textbox pour renseigner la marque
		 * et un bouton enregistrer et un autre pour annuler
		 */
		btnAddEd.addClickHandler(new ClickHandler(){
			
			public void onClick(ClickEvent event){
				lbEdType.addItem("Choisissez un équipement");
				lbEdType.addItem("four");
				lbEdType.addItem("micro-onde");
				lbEdType.addItem("plaque de cuisson");
				lbEdType.addItem("réfrégirateur");
				lbEdType.addItem("congélateur");
				lbEdType.addItem("machine à laver");
				lbEdType.addItem("sèche linge");
				lbEdType.addItem("télévision");
				lbEdType.addItem("home cinéma");
				lbEdType.addItem("ordinateur");
				txtbxEdBrand.setText("Entrez la marque");
				
				int cpt = ftEd.getRowCount()-1;
				ftEd.setWidget(cpt, 0, lbEdType);
				ftEd.setWidget(cpt, 1, txtbxEdBrand);
				ftEd.setWidget(cpt,2, btnSaveEd);
				ftEd.setWidget(cpt, 3, btnCancelMoreInfo);
				lbEdType.setVisible(true);
				txtbxEdBrand.setVisible(true);
				btnSaveEd.setVisible(true);
				btnCancelMoreInfo.setVisible(true);
			}
		});
		
		/**
		 * bouton sauvegarde device dans la base
		 */
		btnSaveEd.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				saveEd();
			}
		});
		
		/**
		 * bouton pour annuler l'ajout de maison, amis, appareil electromenager ou consommation
		 */
		btnCancelMoreInfo.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0,0)));
				lbEdType.setVisible(false);
				txtbxEdBrand.setVisible(false);
				btnSaveEd.setVisible(false);
				txtbxAdresse.setVisible(false);
				txtbxVille.setVisible(false);
				btnSaveHome.setVisible(false);
				btnCancelMoreInfo.setVisible(false);
				btnSaveFriend.setVisible(false);
				lbFriend.setVisible(false);
			}
		});
		
		/**
		 * fait apparaitre la liste des maisons
		 * une textbox dans laquelle sera renseigner la valeur de la consommation
		 * et deux bouton (enregistrer et annuler)
		 */
		btnAddConso.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				txtbxConso.setText("Entrez votre conso");
				ftMoreInfo.setWidget(empl_btnAddConso, 1, lbHome);
				ftMoreInfo.setWidget(empl_btnAddConso, 2, txtbxConso);
				ftMoreInfo.setWidget(empl_btnAddConso, 3, btnSaveConso);
				ftMoreInfo.setWidget(empl_btnAddConso, 4, btnCancelMoreInfo);
				txtbxConso.setVisible(true);
				lbHome.setVisible(true);
				btnSaveConso.setVisible(true);
				btnCancelMoreInfo.setVisible(true);
			}
		});
		
		/**
		 * Click sur le bouton pour enregistrer une consommation dans la base
		 */
		btnSaveConso.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				saveConso();
			}
		});
		
		/**
		 * Click sur le bouton d'ajout d'amis
		 * fait apparaitre une liste avec les amis que l'on peut ajouter
		 * et deux boutons (enregistrer l'ajout ou annuler)
		 */
		btnAddFriend.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				ListAddFriend();
				int cpt = ftFriends.getRowCount()-1;
				ftFriends.setWidget(cpt, 0, lbFriend);
				ftFriends.setWidget(cpt,2, btnSaveFriend);
				ftFriends.setWidget(cpt, 3, btnCancelMoreInfo);
				lbFriend.setVisible(true);
				btnSaveFriend.setVisible(true);
				btnCancelMoreInfo.setVisible(true);
			}
		});
		
		/**
		 * Click sur le bouton de sauvegarde d'ajout d'un amis
		 */
		btnSaveFriend.addClickHandler(new ClickHandler(){
			
			public void onClick(ClickEvent event) {
				ajouterAmi();
				displayMoreDetails(Integer.parseInt(ftMoreInfo.getText(0,0)));
			}
			
		});
		
		/**
		 * Amelioration pour le confort de l'utilisateur
		 */
		txtbxAdresse.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				txtbxAdresse.setText("");
				txtbxAdresse.setFocus(true);
			}
			
		});
		
		txtbxVille.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				txtbxVille.setText("");
				txtbxVille.setFocus(true);
			}
			
		});
		
		txtbxConso.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				txtbxConso.setText("");
				txtbxConso.setFocus(true);
			}
			
		});

	}
}
