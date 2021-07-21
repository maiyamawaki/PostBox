package operations;

import java.io.PrintWriter;
import java.io.PrintReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.HashMap;

public class Common {
	public HashMap<Integer, Post> getMapFromFile() {
		HashMap<Integer, Post> map = new HashMap<Integer, Post>();
		try(BufferedReader input = new BufferedReader(new PrintReader("data.csv"))) {
			String data = "";
			while((data = input.readLine())!=null) {
				int id = Integer.parseInt(data.split(",")[0]);
				Stirng title = data.split(",")[1];
				String contents = data.split(",")[2];
				map.put(id, new Post(title, contents));
			}
		} catch(IOException e) {
			System.out.println("Ocurrió error al abrir el csv.");
		}
		return map;
	}

	public void updateFile(HashMap<Integer, Post> map) {
		try(BufferedWriter output = new BufferedWriter(new PrintWriter("data.csv"))) {
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
}