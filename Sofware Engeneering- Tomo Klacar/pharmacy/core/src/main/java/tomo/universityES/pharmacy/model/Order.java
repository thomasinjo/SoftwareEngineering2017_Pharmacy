package tomo.universityES.pharmacy.model;

import java.util.*;

public class Order {

    private Customer customer;
    private Employee employee;
    private Medicine medicine;

    private Date orderDate;
    private final int OrderNum;


    public Order(Customer customer, Employee employee, Medicine medicine , Date orderDate, int OrderNum) {
        this.customer = customer;
        this.employee = employee;
        this.medicine = medicine;
        this.orderDate = orderDate;
        this.OrderNum = OrderNum;

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return OrderNum;
    }




    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", employee=" + employee +
                ", medicine=" + medicine +
                ", orderDate=" + orderDate +
                ", OrderNum=" + OrderNum +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Order && OrderNum == ((Order) obj).getOrderNum();
    }
}
