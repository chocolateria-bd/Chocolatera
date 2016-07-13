import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Model {
	
	private Connection connection;
	private String user, password;
	private Bootstrap base;
	public Model(Bootstrap base){
		this.base = base;
	}

	public boolean connection(String servidor,String puerto,String usuario,String contrasena,String database){
		
		boolean  band = false;
		String url;
		try{
			//metodo para cargar el driver
			url="jdbc:postgresql://" + servidor + ":" + puerto + "/" + database;
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, usuario, contrasena);
				band = true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}catch(SQLException e){
			e.printStackTrace();
		}//end try-catch

		return band;
	}//end conection
	
	/*
	 * hace la conexion con la bd
	 * */

	/*cerramos la base de datos (metodo)
	 * */
	public boolean cerrarConexion(){
		boolean band=false;
		 try
	        {
	            this.connection.close(); 
	            band=true;
	        }catch(Exception e)
		 	{
	        	e.printStackTrace();
	        }//end try-catch
		 
		 return band;
	}//end cerrarConexion
	
	public String GetUsr(){
		return this.user;
	}//end GetUsr
	
	public String GetPass(){
		return this.password;
	}//end GetUsr
	
	public Connection GetConnection(){
			return this.connection;
	}//end GetConection(
	
}
