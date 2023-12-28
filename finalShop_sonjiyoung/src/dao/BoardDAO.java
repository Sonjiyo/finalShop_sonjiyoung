package dao;

import java.util.ArrayList;

import dto.Board;
import dto.Member;
import util.Util;

public class BoardDAO {
	private final int PAGESIZE = 5;
	private ArrayList<Board> boardList;
	private int pageCount;
	private int curPageNum = 1;
	private int startRow;
	private int endRow;
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
		boardList = new ArrayList<Board>();
	}
	
	static public BoardDAO getInstance() {
		return instance;
	}

	private void setPageCount() {
		pageCount = boardList.size()/PAGESIZE;
		if(boardList.size()%PAGESIZE!=0) pageCount+=1;
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
	
	private int checkBoardNum(int num) {
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getBoardNum()==num) return i;
		}
		return -1;
	}
	
	private void printOneBoard(int idx) {
		System.out.println(boardList.get(idx));
		System.out.println("----------------");
		System.out.println(boardList.get(idx).getContents()+"\n\n");
	}
	
	private boolean isBoardEmpty() {
		if(boardList.size()==0) {
			System.out.println("게시글이 없습니다.");
			return true;
		}
		return false;
	}
	
	public void removeBoard(String id) {
		if(isBoardEmpty()) return;
		int sel = Util.getValue("삭제할 게시글 번호 입력", 1, boardList.size());
		int idx = checkBoardNum(sel);
		if(idx ==-1) {
			System.out.println("올바르지 않은 게시물입니다.");
			return;
		}
		if(!id.equals("admin") && !boardList.get(idx).getId().equals(id)) {
			System.out.println("본인의 게시글을 선택해주세요.");
			return;
		}
		for(int i=idx+1; i<boardList.size(); i++) {
			boardList.get(i).setBoardNum(-1);
			Board.setNum(-1);
		}
		boardList.remove(idx);
		System.out.println("[게시글 삭제 완료]");
	}
	
	public void inputBoard(String id) {
		String title = Util.getValue("제목 입력");
		String contents = Util.getValue("내용 입력");
		boardList.add(new Board(title,id,contents));
	}
	
	public void printMemberBoard(String id) {
		if(isBoardEmpty()) return;
		int cnt = 0;
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getId().equals(id)) {
				cnt++;
				printOneBoard(i);
			}
		}
		if(cnt==0) {
			System.out.println("작성한 게시글이 없습니다.");
			return;
		}
		System.out.println("[1] 삭제\n[0] 돌아가기");
		int sel = Util.getValue("입력", 0, 1);
		if(sel==0) return;
		removeBoard(id);
	}
	
	public void printBoard() {
		if(isBoardEmpty()) return;
		setPageCount();
		while(true) {
			startRow = (curPageNum-1)*PAGESIZE;
			endRow = startRow + PAGESIZE;
			if(endRow > boardList.size()) endRow = boardList.size();
			
			System.out.printf("총 게시글 %d개\n",boardList.size());
			System.out.printf("현재페이지 [%d/%d]\n",curPageNum,pageCount);
			
			if(boardList.size()!=0) {
				for(int i = startRow; i<endRow; i++) {
					System.out.println(boardList.get(i));
				}				
			}
			System.out.println("[1] 이전\n[2] 이후\n[3] 게시글보기\n[0] 종료");
			int sel = Util.getValue("입력", 0, 3);
			if(sel==0) {
				curPageNum = 1;
				return;
			}
			if(sel==1) {
				if(curPageNum==1) {
					System.out.println("이전 페이지가 없습니다.");
					continue;
				}
				curPageNum-=1;
			} else if(sel==2) {
				if(curPageNum>=pageCount) {
					System.out.println("마지막 페이지입니다.");
					continue;
				}
				curPageNum+=1;
			} else {
				sel = Util.getValue("게시글 번호 입력", startRow+1, endRow);
				int idx = checkBoardNum(sel);
				printOneBoard(idx);
				boardList.get(idx).setHits(+1);
			}
		}
	}
}
