/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class ExtendTest extends BaseTest {
    
    public void ExtendTest(){
        System.out.println("HOLA");
        System.out.println(nombre);
    }
    
    @Override
    public String stringSetter(){
        return "Dede clase ExtendTest";
    }
}
