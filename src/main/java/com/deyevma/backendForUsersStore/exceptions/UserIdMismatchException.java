package com.deyevma.backendForUsersStore.exceptions;

public class UserIdMismatchException extends RuntimeException{
    public UserIdMismatchException() {
        super();
    }

    public UserIdMismatchException(String message) {
        super(message);
    }

    public UserIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIdMismatchException(Throwable cause) {
        super(cause);
    }
}
