package dto;

public class Board {
	private static int num;
	private int boardNum;
	private String title;
	private String id;
	private String date;
	private String contents;
	private int hits;
	
	public Board() {
		
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
	
	
}
