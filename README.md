# Chocolatera
Proyecto de base de datos 

Este fue un proyecto realizado para Bases de Datos. En este proyecto usamos el lenguaje Java, y una arquitectura basada
en el patron MVC (Modelo, Vista, Controlador). El proyecto fue realizado con el IDE NetBeans.

### Librerias adicionales usadas:
- El driver JDBC para poder realizar la conexion a la bd mediante postgres.
- Guava, una libreria de Google para Java. Incluimos esta libreria ya que provee ciertas funciones auxiliares
que nos facilitaban el trabajo.

### Instalacion o ejecucion
Es necesario instalar Netbeans, luego clonar el proyecto con git y abrir la carpeta `ChocoNB` desde netbeans. Tambien correr
los scripts `crearbd.sql` y `data.sql` de la carpeta [scripts](scripts) para crear la base de datos y llenarla con 
informacion.

### Uso de guava
Usamos la clase Joiner de guava, mediante la cual podiamos unir cadenas que estaban en una lista o mapa (diccionario o arreglo asociativo)
con un formato especificado.

En el siguiente ejemplo, extraido del archivo [Model.java](ChoboNB\src\Model.java), especificamente del metodo removeRow,
el cual toma el nombre de una tabla o relacion de la bases de datos, y un mapa que mapea cadenas a cadenas, en el cual guardamos
los nombres de las columnas claves y de los valores dados. La idea es ubicar la tupla identificada por estos valores y eliminarla
en la base de datos. Entonces la siguiente linea hace justo lo que necesitamos, que es unir cada par de elementos llave, valor del mapa
con un separador especificado, en este caso `=` y luego cada par unido con `=` lo une con un `AND`.
```java
String sql = String.format("DELETE FROM BD.%s WHERE %s;",
                    tableName, Joiner.on(" AND ").withKeyValueSeparator(" = ").join(keyValues));
```

Por ejemplo, en el caso que tuvieramos un mapa con los siguientes pares llave, valor `{pKey1: 2, pKey2: 589}`, 
y el nombre de tabla `tablaEjemplo`, nuestro codigo armaria la siguiente consulta:

```sql
DELETE FROM BD.tablaEjemplo WHERE pKey = 2 AND pKey = 589;
```

