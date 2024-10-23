package br.edu.ifsc.gaspar.ExemploJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Primeiro {

	//Classe principal
	public static void main(String[] args) {

		// URL do banco de dados, substitua os valores conforme necessário para conectar
		String url = "jdbc:mysql://localhost:3306/teste"; // URL do banco de dados
		String user = "root"; // Nome de usuário do banco de dados
		String password = "aluno"; // Senha do banco de dados

		// Conexão com o banco de dados
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Conexão bem-sucedida!");
			// Aqui é possivel usar a conexão para criar o Statement, PreparedStatement, etc.
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Falha na conexão com o banco de dados.");
		}
	}
	
	
	

	
	

}
