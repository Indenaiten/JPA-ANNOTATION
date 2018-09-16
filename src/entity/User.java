package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="User.getAll", query="SELECT r FROM User r"),
	@NamedQuery(name="User.getForUsername", query="SELECT r FROM User r WHERE r.username = :username"),
	@NamedQuery(name="User.removeAll", query="DELETE FROM User")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idUser")
	private int idUser;
	
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname1")
	private String lastname1;
	
	@Column(name="lastname2")
	private String lastname2;
	
	@Column(name="pass")
	private String pass;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch=FetchType.EAGER)
	private List<Password> passwords;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch=FetchType.EAGER)
	private List<Order> orders;
	
	//METHODS
	//CONSTRUCTS
	public User(){
		
	}
	
	public User(String username, String name, String lastname1, String lastname2, String pass) {
		this.username = username;
		this.name = name;
		this.lastname1 = lastname1;
		this.lastname2 = lastname2;
		this.pass = pass;
	}
	
	public User(int idUser, String username, String name, String lastname1, String lastname2, String pass) {
		this.idUser = idUser;
		this.username = username;
		this.name = name;
		this.lastname1 = lastname1;
		this.lastname2 = lastname2;
		this.pass = pass;
	}
	
	//GETTERS AND SETTERS
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname1() {
		return lastname1;
	}

	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}

	public String getLastname2() {
		return lastname2;
	}

	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Password> getPasswords() {
		return passwords;
	}

	public void setPasswords(List<Password> passwords) {
		this.passwords = passwords;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	//TO STRING
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", name=" + name + ", lastname1=" + lastname1
				+ ", lastname2=" + lastname2 + ", pass=" + pass + ", passwords=" + passwords + ", orders=" + orders
				+ "]";
	}
}
