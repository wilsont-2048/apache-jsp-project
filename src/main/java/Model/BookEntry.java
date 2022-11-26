package Model;

public class BookEntry {
	private final int id;
	private String bookname;
	private String bookgenre;
	private int bookvotes;
	
	public BookEntry(int id, String bookname, String bookgenre, int bookvotes) {
		this.id = id;
		this.bookname = bookname;
		this.bookgenre = bookgenre;
		this.bookvotes = bookvotes;
	}
	
	public int getBookId() {
		return id;
	}
	
	public String getBookName() {
		return bookname;
	}
	
	public String getBookGenre() {
		return bookgenre;
	}
	
	public int getBookVotes() {
		return bookvotes;
	}
	
}
