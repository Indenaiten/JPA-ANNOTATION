package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="orders")
@NamedQueries({
	@NamedQuery(name="Order.getAll", query="SELECT r FROM Order r"),
	@NamedQuery(name="Order.removeAll", query="DELETE FROM Order")
})
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idOrder")
	private int idOrder;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idUser")
	private User user;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="status")
	private boolean status;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "order", fetch=FetchType.EAGER)
	private List<Order_product> orders_products;
	
	//METHODS
	//CONSTRUCTS
	public Order(){
		
	}

	public Order(User user, Date date, boolean status) {
		this.user = user;
		this.date = date;
		this.status = status;
	}
	
	public Order(int idOrder, User user, Date date, boolean status) {
		this.idOrder = idOrder;
		this.user = user;
		this.date = date;
		this.status = status;
	}
	
	//GETTERS AND SETTERS
	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
		return "Order [idOrder=" + idOrder + ", user=" + user.getIdUser() + ", date=" + date + ", status=" + status
				+ ", orders_products=" + orders_products + "]";
	}
}
