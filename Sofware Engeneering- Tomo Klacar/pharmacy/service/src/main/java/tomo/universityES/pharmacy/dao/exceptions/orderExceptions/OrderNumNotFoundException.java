package tomo.universityES.pharmacy.dao.exceptions.orderExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class OrderNumNotFoundException extends PersistenceException {

    public OrderNumNotFoundException() {
    }

    public OrderNumNotFoundException(String message) {
        super(message);
    }

    public OrderNumNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
