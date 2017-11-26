package tomo.universityES.pharmacy.dao.exceptions.CustomerExceptions;


import tomo.universityES.pharmacy.dao.exceptions.PersistenceException;

public class EmailNotFoundException extends PersistenceException {

    public EmailNotFoundException() {
    }

    public EmailNotFoundException(String message) {
        super(message);
    }

    public EmailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
