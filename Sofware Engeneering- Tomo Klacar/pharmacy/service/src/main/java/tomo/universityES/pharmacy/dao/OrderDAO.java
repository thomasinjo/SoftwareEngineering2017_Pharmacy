package tomo.universityES.pharmacy.dao;


import tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions.CustomerNotFoundException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.DateNotFoundException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderAlreadyExistsException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderNotFoundException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderNumNotFoundException;
import tomo.universityES.pharmacy.model.Employee;
import tomo.universityES.pharmacy.model.Order;

import java.util.Collection;
import java.util.Date;

public interface OrderDAO {

    void createOrder(Order order) throws OrderAlreadyExistsException;

    void updateOrder(Order order) throws OrderNotFoundException;

    void deleteOrder(Order Order) throws OrderNotFoundException;

    Collection<Order> readOrders();

    Collection<Order> readOrdersByEmployees(Employee employee) throws CustomerNotFoundException;


    Collection<Order> readOrdersByDate(Date date) throws DateNotFoundException;

    Order readByOrderNum(int OrderNum) throws OrderNumNotFoundException;

}
