package tomo.universityES.pharmacy.service.impl;

import jdk.nashorn.internal.ir.annotations.Ignore;
import tomo.universityES.pharmacy.dao.CustomerDAO;
import tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions.CustomerAlreadyExistsException;
import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.helpClasses.Gender;
import tomo.universityES.pharmacy.service.CustomerManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tomo.universityES.pharmacy.model.helpClasses.Address;
import tomo.universityES.pharmacy.model.helpClasses.City;
import tomo.universityES.pharmacy.model.helpClasses.Country;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class CustomerManagerServiceImpl implements CustomerManagerService
{


    private static Logger LOG = LogManager.getLogger(CustomerManagerServiceImpl.class);
    private CustomerDAO customerDAO;

    public CustomerManagerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Collection<Customer> listCustomers() {
        return customerDAO.readCustomers();
    }

    public Collection<Customer> listCustomersByCity(City city) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getCity().equals(city)){
                result.add(customer);
            }
        }
        return result;
    }


    public Collection<Customer> listCustomersByCountry(Country country) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getCountry().equals(country)){
                result.add(customer);
            }
        }
        return result;
    }

    public void createCustomer(String firstName, String lastName, String emailAddress, String phoneNumber, Address address) {
        Customer customer = new Customer(firstName, lastName, emailAddress, phoneNumber, address);
        try {
            customerDAO.createCustomer(customer);
        } catch (CustomerAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }
    }


}
