package Recu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Ejemplo3 {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/recu33", "Adrian", "Buwiga.33");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = dbmd.getExportedKeys(null, "recu33", "departamentos");
			while(resul.next()) {
				String fk_name = resul.getString("FKCOLUMN_NAME");
				String pk_name = resul.getString("PKCOLUMN_NAME");
				String pk_tablename = resul.getString("PKTABLE_NAME");
				String fk_tablename = resul.getString("FRTABLE_NAME");
				
				System.out.printf("Table PK: %s, Clave Primaria: %s %n",pk_tablename, pk_name);
				System.out.printf("Table PK: %s, Clave Ajena: %s %n",fk_tablename, fk_name);
			}
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
