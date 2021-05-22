package test;

import java.util.ArrayList;
import disc.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import order.Order;


public class Aims extends Application {
	static ArrayList <DigitalVideoDisc> dvd = new ArrayList<>();
	static ArrayList <Book> book = new ArrayList<>();
	static ArrayList <CompactDisc> cd = new ArrayList<>();
	static ArrayList <String> author = new ArrayList<>();
	static ArrayList <Integer> bookChoose = new ArrayList<>();
	static ArrayList <Integer> dvdChoose = new ArrayList<>();
	static ArrayList <Integer> cdChoose = new ArrayList<>();
	static Order anOrder = new Order();
	static Order myOrder = new Order();
	static int pay = 0;

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		dvd1.setId_to_store(1);
		dvd.add(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		dvd2.setId_to_store(2);
		dvd.add(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		dvd3.setId_to_store(2);
		dvd.add(dvd3);

		Book book1 = new Book("Analysis");
		author.add("Nguyen Dinh Tri");
		author.add("Tran viet Dung");
		author.add("Tran Xuan Hien");
		author.add("Nguyen Xuan Thao");
		for (int i = 0; i < author.toArray().length; i ++){
			book1.addAuthor(author.get(i));
		}
		book1.setCategory("Lecture");
		book1.setCost(1.2f);
		book1.setId_to_store(4);
		book.add(book1);

		Book book2 = new Book("Algebra");
		author.clear();
		author.add("Nguyen Dinh Tri");
		author.add("Tran viet Dung");
		author.add("Tran Xuan Hien");
		author.add("Nguyen Xuan Thao");
		for (int i = 0; i < author.toArray().length; i ++){
			book2.addAuthor(author.get(i));
		}
		book2.setCategory("Lecture");
		book2.setCost(1.2f);
		book2.setId_to_store(5);
		book.add(book2);

		Book book3 = new Book("Sherlock Holmes chapter 1");
		author.clear();
		author.add("Conan Doyle");
		for (int i = 0; i < author.toArray().length; i ++){
			book3.addAuthor(author.get(i));
		}
		book3.setCategory("Detective");
		book3.setCost(10.2f);
		book3.setId_to_store(6);
		book.add(book3);

		Book book4 = new Book("Sherlock Holmes chapter 2");
		author.clear();
		author.add("Conan Doyle");
		for (int i = 0; i < author.toArray().length; i ++){
			book4.addAuthor(author.get(i));
		}
		book4.setCategory("Detective");
		book4.setCost(10.2f);
		book4.setId_to_store(7);
		book.add(book4);

		Book book5 = new Book("The old man and the sea");
		author.clear();
		author.add("Earnest Hemingway");
		for (int i = 0; i < author.toArray().length; i ++){
			book5.addAuthor(author.get(i));
		}
		book5.setCategory("Novel");
		book5.setCost(10.2f);
		book5.setId_to_store(8);
		book.add(book5);

		CompactDisc cd1 = new CompactDisc("Conan");
		cd1.setArtist("Aoyama Gosho");
		cd1.setCategory("Detective");
		cd1.setCost(14.4f);
		cd1.setLength(120);
		cd1.setId_to_store(9);
		cd.add(cd1);

		CompactDisc cd2 = new CompactDisc("Doraemon");
		cd2.setArtist("Fujiko F.Fujio");
		cd2.setCategory("Cartoon and Science Fiction");
		cd2.setCost(14.4f);
		cd2.setLength(120);
		cd2.setId_to_store(10);
		cd.add(cd2);

		CompactDisc cd3 = new CompactDisc("Pokemon");
		cd3.setArtist("Aoyama Gosho");
		cd3.setCategory("Detective");
		cd3.setCost(14.4f);
		cd3.setLength(120);
		cd3.setId_to_store(9);
		cd.add(cd3);

		for (int i = 0; i < book.size(); i ++) {
			bookChoose.add(1);
		}
		for (int i = 0; i < dvd.size(); i ++) {
			dvdChoose.add(1);
		}
		for (int i = 0; i < cd.size(); i ++) {
			cdChoose.add(1);
		}

		launch(args);
		System.exit(0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane primaryPane = new BorderPane();

		///////////////////// Khoi tao tieu de
		Label titleLabel = new Label("Order Management Application");
		titleLabel.setStyle("-fx-font-size: 34 System; -fx-font-weight: Bold; -fx-text-fill: #c0392b; -fx-background-color: #ecf0f1");
		titleLabel.setAlignment(Pos.CENTER);
		titleLabel.setPrefWidth(1000);
		titleLabel.setPrefHeight(60);
		primaryPane.setTop(titleLabel);

		Scene primaryScene = new Scene(primaryPane, 1000, 500);
		primaryStage.setScene(primaryScene);

		/////////////////////// Khoi tao Menu
		VBox menuBox = new VBox();
		menuBox.setStyle("-fx-background-color: #2c3e50; -fx-border-width: 5; -fx-border-color: #2ecc71");
		menuBox.setPrefWidth(248);
		menuBox.setPrefHeight(425);
		primaryPane.setLeft(menuBox);

		Label menuLabel = new Label("MENU");
		menuLabel.setStyle("-fx-font-size: 41 Tahoma; -fx-text-fill: #f1c40f; -fx-font-weight: Bold; -fx-border-color: #2ecc71; -fx-border-width: 5");
		menuLabel.setPrefSize(238, 118);
		menuLabel.setAlignment(Pos.CENTER);

		Label createLabel = new Label("  Create new Order");
		createLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #2ecc71; -fx-border-color: #2ecc71; -fx-border-width: 5");
		createLabel.setPrefSize(259, 62);

		Label addLabel = new Label("  Add item to the order");
		addLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #2ecc71; -fx-border-color: #2ecc71; -fx-border-width: 5");
		addLabel.setPrefSize(259, 62);

		Label deleteLabel = new Label("  Delete item by id");
		deleteLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #2ecc71; -fx-border-color: #2ecc71; -fx-border-width: 5");
		deleteLabel.setPrefSize(259, 62);

		Label displayLabel = new Label("  Display the items list of order");
		displayLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #2ecc71; -fx-border-color: #2ecc71; -fx-border-width: 5");
		displayLabel.setPrefSize(259, 62);

		Label exitLabel = new Label("  Exit");
		exitLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #2ecc71; -fx-border-color: #2ecc71; -fx-border-width: 5");
		exitLabel.setPrefSize(259, 76);

		menuBox.getChildren().addAll(menuLabel,createLabel,addLabel, deleteLabel, displayLabel, exitLabel);

		Pane contentPane = new Pane();
		contentPane.setPrefSize(760, 420);
		contentPane.setStyle("-fx-background-color: #7f8c8d");
		primaryPane.setCenter(contentPane);

		////////////////////// lock stage after paid
		Stage lockStage = new Stage();
		AnchorPane lockPane = new AnchorPane();
		Label lockLabel = new Label("You need to create an order to continue shopping !");
		lockPane.getChildren().add(lockLabel);
		Scene lockScence = new Scene(lockPane, 400, 200);
		lockStage.setScene(lockScence);

		///////////////////////   Main scene
		Label primaryLabel = new Label("Welcome to our store");
		primaryLabel.setStyle("-fx-font: 40 System; -fx-font-weight: Bold; -fx-text-fill: #ecf0f1");
		primaryLabel.setLayoutX(150);
		primaryLabel.setLayoutY(150);
		contentPane.getChildren().add(primaryLabel);

		menuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				contentPane.getChildren().clear();
				contentPane.getChildren().add(primaryLabel);
			}
		});

