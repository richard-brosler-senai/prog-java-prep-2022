package br.com.senaisp.aula15.classes;

public class Cliente {
	private int Codigo;
	private String Nome;
	private String Endereco;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) throws ParamentroInvalidoException {
		if ( codigo<=0 || codigo > 100) {
			throw new ParamentroInvalidoException("Código deve ser entre 0 ou 100!");
		}
		Codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) throws ParamentroInvalidoException {
		if (nome.length()<3){
			throw new ParamentroInvalidoException("Nome deve ter pelo menos 3 caracteres!");
		}
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) throws ParamentroInvalidoException {
		if (endereco.length()<3) {
			throw new ParamentroInvalidoException("Endereço deve ter pelo menos 3 caracteres!");
		}
		Endereco = endereco;
	}
	
}
