package facade;

import java.util.List;

import dao.Order_productDAO;
import dao.Order_productDAOImpl;
import entity.Order_product;

public class Order_productFacadeImpl implements Order_productFacade{
	//ATTRIBUTES
	private Order_productDAO dao;
	
	//METHODS
	//CONSTRUCTS
	public Order_productFacadeImpl(){
		this.dao = new Order_productDAOImpl();
	}
	
	//ADD
	@Override
	public boolean add( Order_product order_product ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.add( order_product );
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
	public boolean edit( Order_product order_product ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.edit( order_product );
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
	public Order_product get( int id ) throws Exception {
		//VARIABLES
		Order_product result = null;
		
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
	public List<Order_product> getAll() throws Exception {
		//VARIABLES
		List<Order_product> result = null;
		
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
