package facade;

import java.util.List;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import entity.Order;

public class OrderFacadeImpl implements OrderFacade{
	//ATTRIBUTES
	private OrderDAO dao;
	
	//METHODS
	//CONSTRUCTS
	public OrderFacadeImpl(){
		this.dao = new OrderDAOImpl();
	}
	
	//ADD
	@Override
	public boolean add( Order order ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.add( order );
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
	
	//EDIT
	@Override
	public boolean edit( Order order ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.edit( order );
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
	
	//REMOVE
	@Override
	public boolean remove( int id ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.remove( id );
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
	
	//REMOVE ALL
	@Override
	public boolean removeAll() throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.removeAll();
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
	
	//GET
	@Override
	public Order get( int id ) throws Exception {
		//VARIABLES
		Order result = null;
		
		try{
			//ADD USER
			result = this.dao.get( id );
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
	
	//GET ALL
	@Override
	public List<Order> getAll() throws Exception {
		//VARIABLES
		List<Order> result = null;
		
		try{
			//ADD USER
			result = this.dao.getAll();
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
	
	//EXISTS
	@Override
	public boolean exists(int id) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.exists( id );
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//RETURN RESULT
			return result;
		}
	}
}
