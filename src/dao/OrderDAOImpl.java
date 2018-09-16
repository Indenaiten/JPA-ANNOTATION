package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.Order;

public class OrderDAOImpl implements OrderDAO{
	//ATTRIBUTES
	private EntityManagerFactory emf;
	
	//METHODS
	//CONSTRUCTS
	public OrderDAOImpl(){
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
	public boolean add( Order product ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//SAVE ORDER
			em.persist( product );

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
	public boolean edit( Order product ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//UPDATE ORDER
			em.merge( product );

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

			//REMOVE ORDER
			em.remove( em.getReference( Order.class, id ) );

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
	public Order get( int id ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		Order result = null;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ORDER
			result = em.find( Order.class, id );
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
	public List<Order> getAll() throws Exception{
		//VARIABLES
		EntityManager em = null;
		List<Order> result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ALL INSTANCES OF "USUARIO"
			Query query = em.createNamedQuery( "Order.getAll" );
			
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
			Query query = em.createNamedQuery( "Order.removeAll" );
			
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
