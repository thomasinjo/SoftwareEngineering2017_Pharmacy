package tomo.universityES.pharmacy.dao.exceptions.orderExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class OrderAlreadyExistsException extends PersistenceException {

    public OrderAlreadyExistsException() {
    }

    public OrderAlreadyExistsException(String message) {
        super(message);
    }

    public OrderAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
