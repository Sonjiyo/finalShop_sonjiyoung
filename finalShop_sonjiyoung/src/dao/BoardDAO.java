package dao;

import java.util.ArrayList;

import dto.Board;

public class BoardDAO {
	private ArrayList<Board> boardList;
	private BoardDAO() {
		boardList = new ArrayList<Board>();
	}
	private static BoardDAO instance = new BoardDAO();
	
	static public BoardDAO getInstance() {
		return instance;
	}
}
