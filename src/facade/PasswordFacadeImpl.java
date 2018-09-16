package facade;

import java.util.List;

import dao.PasswordDAO;
import dao.PasswordDAOImpl;
import entity.Password;

public class PasswordFacadeImpl implements PasswordFacade{
	//ATTRIBUTES
	private PasswordDAO dao;
	
	//METHODS
	//CONSTRUCTS
	public PasswordFacadeImpl(){
		this.dao = new PasswordDAOImpl();
	}
	
	//ADD
	@Override
	public boolean add( Password password ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.add( password );
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
	public boolean edit( Password password ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.edit( password );
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
	public Password get( int id ) throws Exception {
		//VARIABLES
		Password result = null;
		
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
	public List<Password> getAll() throws Exception {
		//VARIABLES
		List<Password> result = null;
		
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
