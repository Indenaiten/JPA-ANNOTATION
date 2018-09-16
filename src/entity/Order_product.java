package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="orders_products")
@NamedQueries({
	@NamedQuery(name="Order_product.getAll", query="SELECT r FROM Order_product r"),
	@NamedQuery(name="Order_product.removeAll", query="DELETE FROM Order_product")
})
public class Order_product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idOrder")
	private Order order;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idProduct")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;
	
	//METHODS
	//CONSTRUCTS
	public Order_product(){
		
	}

	public Order_product(Order order, Product product, int quantity) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
	public Order_product(int id, Order order, Product product, int quantity) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Order_product [id=" + id + ", order=" + order.getIdOrder() + ", product=" + product.getIdProduct() + ", quantity=" + quantity + "]";
	}
}
