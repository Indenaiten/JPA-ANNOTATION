package test;

import java.util.ArrayList;
import java.util.List;
import entity.*;
import facade.*;

public class Test01 {

	public static void main(String[] args) {
		//ENTITIES
		User user = null;
		
		//LISTS
		List<User> list = null;
		List<User> users = null;
		
		//FACADES
		UserFacade userFacade = null;
		PasswordFacade passwordFacade = null;
		OrderFacade orderFacade = null;
		ProductFacade productFacade = null;
		
		try{
			//INSTANCES OF FACADES
			userFacade = new UserFacadeImpl();
			passwordFacade = new PasswordFacadeImpl();
			orderFacade = new OrderFacadeImpl();
			productFacade = new ProductFacadeImpl();
			
			//GET ALL USERS
			users = userFacade.getAll();
			
			//SHOW ALL INFORMATION OF LIST OF USERS
			showAllInformationOfListOfUsers( users );
			
			try{
				//CREATE USER
				user = new User( 9, "Juachu", "Juan", "Dominguez", "Gonzalez", "juanchu123" );
				
				//ADD NEW USER
				if( userFacade.add( user ) ){
					System.out.println( "\nSE HA AÑADIDO UN NUEVO USUARIO:\n\t" + user );
				}
				else{
					System.out.println( "\nNO SE HA PODIDO AÑADIR EL NUEVO USUARIO:\n\t" + user );
				}
			}
			catch( Exception e ){
				//SHOW ERROR
				e.printStackTrace();
			}
			
			//GET ALL USERS
			users = userFacade.getAll();
			
			//SHOW ALL INFORMATION OF LIST OF USERS
			showAllInformationOfListOfUsers( users );
			
			//SHOW ALL INFORMATION OF LIST OF USERS
			showAllInformationOfListOfUsers( users );
			
			try{
				//EDIT USER
				user.setUsername( "Juanchumen" );
				
				//ADD NEW USER
				if( userFacade.edit( user ) ){
					System.out.println( "\nSE HA EDITADO UN USUARIO:\n\t" + user );
				}
				else{
					System.out.println( "\nNO SE HA PODIDO EDITAR EL USUARIO:\n\t" + user );
				}
			}
			catch( Exception e ){
				//SHOW ERROR
				e.printStackTrace();
			}
			
			//GET ALL USERS
			users = userFacade.getAll();
			
			//SHOW ALL INFORMATION OF LIST OF USERS
			showAllInformationOfListOfUsers( users );
			
			try{
				//REMOVE USER
				if( userFacade.remove( user.getIdUser() ) ){
					System.out.println( "\nSE HA BORRADO UN USUARIO:\n\t" + user );
				}
				else{
					System.out.println( "\nNO SE HA PODIDO BORRAR EL USUARIO:\n\t" + user );
				}
			}
			catch( Exception e ){
				//SHOW ERROR
				e.printStackTrace();
			}
			
			//GET ALL USERS
			users = userFacade.getAll();
			
			//SHOW ALL INFORMATION OF LIST OF USERS
			showAllInformationOfListOfUsers( users );
			
			try{
				//REMOVE ALL
				if( userFacade.removeAll() ){
					System.out.println( "\nSE HAN BORRADO TODOS LOS USUARIOS" );
				}
				else{
					System.out.println( "\nNO SE HAN PODIDO BORRAR TODOS LOS USUARIOS" );
				}
			}
			catch( Exception e ){
				//SHOW ERROR
				e.printStackTrace();
			}
			
			//GET ALL USERS
			users = userFacade.getAll();
			
			//SHOW ALL INFORMATION OF LIST OF USERS
			showAllInformationOfListOfUsers( users );
		}
		catch( Exception e ){
			//SHOW ERROR
			e.printStackTrace();
		}
	}
	
	//SHOW ALL INFORMATION OF LIST OF USERS
	public static void showAllInformationOfListOfUsers( List<User> users ) throws Exception{
		//CHECK IF EXISTS USERS
		System.out.println( "\nALL USERS\n-------------------------");
		if( users.size() > 0 ){ //IF THERE ARE USERS
			//SHOW USERS
			for( User u : users ){
				System.out.println( u );
				
				System.out.println( "\n\tPASSWORDS" );
				//CHECK IF EXISTS PASSWORDS
				if( u.getPasswords().size() > 0 ){ //IF THERE ARE PASSWORS
					//SHOW PASSWORDS
					for( Password p : u.getPasswords() ){
						System.out.println( "\t" + p );
					}
				}
				else{ //IF THERE AREN'T PASSWORDS
					System.out.println( "\tTHERE AREN'T PASSWORDS" );
				}
				
				System.out.println( "\n\tORDERS" );
				//CHECK THERE ARE ORDERS
				if( u.getOrders().size() > 0 ){ //IF THERE ARE ORDERS
					//SHOW ORDERS
					for( Order o : u.getOrders() ){
						System.out.println( "\t" + o );
						
						//CHECK IF THERE ARE PRODUCTS
						if( o.getOrders_products().size() > 0 ){ //IF THERE ARE PRODUCTS
							//SHOW PRODUCTS
							for( Order_product op : o.getOrders_products() ){
								System.out.println( "\t\t" + op.getProduct() );
							}
							
							//LINE FOR AESTHETICS
							System.out.println();
						}
						else{ //IF THERE AREN'T PRODUCTS
							System.out.println( "\tTHERE AREN'T PRODUCTS" );
						}
					}
				}
				else{ //IF THERE AREN'T ORDERS
					System.out.println( "\tTHERE AREN'T ORDERS" );
				}
				
				//LINE FOR AESTHETICS
				System.out.println();
			}
		}
		else{ //IF THERE AREN'T RESULTS
			System.out.println( "THERE AREN'T USERS" );
		}
	}
}
