package tomo.universityES.pharmacy.dao.exceptions.orderExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class OrderNotFoundException extends PersistenceException {

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
