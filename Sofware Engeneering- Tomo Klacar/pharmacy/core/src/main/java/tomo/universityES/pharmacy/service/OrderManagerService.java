package tomo.universityES.pharmacy.service;


import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.Employee;
import tomo.universityES.pharmacy.model.Medicine;
import tomo.universityES.pharmacy.model.Order;

import java.util.Collection;
import java.util.Date;


public interface OrderManagerService {

    void AddOrder(Customer customer, Employee employee, Medicine medicine , Date orderDate, int OrderNum);


    Collection<Order> listOrders();

}
