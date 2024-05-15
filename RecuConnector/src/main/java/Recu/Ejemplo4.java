package Recu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejemplo4 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");
			
			System.out.println("Introduce el numero de departamento");
			String dep = sc.next();
			System.out.println("Introdue el numero de departamento");
			String nombre = sc.next();
			System.out.println("Introduce la localidad del departamento");
			String loc = sc.next();
			
			String sql = String.format("INSERT INTO departamentos VALUES (%s,'%s','%s')", dep, nombre, loc);
			
			System.out.println(sql);
			
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			
			sentencia.close();
			conexion.close();
			sc.close();
		} catch (SQLException e) {
			System.out.println("Sentecia incorrecta");
		}
	}
}
