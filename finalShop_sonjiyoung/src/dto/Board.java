package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Board {
	private static int num = 1;
	private int boardNum;
	private String title;
	private String id;
	private String date;
	private String contents;
	private int hits;
	
	public Board() {
		
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public String getTitle() {
		return title;
	}
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getContents() {
		return contents;
	}
	public Board(String title, String id,String contents) {
		this.boardNum = num++;
		this.title = title;
		this.id = id;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.date = LocalDate.now().format(formatter);
		this.contents = contents;
	}

	public Board(String boardNum, String title, String id, String date, String contents, String hits) {
		super();
		this.boardNum = Integer.parseInt(boardNum);
		this.title = title;
		this.id = id;
		this.date = date;
		this.contents = contents;
		this.hits = Integer.parseInt(hits);
		num++;
	}
	
	public String dataString() {
		return boardNum+title+id+date+contents+hits+"\n";
	}
}
