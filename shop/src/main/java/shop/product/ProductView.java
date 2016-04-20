package shop.product;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean//tells JSF its a bean
@ApplicationScoped// tells JSf its an application bean
public class ProductView {


	@ManagedProperty("#{productService}")
    private ProductService store;
	private List<Product> products;



	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public ProductService getStore() {
		return store;
	}


	public void setStore(ProductService store) {
		this.store = store;
	}


	public List<Product> getProducts() {
		products = store.findAll();
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public String add(){
		store.save(product);
		System.out.println(" saved product: "+product.toString());
		product = new Product();
    	System.out.println("add to store");
    	return "./productOut.xhtml";
    }

	private Product product;

    @PostConstruct
    public void makeProduct(){
    	product = new Product();
    	System.out.println("postconstruct product");
    	products = store.findAll();//findAll=Spring call to database
    }
    public void remove(Product e) {
		store.remove(e);
		products = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Product removed!", null));
	}
	}