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
			//Para terminar el bucle hay que introducir dos zeros seguidos asi no muestra nada y acaba el bucle
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");
			String sql = "SELECT e.emp_no, e.apellido, e.oficio, e.dir, e.fecha_alt, e.salario, e.comision, e.dept_no, d.dnombre " +
                    "FROM empleados e " +
                    "INNER JOIN departamentos d ON e.dept_no = d.dept_no " +
                    "WHERE e.dept_no = ? OR e.dept_no = ?";
			PreparedStatement sentecia = conexion.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			int dept_no1 = 0;
			
			do {
				
				System.out.println("Introduce el numero del primer departamento");
				dept_no1 = sc.nextInt();
				
				System.out.println("Intrdouce el numero del segundo departamento");
				int dept_no2 = sc.nextInt();
				
				sentecia.setInt(1, dept_no1);
				sentecia.setInt(2, dept_no2);
				
				ResultSet rs = sentecia.executeQuery();
				
				int columnCount = rs.getMetaData().getColumnCount();
				while (rs.next()) {
					for (int i = 1; i <= columnCount; i++) {
	                    System.out.print(rs.getString(i) + "\t");
	                }
	                System.out.println();
				}
				rs.close();
				
				
			} while (dept_no1 != 0);
			sc.close();
			sentecia.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}
}
