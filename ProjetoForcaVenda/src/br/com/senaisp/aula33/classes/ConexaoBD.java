package br.com.senaisp.aula33.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBD {
	private static final String DB_HOST = "localhost";
	private static final String DB_USER = "desenvolvimento";//"root";
	private static final String DB_PASS = "&proMMorp&";//"Sen@i2021*";
	private static final String DB_DATABASE = "senai_java_2022_01";
	private static final String DB_DRIVER = "mysql";
	private static final int DB_PORT = 3306;
	
	private static ConexaoBD instancia;
	
	private Connection fConn;

	private String fDBDriver;
	private String fDBHost;
	private int fDBPort;
	private String fDBDatabase;
	
	private String fConnString;
	private String fDBUsername;
	private String fDBPassword;
	private boolean fInicializado;
	
	private ConexaoBD() {
		//montando a string connection
		//fConnString = "jdbc:"+DB_DRIVER+"://"+DB_HOST+":"+DB_PORT+"/"+DB_DATABASE;
		fDBDriver = DB_DRIVER;
		fDBHost = DB_HOST;
		fDBPort = DB_PORT;
		fDBDatabase = DB_DATABASE;
		fDBUsername = DB_USER;
		fDBPassword = DB_PASS;
		fInicializado = false;
	}
	
	public static synchronized ConexaoBD getInstance() {
		if (instancia == null) {
			instancia = new ConexaoBD();
		}
		return instancia;
	}
	
	public Connection getConn() {
		return fConn;
	}
	
	public String getConnectionString() {
		return "jdbc:"+getDBDriver()+"://"+getDBHost()+":"+getDBPort()+"/"+getDBDatabase();
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
	
	public String getDBDriver() {
		return fDBDriver;
	}

	public void setDBDriver(String fDBDriver) {
		this.fDBDriver = fDBDriver;
	}

	public String getDBHost() {
		return fDBHost;
	}

	public void setDBHost(String fDBHost) {
		this.fDBHost = fDBHost;
	}

	public int getDBPort() {
		return fDBPort;
	}

	public void setDBPort(int fDBPort) {
		this.fDBPort = fDBPort;
	}

	public String getDBDatabase() {
		return fDBDatabase;
	}

	public void setDBDatabase(String fDBDatabase) {
		this.fDBDatabase = fDBDatabase;
	}

	public void connectDB() throws SQLException {
		if (!fInicializado) initializeBD(); 
		//obtendo a conexão com o banco de dados
		fConn = DriverManager.getConnection(getConnectionString(),getDBUsername(),getDBPassword());
	}

	public void disconnectBD() throws SQLException {
		if (fConn!= null) fConn.close();
		fConn = null;
	}
	
	private void initializeBD() throws SQLException {
		String strCon = "jdbc:"+getDBDriver()+"://"+getDBHost()+":"+getDBPort();
		fConn = DriverManager.getConnection(strCon,getDBUsername(),getDBPassword());
		//Criando a database se não existir
		System.out.println("Criando a database se não existe!...");
		PreparedStatement stmt = fConn.prepareStatement("create database if not exists " + getDBDatabase());
		stmt.execute();
		fConn.close();
		
		fConn = DriverManager.getConnection(getConnectionString(),getDBUsername(),getDBPassword());
		//Criando a tabela de cliente se não existir
		String 	sql = "CREATE TABLE IF NOT EXISTS `cliente` (\r\n"
				+ "	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
				+ "	`nome` VARCHAR(60) NOT NULL,\r\n"
				+ "	`endereco` VARCHAR(100) NOT NULL,\r\n"
				+ "	`numero` VARCHAR(20) NOT NULL,\r\n"
				+ "	`complemento` VARCHAR(50) NULL,\r\n"
				+ "	`bairro` VARCHAR(60) NOT NULL,\r\n"
				+ "	`cidade` VARCHAR(60) NOT NULL,\r\n"
				+ "	`uf` VARCHAR(2) NOT NULL,\r\n"
				+ "	`cep` VARCHAR(10) NOT NULL,\r\n"
				+ "	`cpf` VARCHAR(20) NOT NULL,\r\n"
				+ "	`rg` VARCHAR(20) NOT NULL,\r\n"
				+ "	`data_nasc` DATE NULL,\r\n"
				+ "	`created_at` TIMESTAMP NOT NULL DEFAULT current_timestamp(),\r\n"
				+ "	`updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),\r\n"
				+ "	PRIMARY KEY (`id`)\r\n"
				+ ");";
		System.out.println("Criando a tabela de cliente se não existe!...");
		stmt = fConn.prepareStatement(sql);
		stmt.execute();
		fConn.close();
		fInicializado = true;
	}
}
