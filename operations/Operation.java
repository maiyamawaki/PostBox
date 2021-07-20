package operations;

public enum Operation {
	VIEWALL(1, "1 : Mostrar todo"),
	REGISTER(2, "2 : Registrar un post"),
	EDIT(3, "3 : Editar un post"),
	REMOVE(4, "4 : Eliminar el post"),
	CLOSE(9, "9 : Cerrar el servicio");

	private int operationNum;
	private String operationName;

	private Operation(int number, String name) {
		this.setOperationNum(number);
		this.setOperationName(name);
	}

	public void setOperationNum(int num) {
		this.operationNum = num;
	}

	public int getOperationNum() {
		return this.operationNum;
	}

	public void setOperationName(String name) {
		this.operationName = name;
	}

	public String getOperationName() {
		return this.operationName;
	}
}