
public class Book {
	private String name;
	private Author author;
	private double price;
	private int qty=0;
	
	public Book(String name, Author author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Book(String name, Author author, double price, int qty) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public Author getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getAuthorName() {
		return author.getName();
	}
	
	public String getAuthorEmail() {
		return author.getEmail();
	}
	
	public char getAuthorGender() {
		return author.getGender();
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", Author[name= "+getAuthorName()+", email= "+getAuthorEmail()+", gender= "+getAuthorGender()+ "], price=" + price + ", qty=" + qty + "]";
	}
	
	
	
}
