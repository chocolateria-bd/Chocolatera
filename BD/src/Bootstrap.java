 
/*Clase singleton, inicia el programa y contiene las clases base de la aplicacion */
public class Bootstrap {
	
	public static Bootstrap instance = null;
	public Model model; //instancia de la clase para la comunicacion con los datos del programa	private Connection connection;
	public GUI gui;
	
	public static void main(String[] args){
		instance = getInstance();
		instance.model = new Model(instance);
		instance.gui = new GUI(instance);
		instance.gui.setVisible(true);
	}
	public static Bootstrap getInstance(){
		if(instance == null){
			instance = new Bootstrap();
		}
		return instance;
	}
}
