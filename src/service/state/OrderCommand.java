package service.state;

import model.Order;

public interface OrderCommand {
    void handleOrder(Order order) throws Exception;
}
