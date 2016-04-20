package shop.product;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	ProductService(){
		System.out.println("productservice construct");
	}
@PostConstruct//initialises the bean so dependencies can b used
  public void fred(){
	System.out.println("in product service postconst");
}
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void save(Product emp) {
		productRepository.save(emp);
	}

	public void remove(Product emp) {
		productRepository.delete(emp);
	}

}
