package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="products")
@NamedQueries({
	@NamedQuery(name="Product.getAll", query="SELECT r FROM Product r"),
	@NamedQuery(name="Product.getForName", query="SELECT r FROM Product r WHERE r.name = :name"),
	@NamedQuery(name="Product.removeAll", query="DELETE FROM Product")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idProduct")
	private int idProduct;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="stock")
	private int stock;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "product", fetch=FetchType.EAGER)
	private List<Order_product> orders_products;
	
	//METHOS
	//CONSTRUCTS
	public Product(){
		
	}

	public Product(String name, double price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public Product(int idProduct, String name, double price, int stock) {
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	//GETTERS AND SETTERS
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Order_product> getOrders_products() {
		return orders_products;
	}

	public void setOrders_products(List<Order_product> orders_products) {
		this.orders_products = orders_products;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", orders_products=" + orders_products + "]";
	}
}
