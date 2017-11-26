package tomo.universityES.pharmacy.service;

import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.helpClasses.Address;
import tomo.universityES.pharmacy.model.helpClasses.City;
import tomo.universityES.pharmacy.model.helpClasses.Country;

import java.util.Collection;


public interface CustomerManagerService {


    public Collection<Customer> listCustomers();
    public Collection<Customer> listCustomersByCity(City city);
    public Collection<Customer> listCustomersByCountry(Country country);



    public void createCustomer(String firstName, String lastName, String emailAddress, String phoneNumber, Address address);

}
