package disc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DigitalVideoDisc extends Disc implements Playable {
	/**
	 * 
	 */
	public DigitalVideoDisc() {
		
	}
	/**
	 * @param title
	 */
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	/**
	 * @param director
	 * @param length
	 * @param title
	 * @param category
	 * @param cost
	 */
	public DigitalVideoDisc(String director, int length, String title, String category, float cost) {
		super(director, length, title, category, cost);
	}
	
	/**
	 * @param title
	 * @return
	 */
	public boolean search(String title) {
		String[] titleTokens = title.toLowerCase().split(" ");
		for (String token : titleTokens) {
			if (this.title.toLowerCase().indexOf(token) < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 *
	 */
	public void play() {
		Stage playStage = new Stage();
		Pane playPane = new Pane();
		Label titleLabel = new Label("Playing DVD: " + this.getTitle());
		titleLabel.setStyle("-fx-font-size: 20 System; -fx-text-fill: #f62459; -fx-font-weight: Bold");
		titleLabel.setLayoutX(50);
		titleLabel.setLayoutY(50);
		Label lengthLabel = new Label("DVD length: " + this.getLength());
		lengthLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #00b16a");
		lengthLabel.setLayoutX(50);
		lengthLabel.setLayoutY(75);

		playPane.getChildren().addAll(titleLabel, lengthLabel);
		Scene playScene = new Scene(playPane, 600, 400);
		playStage.setScene(playScene);
		playStage.show();
	}
	
	/**
	 *
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof DigitalVideoDisc)) {
			return o.getClass().toString().compareTo(DigitalVideoDisc.class.toString());
		} else {
			DigitalVideoDisc item = (DigitalVideoDisc) o;
			if (Float.compare(this.getCost(), item.getCost()) != 0) {
				return Float.compare(this.getCost(), item.getCost());
			} else {
				return Integer.compare(this.getLength(), item.getLength());
			}
		}
	}
}
