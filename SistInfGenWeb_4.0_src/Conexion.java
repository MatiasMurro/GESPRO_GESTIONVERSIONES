package Postgres;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Conexion {
	Statement st = null;
	Connection con = null;
	DatosBBDD datosConexion =new DatosBBDD();
	public Conexion() {
		pedirDatos();
			}

	public boolean conecta() {
		try {

			/* Driver */
			String driver = "org.postgresql.Driver";
			System.out.println("=> Cargando el Driver:");
			Class.forName(driver);
			System.out.println("OK");
			
			/* Definiendo Base de Datos */ 
			String url = "jdbc:postgresql://" + datosConexion.getHost() + ":"+datosConexion.getPuerto()+"/" + datosConexion.getBBDD();
		
		
			/* Conectando */ 
			System.out.println("=> conectando:");
			con = DriverManager.getConnection(url, datosConexion.getUsuario(), datosConexion.getClave());
			System.out.println("OK");
			System.out.println(datosConexion.toString());
			/** Mostrando Resultados  **/
			st = con.createStatement();

			return true;
		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, x.toString());

			return false;
		}

	}

	private void pedirDatos() {
		
		String entradaTeclado = null;
		
		System.out.println("Introduzca un usuario:");
		Scanner entradaEscaner = new Scanner(System.in); 
		entradaTeclado = entradaEscaner.next();
		datosConexion.SetUsuario(entradaTeclado);
											 
		System.out.println("Introduzca una contraseña:");
		entradaTeclado = entradaEscaner.next();
		datosConexion.SetClave(entradaTeclado);
		
		System.out.println("Introduzca el servidor:");
		entradaTeclado = entradaEscaner.next();
		datosConexion.SetHost(entradaTeclado);
		
				
		System.out.println("Introduzca un puerto:");
		entradaTeclado = entradaEscaner.next();
		//convertimos a integer
		datosConexion.SetPuerto(Integer.parseInt(entradaTeclado));

		System.out.println("Introduzca la base de datos:");
		entradaTeclado = entradaEscaner.next();
		datosConexion.SetBBDD(entradaTeclado);
					
		entradaEscaner.close();
			
										
		}

}
