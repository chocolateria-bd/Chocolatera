
import java.util.Arrays;
import java.util.List;
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
public class Utils {
    public static String[] listToArray(List<String> list){
        String[] newArray = new String[list.size()];
        newArray = list.toArray(newArray);
        return newArray;
    }
    
    public static Object[][] listOfListsToArray(List<Map<String, Object>> listOfMaps){
        if (!listOfMaps.isEmpty()) {
            Object[][] tableOfObjects = new String[listOfMaps.size()][listOfMaps.get(0).size()];
            for (int i = 0; i < listOfMaps.size(); i++) {
                Map<String, Object> map = listOfMaps.get(i);
                int j = 0;
                for(Map.Entry e : map.entrySet()){
                    tableOfObjects[i][j++] = e.getValue().toString();
                }
            }
            return tableOfObjects;
        }
        return new Object[0][0];
    }
    
    public static String getPrimaryKey(String tableName) {
        return Constants.tablesPrimaryKeys.get(tableName);
    }
    
    public static String stringify(String string){
        return "'" + string + "'";
    }
}
