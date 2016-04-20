package shop.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public void save(Employee emp) {
		employeeRepository.save(emp);
	}

	public void remove(Employee emp) {
		employeeRepository.delete(emp);
	}

}
