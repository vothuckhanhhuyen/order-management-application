package disc;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Track implements Playable, Comparable<Object> {
	private String title;
	private int length;
	
	/**
	 * 
	 */
	public Track() {
		
	}
	/**
	 * @param title
	 */
	public Track(String title) {
		this.title = title;
	}
	/**
	 * @param title
	 * @param length
	 */
	public Track(String title, int length) {
		this(title);
		this.length = length;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 */
	public void setLength(int length) {
		this.length = length;
	}
	public Pane playPane = new Pane();
	@Override
	public void play() {

		Label playLabel = new Label("Track title: " + this.getTitle());
		playLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #00b16a");
		Label lengthLabel = new Label("Track length: " + this.getLength());
		lengthLabel.setStyle("-fx-font-size: 15 System; -fx-text-fill: #00b16a");
		lengthLabel.setLayoutY(20);
		playPane.getChildren().addAll(playLabel, lengthLabel);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Track)) {
			return false;
		}
		else {
			Track newTrack = (Track) obj;
			if (newTrack.length == this.length && newTrack.title == this.title) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 *
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Track)) {
			return o.getClass().toString().compareTo(Track.class.toString());
		} else {
			Track item = (Track) o;
			return Integer.compare(this.getLength(), item.getLength());
		}
	}
}
