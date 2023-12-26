package dao;

import java.util.ArrayList;

import dto.Board;
import dto.Member;

public class BoardDAO {
	private ArrayList<Board> boardList;
	private BoardDAO() {
		boardList = new ArrayList<Board>();
	}
	private static BoardDAO instance = new BoardDAO();
	
	static public BoardDAO getInstance() {
		return instance;
	}

	public void loadBoardData(String data) {
		String[] dataList = data.split("\n");
		for(int i=0; i<dataList.length; i++) {
			String[] temp = dataList[i].split("/");
			boardList.add(new Board(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]));
		}
		System.out.println("[board 데이터 로드 완료]");
	}
	
	public String saveBoardData() {
		String data = "";
		if(boardList.size()==0) return data;
		for(Board b : boardList) {
			data += b.dataString();
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
}
