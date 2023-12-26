package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDAO {
	private static File file;
	private static FileDAO instance = new FileDAO();
	private static String filePath = System.getProperty("user.dir") + "\\src\\files\\";

	enum FileName {
		BOARD("board.txt"), MEMBER("member.txt"), ITEM("item.txt"), CART("cart.txt");
		private String name;
		FileName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	private FileDAO() {
		init();
	}
	
	private void init() {
		createFile(FileName.BOARD);
		createFile(FileName.MEMBER);
		createFile(FileName.ITEM);
		createFile(FileName.CART);
	}

	private void createFile(FileName name) {
		Path path = Paths.get("src/files/" + name.getName());
		try {
			Files.createFile(path);
		} catch (IOException e) {
			//System.out.println("파일이 이미 있음");
		}
	}

	private static String loadFile(FileName name) {
		String data = "";
		file = new File(filePath+name.getName());
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);){
			String str = "";
			while(true) {
				str = br.readLine();
				if(str == null) break;
				data+=str+"\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
	
	public static void loadAllFiles() {
		BoardDAO.getInstance().loadBoardData(loadFile(FileName.BOARD));
		MemberDAO.getInstance().loadMemberData(loadFile(FileName.MEMBER));
		ItemDAO.getInstance().loadItemData(loadFile(FileName.ITEM));
		CartDAO.getInstance().loadCartData(loadFile(FileName.CART));
	}
	
	private static void saveFile(String data,FileName name) {
		file = new File(filePath+name.getName());
		try(FileWriter fw = new FileWriter(file)){
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveAllFiles() {
		saveFile(BoardDAO.getInstance().saveBoardData(),FileName.BOARD);
		saveFile(MemberDAO.getInstance().saveMemberData(),FileName.MEMBER);
		saveFile(ItemDAO.getInstance().saveItemData(),FileName.ITEM);
		saveFile(CartDAO.getInstance().saveCartData(),FileName.CART);
	}
}