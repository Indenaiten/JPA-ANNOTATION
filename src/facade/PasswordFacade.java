package facade;

import java.util.List;
import entity.Password;

public interface PasswordFacade {
	//ADD
	boolean add( Password password ) throws Exception;
	
	//EDIT
	boolean edit( Password password ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
	
	//GET
	Password get( int id ) throws Exception;
	
	//GET ALL
	List<Password> getAll() throws Exception;
	
	//EXISTS
	boolean exists( int id ) throws Exception;
}
