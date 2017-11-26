package tomo.universityES.pharmacy.dao.exceptions.orderExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class DateNotFoundException extends PersistenceException {

    public DateNotFoundException() {
    }

    public DateNotFoundException(String message) {
        super(message);
    }

    public DateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
