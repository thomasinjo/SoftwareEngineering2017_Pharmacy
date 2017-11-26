package tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class CustomerAlreadyExistsException extends PersistenceException {

    public CustomerAlreadyExistsException() {
    }

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }

    public CustomerAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
