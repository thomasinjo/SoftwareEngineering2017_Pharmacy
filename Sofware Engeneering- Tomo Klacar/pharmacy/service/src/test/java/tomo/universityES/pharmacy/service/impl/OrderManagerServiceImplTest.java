package tomo.universityES.pharmacy.service.impl;


import tomo.universityES.pharmacy.dao.OrderDAO;
import tomo.universityES.pharmacy.dao.exceptions.orderExceptions.OrderAlreadyExistsException;
import tomo.universityES.pharmacy.model.Customer;
import tomo.universityES.pharmacy.model.Employee;
import tomo.universityES.pharmacy.model.Medicine;
import tomo.universityES.pharmacy.model.Order;
import tomo.universityES.pharmacy.model.helpClasses.*;
import tomo.universityES.pharmacy.service.OrderManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

public class OrderManagerServiceImplTest {


    private Logger LOG = LogManager.getLogger(OrderManagerServiceImpl.class);
    private OrderManagerService service;

    @Before
    public void  setUp() throws ParseException, OrderAlreadyExistsException {
        OrderDAO orderDAO = EasyMock.createMock(OrderDAO.class);

        Address adress1 = new Address("3515", City.MISKOLC, Country.HUNGARY);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Customer tomo = new Customer("Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        Customer miroslav = new Customer("Miroslav",
                "Maksimovic",
                "mikimaksimovic@gmail.com",
                "+38765150160",
                adress1);
        Employee janek = new Employee("Janek",
                "Druzik",
                Gender.MALE,
                dateFormat.parse("1994-12-11"),
                "janekdruzik@gmail.com",
                "+38765987321",
                adress1
        );
        Employee frank = new Employee("Francesko",
                "Italiano",
                Gender.MALE,
                dateFormat.parse("1993-10-23"),
                "frankitaliano@gmail.com",
                "+38765654789",
                adress1
        );
        Medicine aspirin = new Medicine("Aspirin", Availability.YES);
        Medicine vitamins = new Medicine("Vitamins", Availability.YES);
        Medicine insuline = new Medicine("Insuline", Availability.NO);



        Order order1 = new Order(tomo, janek,aspirin, dateFormat.parse("2017-10-05"),1);
        Order order2 = new Order(miroslav, frank, insuline, dateFormat.parse("2017-10-06"),2);
        Order order3 = new Order(miroslav, frank, vitamins, dateFormat.parse("2017-10-07"),3);



        EasyMock.expect(orderDAO.readOrders()).andReturn(Arrays.asList(order1, order2));
        orderDAO.createOrder(order1);
        orderDAO.createOrder(order2);
        orderDAO.createOrder(order3);
        EasyMock.replay(orderDAO);
        service = new OrderManagerServiceImpl(orderDAO);
    }
    @Test
    public void testLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void testListAllOrders() throws ParseException {

        Address adress1 = new Address("3515", City.MISKOLC, Country.HUNGARY);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Customer tomo = new Customer("Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        Customer miroslav = new Customer("Miroslav",
                "Maksimovic",
                "mikimaksimovic@gmail.com",
                "+38765150160",
                adress1);
        Employee janek = new Employee("Janek",
                "Druzik",
                Gender.MALE,
                dateFormat.parse("1994-12-11"),
                "janekdruzik@gmail.com",
                "+38765987321",
                adress1
        );
        Employee frank = new Employee("Francesko",
                "Italiano",
                Gender.MALE,
                dateFormat.parse("1993-10-23"),
                "frankitaliano@gmail.com",
                "+38765654789",
                adress1
        );
        Medicine aspirin = new Medicine("Aspirin", Availability.YES);
        Medicine vitamins = new Medicine("Vitamins", Availability.YES);
        Medicine insuline = new Medicine("Insuline", Availability.NO);



        Order order1 = new Order(tomo, janek,aspirin, dateFormat.parse("2017-10-05"),1);
        Order order2 = new Order(miroslav, frank, insuline, dateFormat.parse("2017-10-06"),2);
        Order order3 = new Order(miroslav, frank, vitamins, dateFormat.parse("2017-10-07"),3);


        Collection<Order> expected = Arrays.asList(order1, order2);
        Collection<Order> actual = service.listOrders();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }




    @Test
    public void createOrderWhichExists() throws ParseException {
        Address adress1 = new Address("3515", City.MISKOLC, Country.HUNGARY);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Customer tomo = new Customer("Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        Employee frank = new Employee("Francesko",
                "Italiano",
                Gender.MALE,
                dateFormat.parse("1993-10-23"),
                "frankitaliano@gmail.com",
                "+38765654789",
                adress1
        );
        Medicine aspirin = new Medicine("Aspirin", Availability.YES);
        service.AddOrder(tomo,frank,aspirin, dateFormat.parse("2017-11-05"),1);
    }

}
