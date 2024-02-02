package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance() {
//        if (null == factoryConfig) {
//            factoryConfig = new SessionFactoryConfig();
//            return factoryConfig;
//        } else {
//            return factoryConfig;
//        }

       return  (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;

    }

    public Session getSession() {
        //1. Creates a Service Registry.
       StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

       //2. Creates a Metadata Object.
        Metadata metadata = new MetadataSources(serviceRegistry)
//                .addAnnotatedClass()
                .getMetadataBuilder()
                .build();

        //3. Creates a Session Factory.
        SessionFactory sessionFactory = metadata
                .buildSessionFactory();

        // Created and Open The Session.
         return sessionFactory.openSession();
    }
}
