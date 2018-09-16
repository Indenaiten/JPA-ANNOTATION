package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.Password;

public class PasswordDAOImpl implements PasswordDAO{
	//ATTRIBUTES
	private EntityManagerFactory emf;
	
	//METHODS
	//CONSTRUCTS
	public PasswordDAOImpl(){
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
	public boolean add( Password password ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//SAVE PASSWORD
			em.persist( password );

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
	public boolean edit( Password password ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//UPDATE PASSWORD
			em.merge( password );

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

			//REMOVE PASSWORD
			em.remove( em.getReference( Password.class, id ) );

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
	public Password get( int id ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		Password result = null;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET PASSWORD
			result = em.find( Password.class, id );
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
	public List<Password> getAll() throws Exception{
		//VARIABLES
		EntityManager em = null;
		List<Password> result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ALL INSTANCES OF "USUARIO"
			Query query = em.createNamedQuery( "Password.getAll" );
			
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
			Query query = em.createNamedQuery( "Password.removeAll" );
			
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
