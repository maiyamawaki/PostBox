import java.io.Console;

import operations.*;

public class PostBox {
	public static void main(String[] args) {
		PostBox app = new PostBox();
		app.start();
	}

	public void start() {
		Console console = System.console();

		ViewAll viewAll = new ViewAll();
		Register register = new Register();
		Edit edit = new Edit();

		int inputId = 0;
		while (inputId != Operation.CLOSE.getOperationNum()) {
			try{
				System.out.println(Operation.VIEWALL.getOperationName());
				System.out.println(Operation.REGISTER.getOperationName());
				System.out.println(Operation.EDIT.getOperationName());
				System.out.println(Operation.REMOVE.getOperationName());
				System.out.println(Operation.CLOSE.getOperationName());
				inputId = Integer.parseInt(console.readLine());

				if (inputId == Operation.VIEWALL.getOperationNum()) {
					viewAll.viewAll();
				} else if (inputId == Operation.REGISTER.getOperationNum()) {
					register.register();
				} else if (inputId == Operation.EDIT.getOperationNum()) {
					edit.edit();
				}
			} catch (NumberFormatException e) {
				System.out.println("Elija algun numero correspondiente.");
			}
		}
	}
}