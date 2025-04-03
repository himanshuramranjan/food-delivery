package service;

public class PaymentService {
    private static volatile PaymentService paymentService;
    private PaymentService() {}

    public static PaymentService getInstance() {
        if(paymentService == null) {
            synchronized (PaymentService.class) {
                if(paymentService == null) {
                    paymentService = new PaymentService();
                }
            }
        }
        return paymentService;
    }

    public boolean processPayment(double amount) {
        // further strategy can be defined for this
        System.out.println("payment of " + amount + " is successfull");
        return true;
    }
}
