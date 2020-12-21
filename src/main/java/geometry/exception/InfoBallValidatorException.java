package geometry.exception;

public class InfoBallValidatorException extends Exception {
    public InfoBallValidatorException(){}

    public InfoBallValidatorException(String message) {
        super(message);
    }

    public InfoBallValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfoBallValidatorException(Throwable cause) {
        super(cause);
    }
}
