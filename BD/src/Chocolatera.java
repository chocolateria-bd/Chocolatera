import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class Chocolatera<Gridlayout> extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelMenu,panel;
	private JButton btnAgregar,btnEliminar,btnConsultar,btnAceptar,btnCancelar;
	private boolean band=false;
	private JButton btnSalir,btnCerrarSesion;
	GUI g;
	private JButton btnRegistrar;
	private JTextField textField;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Chocolatera(GUI e) {
		getContentPane().setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20)); 
		initialize();
		e.setVisible(false);
		g=e;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setTitle("Chocolatera");
		setBounds(100, 100, 668, 436);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		 panelMenu = new JPanel();
		panelMenu.setBounds(10, 11, 632, 34);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		 btnAgregar = new JButton("Agregar");
		 btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 0, 89, 23);
		panelMenu.add(btnAgregar);
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.addActionListener(this);
		btnEliminar.setBounds(157, 0, 89, 23);
		panelMenu.add(btnEliminar);
		
		 btnConsultar = new JButton("Consultar");
		 btnConsultar.addActionListener(this);
		btnConsultar.setBounds(533, 0, 89, 23);
		panelMenu.add(btnConsultar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(385, 0, 89, 23);
		panelMenu.add(btnRegistrar);
		
		 panel = new JPanel();
		panel.setBounds(10, 57, 632, 329);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		 btnAceptar = new JButton("Aceptar");
		 btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 295, 89, 23);
		panel.add(btnAceptar);
		
		 btnCancelar = new JButton("Cancelar");
		 btnCancelar.addActionListener(this);
		btnCancelar.setBounds(165, 295, 89, 23);
		panel.add(btnCancelar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(533, 295, 89, 23);
		panel.add(btnSalir);
		
		 btnCerrarSesion = new JButton("Cerrar sesion");
		 btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBounds(366, 295, 128, 23);
		panel.add(btnCerrarSesion);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 612, 273);
		panel.add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Statement st;
		
		if(e.getSource()==btnCerrarSesion){
			
			if(g.cerrarConexion()){
				this.removeAll();
				this.setVisible(false);
				MostrarGUI(g);
				
				
			}//end if
			
		}//end if
		
		if(e.getSource()==btnCancelar){
			
			this.paint(getGraphics());
		}//end if
		
		if(e.getSource()==btnSalir){
			
			if(g.cerrarConexion()){
				System.exit(1);
				
			}//end if
			
		}//end if
		
		if(e.getSource()==btnAgregar){
			
			try {
				st=g.GetConnection().createStatement();
				rs=st.executeQuery("SELECT tablename FROM pg_tables where schemaname='bd'");
				rs.next();
				
				
				while (!(rs.isLast())){
					
					textField.setText(rs.getString(1));
					rs.next();
				}//end while*/
				textField.setText(rs.getString(1));
				this.paint(getGraphics());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(rootPane, "Conexion perdida");
			}//end try and catch
			band=true;
		}//end if
		
		if(e.getSource()==btnEliminar){
			
			band=true;
		}//end if
		
		if(e.getSource()==btnConsultar){
			
			band=true;
		}//end if
		
		if(e.getSource()==btnAceptar && band==true){
			//aqui deberia tomarse la query del textFieldQuery y ejecutarla a la bd 
			band=false;
		}//end if
		
		if(e.getSource()==btnRegistrar){
			Registrar r=new Registrar(this);
			this.setVisible(false);
			r.setVisible(true);
			
		}//end if
	}
	
	// TODO procedimiento que muestra las vistas segun el privilegio del usuario 1 administrador 2 normal
	public void Privilegios(int tipo){
		
		if(tipo==1){
			btnAgregar.setEnabled(true);
			btnEliminar.setEnabled(true);
			btnConsultar.setEnabled(true);
		}else{
			
			btnAgregar.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnAgregar.setVisible(false);
			btnEliminar.setVisible(false);
			btnConsultar.setEnabled(true);
			
			
		}//end if-else
	}//end Privilegios
	
	//TODO // aqui deberiamos mostrar todas las tablas de neustra relacion ecepto la de usuario que se muestra segun si es administrador o no 
	public void ShowTables(){
	}//end ShowTAbles
	
	// TODO hacemos la query y segun el boton insertamos, eliminamos o mostramos 
	public boolean QueryDo(int op){
		
		/*hacemos la query y segun el boton insertamos, eliminamos o mostramos */
		
		boolean band=false;
		switch(op){
		
			case 1:
				/*para insertar en una tabla aqui se debe agregar el codgio correspondiente*/
				band=true;
			break;//end case 1
			
			case 2:
				/*para eliminar en una tabla aqui se debe agregar el codigo correspondiente*/
				band=true;
			break;//end case 2
			
			case 3:
				/*para consultar una tabla aqui se debe agrega el codigo correspondiente*/
				band=true;
			break;//end case 3
		}//end switch
		return band;
		
	}//emdd QueryDO
	
	private void MostrarGUI(GUI g){
		g.setVisible(true);
	}//edn MostrarGUI
}
