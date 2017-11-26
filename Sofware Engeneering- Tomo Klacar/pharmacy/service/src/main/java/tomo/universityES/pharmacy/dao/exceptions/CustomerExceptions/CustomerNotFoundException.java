package tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class CustomerNotFoundException extends PersistenceException {

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
