import java.sql.*;
import java.util.*;


public class Model {
	
    private Connection connection;
    private String server, port, database, user, password, schema;
    private Map<String, List<String>> tableNames;

    /*Metodos para el manejo de la conexion */

     // hace la conexion con la bd
    public boolean initConnection(String server,String port,String user,String password,String database){
        this.tableNames = new HashMap<String, List<String>>();
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
            getDatabaseColumnNames(rs.getString("tablename"));
        }
    }
    
    //Obtenemos los nombres de las columnas de la tabla tableName
    private void getDatabaseColumnNames(String tableName)
    {
        try{
            Collection<String> columns = new LinkedList<String>();
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

    //imprimir la información de la base de datos
    public void printDatabaseInfo(){
        System.out.println(this.tableNames);
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
    
    public  List<Map<String, String>> selectAllFromLoader(String tableName) {
        List<Map<String, String>> result = new LinkedList< Map<String, String> >();
        try {
            Statement st = this.connection.createStatement();
            String sql = "SELECT * FROM BD." + tableName + ";";
            ResultSet rs = st.executeQuery(sql);
            // para retornar un hashmap con (nombreColumna => lista de filas) en lugar de un ResultSet
            while (rs.next()) {
                Map tempHashMap = new HashMap<String, String>();
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

    public String parseColumnNames(Collection<String> columnNames){
        String result = "";
        Iterator i = columnNames.iterator();
        if(!columnNames.isEmpty()){
            while(i.hasNext()){
                result += result + i.next();
                if(i.hasNext()){
                    result += ", ";
                }else{
                    result += " ";
                }
            }
        }else{
            result += "*";
        }
        return result;
    }
}
