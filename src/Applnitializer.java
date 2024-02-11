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

        Customer customer = getCustomer();

        session.save(customer);

        transaction.
                commit();

        session.close();

        //Get

        Session getSession =
                SessionFactoryConfig.
                        getInstance().
                        getSession();
        Customer existingCustomer =
                getSession.
                        get(Customer.class, 1);

        System.out.println("Existing Customer" +existingCustomer);

        getSession.close();

        System.out.println("----GET----");

        //Update

        Session updateSession =
                SessionFactoryConfig.
                getInstance().
                getSession();
        Transaction updateTransaction = updateSession.beginTransaction();

        existingCustomer.setAddress("Galle");

        updateSession.update(existingCustomer);

        updateSession.close();

        System.out.println("----UPDATE----");

        //Delete
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();

        Customer existingCus = deleteSession.get(Customer.class,1);
        existingCus.setAddress("Mathara");
        Transaction deleteTransaction =
                deleteSession.beginTransaction();

        deleteSession.delete(existingCus);
        deleteTransaction.commit();

        System.out.println("----DELETE----");

    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(001);
        customer.setName("Shehan");
        customer.setAddress("Mathara");
        customer.setSalary(82000.00);
        customer.setMobileNumber(0);
        return customer;
    }
}