package operations;

import java.util.HashMap;
import java.io.Console;

public class Register extends Common {
	public void register() {
		Console console = System.console();
		HashMap<Integer, Post> map = getMapFromFile();

		String title = getTitle();
		String contents = getContents();

		int max = 0;
		for (int key : map.keySet()) {
			if (max<key) {
				max = key;
			}
		}

		int newId = max + 1;

		map.put(newId, new Post(title, contents));

		updateFile(map);
	}
}