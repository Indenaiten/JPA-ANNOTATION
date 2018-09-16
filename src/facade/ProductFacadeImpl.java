package facade;

import java.util.List;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import entity.Product;

public class ProductFacadeImpl implements ProductFacade{
	//ATTRIBUTES
	private ProductDAO dao;
	
	//METHODS
	//CONSTRUCTS
	public ProductFacadeImpl(){
		this.dao = new ProductDAOImpl();
	}
	
	//ADD
	@Override
	public boolean add( Product product ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.add( product );
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
	public boolean edit( Product product ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.edit( product );
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
	public Product get( int id ) throws Exception {
		//VARIABLES
		Product result = null;
		
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
	
	//GET FOR NAME
	@Override
	public Product get( String productname ) throws Exception {
		//VARIABLES
		Product result = null;
		
		try{
			//ADD USER
			result = this.dao.get( productname );
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
	public List<Product> getAll() throws Exception {
		//VARIABLES
		List<Product> result = null;
		
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
