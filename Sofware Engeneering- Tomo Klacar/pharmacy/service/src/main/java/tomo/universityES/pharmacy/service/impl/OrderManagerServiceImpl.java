package tomo.universityES.pharmacy.service.impl;

import tomo.universityES.pharmacy.dao.OrderDAO;
import tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions.CustomerNotFoundException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.DateNotFoundException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderAlreadyExistsException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderNotFoundException;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderNumNotFoundException;
import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.Employee;
import tomo.universityES.pharmacy.model.Medicine;
import tomo.universityES.pharmacy.model.Order;
import tomo.universityES.pharmacy.service.OrderManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class OrderManagerServiceImpl implements OrderManagerService
{


    private static Logger LOG = LogManager.getLogger(OrderManagerServiceImpl.class);
    private OrderDAO orderDAO;

    public OrderManagerServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void AddOrder(Customer customer, Employee employee, Medicine medicine , Date orderDate, int OrderNum){
        Order order = new Order(customer,employee,medicine,orderDate,OrderNum);
        try {
            orderDAO.createOrder(order);
        } catch (OrderAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateOrder(Customer customer, Employee employee, Medicine medicine , Date orderDate, int OrderNum){
        Order order = new Order(customer,employee,medicine,orderDate,OrderNum);
        try {
            orderDAO.updateOrder(order);
        } catch (OrderNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public void deleteOrder(Order order) {
        try {
            orderDAO.deleteOrder(order);
        } catch (OrderNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Order> listOrders() {
        return orderDAO.readOrders();
    }



    public Collection<Order> listOrdersByCustomers(Customer customer) throws CustomerNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getCustomer() == customer){
                result.add(order);
            }
        }
        return result;
    }


    public Collection<Order> readOrdersByDate(Date date) throws DateNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getOrderDate() == date){
                result.add(order);
            }
        }
        return result;
    }


    public Order readByOrderNum(int orderNum) throws OrderNumNotFoundException {
        return  orderDAO.readByOrderNum(orderNum);
    }
    
}
