package br.com.senaisp.aula31.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
	private static final String DB_HOST = "localhost";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "Sen@i2021*";
	private static final String DB_DATABASE = "senai_java_2022_01";
	private static final String DB_DRIVER = "mysql";
	private static final int DB_PORT = 3306;
	
	private static ConexaoBD instancia;
	
	private Connection fConn;
	private Statement fStmt;
	
	private ConexaoBD() throws SQLException {
		String strConn = "jdbc:"+DB_DRIVER+"://"+DB_HOST+":"+DB_PORT+"/"+DB_DATABASE;
		fConn = DriverManager.getConnection(strConn,DB_USER,DB_PASS);
		fStmt = fConn.createStatement();
	}
	
	public static synchronized ConexaoBD getInstance() throws SQLException {
		if (instancia == null) {
			instancia = new ConexaoBD();
		}
		return instancia;
	}
	
	public Statement getStmt() {
		return fStmt;
	}
	
	public Connection getConn() {
		return fConn;
	}
	
	public void inicializarBD() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS clientes (\r\n"
				+ "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `nome` VARCHAR(60) NOT NULL,\r\n"
				+ "  `idade` INT UNSIGNED NOT NULL,\r\n"
				+ "  `cpf` VARCHAR(20) NOT NULL,\r\n"
				+ "  `rg` VARCHAR(20) NOT NULL,\r\n"
				+ "  `data_nasc` DATE NOT NULL,\r\n"
				+ "  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),\r\n"
				+ "  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp() on update current_timestamp(),\r\n"
				+ "  PRIMARY KEY (`id`));";
		fStmt.execute(sql);
	}
}
