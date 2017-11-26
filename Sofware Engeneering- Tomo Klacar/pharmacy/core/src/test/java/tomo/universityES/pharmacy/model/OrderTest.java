package tomo.universityES.pharmacy.model;


import tomo.universityES.pharmacy.model.helpClasses.*;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order1;
    private Order order2;
    private Order order3;
    private Customer tomo;
    private Employee frank;



    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static  void afterClass(){
    }

    @Before
    public void setUp() throws ParseException {
        Address adress1 = new Address("3515", City.MISKOLC, Country.HUNGARY);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        this.tomo = new Customer("Tomo",
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
        this.frank = new Employee("Francesko",
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



        this.order1 = new Order(tomo, janek,aspirin, dateFormat.parse("2017-10-05"),1);
        this.order2 = new Order(miroslav, frank, insuline, dateFormat.parse("2017-10-06"),2);
        this.order3 = new Order(miroslav, frank, vitamins, dateFormat.parse("2017-10-07"),3);
    }

    @After
    public void tearDown(){
    }



    @Test
    public void testCustomer(){
        assertEquals(order1.getCustomer(), tomo);

    }

    @Test
    public void testOrderDate() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            assertEquals(order2.getOrderDate(),dateFormat.parse("2017-10-06"));
    }


    @Ignore
    public void testEmployee(){
        assertEquals(order2.getEmployee(), frank);
    }


}