		/////////////////// Create new Order
		createLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				contentPane.getChildren().clear();
				for (int i = 0; i < book.size(); i ++) {
					bookChoose.set(i, 1);
				}
				for (int i = 0; i < dvd.size(); i ++) {
					dvdChoose.set(i, 1);
				}
				for (int i = 0; i < cd.size(); i ++) {
					cdChoose.set(i, 1);
				}
				anOrder.itemsOrdered.clear();
				pay = 0;

				Label newOrderLabel = new Label("New Order was created !");
				newOrderLabel.setStyle("-fx-font: 30 System; -fx-font-weight: Bold; -fx-text-fill: #ecf0f1");
				newOrderLabel.setLayoutX(200);
				newOrderLabel.setLayoutY(180);
				contentPane.getChildren().add(newOrderLabel);
			}
		});
		//////////////////////////  Add item to order
		addLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				contentPane.getChildren().clear();

				ToolBar itemBar = new ToolBar();
				itemBar.setStyle("-fx-background-color: #fcb941");
				itemBar.setPrefSize(760, 22);

				Button bookItem = new Button("Book");
				bookItem.setStyle("-fx-font: 15 System; -fx-font-weight: Bold; -fx-text-fill: #3a539b; -fx-background-color: #f2784b");
				bookItem.setAlignment(Pos.CENTER);
				bookItem.setPrefSize(150, 21);

				Button dvdItem = new Button("Digital Video Disc");
				dvdItem.setStyle("-fx-font: 15 System; -fx-font-weight: Bold; -fx-text-fill: #3a539b; -fx-background-color: #f2784b");
				dvdItem.setAlignment(Pos.CENTER);
				dvdItem.setPrefSize(150, 21);

				Button cdItem = new Button("Compact Disc");
				cdItem.setStyle("-fx-font: 15 System; -fx-font-weight: Bold; -fx-text-fill: #3a539b; -fx-background-color: #f2784b");
				cdItem.setAlignment(Pos.CENTER);
				cdItem.setPrefSize(150, 21);

				Button payItem = new Button("List item");
				payItem.setStyle("-fx-font: 15 System; -fx-font-weight: Bold; -fx-text-fill: #3a539b; -fx-background-color: #f2784b");
				payItem.setAlignment(Pos.CENTER);
				payItem.setPrefSize(150, 21);
				itemBar.getItems().addAll(bookItem, dvdItem, cdItem, payItem);

				ScrollPane listItemPane = new ScrollPane();
				listItemPane.setPrefSize(750, 400);
				listItemPane.setLayoutY(31);
				listItemPane.setStyle("-fx-background-color: #7f8c8d");
				VBox listItemBox = new VBox();
				listItemBox.setPrefWidth(760);
				listItemBox.setStyle("-fx-background-color: #7f8c8d");
				listItemPane.setContent(listItemBox);

				Label welcomeAddItem = new Label("Choose the type of item you want to add");
				welcomeAddItem.setStyle("-fx-font: 30 System; -fx-font-weight: Bold; -fx-text-fill: #7f8c8d");
				welcomeAddItem.setLayoutX(100);
				welcomeAddItem.setLayoutY(180);
				contentPane.getChildren().addAll(itemBar, listItemPane, welcomeAddItem);


				//////////////////// show list of books
				bookItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						listItemBox.getChildren().clear();
						contentPane.getChildren().remove(welcomeAddItem);
						ArrayList<SplitPane> listMediaItem = new ArrayList<>();
						ArrayList<Label> mediaTitle = new ArrayList<>();
						ArrayList<Pane> mediaInfoPane = new ArrayList<>();
						ArrayList<TextArea> mediaInfo = new ArrayList<>();
						ArrayList<Button> addOrSub = new ArrayList<>();

						for (int i = 0; i < book.size(); i ++) {
							listMediaItem.add(null);
							listMediaItem.set(i, new SplitPane());
							listMediaItem.get(i).setOrientation(Orientation.VERTICAL);
							listMediaItem.get(i).setPrefSize(760, 150);
							listItemBox.getChildren().add(listMediaItem.get(i));

							mediaTitle.add(null);
							mediaTitle.set(i, new Label(book.get(i).getTitle()));
							mediaTitle.get(i).setStyle("-fx-font-size: 20 System; -fx-font-weight: Bold; -fx-text-fill: #4d13d1; -fx-background-color: #e8e8e8");
							mediaTitle.get(i).setAlignment(Pos.CENTER);
							mediaTitle.get(i).setPrefSize(758, 31);

							mediaInfoPane.add(null);
							mediaInfoPane.set(i, new Pane());
							mediaInfoPane.get(i).setStyle("-fx-background-color: #c5eff7");

							mediaInfo.add(null);
							mediaInfo.set(i, new TextArea("Authors: " + book.get(i).getAuthors() + "\n"
														+ "Category: " + book.get(i).getCategory() + "\n"
														+ "Cost: " + book.get(i).getCost() + "$\n"
														+ "ID: " + book.get(i).getId_to_store()));
							mediaInfo.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f62459");
							mediaInfo.get(i).setLayoutX(100);
							mediaInfo.get(i).setEditable(false);

							addOrSub.add(null);
							addOrSub.set(i, new Button());
							if (bookChoose.get(i) == 1) {
								addOrSub.get(i).setText("Add");
							}
							else {
								addOrSub.get(i).setText("Sub");
							}
							addOrSub.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-background-color: #c8f7c5");
							addOrSub.get(i).setLayoutX(480);
							addOrSub.get(i).setLayoutY(70);
							mediaInfoPane.get(i).getChildren().addAll(mediaInfo.get(i), addOrSub.get(i));
							listMediaItem.get(i).getItems().addAll(mediaTitle.get(i), mediaInfoPane.get(i));

							int finalI = i;
							addOrSub.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent mouseEvent) {
									if (pay == 0){
										if (bookChoose.get(finalI) == 0) {
											bookChoose.set(finalI, (bookChoose.get(finalI) + 1) % 2);
											addOrSub.get(finalI).setText("Add");
											anOrder.itemsOrdered.remove(book.get(finalI));
										} else if (anOrder.itemsOrdered.size() < anOrder.MAX_NUMBERS_ORDERED) {
											bookChoose.set(finalI, (bookChoose.get(finalI) + 1) % 2);
											addOrSub.get(finalI).setText("Sub");
											anOrder.itemsOrdered.add(book.get(finalI));
										} else {
											Label label = new Label("Full items of the order !!");
											AnchorPane root = new AnchorPane();
											root.getChildren().add(label);
											Scene scene = new Scene(root, 200, 200);
											Stage stage = new Stage();
											stage.setScene(scene);
											stage.initModality(Modality.WINDOW_MODAL);
											stage.initOwner(primaryStage);
											stage.show();
										}
									}
									else {
										lockStage.show();
									}
								}
							});
						}
					}
				});

				//////////////////// show list of dvds
				dvdItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						listItemBox.getChildren().clear();
						contentPane.getChildren().remove(welcomeAddItem);
						ArrayList<SplitPane> listMediaItem = new ArrayList<>();
						ArrayList<Label> mediaTitle = new ArrayList<>();
						ArrayList<Pane> mediaInfoPane = new ArrayList<>();
						ArrayList<TextArea> mediaInfo = new ArrayList<>();
						ArrayList<Button> addOrSub = new ArrayList<>();

						for (int i = 0; i < dvd.size(); i ++) {
							listMediaItem.add(null);
							listMediaItem.set(i, new SplitPane());
							listMediaItem.get(i).setOrientation(Orientation.VERTICAL);
							listMediaItem.get(i).setPrefSize(760, 150);
							listItemBox.getChildren().add(listMediaItem.get(i));

							mediaTitle.add(null);
							mediaTitle.set(i, new Label(dvd.get(i).getTitle()));
							mediaTitle.get(i).setStyle("-fx-font-size: 20 System; -fx-font-weight: Bold; -fx-text-fill: #4d13d1; -fx-background-color: #e8e8e8");
							mediaTitle.get(i).setAlignment(Pos.CENTER);
							mediaTitle.get(i).setPrefSize(758, 31);

							mediaInfoPane.add(null);
							mediaInfoPane.set(i, new Pane());
							mediaInfoPane.get(i).setStyle("-fx-background-color: #c5eff7");

							mediaInfo.add(null);
							mediaInfo.set(i, new TextArea("Director: " + dvd.get(i).getDirector() + "\n"
									+ "Category: " + dvd.get(i).getCategory() + "\n"
									+ "Length: " + dvd.get(i).getLength() + "\n"
									+ "Cost: " + dvd.get(i).getCost() + "$\n"
									+ "ID: " + dvd.get(i).getId_to_store()));
							mediaInfo.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f62459");
							mediaInfo.get(i).setLayoutX(100);
							mediaInfo.get(i).setEditable(false);

							addOrSub.add(null);
							addOrSub.set(i, new Button());
							if (dvdChoose.get(i) == 1) {
								addOrSub.get(i).setText("Add");
							}
							else {
								addOrSub.get(i).setText("Sub");
							}
							addOrSub.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-background-color: #c8f7c5");
							addOrSub.get(i).setLayoutX(480);
							addOrSub.get(i).setLayoutY(70);
							mediaInfoPane.get(i).getChildren().addAll(mediaInfo.get(i), addOrSub.get(i));
							listMediaItem.get(i).getItems().addAll(mediaTitle.get(i), mediaInfoPane.get(i));

							int finalI = i;
							addOrSub.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent mouseEvent) {
									if (pay == 0){
										if (dvdChoose.get(finalI) == 0) {
											dvdChoose.set(finalI, (dvdChoose.get(finalI) + 1) % 2);
											addOrSub.get(finalI).setText("Add");
											anOrder.itemsOrdered.remove(dvd.get(finalI));
										} else if (anOrder.itemsOrdered.size() < anOrder.MAX_NUMBERS_ORDERED) {
											dvdChoose.set(finalI, (dvdChoose.get(finalI) + 1) % 2);
											addOrSub.get(finalI).setText("Sub");
											anOrder.itemsOrdered.add(dvd.get(finalI));
										} else {
											Label label = new Label("Full items of the order !!");
											AnchorPane root = new AnchorPane();
											root.getChildren().add(label);
											Scene scene = new Scene(root, 200, 200);
											Stage stage = new Stage();
											stage.setScene(scene);
											stage.initModality(Modality.WINDOW_MODAL);
											stage.initOwner(primaryStage);
											stage.show();
										}
									}
									else {
										lockStage.show();
									}
								}
							});
						}
					}
				});
				//////////////////// show list of CDs
				cdItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						listItemBox.getChildren().clear();
						contentPane.getChildren().remove(welcomeAddItem);
						ArrayList<SplitPane> listMediaItem = new ArrayList<>();
						ArrayList<Label> mediaTitle = new ArrayList<>();
						ArrayList<Pane> mediaInfoPane = new ArrayList<>();
						ArrayList<TextArea> mediaInfo = new ArrayList<>();
						ArrayList<Button> addOrSub = new ArrayList<>();

						for (int i = 0; i < cd.size(); i ++) {
							listMediaItem.add(null);
							listMediaItem.set(i, new SplitPane());
							listMediaItem.get(i).setOrientation(Orientation.VERTICAL);
							listMediaItem.get(i).setPrefSize(760, 180);
							listItemBox.getChildren().add(listMediaItem.get(i));

							mediaTitle.add(null);
							mediaTitle.set(i, new Label(cd.get(i).getTitle()));
							mediaTitle.get(i).setStyle("-fx-font-size: 20 System; -fx-font-weight: Bold; -fx-text-fill: #4d13d1; -fx-background-color: #e8e8e8");
							mediaTitle.get(i).setAlignment(Pos.CENTER);
							mediaTitle.get(i).setPrefSize(758, 31);

							mediaInfoPane.add(null);
							mediaInfoPane.set(i, new Pane());
							mediaInfoPane.get(i).setStyle("-fx-background-color: #c5eff7");

							mediaInfo.add(null);
							mediaInfo.set(i, new TextArea("Director: " + cd.get(i).getDirector() + "\n"
									+ "Artist: " + cd.get(i).getArtist() + "\n"
									+ "Category: " + cd.get(i).getCategory() + "\n"
									+ "Length: " + cd.get(i).getLength() + "\n"
									+ "Cost: " + cd.get(i).getCost() + "$\n"
									+ "ID: " + cd.get(i).getId_to_store()));
							mediaInfo.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f62459");
							mediaInfo.get(i).setLayoutX(100);
							mediaInfo.get(i).setEditable(false);

							addOrSub.add(null);
							addOrSub.set(i, new Button());
							if (cdChoose.get(i) == 1) {
								addOrSub.get(i).setText("Add");
							}
							else {
								addOrSub.get(i).setText("Sub");
							}
							addOrSub.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-background-color: #c8f7c5");
							addOrSub.get(i).setLayoutX(480);
							addOrSub.get(i).setLayoutY(70);
							mediaInfoPane.get(i).getChildren().addAll(mediaInfo.get(i), addOrSub.get(i));
							listMediaItem.get(i).getItems().addAll(mediaTitle.get(i), mediaInfoPane.get(i));

							int finalI = i;
							addOrSub.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent mouseEvent) {
									if (pay == 0){
										if (cdChoose.get(finalI) == 0) {
											cdChoose.set(finalI, (cdChoose.get(finalI) + 1) % 2);
											addOrSub.get(finalI).setText("Add");
											anOrder.itemsOrdered.remove(cd.get(finalI));
										} else if (anOrder.itemsOrdered.size() < anOrder.MAX_NUMBERS_ORDERED) {
											cdChoose.set(finalI, (cdChoose.get(finalI) + 1) % 2);
											addOrSub.get(finalI).setText("Sub");
											anOrder.itemsOrdered.add(cd.get(finalI));
										} else {
											Label label = new Label("Full items of the order !!");
											AnchorPane root = new AnchorPane();
											root.getChildren().add(label);
											Scene scene = new Scene(root, 200, 200);
											Stage stage = new Stage();
											stage.setScene(scene);
											stage.initModality(Modality.WINDOW_MODAL);
											stage.initOwner(primaryStage);
											stage.show();
										}
									}
									else {
										lockStage.show();
									}
								}
							});
						}
					}
				});
				//////////////////// Show list item of order and pay
				payItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						listItemBox.getChildren().clear();
						contentPane.getChildren().remove(welcomeAddItem);
						ArrayList<SplitPane> listMediaItem = new ArrayList<>();
						ArrayList<Label> mediaTitle = new ArrayList<>();
						ArrayList<Pane> mediaInfoPane = new ArrayList<>();
						ArrayList<TextArea> mediaInfo = new ArrayList<>();

						for (int i = 0; i < anOrder.itemsOrdered.size(); i++) {
							listMediaItem.add(null);
							listMediaItem.set(i, new SplitPane());
							listMediaItem.get(i).setOrientation(Orientation.VERTICAL);
							listMediaItem.get(i).setPrefSize(760, 180);
							listItemBox.getChildren().add(listMediaItem.get(i));

							mediaTitle.add(null);
							mediaTitle.set(i, new Label(anOrder.itemsOrdered.get(i).getTitle()));
							mediaTitle.get(i).setStyle("-fx-font-size: 20 System; -fx-font-weight: Bold; -fx-text-fill: #4d13d1; -fx-background-color: #e8e8e8");
							mediaTitle.get(i).setAlignment(Pos.CENTER);
							mediaTitle.get(i).setPrefSize(758, 31);

							mediaInfoPane.add(null);
							mediaInfoPane.set(i, new Pane());
							mediaInfoPane.get(i).setStyle("-fx-background-color: #c5eff7");

							mediaInfo.add(null);
							if (anOrder.itemsOrdered.get(i) instanceof CompactDisc) {
								mediaInfo.set(i, new TextArea("Director: " + ((CompactDisc) anOrder.itemsOrdered.get(i)).getDirector() + "\n"
										+ "Artist: " + ((CompactDisc) anOrder.itemsOrdered.get(i)).getArtist() + "\n"
										+ "Category: " + anOrder.itemsOrdered.get(i).getCategory() + "\n"
										+ "Length: " + ((Disc) anOrder.itemsOrdered.get(i)).getLength() + "\n"
										+ "Cost: " + anOrder.itemsOrdered.get(i).getCost() + "$\n"
										+ "ID: " + anOrder.itemsOrdered.get(i).getId_to_store()));
							}
							if (anOrder.itemsOrdered.get(i) instanceof DigitalVideoDisc) {
								mediaInfo.set(i, new TextArea("Director: " + ((Disc) anOrder.itemsOrdered.get(i)).getDirector() + "\n"
										+ "Category: " + anOrder.itemsOrdered.get(i).getCategory() + "\n"
										+ "Length: " + ((Disc) anOrder.itemsOrdered.get(i)).getLength() + "\n"
										+ "Cost: " + anOrder.itemsOrdered.get(i).getCost() + "$\n"
										+ "ID: " + anOrder.itemsOrdered.get(i).getId_to_store()));
							}
							if (anOrder.itemsOrdered.get(i) instanceof Book) {
								mediaInfo.set(i, new TextArea("Authors: " + ((Book) anOrder.itemsOrdered.get(i)).getAuthors() + "\n"
										+ "Category: " + anOrder.itemsOrdered.get(i).getCategory() + "\n"
										+ "Cost: " + anOrder.itemsOrdered.get(i).getCost() + "$\n"
										+ "ID: " + anOrder.itemsOrdered.get(i).getId_to_store()));
							}
							mediaInfo.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f62459");
							mediaInfo.get(i).setLayoutX(100);
							mediaInfo.get(i).setEditable(false);
							mediaInfoPane.get(i).getChildren().add(mediaInfo.get(i));
							listMediaItem.get(i).getItems().addAll(mediaTitle.get(i), mediaInfoPane.get(i));
						}
						Button payButton = new Button("Pay");
						payButton.setStyle("-fx-font-size: 20 System; -fx-text-fill: #cf000f; -fx-font-weight: Bold; -fx-background-color: #7befb2");
						payButton.setAlignment(Pos.CENTER);
						payButton.setPrefWidth(760);
						listItemBox.getChildren().add(payButton);

						if (pay == 0) {
							{
								payButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent mouseEvent) {
										if (anOrder.itemsOrdered.size() >= 1) {
											for (int i = 0; i < anOrder.itemsOrdered.size(); i++) {
												myOrder.addMedia(anOrder.itemsOrdered.get(i));
											}
											Stage payStage = new Stage();
											AnchorPane payPane = new AnchorPane();
											if (anOrder.itemsOrdered.size() < 3) {
												Label payLabel = new Label("Your total cost is: " + (anOrder.totalCost()) + "$");
												payLabel.setStyle("-fx-font: 15 System; -fx-text-fill: #f62459");
												payLabel.setAlignment(Pos.BOTTOM_CENTER);
												payLabel.setLayoutX(100);
												payLabel.setLayoutY(50);
												payPane.getChildren().add(payLabel);
											} else {
												Label luckyLabel = new Label("You get a lucky item: " + anOrder.itemsOrdered.get(anOrder.i).getTitle());
												Label payLabel = new Label("Your total cost is: " + (anOrder.totalCost() - anOrder.itemsOrdered.get(anOrder.i).getCost()) + "$");
												payLabel.setStyle("-fx-font: 15 System; -fx-text-fill: #f62459");
												payLabel.setAlignment(Pos.BOTTOM_CENTER);
												payLabel.setLayoutX(100);
												payLabel.setLayoutY(50);
												payPane.getChildren().add(payLabel);
												luckyLabel.setStyle("-fx-font: 20 System; -fx-text-fill: #00b16a");
												luckyLabel.setAlignment(Pos.CENTER);
												luckyLabel.setLayoutX(100);
												luckyLabel.setLayoutY(75);
												payPane.getChildren().add(luckyLabel);
											}
											Scene payScene = new Scene(payPane, 600, 400);
											payStage.setScene(payScene);
											payStage.show();
											pay = 1;
											anOrder.itemsOrdered.clear();
										}
									}
								});
							}
						} else {
							lockStage.show();
						}
					}
				});
			}
		});
		///////////////////////// Delete item by id
		deleteLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				contentPane.getChildren().clear();
				AnchorPane deleteSearch = new AnchorPane();
				deleteSearch.setPrefWidth(600);
				deleteSearch.setPrefHeight(400);
				deleteSearch.setLayoutX(0);
				deleteSearch.setLayoutY(0);

				Label searchDeleteLabel = new Label("Search");
				searchDeleteLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #f7ca18; -fx-background-color: #9a12b3");
				searchDeleteLabel.setPrefWidth(68);
				searchDeleteLabel.setPrefHeight(31);
				searchDeleteLabel.setLayoutX(0);
				searchDeleteLabel.setLayoutY(10);
				searchDeleteLabel.setAlignment(Pos.CENTER);

				TextField searchDeleteText = new TextField();
				searchDeleteText.setPrefWidth(247);
				searchDeleteText.setPrefHeight(31);
				searchDeleteText.setLayoutX(68);
				searchDeleteText.setLayoutY(10);
				searchDeleteText.setStyle("-fx-font: 15 System");

				Button searchDeleteButton = new Button("Enter");
				searchDeleteButton.setStyle("-fx-font-size: 15 System; -fx-text-fill: #eb9532; -fx-background-color: #1f3a93");
				searchDeleteButton.setPrefWidth(55);
				searchDeleteButton.setPrefHeight(31);
				searchDeleteButton.setLayoutX(314);
				searchDeleteButton.setLayoutY(10);

				Pane deleteNotationPane = new Pane();
				deleteNotationPane.setLayoutX(50);
				deleteNotationPane.setLayoutY(100);
				deleteSearch.getChildren().addAll(searchDeleteText, searchDeleteLabel, searchDeleteButton, deleteNotationPane);

				///////////////////// delete media by button
				searchDeleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						String stringDeleteSearch = searchDeleteText.getText();
						int k = 0;
						for (int i = 0; i < myOrder.itemsOrdered.size(); i ++) {
							if (myOrder.itemsOrdered.get(i).getId_to_store() == Integer.parseInt(stringDeleteSearch)){
								Label deleteNotation = new Label("The item " + myOrder.itemsOrdered.get(i).getTitle() + " is deleted !");
								deleteNotation.setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-font-weight: Bold");
								deleteNotationPane.getChildren().clear();
								deleteNotationPane.getChildren().add(deleteNotation);
								k = 1;
								myOrder.itemsOrdered.remove(i);
								break;
							}
						}
						if (k == 0) {
							Label deleteNotation = new Label("There no item has id: " + searchDeleteText.getText());
							deleteNotation.setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-font-weight: Bold");
							deleteNotationPane.getChildren().clear();
							deleteNotationPane.getChildren().add(deleteNotation);
						}
					}
				});
				///////////////////// delete media by Enter
				searchDeleteText.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent keyEvent) {
						if (keyEvent.getCode() == KeyCode.ENTER) {
							String stringDeleteSearch = searchDeleteText.getText();
							int k = 0;
							for (int i = 0; i < myOrder.itemsOrdered.size(); i ++) {
								if (myOrder.itemsOrdered.get(i).getId_to_store() == Integer.parseInt(stringDeleteSearch)){
									Label deleteNotation = new Label("The item " + myOrder.itemsOrdered.get(i).getTitle() + " is deleted !");
									deleteNotation.setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-font-weight: Bold");
									deleteNotationPane.getChildren().clear();
									deleteNotationPane.getChildren().add(deleteNotation);
									k = 1;
									myOrder.itemsOrdered.remove(i);
									break;
								}
							}
							if (k == 0) {
								Label deleteNotation = new Label("There no item has id: " + searchDeleteText.getText());
								deleteNotation.setStyle("-fx-font-size: 15 System; -fx-text-fill: #f03434; -fx-font-weight: Bold");
								deleteNotationPane.getChildren().clear();
								deleteNotationPane.getChildren().add(deleteNotation);
							}
						}
					}
				});
				contentPane.getChildren().add(deleteSearch);
			}
		});
		//////////////////////// Display list item of order
		displayLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				contentPane.getChildren().clear();
				Label titleDisplay = new Label("The items list of your order");
				titleDisplay.setStyle("-fx-font: 30 System; -fx-font-weight: Bold; -fx-text-fill: #ecf0f1");
				titleDisplay.setLayoutX(180);

				ScrollPane listItemPane = new ScrollPane();
				listItemPane.setPrefSize(750, 400);
				listItemPane.setLayoutY(40);
				listItemPane.setStyle("-fx-background-color: #7f8c8d");
				VBox listItemBox = new VBox();
				listItemBox.setPrefWidth(760);
				listItemBox.setStyle("-fx-background-color: #7f8c8d");
				listItemPane.setContent(listItemBox);
				contentPane.getChildren().addAll(titleDisplay, listItemPane);

				ArrayList<SplitPane> listMediaItem = new ArrayList<>();
				ArrayList<Label> mediaTitle = new ArrayList<>();
				ArrayList<Pane> mediaInfoPane = new ArrayList<>();
				ArrayList<TextArea> mediaInfo = new ArrayList<>();

				for (int i = 0; i < myOrder.itemsOrdered.size(); i++) {
					listMediaItem.add(null);
					listMediaItem.set(i, new SplitPane());
					listMediaItem.get(i).setOrientation(Orientation.VERTICAL);
					listMediaItem.get(i).setPrefSize(760, 180);
					listItemBox.getChildren().add(listMediaItem.get(i));

					mediaTitle.add(null);
					mediaTitle.set(i, new Label(myOrder.itemsOrdered.get(i).getTitle()));
					mediaTitle.get(i).setStyle("-fx-font-size: 20 System; -fx-font-weight: Bold; -fx-text-fill: #4d13d1; -fx-background-color: #e8e8e8");
					mediaTitle.get(i).setAlignment(Pos.CENTER);
					mediaTitle.get(i).setPrefSize(758, 31);

					mediaInfoPane.add(null);
					mediaInfoPane.set(i, new Pane());
					mediaInfoPane.get(i).setStyle("-fx-background-color: #c5eff7");

					mediaInfo.add(null);
					if (myOrder.itemsOrdered.get(i) instanceof CompactDisc) {
						mediaInfo.set(i, new TextArea("Director: " + ((CompactDisc) myOrder.itemsOrdered.get(i)).getDirector() + "\n"
								+ "Artist: " + ((CompactDisc) myOrder.itemsOrdered.get(i)).getArtist() + "\n"
								+ "Category: " + myOrder.itemsOrdered.get(i).getCategory() + "\n"
								+ "Length: " + ((Disc) myOrder.itemsOrdered.get(i)).getLength() + "\n"
								+ "Cost: " + myOrder.itemsOrdered.get(i).getCost() + "$\n"
								+ "ID: " + myOrder.itemsOrdered.get(i).getId_to_store()));
						int finalI = i;
						mediaTitle.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent mouseEvent) {
								((CompactDisc) myOrder.itemsOrdered.get(finalI)).play();
							}
						});
					}
					if (myOrder.itemsOrdered.get(i) instanceof DigitalVideoDisc) {
						mediaInfo.set(i, new TextArea("Director: " + ((Disc) myOrder.itemsOrdered.get(i)).getDirector() + "\n"
								+ "Category: " + myOrder.itemsOrdered.get(i).getCategory() + "\n"
								+ "Length: " + ((Disc) myOrder.itemsOrdered.get(i)).getLength() + "\n"
								+ "Cost: " + myOrder.itemsOrdered.get(i).getCost() + "$\n"
								+ "ID: " + myOrder.itemsOrdered.get(i).getId_to_store()));
						int finalI = i;
						mediaTitle.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent mouseEvent) {
								((DigitalVideoDisc) myOrder.itemsOrdered.get(finalI)).play();
							}
						});
					}
					if (myOrder.itemsOrdered.get(i) instanceof Book) {
						mediaInfo.set(i, new TextArea("Authors: " + ((Book) myOrder.itemsOrdered.get(i)).getAuthors() + "\n"
								+ "Category: " + myOrder.itemsOrdered.get(i).getCategory() + "\n"
								+ "Cost: " + myOrder.itemsOrdered.get(i).getCost() + "$\n"
								+ "ID: " + myOrder.itemsOrdered.get(i).getId_to_store()));
					}
					mediaInfo.get(i).setStyle("-fx-font-size: 15 System; -fx-text-fill: #f62459");
					mediaInfo.get(i).setLayoutX(100);
					mediaInfoPane.get(i).getChildren().add(mediaInfo.get(i));
					listMediaItem.get(i).getItems().addAll(mediaTitle.get(i), mediaInfoPane.get(i));
				}
			}
		});
		///////////////////// Exit
		exitLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				primaryStage.close();
			}
		});

		primaryStage.show();
		primaryStage.setResizable(false);
	}
}
