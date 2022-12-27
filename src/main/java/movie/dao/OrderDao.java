package movie.dao;

import java.util.List;
import movie.model.Order;
import movie.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
