/*pruebas del puto git */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;

public class GUI extends JFrame  implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField user;
	private JPasswordField passwordField;
	private JPanel InicioPanel;
	private JButton btnIniciar, btnCancelar;
	private JLabel lblNewLabel,lblUsuario;
	private JButton btnCerrar;

	private Connection con;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI() {
		getContentPane().setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20)); 
		initialize();
	}//end GUI

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setTitle("Chocolatera");
		setBounds(100, 100, 479, 270);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		InicioPanel = new JPanel();
		InicioPanel.setBounds(10, 11, 414, 209);
		getContentPane().add(InicioPanel);
		InicioPanel.setLayout(null);
		
		 btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(78, 151, 89, 23);
		InicioPanel.add(btnIniciar);
		btnIniciar.addActionListener(this);
		
		 btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(177, 151, 89, 23);
		InicioPanel.add(btnCancelar);
		
		
		user = new JTextField();
		user.setBounds(236, 50, 86, 20);
		InicioPanel.add(user);
		user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 88, 89, 20);
		InicioPanel.add(passwordField);
		
		 lblNewLabel = new JLabel("contrase\u00F1a");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(78, 91, 89, 14);
		InicioPanel.add(lblNewLabel);
		
		 lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblUsuario.setBounds(78, 53, 46, 14);
		InicioPanel.add(lblUsuario);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(276, 151, 89, 23);
		InicioPanel.add(btnCerrar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pass;
			
		if(e.getSource()==btnIniciar){
			//hace la conexion con la bd falta validar si es usuario con privilegios o no lo hare mas tarde ! 
			
			 pass= new String(passwordField.getPassword());
			
			if(conection("localhost","5432",user.getText(),pass,"proyectobd")){
				
				Chocolatera Chc=new Chocolatera(this);
				Chc.setVisible(true);
				Chc.Privilegios(1);/// si no es 1 es usuario normal validar esta parte cuando el usuario inicie de session
				passwordField.setText(null);
				pass=null;
			}//end if
		}//end if
		
		if(e.getSource()==btnCancelar){
			//restaurar las vistas
			
			passwordField.setText(null);
			user.setText(null);
			this.paint(getGraphics());
				
		}//end if
		
		if(e.getSource()==btnCerrar){
			
			//cerrar programa
			System.exit(0);
			
		}//end if
		
		
	}//end actionPerformed
	/*
	 * hace la conexion con la bd
	 * */
	private boolean conection(String servidor,String puerto,String usuario,String contrasena,String database){
		
		boolean  band=false;
		String url;
		try{
			//metodo para cargar el driver
			url="jdbc:postgresql://" + servidor + ":" + puerto + "/" + database;
			try {
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection(url, usuario, contrasena);
				band=true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog(rootPane, "No se pudo conectar a la BD");
			
		}//end try-catch

		return band;
	}//end conection
	
	/*cerramos la base de datos (metodo)
	 * */
	public boolean cerrarConexion(){
		boolean band=false;
		 try
	        {
	            con.close();
	            
	            band=true;
	        }catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(rootPane,"Problema para cerrar la Conexión a la base de datos ");
	        }//end try-catch
		 
		 return band;
	}//end cerrarConexion
	
	public String GetUsr(){
		return user.getText();
	}//end GetUsr
	
	public String GetPass(){
		String pass= new String(passwordField.getPassword());
		return pass;
	}//end GetUsr
	
	public Connection GetConnection(){
			return con;
	}//end GetConection(
}

