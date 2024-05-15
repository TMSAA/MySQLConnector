package Recu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejemplo6 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");
			String sql = "select apellido, emp_no, dnombre from empleados inner join departamentos ON empleados.dept_no = departamentos.dept_no";
			PreparedStatement sentecia = conexion.prepareStatement(sql);
			
			System.out.println("Introduce el numero de departamento");
			int numero = sc.nextInt();
			
			sentecia.setInt(1, numero);
			
			ResultSet rs = sentecia.executeQuery();
			while(rs.next()) {
				System.out.println();
			}
			rs.close();
			sentecia.close();
			conexion.close();
			sc.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
}
