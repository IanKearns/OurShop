package shop.employee;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class EmployeeView {


	@ManagedProperty("#{employeeService}")
    private EmployeeService store;
	private List<Employee> employees;




	public EmployeeService getStore() {
		return store;
	}


	public void setStore(EmployeeService store) {
		this.store = store;
	}


	public List<Employee> getEmployees() {
		employees = store.findAll();
		return employees;
	}


	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}


	public String add(){
		System.out.println(" about to save employee: "+employee.toString());
		store.save(employee);
		System.out.println(" saved employee: "+employee.toString());
		employee = new Employee();
    	System.out.println("add to store");
    	return "./empOutput.xhtml";
    }

	private Employee employee;
	public static void testBuy() {
		System.out.println("Ok Class EmployeeView Working");
	}
    @PostConstruct
    public void makeCustomer(){
    	employee = new Employee();
    	System.out.println("postconstruct employee");
    	employees = store.findAll();
    }
    public void remove(Employee e) {
		store.remove(e);
		employees = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee removed!", null));
	}

    public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



}