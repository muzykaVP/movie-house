package movie.service;

import java.util.List;
import movie.model.Order;
import movie.model.ShoppingCart;
import movie.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
