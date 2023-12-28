package dao;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDAO {
	private static FileDAO instance = new FileDAO();
	private static String curPath = "src\\files";
	private static Charset charset = StandardCharsets.UTF_8; 

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
		Path path = Paths.get(curPath,name.getName());
		StringBuilder data = new StringBuilder();
		
		try(FileInputStream fis = new FileInputStream(path.toString());
			InputStreamReader ir = new InputStreamReader(fis, charset);
			BufferedReader br = new BufferedReader(ir);){
			String line = "";
			while((line=br.readLine())!=null) {
				data.append(line);
				data.append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data.toString().substring(0,data.length()-1);
	}
	
	public static void loadAllFiles() {
		BoardDAO.getInstance().loadBoardData(loadFile(FileName.BOARD));
		MemberDAO.getInstance().loadMemberData(loadFile(FileName.MEMBER));
		ItemDAO.getInstance().loadItemData(loadFile(FileName.ITEM));
		CartDAO.getInstance().loadCartData(loadFile(FileName.CART));
	}
	
	private static void saveFile(String data,FileName name) {
		Path path = Paths.get(curPath,name.getName());

		try (FileOutputStream fos = new FileOutputStream(path.toString());
			OutputStreamWriter ow = new OutputStreamWriter(fos, charset);
			BufferedWriter bw = new BufferedWriter(ow);){
			
			bw.write(data);
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