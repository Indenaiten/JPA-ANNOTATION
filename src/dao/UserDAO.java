package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	//ADD
	boolean add( User user ) throws Exception;
	
	//EDIT
	boolean edit( User user ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
	
	//GET
	User get( int id ) throws Exception;
	
	//GET FOR USERNAME
	User get( String username ) throws Exception;
	
	//GET ALL
	List<User> getAll() throws Exception;
	
	//EXISTS
	boolean exists( int id ) throws Exception;
}
