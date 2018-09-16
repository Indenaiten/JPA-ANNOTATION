package facade;

import java.util.List;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

public class UserFacadeImpl implements UserFacade{
	//ATTRIBUTES
	private UserDAO dao;
	
	//METHODS
	//CONSTRUCTS
	public UserFacadeImpl(){
		this.dao = new UserDAOImpl();
	}
	
	//ADD
	@Override
	public boolean add( User user ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.add( user );
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
	public boolean edit( User user ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			result = this.dao.edit( user );
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
	public User get( int id ) throws Exception {
		//VARIABLES
		User result = null;
		
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
	
	//GET FOR USERNAME
	@Override
	public User get( String username ) throws Exception {
		//VARIABLES
		User result = null;
		
		try{
			//ADD USER
			result = this.dao.get( username );
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
	public List<User> getAll() throws Exception {
		//VARIABLES
		List<User> result = null;
		
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
