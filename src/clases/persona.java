package clases;

class persona {
	
	protected String dni, name, last_name, address, email, username, password;
	
	public persona(String dni, String name, String last_name, String address, String email, String username,
			String password) {
		this.dni = dni;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getLast_name() {
		return last_name;
	}

	protected void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
	
}
