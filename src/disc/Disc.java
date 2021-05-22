package disc;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	/**
	 * 
	 */
	public Disc() {
		
	}
	/**
	 * @param director
	 */
	public Disc(String director) {
		this.director = director;
	}
	/**
	 * @param director
	 * @param length
	 */
	public Disc(String director, int length) {
		this(director);
		this.length = length;
	}
	/**
	 * @param director
	 * @param length
	 * @param title
	 * @param category
	 * @param cost
	 */
	public Disc(String director, int length, String title, String category, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
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
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 */
	public void setDirector(String director) {
		this.director = director;
	}
}
