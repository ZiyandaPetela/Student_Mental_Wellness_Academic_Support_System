package exceptions;
public class AppointmentCancellationException extends RuntimeException {
    public AppointmentCancellationException(String message) { super(message); }
}