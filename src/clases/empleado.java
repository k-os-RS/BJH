package clases;

class empleado extends persona {
	
	protected facturapide invoice;

	public empleado(String dni, String name, String last_name, String address, String email, String username,
			String password, facturapide invoice) {
		super(dni, name, last_name, address, email, username, password);
		this.invoice = invoice;
	}

}
