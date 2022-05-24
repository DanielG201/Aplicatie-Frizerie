package org.loose.fis.sre.exceptions;

public class ReservationAlreadyExistsException extends Exception {

    private String username;

    public ReservationAlreadyExistsException(String username) {
        super(String.format("An account with the username %s already exists!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
