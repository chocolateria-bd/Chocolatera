
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class Constants {
    public static final Map<String, String> tablesPrimaryKeys;
    static
    {
        tablesPrimaryKeys = new HashMap<String, String>();
        tablesPrimaryKeys.put("cliente", "codigo");
        tablesPrimaryKeys.put("producto", "codigo");
    }
    
    
}
