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
	private JButton btnRegistrar;

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
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(276, 151, 89, 23);
		InicioPanel.add(btnRegistrar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usr;
		Registrar reg;
			
		if(e.getSource()==btnIniciar){
			//hace la conexion con la bd falta validar si es usuario con privilegios o no lo hare mas tarde ! 
			String pass=new String( passwordField.getPassword());
			usr= user.getText();
			if(conection("localhost","5432",usr,pass,"proyectobd")){
				
				Chocolatera Chc=new Chocolatera(this);
				Chc.setVisible(true);
				Chc.Privilegios(1);/// si no es 1 es usuario normal validar esta parte cuando el usuario inicie de session
				
			}//end if
		}//end if
		
		if(e.getSource()==btnCancelar){
			//restaurar las vistas
			
			passwordField.setText(null);
			user.setText(null);
			this.paint(getGraphics());
				
		}//end if
		
		if(e.getSource()==btnRegistrar){
			
			//registrar un usuario segun el tipo 
			reg=new Registrar(this);
			reg.setVisible(true);
			
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
			
			JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE,"No se pudo hacer conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
			
		}//end try-catch
		
		
		return band;
	}//end conection
}

