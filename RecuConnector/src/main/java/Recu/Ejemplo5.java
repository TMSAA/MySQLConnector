package Recu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejemplo5 {

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");
			
			System.out.println("Introduce el numero de departamento");
			String dep = sc.next();
			System.out.println("Introdue el operador(+,-,*)");
			String operador = sc.next();
			System.out.println("Introduce la cantidad ahora");
			String cantidad = sc.next();
			
			String sql = String.format("UPDATE empleados SET salario = salario %s  %s WHERE dept_no = %s", operador,cantidad, dep);
			
			System.out.println(sql);
			
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("empleados afectados: %d %n", filas);
			
			sentencia.close();
			conexion.close();
			sc.close();
		} catch (SQLException e) {
			e.getMessage();
			e.getErrorCode();
		}
	
	}
}
