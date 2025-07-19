package service.state;

import enums.OrderStatus;
import model.Order;
import service.PaymentService;

public class PlaceOrderCommand implements OrderCommand {

    @Override
    public void handleOrder(Order order) throws Exception {
        boolean isPaymentDone = PaymentService.getInstance().processPayment(order.getTotalAmount());
        if(isPaymentDone) {
            order.setStatus(OrderStatus.PLACED);
            System.out.println("Order " + order.getOrderId() + " has been placed.");
        }
        else throw new Exception("Payment has failed, please retry");

    }
}
