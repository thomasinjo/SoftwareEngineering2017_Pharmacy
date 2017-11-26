package tomo.universityES.pharmacy.dao;

import tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions.*;
import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.helpClasses.City;
import tomo.universityES.pharmacy.model.helpClasses.Country;

import java.util.Collection;

public interface CustomerDAO {

    void createCustomer(Customer customer) throws CustomerAlreadyExistsException;

    void updateCustomer(Customer customer) throws CustomerNotFoundException;

    void deleteCustomer(Customer customer) throws CustomerNotFoundException;

    Collection<Customer> readCustomers();

    Collection<Customer> readCustomersByCity(City city);

    Collection<Customer> readCustomersByCountry(Country country);


    Customer readCustomersByEmail(String email) throws EmailNotFoundException;


    Customer readCustomersByPhone(String phone) throws PhoneNotFoundException;
}
