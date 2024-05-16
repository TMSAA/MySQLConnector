package Recu;

import java.sql.*;

public class Ejemplo1 {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");

			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet result = sentencia.executeQuery(sql);

			while (result.next()) {
				System.out.printf("%d, %n, %s, %s", result.getInt(0), result.getString(1), result.getInt(2) );
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Sentencia incorrecta");
		}
	}
}
