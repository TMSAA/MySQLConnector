package Recu;

import java.sql.*;

public class Ejemplo1 {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");

			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM empleados";
			ResultSet result = sentencia.executeQuery(sql);

			while (result.next()) {
				System.out.printf("%d, %s, %d %n", result.getInt(1), result.getString(2), result.getInt(8) );
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Sentencia incorrecta");
		}
	}
}
