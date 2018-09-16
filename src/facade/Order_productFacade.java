package facade;

import java.util.List;
import entity.Order_product;

public interface Order_productFacade {
	//ADD
	boolean add( Order_product order_product ) throws Exception;
	
	//EDIT
	boolean edit( Order_product order_product ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
	
	//GET
	Order_product get( int id ) throws Exception;
	
	//GET ALL
	List<Order_product> getAll() throws Exception;
	
	//EXISTS
	boolean exists( int id ) throws Exception;
}
