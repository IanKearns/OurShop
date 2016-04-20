package shop.cart;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;

import shop.product.Product;
import shop.product.ProductService;


@ManagedBean
@SessionScoped
public class ProductCustView {

	@ManagedProperty("#{productService}")
	private ProductService store;
	private List<Product> products;
	private CartItem ci;
	private List<CartItem> thecart;
	
	public CartItem getCi() {
		return ci;
	}

	public void setCi(CartItem ci) {
		this.ci = ci;
	}

	public List<CartItem> getThecart() {
		//thecart = cart.findAll();
		return thecart;
	}

	public void setThecart(List<CartItem> thecart) {
		this.thecart = thecart;
	}

	public void setCart(CartItemService cart) {
		this.cart = cart;
	}

	@ManagedProperty("#{cartItemService}")
	private CartItemService cart;


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	 
	public List<Product> getProducts() {
		products = store.findAll();
		return products;
	}

	 
	//public void setCart(CartItemService xcart) {
		//cart = xcart;
	//}
	
	public CartItemService getCart() {
		return cart;
	}

	public void setCart(List<CartItem>thecart){
		this.thecart = thecart;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	

	public ProductService getStore() {
		return store;
	}

	public void setStore(ProductService store) {
		this.store = store;
	}

	public static void testBuy() {
		System.out.println("Ok Class ProductCustView Working");
	}

	public String buy(Product p) {
		ci = new CartItem();
		ci.setProduct(p);
		//ci.setAmount(1);
		ci.setQuantity(1);
		thecart.add(ci);
		
		//cart.save(ci);
		System.out.println(" added to cart: " + ci.toString());
		// product = new Product();
		System.out.println("add to cart");
		return "./cart.xhtml";
	}

	private Product product;

	@PostConstruct
	public void makeProduct() {
		product = new Product();
		System.out.println("postconstruct productcustview");
		products = store.findAll();// findAll=Spring call to database
		thecart = new ArrayList<CartItem>(); 
	}
	
	public void remove(CartItem cartitem){
		System.out.println("remove");
		thecart.remove(cartitem);
	}

	/*public void remove(Product e) {
		store.remove(e);
		products = store.findAll();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Product removed!", null));
	}*/
	public String update(){
		// get the data table from the current session instance 
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance()
	            .getViewRoot().findComponent("form:cartTable");
		// get the row count of the datatable and loop through 
		for (int rowIndex = 0; rowIndex < dataTable.getRowCount(); rowIndex++) {
			//set the rowIndex of the datatable in order to then get the row data
		    dataTable.setRowIndex(rowIndex);
		    // cast the row data to a cart item
		    CartItem ci = (CartItem) dataTable.getRowData();
		    // update thecart setting the quantity to the cart item ci's quantity
		    
		    for(CartItem theCartci : thecart){
		    	if(theCartci.getProduct().getName().equalsIgnoreCase(ci.getProduct().getName())){
		    		theCartci.setQuantity(ci.getQuantity());
		    	}
		    }
		    //thecart.get(ci.getId()).setQuantity(ci.getQuantity());
		}
		// refresh the cart screen by returning the link
		return "./cart.xhtml";
	}
	}

