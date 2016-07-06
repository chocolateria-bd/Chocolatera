import javax.swing.JOptionPane; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Registrar extends JFrame  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre,textFieldCi;
	private JButton btnNewButtonAceptar;
	private JPanel panel;
	JLabel lblNombre,lblCedula,lblContrasea;
	private JButton btnCancelar,btnAtras;
	private JPasswordField passwordField;
	private JCheckBox chckbxAdministrador,chckbxEmpleado;
	GUI g;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Registrar(GUI e) {
		getContentPane().setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20)); 
		initialize();
		g=e;
		g.setVisible(false);
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
		
		 lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Arial", Font.BOLD, 12));
		lblCedula.setBounds(116, 50, 46, 14);
		panel.add(lblCedula);
		
		 lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 12));
		lblContrasea.setBounds(116, 82, 66, 14);
		panel.add(lblContrasea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(218, 14, 155, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCi = new JTextField();
		textFieldCi.setBounds(218, 48, 155, 20);
		panel.add(textFieldCi);
		textFieldCi.setColumns(10);
		
		 btnNewButtonAceptar = new JButton("Aceptar");
		 btnNewButtonAceptar.addActionListener(this);
		btnNewButtonAceptar.setBounds(116, 175, 89, 23);
		panel.add(btnNewButtonAceptar);
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(218, 175, 89, 23);
		panel.add(btnCancelar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 80, 155, 20);
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
		String usr,Ci,pass;
		int i;
		boolean band;
		
		if(e.getSource()==btnCancelar){
			
			passwordField.setText(null);
			textFieldCi.setText(null);
			textFieldNombre.setText(null);
			this.paint(getGraphics());
		}//end if
		
		if(e.getSource()==btnNewButtonAceptar){
				
			usr=textFieldNombre.getText();
			Ci=textFieldCi.getText();
			pass= new String(passwordField.getPassword());
			
			i=0;
			band=true;
			
			while(i<=usr.length() && band){
				
				if(isNumeric(usr)){
					band=false;
					System.out.println("hola");
				}//en if
				i++;
			}//end for
			
			if(band==false || usr.length()==0 || Ci.length()==0 || pass.length()==0  || (chckbxEmpleado.isSelected() && chckbxAdministrador.isSelected())||(!(chckbxEmpleado.isSelected()) && !(chckbxAdministrador.isSelected())) ){
				 JOptionPane.showMessageDialog( null, "El usuario no puede ser alfanumerico o Contraseña y Ci estan en vacios o verifique las casilla de tipo de usuario" );
				 textFieldNombre.setText(null);
				 textFieldCi.setText(null);
				 passwordField.setText(null);
			}else{
				
				///aqui debe ir la llamada a la rutina para insertar en la tablas de usuarios
				/// el uevo usuario con sus permisos 
			}
			
		}//end if
		
		if(e.getSource()==btnAtras){
			this.removeAll();
			this.setVisible(false);
			ShowGui(g);
			
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
	
	private void ShowGui(GUI g){
		g.setVisible(true);
	}//end ShowGui
}
