package dao;

import java.util.List;

import entity.Order;

public interface OrderDAO {
	//ADD
	boolean add( Order order ) throws Exception;
	
	//EDIT
	boolean edit( Order order ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
	
	//GET
	Order get( int id ) throws Exception;
	
	//GET ALL
	List<Order> getAll() throws Exception;
	
	//EXISTS
	boolean exists( int id ) throws Exception;
}
