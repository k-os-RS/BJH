package clases;

class producto {

	protected String sale_price, type, stock, name;

	public producto(String sale_price, String type, String stock, String name) {
		super();
		this.sale_price = sale_price;
		this.type = type;
		this.stock = stock;
		this.name = name;
	}

	protected String getSale_price() {
		return sale_price;
	}

	protected void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}

	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	protected String getStock() {
		return stock;
	}

	protected void setStock(String stock) {
		this.stock = stock;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
}
