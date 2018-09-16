package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.Order_product;

public class Order_productDAOImpl implements Order_productDAO{
	//ATTRIBUTES
	private EntityManagerFactory emf;
	
	//METHODS
	//CONSTRUCTS
	public Order_productDAOImpl(){
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
	public boolean add( Order_product product ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//SAVE ORDER_PRODUCT
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
	public boolean edit( Order_product product ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//UPDATE ORDER_PRODUCT
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

			//REMOVE ORDER_PRODUCT
			em.remove( em.getReference( Order_product.class, id ) );

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
	public Order_product get( int id ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		Order_product result = null;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ORDER_PRODUCT
			result = em.find( Order_product.class, id );
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
	public List<Order_product> getAll() throws Exception{
		//VARIABLES
		EntityManager em = null;
		List<Order_product> result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ALL INSTANCES OF "USUARIO"
			Query query = em.createNamedQuery( "Order_product.getAll" );
			
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
			Query query = em.createNamedQuery( "Order_product.removeAll" );
			
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
