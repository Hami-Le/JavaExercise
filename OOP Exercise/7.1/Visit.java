import java.util.Date;

public class Visit {
	private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(String name, Date date) {
        this.customer = new Customer(name);
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double svcDiscount = 0.0;
        double prodDiscount = 0.0;

        if (customer.isMember()) {
            svcDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
            prodDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());
        }

        double totalSvc = serviceExpense * (1 - svcDiscount);
        double totalProd = productExpense * (1 - prodDiscount);
        return totalSvc + totalProd;
    }

    @Override
    public String toString() {
        return "Visit[customer=" + customer + ", date=" + date
                + ", serviceExpense=" + serviceExpense
                + ", productExpense=" + productExpense
                + ", totalExpense=" + getTotalExpense() + "]";
    }
}
