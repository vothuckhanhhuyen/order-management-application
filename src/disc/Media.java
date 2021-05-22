package disc;

public class Media implements Comparable<Object> {
	protected String title;
	protected String category;	
	protected float cost;
	protected int id_to_store;
	public static int count_media = 0;
	
	/**
	 * 
	 */
	public Media() {
		count_media += 1;
		this.id_to_store = count_media;
	}
	/**
	 * @param title
	 */
	public Media(String title) {
		this.title = title;
		count_media += 1;
		this.id_to_store = count_media;
	}
	/**
	 * @param title
	 * @param category
	 */
	public Media(String title, String category) {
		this(title);
		this.category = category;
		count_media += 1;
		this.id_to_store = count_media;
	}
	/**
	 * @param title
	 * @param category
	 * @param cost
	 */
	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
		count_media += 1;
		this.id_to_store = count_media;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}
	/**
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}
	/**
	 * @return the id_to_store
	 */
	public int getId_to_store() {
		return id_to_store;
	}
	/**
	 */
	public void setId_to_store(int id_to_store) {
		this.id_to_store = id_to_store;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Media)) {
			return false;
		}
		else {
			Media thisObj = (Media) obj;
			if (thisObj.id_to_store == this.id_to_store) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Media)) {
			return o.getClass().toString().compareTo(Media.class.toString());
		} else {
			Media item = (Media) o;
			return this.title.compareTo(item.title);
		}
	}
}
