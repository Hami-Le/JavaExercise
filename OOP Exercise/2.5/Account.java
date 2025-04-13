
public class Account {
	private int id;
	private Customer customer;
	private double balance = 0.0;

	public Account(int id, Customer customer, double balance) {
		this.id = id;
		this.customer = customer;
		this.balance = balance;
	}

	public Account(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customer.getId();
	}

	public String getCustomerName() {
		return customer.getName();
	}

	public Account deposit(double amount) {
		balance += amount;
		return null;
	}

	public Account withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("amount withdraw exceeds the current balance!");
		}
		return null;
	}

	@Override
	public String toString() {
		return getCustomerName() + "(" + getCustomerId() + ") balance=$" + String.format("%.02f", balance);
	}

}
