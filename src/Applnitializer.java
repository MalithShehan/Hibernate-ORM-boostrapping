import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Applnitializer {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(002);
        customer.setName("Shehan");
        customer.setAddress("Mathara");
        customer.setSalary(82000.00);

        session.save(customer);

        transaction.commit();

        session.close();

    }
}