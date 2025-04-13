
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        Customer c1 = new Customer("Hmi");
        c1.setMember(true);
        c1.setMemberType("Gold");

        Visit v1 = new Visit(c1.getName(), new Date());
        v1.setCustomer(c1);
        v1.setServiceExpense(100);
        v1.setProductExpense(50);
        System.out.println(v1);

        Customer c2 = new Customer("Tphuong");
        c2.setMember(true);
        c2.setMemberType("Premium");

        Visit v2 = new Visit(c2.getName(), new Date());
        v2.setCustomer(c2);
        v2.setServiceExpense(200);
        v2.setProductExpense(100);
        System.out.println(v2);

        Customer c3 = new Customer("Hmy");

        Visit v3 = new Visit(c3.getName(), new Date());
        v3.setCustomer(c3);
        v3.setServiceExpense(150);
        v3.setProductExpense(80);
        System.out.println(v3);
    }
}

