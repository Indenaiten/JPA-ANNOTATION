package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.User;

public class UserDAOImpl implements UserDAO{
	//ATTRIBUTES
	private EntityManagerFactory emf;
	
	//METHODS
	//CONSTRUCTS
	public UserDAOImpl(){
		//LOAD PERSISTENCE
		this.emf = Persistence.createEntityManagerFactory( "NameOfConnection" );
	}
	
	//GET ENTITY MANAGER
	private EntityManager getEntityManager(){
		//RETURN ENTITY MANAGER
		return this.emf.createEntityManager();
	}
	
	//ADD
	@Override
	public boolean add( User user ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//SAVE USER
			em.persist( user );

			//COMMIT
			em.getTransaction().commit();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//EDIT
	@Override
	public boolean edit( User user ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//UPDATE USER
			em.merge( user );

			//COMMIT
			em.getTransaction().commit();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//REMOVE
	@Override
	public boolean remove( int id ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//REMOVE USER
			em.remove( em.getReference( User.class, id ) );

			//COMMIT
			em.getTransaction().commit();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//GET
	@Override
	public User get( int id ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		User result = null;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET USER
			result = em.find( User.class, id );
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//GET FOR USERNAME
	@Override
	public User get( String username ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		User result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET USER BY USERNAME
			Query query = em.createNamedQuery( "User.getForUsername" );
			
			//SET PARAMETER
			query.setParameter( "username", username );
			
			try{
				//GET RESULT
				result =  (User) query.getSingleResult();
			}
			catch( Exception e ){
				//SET RESULT IN NULL
				result = null;
			}

		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//GET ALL
	@Override
	public List<User> getAll() throws Exception{
		//VARIABLES
		EntityManager em = null;
		List<User> result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ALL INSTANCES OF "USUARIO"
			Query query = em.createNamedQuery( "User.getAll" );
			
			//GET RESULTS
			result =  query.getResultList();
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//REMOVE ALL
	@Override
	public boolean removeAll() throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();
			
			//START TRANSACTION
			em.getTransaction().begin();

			//GET ALL INSTANCES OF "USUARIO"
			Query query = em.createNamedQuery( "User.removeAll" );
			
			//EXECUTE QUERY
			query.executeUpdate();
			
			//COMMIT
			em.getTransaction().commit();
			 
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			throw new Exception( e );
		}
		finally{
			//CHECK ENTITY MANAGER
			if (em != null) { //IF IT'S NOT NULL
				//CLOSE ENTITY MANAGER
				em.close();
			}
			
			//RETURN RESULT
			return result;
		}
	}
	
	//EXISTS
	@Override
	public boolean exists( int id ) throws Exception{
		//VARIABLES
		boolean result = false;
		
		try{
			//CHECK IF EXISTS
			if( this.get(id ) != null ){
				//SET RESULT IN TRUE
				result = true;
			}
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
