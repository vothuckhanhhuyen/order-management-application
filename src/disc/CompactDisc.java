package disc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	/**
	 * 
	 */
	public CompactDisc() {
		
	}
	/**
	 * @param artist
	 * @param director
	 * @param length
	 * @param title
	 * @param category
	 * @param cost
	 */
	public CompactDisc(String artist, String director, int length, String title, String category, float cost) {
		super(director, length, title, category, cost);
		this.artist = artist;
	}
	/**
	 * @param artist
	 * @param tracks
	 * @param director
	 * @param length
	 * @param title
	 * @param category
	 * @param cost
	 */
	public CompactDisc(String artist, ArrayList<Track> tracks, String director, int length, String title, String category, float cost) {
		super(director, length, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title) {
		super(title);
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	/**
	 * @param tr
	 */
	public void addTrack(Track tr) {
		tracks.add(tr);
		System.out.println("The track (" + tr.getTitle() + ", "
										 + tr.getLength() + ") has been added");
	}
	
	/**
	 * @param id
	 */
	public void removeTrack(int id) {
		System.out.println("The track (" + tracks.get(id).getTitle() + ", "
				                         + tracks.get(id).getLength() + ") has been removed");
		for (int j = id; j < tracks.size() - 1; j++) {
			tracks.get(j).setTitle(tracks.get(j + 1).getTitle());
			tracks.get(j).setLength(tracks.get(j + 1).getLength());
		}
		tracks.remove(tracks.size() - 1);
	}
	
	@Override
	public int getLength() {
		int length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}
	
	/**
	 *
	 */
	public void play() {
		Stage playStage = new Stage();
		VBox playBox = new VBox();
		Scene playScene = new Scene(playBox);
		playStage.setScene(playScene);
		for (int i = 0; i < tracks.size(); i++) {
			Label trackLabel = new Label("Playing track: " + (i+1));
			trackLabel.setStyle("-fx-font-size: 20 System; -fx-text-fill: #f62459; -fx-font-weight: Bold");
			trackLabel.setAlignment(Pos.CENTER_LEFT);
			playBox.getChildren().addAll(trackLabel, tracks.get(i).playPane);
			tracks.get(i).play();
		}
		playStage.show();
	}
	
	/**
	 *
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof CompactDisc)) {
			return o.getClass().toString().compareTo(CompactDisc.class.toString());
		} else {
			CompactDisc item = (CompactDisc) o;
			if (Integer.compare(this.tracks.size(), item.tracks.size()) != 0) {
				return Integer.compare(this.tracks.size(), item.tracks.size());
			} else {
				return Integer.compare(this.getLength(), item.getLength());
			}
		}
	}
}
