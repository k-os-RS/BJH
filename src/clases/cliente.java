package clases;

class cliente extends persona {
	
	protected facturacompra invoice;

	public cliente(String dni, String name, String last_name, String address, String email, String username,
			String password, facturacompra invoice) {
		super(dni, name, last_name, address, email, username, password);
		this.invoice = invoice;
	}
	
}
