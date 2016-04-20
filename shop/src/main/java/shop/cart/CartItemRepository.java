package shop.cart;
import org.springframework.data.jpa.repository.JpaRepository;

import shop.cart.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}
