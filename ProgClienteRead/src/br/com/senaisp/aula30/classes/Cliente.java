package br.com.senaisp.aula30.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

	public boolean importarArquivo(String caminho) {
		return importarArquivo(caminho, TipoArquivo.CSV);
	}
	
	public boolean exportarArquivo(String caminho, TipoArquivo tpArq) {
		boolean ret = false;
		switch (tpArq) {
		case CSV:
			ret = writeCSVFile(caminho);
			break;
		case JSON:
			ret = writeJSONFile(caminho);
			break;
		case XML:
			ret = writeXMLFile(caminho);
			break;
		}
		return ret;
	}	
	
	public boolean serializarLista(String caminho) {
		boolean ret = false;
		File arq = new File(caminho);
		try {
			arq.delete();
			arq.createNewFile();
			FileOutputStream fos = new FileOutputStream(arq);
			ObjectOutputStream objO = new ObjectOutputStream(fos);
			objO.writeObject(lstClientes);
			objO.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public boolean deserializarLista(String caminho) {
		boolean ret = false;
		lstClientes.clear();
		try {
			File arq = new File(caminho);
			if (arq.exists()) {
				FileInputStream fis = new FileInputStream(arq);
				ObjectInputStream ois = new ObjectInputStream(fis);
				lstClientes = (ArrayList<Object[]>) ois.readObject();
				ois.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
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
			NodeList listaNos = root.getElementsByTagName("row");
			// Percorrendo a lista de itens
			for (int i = 0; i < listaNos.getLength(); i++) {
				Node item = listaNos.item(i);
				if (item instanceof Element) {
					Element itt = (Element) item;
					nome = itt.getElementsByTagName("nome").item(0).getTextContent();
					idade = Integer.parseInt(itt.getElementsByTagName("idade").item(0).getTextContent());
					cpf = itt.getElementsByTagName("cpf").item(0).getTextContent();
					rg = itt.getElementsByTagName("rg").item(0).getTextContent();
					data_nasc = dtFmt.parse(itt.getElementsByTagName("data_nasc").item(0).getTextContent());
					sexo = itt.getElementsByTagName("sexo").item(0).getTextContent();
					signo = itt.getElementsByTagName("signo").item(0).getTextContent();
					mae = itt.getElementsByTagName("mae").item(0).getTextContent();
					pai = itt.getElementsByTagName("pai").item(0).getTextContent();
					email = itt.getElementsByTagName("email").item(0).getTextContent();
					senha = itt.getElementsByTagName("senha").item(0).getTextContent();
					cep = itt.getElementsByTagName("cep").item(0).getTextContent();
					endereco = itt.getElementsByTagName("endereco").item(0).getTextContent();
					numero = Integer.parseInt(itt.getElementsByTagName("numero").item(0).getTextContent());
					bairro = itt.getElementsByTagName("bairro").item(0).getTextContent();
					cidade = itt.getElementsByTagName("cidade").item(0).getTextContent();
					estado = itt.getElementsByTagName("estado").item(0).getTextContent();
					telefone_fixo = itt.getElementsByTagName("telefone_fixo").item(0).getTextContent();
					celular = itt.getElementsByTagName("celular").item(0).getTextContent();
					altura = Double.parseDouble(itt.getElementsByTagName("altura").item(0).getTextContent().replace(",", "."));
					peso = Integer.parseInt(itt.getElementsByTagName("peso").item(0).getTextContent());
					tipo_sanguineo = itt.getElementsByTagName("tipo_sanguineo").item(0).getTextContent();
					cor = itt.getElementsByTagName("cor").item(0).getTextContent();
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
	
	private boolean writeXMLFile(String caminho) {
		boolean ret = false;
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			Element root = document.createElement("root");
            document.appendChild(root);
            
            for (Object[] item : lstClientes) {
            	Element linha = document.createElement("row");
            	
            	linha.appendChild(criarNo(document,"nome",(String) item[0]));
            	linha.appendChild(criarNo(document,"idade",Integer.toString((int) item[1])));
            	linha.appendChild(criarNo(document,"cpf",(String) item[2]));
            	linha.appendChild(criarNo(document,"rg",(String) item[3]));
            	linha.appendChild(criarNo(document,"data_nasc",dtFmt.format(item[4])));
            	linha.appendChild(criarNo(document,"sexo",(String) item[5]));
            	linha.appendChild(criarNo(document,"signo",(String) item[6]));
            	linha.appendChild(criarNo(document,"mae",(String) item[7]));
            	linha.appendChild(criarNo(document,"pai",(String) item[8]));
            	linha.appendChild(criarNo(document,"email",(String) item[9]));
            	linha.appendChild(criarNo(document,"senha",(String) item[10]));
            	linha.appendChild(criarNo(document,"cep",(String) item[11]));
            	linha.appendChild(criarNo(document,"endereco",(String) item[12]));
            	linha.appendChild(criarNo(document,"numero",Integer.toString((int) item[13])));
            	linha.appendChild(criarNo(document,"bairro",(String) item[14]));
            	linha.appendChild(criarNo(document,"cidade",(String) item[15]));
            	linha.appendChild(criarNo(document,"estado",(String) item[16]));
            	linha.appendChild(criarNo(document,"telefone",(String) item[17]));
            	linha.appendChild(criarNo(document,"celular",(String) item[18]));
            	linha.appendChild(criarNo(document,"altura",Double.toString((double) item[19])));
            	linha.appendChild(criarNo(document,"peso",Integer.toString((int) item[20])));
            	linha.appendChild(criarNo(document,"tipo_sanguineo",(String) item[21]));
            	linha.appendChild(criarNo(document,"cor",(String) item[22]));
            	
            	root.appendChild(linha);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            FileOutputStream output = new FileOutputStream(caminho);
            StreamResult result = new StreamResult(output);
            transformer.transform(domSource, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	private Element criarNo(Document doc, String nomeNo, String valor) {
		Element el = doc.createElement(nomeNo);
		el.appendChild(doc.createTextNode(valor));
		return el;
	}

	private boolean writeJSONFile(String caminho) {
		boolean ret = false;
		try {
			FileOutputStream fos = new FileOutputStream(caminho);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(osw);
			JSONArray vetItens = new JSONArray();
			for (Object[] item : lstClientes) {
				JSONObject it = new JSONObject();
				it.put("nome", item[0]);
				it.put("idade", item[1]);
				it.put("cpf", item[2]);
				it.put("rg", item[3]);
				it.put("data_nasc", dtFmt.format(item[4]));
				it.put("sexo", item[5]);
				it.put("signo", item[6]);
				it.put("mae", item[7]);
				it.put("pai", item[8]);
				it.put("email", item[9]);
				it.put("senha", item[10]);
				it.put("cep", item[11]);
				it.put("endereco", item[12]);
				it.put("numero", item[13]);
				it.put("bairro", item[14]);
				it.put("cidade", item[15]);
				it.put("estado", item[16]);
				it.put("telefone", item[17]);
				it.put("celular", item[18]);
				it.put("altura", item[19]);
				it.put("peso", item[20]);
				it.put("tipo_sanguineo", item[21]);
				it.put("cor", item[22]);
				vetItens.put(it);
			}
			bw.write(vetItens.toString());
			bw.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private boolean writeCSVFile(String caminho) {
		boolean ret = false;
		try {
			FileOutputStream fos = new FileOutputStream(caminho);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(osw);
			for (Object[] item : lstClientes) {
				bw.write(item[0] + ","); //nome
				bw.write(item[1] + ","); //idade
				bw.write(item[2] + ","); //cpf
				bw.write(item[3] + ","); //rg
				bw.write(dtFmt.format(item[4]) + ","); //dtnasc
				bw.write(item[5] + ","); //sexo
				bw.write(item[6] + ","); //signo
				bw.write(item[7] + ","); //mae
				bw.write(item[8] + ","); //pai
				bw.write(item[9] + ","); //email
				bw.write(item[10] + ","); //senha
				bw.write(item[11] + ","); //cep
				bw.write(item[12] + ","); //endereco
				bw.write(item[13] + ","); //numero
				bw.write(item[14] + ","); //bairro
				bw.write(item[15] + ","); //cidade
				bw.write(item[16] + ","); //estado
				bw.write(item[17] + ","); //telefone
				bw.write(item[18] + ","); //celular
				bw.write(String.format("%5.2f", item[19]) + ","); //altura
				bw.write(item[20] + ","); //peso
				bw.write(item[21] + ","); //tipo sanguineo
				bw.write(item[22] + "\r\n"); //cor
			}
			bw.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
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
