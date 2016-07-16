/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class Bootstrap {
    public static Bootstrap instance;
    public static ChocoUI view;
    public static Model model;
    public static void main(String args[]){
        System.out.println("Hello, World");
        model = new Model();
        model.initConnection("localhost","5432","postgres", "pi3141592", "proyectobd");
        model.printDatabaseInfo();
        //ChocoUI.init();
        
    }
}
