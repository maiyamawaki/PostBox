package operations;

public class Post {
	private String title;
	private String contents;

	public Post (String title, String contents) {
		this.setTitle(title);
		this.setContents(contents);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	} 

	public String getContents() {
		return this.contents;
	}
}