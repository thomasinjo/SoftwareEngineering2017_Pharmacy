package tomo.universityES.pharmacy.model;


import tomo.universityES.pharmacy.model.helpClasses.Address;
import tomo.universityES.pharmacy.model.helpClasses.City;
import org.junit.*;
import tomo.universityES.pharmacy.model.helpClasses.Country;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static  org.junit.Assert.*;

public class CustomerTest {

    private Customer tomo;
    private Customer miroslav;

    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static  void afterClass(){
    }

    @Before
    public void setUp() throws ParseException {
        Address adress1 = new Address("3515", City.ROME, Country.ITALIA);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.tomo = new Customer(
                "Tomo",
                "Klacar",
                "tomoklacar@gmail.com",
                "+38765845948",
                adress1);
        this.miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                "mikimaksimovic@gmail.com",
                "+38764150160",
                adress1);
    }

    @After
    public void tearDown(){
    }


    @Test
    public void testFirstName(){
        assertEquals(tomo.getFirstName(), "Tomo");
    }

    @Test
    public void testLastName(){
        assertEquals(miroslav.getLastName(), "Maksimovic");
    }


    @Test
    public void testIsSameCity() {
        assertEquals(miroslav.getCity(),City.ROME);

    }

    @Test
    public void testIsSameEmail() {
        assertEquals(miroslav.getEmailAddress(),"mikimaksimovic@gmail.com");

    }

    @Test
    public void testIsSameNumber() {
        assertEquals(tomo.getPhoneNumber(),"+38765845948");

    }

}
