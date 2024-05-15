package Recu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejemplo4_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");
			System.out.println("Introduce el numero del departamento que quieras borrar");
			String departamento = sc.next();
			
			String sql = String.format("DELETE FROM departamentos WHERE dnombre = '%s'", departamento);
		
			System.out.println(sql);
			
			Statement sentecia = conexion.createStatement();
			int filas = sentecia.executeUpdate(sql);
			System.out.printf("Departamentos afectados: %d %n",filas);
			
			sentecia.close();
			conexion.close();
			sc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
