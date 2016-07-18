
import java.lang.reflect.InvocationTargetException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Bootstrap {
    public static Bootstrap instance = null;
    public ChocoUI view = null;
    public Model model = null;
    
    private Bootstrap(){
        model = new Model();
        view = ChocoUI.getInstance();
    }
    
    public static synchronized Bootstrap getInstance(){
        if (instance == null) {
            instance = new Bootstrap();
        }
        return instance;
    }
    
    public static void main(String args[]){
        
        ChocoUI.init();
        instance = new Bootstrap();
                   
        System.out.println("!! -- Initialization was correct.  -- !!");
        if (instance.view == null || instance.model == null) {
            System.out.println("- Instance is  null.");
        }

        
        //instance.model.initConnection("localhost","5432", "postgres", "pi3141592", "proyectobd");
        //instance.model.printDatabaseInfo();
        // model.closeConnection();
    }
}
