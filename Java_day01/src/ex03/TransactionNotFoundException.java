package ex03;

public class TransactionNotFoundException extends RuntimeException {
    TransactionNotFoundException(String errMessage) {
        super(errMessage);
    }
}
