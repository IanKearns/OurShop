package shop.cart;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartItemService {
	@Autowired
	private CartItemRepository cartItemRepository;

	CartItemService(){
		System.out.println("productservice construct");
	}
public CartItemRepository getCartItemRepository() {
		return cartItemRepository;
	}
	public void setCartItemRepository(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;
	}
@PostConstruct
  public void fred(){
	System.out.println("in product service postconst");
}
	public List<CartItem> findAll() {
		return cartItemRepository.findAll();
	}

	public void save(CartItem citem) {
		cartItemRepository.save(citem);
	}

	public void remove(CartItem citem) {
		cartItemRepository.delete(citem);
	}
}
