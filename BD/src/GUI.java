/*pruebas del puto git */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
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

	
	private Dimension dimension;
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
			//hacer la conexion con la bd y mostrar la siguiente vista validar el inicio de sesion
			usr= user.getText();
			String pass=new String( passwordField.getPassword());
			Chocolatera Chc=new Chocolatera(this);
			
				Chc.setVisible(true);
				Chc.Privilegios(1);/// si no es 1 es usuario normal validar esta parte cuando el usuario inicie de session
			
			Chc.setVisible(true);
			
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
		
		
	}
}

