package tomo.universityES.pharmacy.model;

import tomo.universityES.pharmacy.model.helpClasses.Address;
import tomo.universityES.pharmacy.model.helpClasses.City;
import tomo.universityES.pharmacy.model.helpClasses.Country;
import tomo.universityES.pharmacy.model.helpClasses.Gender;

import java.util.Date;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Gender gender;
    private Date birthDate;
    private final String emailAddress;
    private final String phoneNumber;
    private Address address;

    public Employee(String firstName, String lastName, Gender gender, Date birthDate, String emailAddress, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getZipCode() {
        return address.getZipCode();
    }

    public City getCity() {
        return address.getCity();
    }

    public Country getCountry() {
        return address.getCountry();
    }


    @Override
    public String toString() {
        return firstName +" " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Customer && firstName.equals(((Employee) obj).firstName) && lastName.equals(((Employee) obj).lastName);
    }
}
