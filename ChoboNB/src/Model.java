import com.google.common.base.Joiner;
import java.sql.*;
import java.util.*;


public class Model {
	
    private Connection connection;
    private String server, port, database, user, password, schema;
    private Map<String, List<String>> tableNames;
    private Map<String, List<String>> primaryKeyColumns;

    /*Metodos para el manejo de la conexion */

     // hace la conexion con la bd
    public boolean initConnection(String server,String port,String user,String password,String database){
        this.tableNames = new HashMap<String, List<String>>();
        this.primaryKeyColumns = new HashMap<String, List<String>>();
        boolean  band = false;
        String url;
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
        this.schema = "bd";

        try {
            //metodo para cargar el driver
            url = "jdbc:postgresql://" + server + ":" + port + "/" + database;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                band = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Driver no encontrado");
                // e.printStackTrace();
            }	
            
            try{
                getDatabaseTableNames();
            }catch(Exception e){
                System.out.println("Error al obtener nombres");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
        }//end try-catch

        return band;
    }//end conection

    //obtenemos los nombres de las tablas (y las columnas llamando a getDatabaseColumnNames)
    private void getDatabaseTableNames() throws SQLException {            
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT tablename FROM pg_tables where schemaname='" + this.schema + "'");

        while (rs.next()) {
            this.tableNames.put(rs.getString("tablename"), new LinkedList<String>());
            this.primaryKeyColumns.put(rs.getString("tablename"), new LinkedList<String>());
            getDatabaseColumnNames(rs.getString("tablename"));
            getDatabasePrimaryKeyColumns(rs.getString("tablename"));
        }
    }
    
    //Obtenemos los nombres de las columnas de la tabla tableName
    private void getDatabaseColumnNames(String tableName)
    {
        try{
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet rs = metadata.getColumns(null, "bd", tableName, null);
            while(rs.next()){
                this.tableNames.get(tableName).add(rs.getString("COLUMN_NAME"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
     //obtenemos el nombre de las columnas que son llaves primarias en las tablas
    private void getDatabasePrimaryKeyColumns(String tableName){
        try{
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet rs = metadata.getPrimaryKeys(null, "bd", tableName);
            while(rs.next()){
                this.primaryKeyColumns.get(tableName).add(rs.getString("COLUMN_NAME"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //imprimir la información de la base de datos
    public void printDatabaseInfo(){
        System.out.println("Tablas de la base de datos:");
        System.out.println(this.tableNames);
        System.out.println("Llaves primarias de la base de datos");
        System.out.println(this.primaryKeyColumns);
    }

    //cerramos la conexion con la base de datos (metodo)
    public boolean closeConnection(){
        boolean band=false;
        try{
            this.connection.close(); 
            band=true;
        }catch(Exception e){
            e.printStackTrace();
        }//end try-catch
        
        return band;
    }//end cerrarConexion
    
    public Map<String, List<String>> getTableNames(){
        try{
            this.getDatabaseTableNames();
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.tableNames;
    }
    
    public String GetUsr(){
            return this.user;
    }//end GetUsr

    public String GetPass(){
            return this.password;
    }//end GetUsr

    public Connection GetConnection(){
            return this.connection;
    }//end GetConection

    public  Map<String, List<String>> selectAllFrom(String tableName) {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        try {
            for (String e : tableNames.get(tableName)) {
                result.put(e, new LinkedList<String>());   //inicializamos el mapa con listas vacias
            }
            Statement st = this.connection.createStatement();
            String sql = "SELECT * FROM BD." + tableName + ";";
            ResultSet rs = st.executeQuery(sql);
            //para retornar un hashmap con (nombreColumna => lista de filas) en lugar de un ResultSet
            while (rs.next()) {
                for(String e : this.tableNames.get(tableName)){
                    result.get(e).add(rs.getString(e));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }            
        return result;
    }
    
    public  List<Map<String, Object>> selectAllFromLoader(String tableName) {
        List<Map<String, Object>> result = new LinkedList< Map<String, Object> >();
        try {
            Statement st = this.connection.createStatement();
            String sql = "SELECT * FROM BD." + tableName + ";";
            ResultSet rs = st.executeQuery(sql);
            // para retornar un hashmap con (nombreColumna => lista de filas) en lugar de un ResultSet
            while (rs.next()) {
                Map tempHashMap = new HashMap<String, Object>();
                for(String e : this.tableNames.get(tableName)){
                    tempHashMap.put(e, rs.getString(e));
                }
                result.add(tempHashMap);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }            
        return result;
    }
    
    public void removeRow(String tableName, Map<String,String> keyValues){
        try {
            Statement statement = this.connection.createStatement();
            String sql = String.format("DELETE FROM BD.%s WHERE %s;",
                    tableName, Joiner.on(" AND ").withKeyValueSeparator(" = ").join(keyValues));
            statement.executeUpdate(sql);
            // this.connection.commit();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addRow(String tableName, List<String> values) {
        for (int i=0; i < values.size(); i++) {
            values.set(i, Utils.stringify(values.get(i)));
        }
        try {
            Statement st = this.connection.createStatement();
            String sql = String.format("INSERT INTO BD.%s VALUES(%s)", tableName, Joiner.on(", ").join(values));
            st.executeUpdate(sql);
            System.out.println(sql);
        } catch(SQLException e) {
            System.out.println("ERROR AL AGREGAR");
            // e.printStackTrace();
        }
    }
    
    public Map<Integer, String> getKeyIndexFrom(String tableName) {
        Map<Integer, String> indexMap = new HashMap<Integer, String>();
        List<String> keyColumns = this.primaryKeyColumns.get(tableName);
        int index = 0;
        for (String e : this.tableNames.get(tableName)) {
            if (keyColumns.contains(e)) {
                indexMap.put((int)index, e);
            }
            index++;
        }
        return indexMap;
    }
    
    public void getProductWithMaxValue(){
        try{
            Statement st = this.connection.createStatement();
            String sql;
            sql = "SELECT * FROM BD.Producto WHERE valor=(SELECT MAX(valor) FROM BD.Producto)";
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
