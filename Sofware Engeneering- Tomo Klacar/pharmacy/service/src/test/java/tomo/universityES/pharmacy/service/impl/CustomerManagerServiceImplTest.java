package tomo.universityES.pharmacy.service.impl;


import org.junit.Ignore;
import tomo.universityES.pharmacy.dao.CustomerDAO;
import tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions.CustomerAlreadyExistsException;
import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.helpClasses.Address;
import tomo.universityES.pharmacy.service.CustomerManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tomo.universityES.pharmacy.model.helpClasses.City;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import static tomo.universityES.pharmacy.model.helpClasses.Country.BOSNIA;
import static tomo.universityES.pharmacy.model.helpClasses.Country.HUNGARY;
public class CustomerManagerServiceImplTest {
    private Address adress1;
    private Address adress2;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Logger LOG = LogManager.getLogger(CustomerManagerServiceImpl.class);
    private CustomerManagerService service;

    @Before
    public void  setUp() throws ParseException, CustomerAlreadyExistsException {
        CustomerDAO customerDAO = EasyMock.createMock(CustomerDAO.class);

         adress1 = new Address("3515", City.MISKOLC, HUNGARY);
         adress2 = new Address("6593", City.PALE, BOSNIA);

        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                "mikimaksimovic@gmail.com",
                "+38765150160",
                adress1);

        Customer vojciech = new Customer(
                "Wojciech",
                "Kaczan",
                "wojo@gmail.com",
                "+40123456789",
                adress2);

        EasyMock.expect(customerDAO.readCustomers()).andReturn(Arrays.asList(tomo,miroslav));
        customerDAO.createCustomer(tomo);
        EasyMock.expectLastCall().andThrow(new CustomerAlreadyExistsException("Tomo Klacar already exists!"));
        customerDAO.createCustomer(vojciech);
        EasyMock.replay(customerDAO);
        service = new CustomerManagerServiceImpl(customerDAO);
    }
    @Test
    public void TestLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void TestAllCustomers() throws ParseException {

        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                "mikimaksimovic@gmail.com",
                "+38765150160",
                adress1);
        Collection<Customer> expected = Arrays.asList(tomo,miroslav);
        Collection<Customer> actual = service.listCustomers();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testListAllCustomersByCity() throws ParseException {
        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                "mikimaksimovic@gmail.com",
                "+38765150160",
                adress1);

        Collection<Customer> expected = Arrays.asList(tomo,miroslav);
       
    }


    @Test
    public void CreateCustomerWhichExists() throws ParseException {

        service.createCustomer("Wojciech",
                "Kaczan",
                "wojo@gmail.com",
                "+40123456789",
                adress2);
    }
    @Ignore
    @Test
    public void CreateNewCustomer() throws ParseException {
        service.createCustomer("Albert",
                "Akos",
                "albert.akos@gmail.com",
                "+40752624119",
                adress2);
    }
}
