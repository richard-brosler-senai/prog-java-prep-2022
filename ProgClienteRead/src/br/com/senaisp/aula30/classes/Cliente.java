package br.com.senaisp.aula30.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Cliente {
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private Date data_nasc;
	private String sexo;
	private String signo;
	private String mae;
	private String pai;
	private String email;
	private String senha;
	private String cep;
	private String endereco;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone_fixo;
	private String celular;
	private double altura;
	private int peso;
	private String tipo_sanguineo;
	private String cor;

	private DateFormat dtFmt;
	private List<Object[]> lstClientes;

	/**
	 * Constructor Padrão
	 */
	public Cliente() {
		inicializador();
	}

	/**
	 * Método para importar arquivos
	 * 
	 * @param caminho Indicar o caminho do arquivo a ser importado.
	 * @param tpArq   Indicar o tipo de arquivo a ser importado. Default CSV
	 * @return Retorna verdadeiro se conseguiu ler com sucesso o arquivo
	 */
	public boolean importarArquivo(String caminho, TipoArquivo tpArq) {
		boolean ret = false;
		switch (tpArq) {
		case CSV:
			ret = readCSVFile(caminho);
			break;
		case JSON:
			ret = readJSONFile(caminho);
			break;
		case XML:
			ret = readXMLFile(caminho);
			break;
		}

		return ret;
	}

	private boolean readXMLFile(String caminho) {
		boolean ret = false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(caminho);
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = fact.newDocumentBuilder();
			Document doc = build.parse(fis);
			// Obtendo o nó root
			Element root = doc.getDocumentElement();
			// Obtendo a lista de filhos
			NodeList listaNos = root.getChildNodes();
			// Percorrendo a lista de itens
			for (int i = 0; i < listaNos.getLength(); i++) {
				Node item = listaNos.item(i);
				NodeList itens = item.getChildNodes();
				if (itens.getLength() > 0) {
					for (int f = 0; f < itens.getLength(); f++) {
						Node itt = itens.item(f);
						if (itt instanceof Element) {
							switch(itt.getNodeName()) {
							case "nome" : nome = itt.getTextContent(); break;
							case "idade" : idade = Integer.parseInt(itt.getTextContent()); break;
							case "cpf" : cpf = itt.getTextContent(); break;
							case "rg" : rg = itt.getTextContent(); break;
							case "data_nasc" : data_nasc = dtFmt.parse(itt.getTextContent()); break;
							case "sexo" : sexo = itt.getTextContent(); break;
							case "signo" : signo = itt.getTextContent(); break;
							case "mae" : mae = itt.getTextContent(); break;
							case "pai" : pai = itt.getTextContent(); break;
							case "email" : email = itt.getTextContent(); break;
							case "senha" : senha = itt.getTextContent(); break;
							case "cep" : cep = itt.getTextContent(); break;
							case "endereco" : endereco = itt.getTextContent(); break;
							case "numero" : numero = Integer.parseInt(itt.getTextContent()); break;
							case "bairro" : bairro = itt.getTextContent(); break;
							case "cidade" : cidade = itt.getTextContent(); break;
							case "estado" : estado = itt.getTextContent(); break;
							case "telefone_fixo" : telefone_fixo = itt.getTextContent(); break;
							case "celular" : celular = itt.getTextContent(); break;
							case "altura" : altura = Double.parseDouble(itt.getTextContent().replace(",", ".")); break;
							case "peso" : peso = Integer.parseInt(itt.getTextContent()); break;
							case "tipo_sanguineo" : tipo_sanguineo = itt.getTextContent(); break;
							case "cor" : cor = itt.getTextContent(); break;
							}
						}
					}
					Object it[] = {
							nome,
							idade,
							cpf,
							rg,
							data_nasc,
							sexo,
							signo,
							mae,
							pai,
							email,
							senha,
							cep,
							endereco,
							numero,
							bairro,
							cidade,
							estado,
							telefone_fixo,
							celular,
							altura,
							peso,
							tipo_sanguineo,
							cor							
					};
					lstClientes.add(it);
				}
			}
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private boolean readJSONFile(String caminho) {
		boolean ret = false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(caminho);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer strBuff = new StringBuffer();
			String strLinha;
			// retirando a linha de cabeçalho
			while ((strLinha = br.readLine()) != null) {
				strBuff.append(strLinha);
			}

			JSONArray obj = new JSONArray(strBuff.toString());
			System.out.println(obj.toString());
			for (int i = 0; i < obj.length(); i++) {
				JSONObject itens = obj.getJSONObject(i);

				Date dtNasc = dtFmt.parse(itens.getString("data_nasc"));
				String strAltura = itens.getString("altura");
				Object it[] = { itens.getString("nome"), // Nome
						itens.getInt("idade"), // Idade
						itens.getString("cpf"), // cpf
						itens.getString("rg"), // rg
						dtNasc, // dtnascimento
						itens.getString("sexo"), // sexo
						itens.getString("signo"), // signo
						itens.getString("mae"), // mae
						itens.getString("pai"), // pai
						itens.getString("email"), // email
						itens.getString("senha"), // senha
						itens.getString("cep"), // cep
						itens.getString("endereco"), // endereco
						itens.getInt("numero"), // numero
						itens.getString("bairro"), // bairro
						itens.getString("cidade"), // cidade
						itens.getString("estado"), // estado
						itens.getString("telefone_fixo"), // telefone fixo
						itens.getString("celular"), // celular
						Double.parseDouble(strAltura.replace(",", ".")), // altura
						itens.getInt("peso"), // peso
						itens.getString("tipo_sanguineo"), // tipo sanguineo
						itens.getString("cor")// cor
				};
				lstClientes.add(it);
			}
			br.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private boolean readCSVFile(String caminho) {
		boolean ret = false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(caminho);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			String strLinha = br.readLine();
			// retirando a linha de cabeçalho
			while ((strLinha = br.readLine()) != null) {
				List<String> itens = Arrays.asList(strLinha.split("\\s*,\\s*"));
				Date dtNasc = dtFmt.parse(itens.get(4));
				String strAltura = itens.get(19) + "." + itens.get(20);
				Object it[] = { itens.get(0), // Nome
						Integer.parseInt(itens.get(1)), // Idade
						itens.get(2), // cpf
						itens.get(3), // rg
						dtNasc, // dtnascimento
						itens.get(5), // sexo
						itens.get(6), // signo
						itens.get(7), // mae
						itens.get(8), // pai
						itens.get(9), // email
						itens.get(10), // senha
						itens.get(11), // cep
						itens.get(12), // endereco
						Integer.parseInt(itens.get(13)), // numero
						itens.get(14), // bairro
						itens.get(15), // cidade
						itens.get(16), // estado
						itens.get(17), // telefone fixo
						itens.get(18), // celular
						Double.parseDouble(strAltura.replace("\"", "")), // altura
						Integer.parseInt(itens.get(21)), // peso
						itens.get(22), // tipo sanguineo
						itens.get(23)// cor
				};
				lstClientes.add(it);
			}
			br.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public boolean importarArquivo(String caminho) {
		return importarArquivo(caminho, TipoArquivo.CSV);
	}

	private void inicializador() {
		lstClientes = new ArrayList<Object[]>();
		dtFmt = new SimpleDateFormat("dd/MM/yyyy");
		nome = "";
		idade = 0;
		cpf = "";
		rg = "";
		try {
			data_nasc = dtFmt.parse("30/12/1899");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sexo = "";
		signo = "";
		mae = "";
		pai = "";
		email = "";
		senha = "";
		cep = "";
		endereco = "";
		numero = 0;
		bairro = "";
		cidade = "";
		estado = "";
		telefone_fixo = "";
		celular = "";
		altura = 0;
		peso = 0;
		tipo_sanguineo = "";
		cor = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone_fixo() {
		return telefone_fixo;
	}

	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Object[]> getLista() {
		return lstClientes;
	}

	/**
	 * Enum TipoArquivo para importação
	 * 
	 * @author Richard
	 *
	 */
	public enum TipoArquivo {
		CSV, JSON, XML
	}
}
