package exceptions;
public class AppointmentLimitExceededException extends RuntimeException {
    public AppointmentLimitExceededException(String message) { super(message); }
}
