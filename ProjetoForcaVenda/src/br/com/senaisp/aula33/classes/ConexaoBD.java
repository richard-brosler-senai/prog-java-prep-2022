package br.com.senaisp.aula33.classes;

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
	private String fConnString;
	private String fDBUsername;
	private String fDBPassword;
	
	private ConexaoBD() {
		//montando a string connection
		fConnString = "jdbc:"+DB_DRIVER+"://"+DB_HOST+":"+DB_PORT+"/"+DB_DATABASE;
		fDBUsername = DB_USER;
		fDBPassword = DB_PASS;
	}
	
	public static synchronized ConexaoBD getInstance() {
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
	
	public String getConnectionString() {
		return fConnString;
	}
	
	public void setConnectionString(String value) {
		fConnString = value;
	}

	public String getDBUsername() {
		return fDBUsername;
	}

	public void setDBUsername(String value) {
		fDBUsername = value;
	}

	public String getDBPassword() {
		return fDBPassword;
	}

	public void setDBPassword(String value) {
		fDBPassword = value;
	}
	
	public void connectDB() throws SQLException {
		//obtendo a conex�o com o banco de dados
		fConn = DriverManager.getConnection(getConnectionString(),getDBUsername(),getDBPassword());
		//criando a instru��o para execu��o de SQLs
		fStmt = fConn.createStatement();
	}

	public void disconnectBD() throws SQLException {
		if (fStmt!= null) fStmt.close();
		if (fConn!= null) fConn.close();
		fStmt = null;
		fConn = null;
	}
	
}
