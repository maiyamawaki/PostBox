package operations;

import java.io.Console;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.HashMap;
import java.io.IOException;

public class Common {
	Console console = System.console();

	public HashMap<Integer, Post> getMapFromFile() {
		HashMap<Integer, Post> map = new HashMap<Integer, Post>();
		try(BufferedReader input = new BufferedReader(new FileReader("data.csv"))) {
			String data = "";
			while((data = input.readLine())!=null) {
				try {
					int id = Integer.parseInt(data.split(",")[0]);
					String title = data.split(",")[1];
					String contents = data.split(",")[2];
					map.put(id, new Post(title, contents));
				} catch (ArrayIndexOutOfBoundsException e) {}
			}
		} catch(IOException e) {
			System.out.println("Ocurrió error al abrir el csv.");
		}
		return map;
	}

	public void updateFile(HashMap<Integer, Post> map) {
		try(BufferedWriter output = new BufferedWriter(new FileWriter("data.csv"))) {
			for (int key : map.keySet()) {
				Post post = map.get(key);
				output.write(String.valueOf(key));
				output.write(",");
				output.write(post.getTitle());
				output.write(",");
				output.write(post.getContents());
				output.newLine();
			}
		}catch(IOException e) {
			System.out.println("Occurió error al abrir el csv.");
		}
	}

	public String getTitle() {
		String title = null;
		do {
			System.out.print("Escribe el titlo del Post : ");
			title = console.readLine();
		} while (title == null || title.length() <= 0);
		return title;
	}

	public String getContents() {
		String contentes = null;
		do {
			System.out.print("Escribe el contents del Post : ");
			contentes = console.readLine();
		} while (contentes == null || contentes.length() <= 0);
		return contentes;
	}
}