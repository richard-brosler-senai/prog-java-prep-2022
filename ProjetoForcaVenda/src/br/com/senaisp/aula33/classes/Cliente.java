package br.com.senaisp.aula33.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

public class Cliente {
	private ConexaoBD conexao;

	private int id;
	private String nome;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String cpf;
	private String rg;
	private Date data_nasc;
	private DateFormat dtFmt;
	private DateFormat dtFmtSQL;
	/**
	 * Constructor Cliente
	 */
	public Cliente() {
		conexao = ConexaoBD.getInstance();
		dtFmt = new SimpleDateFormat("dd/MM/yyyy");
		dtFmtSQL = new SimpleDateFormat("yyyy-MM-dd");
	}

	// Inicio Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public java.sql.Date getData_nascSQL() {
		java.sql.Date dtnas = null;
		if (data_nasc != null) {
			dtnas = java.sql.Date.valueOf(data_nasc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		return dtnas;
	}

	// Fim Getters e Setters
	// Métodos Públicos
	/**
	 * Método novo - Inicializa os fields
	 */
	public void novo() {
		id = 0;
		nome = "";
		endereco = "";
		numero = "";
		complemento = null;
		bairro = "";
		cidade = "";
		uf = "";
		cpf = "";
		rg = "";
		data_nasc = null;
	}

	public void create() throws SQLException {
		conexao.connectDB();
		Connection conn = conexao.getConn();
		String sql = "insert into cliente(nome,endereco,numero,complemento,bairro," + "cidade,uf,cep,cpf,rg,data_nasc) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, nome);
		stmt.setString(2, endereco);
		stmt.setString(3, numero);
		stmt.setString(4, complemento);
		stmt.setString(5, bairro);
		stmt.setString(6, cidade);
		stmt.setString(7, uf);
		stmt.setString(8, cep);
		stmt.setString(9, cpf);
		stmt.setString(10, rg);
		stmt.setString(11, data_nasc == null ? null : dtFmtSQL.format(data_nasc));

		int intLinhasAfetadas = stmt.executeUpdate();
		System.out.println("Linhas afetadas no Insert " + intLinhasAfetadas);
		// Obtendo o Id gerado
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		id = rs.getInt(1);
		System.out.println("Id gerado = " + id);
		conexao.disconnectBD();
	}

	public boolean read() throws SQLException {
		boolean ret = false;
		conexao.connectDB();
		Connection conn = conexao.getConn();
		String sql = "select * from cliente where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsm = stmt.getMetaData();
		System.out.print("Colunas: ");
		for (int intI = 1; intI <= rsm.getColumnCount(); intI++) {
			if (intI > 1)
				System.out.print(",");
			System.out.print(rsm.getColumnName(intI));
		}
		System.out.println();
		if (rs.next()) {
			ret = true;
			nome = rs.getString(2);
			endereco = rs.getString(3);
			numero = rs.getString(4);
			complemento = rs.getString(5);
			bairro = rs.getString(6);
			cidade = rs.getString(7);
			uf = rs.getString(8);
			cep = rs.getString(9);
			cpf = rs.getString(10);
			rg = rs.getString(11);
			setData_nasc(rs.getDate(12));
		} else {
			System.out.println("Registro não encontrado!");
		}
		conexao.disconnectBD();
		return ret;
	}

	public void createDireto() throws SQLException {
		conexao.connectDB();
		Connection conn = conexao.getConn();
		String sql = "insert into cliente(nome,endereco,numero,complemento,bairro," + "cidade,uf,cep,cpf,rg,data_nasc) "
				+ "values (" + "'" + nome + "'," + "'" + endereco + "'," + "'" + numero + "',"
				+ (complemento == null ? "null," : "'" + complemento + "',") + "'" + bairro + "'," + "'" + cidade + "',"
				+ "'" + uf + "'," + "'" + cep + "'," + "'" + cpf + "'," + "'" + rg + "',"
				+ (data_nasc == null ? "null" : "'" + dtFmtSQL.format(data_nasc) + "'") + ")";
		System.out.println("SQL: " + sql);
		Statement stmt = conn.createStatement();
		int intRowsAff = stmt.executeUpdate(sql);
		System.out.println("Linhas afetadas: " + intRowsAff);
		sql = "select LAST_INSERT_ID();";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		id = rs.getInt(1);
		System.out.println("ID -> " + id);
	}
	
	public void setCep(String value) {
		cep = value;
	}

	public String getCep() {
		return cep;
	}
}
