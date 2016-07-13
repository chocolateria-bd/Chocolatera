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
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.DropMode;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class Chocolatera extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelMenu,panel;
	private JButton btnMostrarT,btnEliminar,btnConsultar,btnAceptar,btnCancelar;
	private boolean band=false;
	private JButton btnSalir,btnCerrarSesion;
	private JButton btnRegistrar;
	Bootstrap base;
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel modelolist;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList list;
 
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Chocolatera(Bootstrap base) {
		getContentPane().setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20)); 
		initialize();
		base.gui.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	@SuppressWarnings("rawtypes")
	private void initialize() {
		
		this.setTitle("Chocolatera");
		setBounds(100, 100, 668, 436);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		 panelMenu = new JPanel();
		panelMenu.setBounds(10, 11, 632, 34);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		 btnMostrarT = new JButton("Mostrar Tablas");
		 btnMostrarT.addActionListener(this);
		btnMostrarT.setBounds(10, 0, 103, 23);
		panelMenu.add(btnMostrarT);
		
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
		
		 scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 11, 612, 273);
		panel.add(scrollPane);
		
		 list = new JList();
		
		scrollPane.setViewportView(list);
	}
	

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Statement st;
				if(e.getSource()==btnCerrarSesion){
			
			if(this.base.model.cerrarConexion()){
				this.removeAll();
				this.setVisible(false);
				MostrarGUI(this.base.gui);
				
				
			}//end if
			
		}//end if
		
		if(e.getSource()==btnCancelar){
			modelolist.removeAllElements();
			list.setVisible(false);
			this.paint(getGraphics());
		}//end if
		
		if(e.getSource()==btnSalir){
			
			if(this.base.model.cerrarConexion()){
				System.exit(1);
				
			}//end if
			
		}//end if
		
		if(e.getSource()==btnMostrarT){
			
			try {
				
				modelolist=new DefaultListModel();
				list.setCellRenderer(new CheckboxListCellRenderer());
				 list.setModel(modelolist);
				st=this.base.model.GetConnection().createStatement();
				rs=st.executeQuery("SELECT tablename FROM pg_tables where schemaname='bd'");
				rs.next();
					
				while (!(rs.isLast())){
					modelolist.addElement(rs.getString(1));
					
					rs.next();
					
				}//end while*/
				modelolist.addElement(rs.getString(1));
			
				list.setVisible(true);
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
			Registrar ventana_registro =new Registrar(this.base);
			this.setVisible(false);
			ventana_registro.setVisible(true);
			
		}//end if
	}
	
	
	// TODO procedimiento que muestra las vistas segun el privilegio del usuario 1 administrador 2 normal
	public void Privilegios(int tipo){
		
		if(tipo==1){
			btnMostrarT.setEnabled(true);
			btnEliminar.setEnabled(true);
			btnConsultar.setEnabled(true);
		}else{
			
			btnMostrarT.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnMostrarT.setVisible(false);
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




