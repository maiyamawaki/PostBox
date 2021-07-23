package operations;

import java.io.Console;
import java.util.HashMap;

public class Edit extends Common {
	public void edit() {
		Console console = System.console();
		HashMap<Integer, Post> map = getMapFromFile();

		System.out.println("Elije el post que quieres editar.");
	  try {
			int id = Integer.parseInt(console.readLine());
			Post postForEdit = null;

			for (int key : map.keySet()) {
				if (key == id) {
					postForEdit = map.get(key);
				}
			}

			if (postForEdit == null) {
				System.out.println("No hay ningun post con este id");
			} else {
				String newTitle = postForEdit.getTitle();
				String newContents = postForEdit.getContents();

				System.out.println("Quieres editar su titulo?");
				String answer = getAnswer();
				if (answer.equals("y")) {
					newTitle = getTitle();
				}

				System.out.println("Quieres editar su contents");
				answer = getAnswer();
				if (answer.equals("y")) {
					newContents = getContents();
				}

				map.put(id, new Post(newTitle, newContents));
				updateFile(map);
			}
		} catch (NumberFormatException e) {
			System.out.println("Ejige un post por su id.");
		}
	}
}