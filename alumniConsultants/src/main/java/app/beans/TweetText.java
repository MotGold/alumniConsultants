package app.beans;

public class TweetText {
	
	private String textContent;
	private String username;
	
	public TweetText(String textContent, String username) {
		super();
		this.textContent = textContent;
		this.username = username;
	}

	public TweetText() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
