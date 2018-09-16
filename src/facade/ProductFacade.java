package facade;

import java.util.List;
import entity.Product;

public interface ProductFacade {
	//ADD
	boolean add( Product product ) throws Exception;
	
	//EDIT
	boolean edit( Product product ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
	
	//GET
	Product get( int id ) throws Exception;
	
	//GET FOR NAME
	Product get( String name ) throws Exception;
	
	//GET ALL
	List<Product> getAll() throws Exception;
	
	//EXISTS
	boolean exists( int id ) throws Exception;
}
