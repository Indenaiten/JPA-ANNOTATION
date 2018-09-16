package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.Product;

public class ProductDAOImpl implements ProductDAO{
	//ATTRIBUTES
	private EntityManagerFactory emf;
	
	//METHODS
	//CONSTRUCTS
	public ProductDAOImpl(){
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
	public boolean add( Product product ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//SAVE PRODUCT
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
	public boolean edit( Product product ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		boolean result = false;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//START TRANSACTION
			em.getTransaction().begin();

			//UPDATE PRODUCT
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

			//REMOVE PRODUCT
			em.remove( em.getReference( Product.class, id ) );

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
	public Product get( int id ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		Product result = null;
		
		try{
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET PRODCUCT
			result = em.find( Product.class, id );
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
	
	//GET FOR NAME
	@Override
	public Product get( String name ) throws Exception{
		//VARIABLES
		EntityManager em = null;
		Product result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET PRODUCT BY NAME
			Query query = em.createNamedQuery( "Product.getForName" );
			
			//SET PARAMETER
			query.setParameter( "productname", name );
			
			try{
				//GET RESULT
				result =  (Product) query.getSingleResult();
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
	public List<Product> getAll() throws Exception{
		//VARIABLES
		EntityManager em = null;
		List<Product> result = null;
		
		try {
			//GET ENTITY MANAGER
			em = getEntityManager();

			//GET ALL INSTANCES OF "USUARIO"
			Query query = em.createNamedQuery( "Product.getAll" );
			
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
			Query query = em.createNamedQuery( "Product.removeAll" );
			
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
