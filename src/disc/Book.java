package disc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	private String content;
	private String[] contentTokens;
	private TreeMap<String, Integer> wordFrequency = new TreeMap<>();
	
	/**
	 * 
	 */
	public Book() {
		
	}
	/**
	 * @param title
	 */
	public Book(String title) {
		super(title);
	}
	/**
	 * @param title
	 * @param category
	 */
	public Book(String title, String category) {
		super(title, category);
	}
	/**
	 * @param title
	 * @param category
	 * @param cost
	 */
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	/**
	 * @param title
	 * @param category
	 * @param cost
	 * @param authors
	 */
	public Book(String title, String category, float cost, ArrayList<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the contentTokens
	 */
	public String[] getContentTokens() {
		return contentTokens;
	}
	/**
	 */
	public void setContentTokens(String[] contentTokens) {
		this.contentTokens = contentTokens;
	}
	/**
	 * @return the wordFrequency
	 */
	public TreeMap<String, Integer> getWordFrequency() {
		return wordFrequency;
	}
	/**
	 */
	public void setWordFrequency(TreeMap<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}
	/**
	 * @return authors
	 */
	public ArrayList<String> getAuthors() {
		return authors;
	}
	/**
	 * @param authors
	 */
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	/**
	 * @param authorName
	 */
	public void addAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			System.out.println("This author is already added!");
		} else {
			this.authors.add(authorName);
		}
	}
	
	/**
	 * @param authorName
	 */
	public void removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		} else {
			System.out.println("This author is not added!");
		}
	}
	
	/**
	 *
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Book)) {
			return o.getClass().toString().compareTo(Book.class.toString());
		} else {
			Book item = (Book) o;
			if (this.title.compareTo(item.title) != 0) {
				return this.title.compareTo(item.title);
			} else {
				return Integer.compare(this.authors.size(), item.authors.size());
			}
		}
	}
	
	/**
	 * 
	 */
	public void processContent() {
		contentTokens = content.toLowerCase().split(" |,.");
		Arrays.sort(contentTokens);
		for (String t : contentTokens) {
			if (wordFrequency.get(t) == null) {
				wordFrequency.put(t, 1);
			} else {
				int c = wordFrequency.get(t);
				wordFrequency.put(t, c + 1);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Book [title=" + this.getTitle() + ", category=" + this.getCategory() + ", cost=" + this.getCost() + ", contentLength=" + this.wordFrequency.size() + "]");
		str.append("\nAuthors: ");
		for (String t : authors) {
			str.append(t + " ");
		}
		str.append("\nWord tokens:\n");
		for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			str.append(key + " : " + value + "\n");
		}
		return str.toString();
	}
}
