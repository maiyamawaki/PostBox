package operations;

import java.util.HashMap;

public class ViewAll extends Common {
	public void viewAll() {
		HashMap<Integer, Post> map = getMapFromFile();

		if (map.size()<=0) {
			System.out.println("No hay ningun post registrado.");
		} else {
			for (int key : map.keySet()) {
				Post post = map.get(key);
				System.out.print("ID : " + key);
				System.out.print(" TITLE : " + post.getTitle());
				System.out.println(" CONTENTS : " + post.getContents());
			}
		}
	}
}