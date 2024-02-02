package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name = "customer")
@Entity
@Table(name = "customer")

public class Customer {

    @Id // Tells Hibernate that is the Primary key of this.

    @Column(name = "customerId")
    private int id;

    @Column(name = "customerName")
    private String name;

    @Column(name = "customerAddress")
    private String address;

    @Column(name = "customerSalary")
    private double salary;

    public Customer() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public Customer(int id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
}
