package uk.co.echomoo.WhereIsThat.exceptions;

public class LocationException extends RuntimeException {
    public LocationException(String s) { super(s); }
    public LocationException(String s, Exception e) {
        super(s, e);
    }
}
