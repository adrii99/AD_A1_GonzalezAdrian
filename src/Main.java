import java.sql.*;

public class Main {
    public static void main(String[] args){

        try
        {
            //carga el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Se conecta a la base de datos
            Connection conexion=DriverManager.getConnection
                    ("jdbc:mysql://localhost/tiendas?serverTimezone=UTC","root","usuario");
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("SELECT  DNI,nombre FROM empresario");

            //EJERCICIO 1
            System.out.println("DNI Y NOMBRE TABLA EMPRESARIO\n");

            while(resul.next())
            {
                System.out.println(resul.getString(1) + " " + resul.getString(2));
            }

            //EJERCICIO 2
            System.out.println("\nNOMBRE Y CATEGORIA TABLA ARTICULOS\n");

            resul = sentencia.executeQuery("SELECT nombre,categoria FROM articulo");

            while(resul.next())
            {
                System.out.println(resul.getString(1) + " " + resul.getString(2));
            }

            //EJERCICIO 3
            System.out.println("\nDNI EMPRESARIO Y NOMBRE FRUTERIAS\n");

            resul = sentencia.executeQuery("SELECT DNIemp,nombre FROM fruteria");

            while(resul.next())
            {
                System.out.println(resul.getString(1) + " " + resul.getString(2));
            }

            //EJERCICIO 4
            System.out.println("\nLISTADO COMPLETO DE LOS DATOS DE LA TABLA STOCK\n");

            resul = sentencia.executeQuery("SELECT cod_art,cod_f,cantidad FROM stock join fruteria on (stock.cod_f=fruteria.cod) join articulo on (articulo.cod=stock.cod_art)");

            resul.close();
            sentencia.close();
            conexion.close();

        }
        catch (ClassNotFoundException cn ) {cn.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
    }

}