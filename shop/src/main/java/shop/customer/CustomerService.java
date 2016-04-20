package shop.customer;
//combines with CusatomerRepository to give Model
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//similar to @Bean but gives different functionality
public class CustomerService {

	@Autowired//spring creates student repository
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public void save(Customer c) {
		customerRepository.save(c);
	}

	public void remove(Customer c) {
		customerRepository.delete(c);
	}

}

