package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="passwords")
@NamedQueries({
	@NamedQuery(name="Password.getAll", query="SELECT r FROM Password r"),
	@NamedQuery(name="Password.removeAll", query="DELETE FROM Password")
})
public class Password implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idPassword")
	private int idPassword;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idUser")
	private User user;
	
	@Column(name="password")
	private String password;
	
	//METHODS
	//CONSTRUCTS
	public Password(){
		
	}

	public Password(User user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public Password(int idPassword, User user, String password) {
		this.idPassword = idPassword;
		this.user= user;
		this.password = password;
	}
	
	//GETTERS AND SETTERS
	public int getIdPassword() {
		return idPassword;
	}

	public void setIdPassword(int idPassword) {
		this.idPassword = idPassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Password [idPassword=" + idPassword + ", user=" + user.getIdUser() + ", password=" + password + "]";
	}
}
