package service;

public class PaymentService {
    private PaymentService() {}

    private static class PaymentServiceHolder {
        private static final PaymentService INSTANCE = new PaymentService();
    }

    public static PaymentService getInstance() {
        return PaymentServiceHolder.INSTANCE;
    }

    public boolean processPayment(double amount) {
        // further strategy can be defined for this
        System.out.println("payment of " + amount + " is successfull");
        return true;
    }
}
