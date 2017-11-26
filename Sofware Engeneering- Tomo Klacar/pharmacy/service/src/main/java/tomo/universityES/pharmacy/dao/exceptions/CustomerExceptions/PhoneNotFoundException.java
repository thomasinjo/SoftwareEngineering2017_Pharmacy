package tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class PhoneNotFoundException extends PersistenceException {

    public PhoneNotFoundException() {
    }

    public PhoneNotFoundException(String message) {
        super(message);
    }

    public PhoneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
