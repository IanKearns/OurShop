package shop.customer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class CustomerView {



	@ManagedProperty("#{customerService}")
    private CustomerService store;
	private List<Customer> customers;




	public CustomerService getStore() {
		return store;

	}


	public void setStore(CustomerService store) {
		this.store = store;
	}


	public List<Customer> getCustomers() {
		customers = store.findAll();
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public String add(){
		System.out.println(" about to save customer: "+customer.toString());
		store.save(customer);
		System.out.println(" saved customer: "+customer.toString());
		customer = new Customer();
    	System.out.println("add to store");
    	return "./output.xhtml";
    }

	private Customer customer;

    @PostConstruct
    public void makeCustomer(){
    	customer = new Customer();
    	System.out.println("postconstruct customer");
    	customers = store.findAll();
    }
    public void remove(Customer s) {
		store.remove(s);
		customers = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Customer removed!", null));
	}

    public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {//this is invoked when u click edit
		this.customer = customer;
	}



}