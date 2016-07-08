import javax.swing.JOptionPane; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Registrar extends JFrame  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JButton btnNewButtonAceptar;
	private JPanel panel;
	JLabel lblNombre,lblContrasea;
	private JButton btnCancelar,btnAtras;
	private JPasswordField passwordField;
	private JCheckBox chckbxAdministrador,chckbxEmpleado;
	private Connection con;
	
	Chocolatera r;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Registrar(Chocolatera e) {
		getContentPane().setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20)); 
		initialize();
		r=e;
		r.setVisible(false);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setTitle("Registrar usuario");
		setBounds(100, 100, 479, 267);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		 panel = new JPanel();
		panel.setBounds(10, 11, 443, 209);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		 lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(116, 16, 46, 14);
		panel.add(lblNombre);
		
		 lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 12));
		lblContrasea.setBounds(116, 50, 66, 14);
		panel.add(lblContrasea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(218, 14, 155, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		 btnNewButtonAceptar = new JButton("Aceptar");
		 btnNewButtonAceptar.addActionListener(this);
		btnNewButtonAceptar.setBounds(116, 175, 89, 23);
		panel.add(btnNewButtonAceptar);
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(218, 175, 89, 23);
		panel.add(btnCancelar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 48, 155, 20);
		panel.add(passwordField);
		
		 chckbxAdministrador = new JCheckBox("Administrador");
		chckbxAdministrador.setBounds(110, 122, 108, 23);
		panel.add(chckbxAdministrador);
		
		 chckbxEmpleado = new JCheckBox("Empleado");
		chckbxEmpleado.setBounds(218, 122, 97, 23);
		panel.add(chckbxEmpleado);
		
		 btnAtras = new JButton("Atras");
		 btnAtras.addActionListener(this);
		btnAtras.setBounds(317, 175, 89, 23);
		panel.add(btnAtras);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usr,pass;
		int i;
		boolean band;
		Statement st;
		
		if(e.getSource()==btnCancelar){
			
			passwordField.setText(null);
			textFieldNombre.setText(null);
			this.paint(getGraphics());
		}//end if
		
		if(e.getSource()==btnNewButtonAceptar){
				
			usr=textFieldNombre.getText();
			pass= new String(passwordField.getPassword());
			
			i=0;
			band=true;
			
			while(i<=usr.length() && band){
				
				if(isNumeric(usr)){
					band=false;
					
				}//en if
				i++;
			}//end for
			
			if(band==false || usr.length()==0 || pass.length()==0  || (chckbxEmpleado.isSelected() && chckbxAdministrador.isSelected())||(!(chckbxEmpleado.isSelected()) && !(chckbxAdministrador.isSelected())) ){
				 JOptionPane.showMessageDialog( null, "El usuario no puede ser alfanumerico o Contraseña y Ci estan en vacios o verifique las casilla de tipo de usuario" );
				 textFieldNombre.setText(null);
				 passwordField.setText(null);
			}else{
				
				if(conection("localhost","5432",r.g.GetUsr(),r.g.GetPass())){
					try {
						st=con.createStatement();
						
						if(chckbxAdministrador.isSelected()){
				
							st.executeUpdate("CREATE USER "+usr+" PASSWORD '"+pass+"'");
							st.executeUpdate("ALTER ROLE "+usr+" WITH SUPERUSER");
							
						}else{
							
							st.executeUpdate("CREATE USER "+usr+" PASSWORD '"+pass+"'");
							
						}//end if-else
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(rootPane, "Conexion perdida");
					}
				}//end if
			}
			
		}//end if
		
		if(e.getSource()==btnAtras){
			this.removeAll();
			this.setVisible(false);
			ShowGui(r);
			
		}//end if
	}
	
	public  boolean isNumeric(String c){
		try {
			Integer.parseInt(c);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}//isNumeric
	
	private void ShowGui(Chocolatera g){
		g.setVisible(true);
	}//end ShowGui
	
	private boolean conection(String servidor,String puerto,String usuario,String contrasena){
		
		boolean  band=false;
		String url;
		try{
			//metodo para cargar el driver
			url="jdbc:postgresql://" + servidor + ":" + puerto + "/"+"postgres";
			try {
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection(url, usuario, contrasena);
				band=true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog(rootPane, "No se pudo conectar a la BD, para la creacion del usuario");
			
		}//end try-catch

		return band;
	}//end conection
}
