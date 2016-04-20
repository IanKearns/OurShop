package shop;
//modify to accept products and employees
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.customer.Customer;
import shop.customer.CustomerRepository;
import shop.product.Product;
import shop.product.ProductRepository;


@Service
public class InitDbService {

	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		{
			Customer a = new Customer();
			a.setName("joe");
			a.setAddress("cork");
			customerRepository.save(a);//saves customer object to database
		}
		{
			Customer a = new Customer();
			a.setName("mary");
			a.setAddress("dublin");
			customerRepository.save(a);
		}
		
/*		{
		Product a = new Product();
		a.setName("car");
		a.setDescription("dublin");
		a.setCarImage("images/carImage.jpeg");
		productRepository.save(a);
		}*/
		
		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
