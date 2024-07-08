package ex05;

public class TransactionNotFoundException extends RuntimeException {
    TransactionNotFoundException(String errMessage) {
        super(errMessage);
    }
}
