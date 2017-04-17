package model;

public class Usuario {
	private String nome;
	private String cpf;
	private String senha;
	private String tipoFuncionario;
	private String empresa;
	private String horario;
	private boolean autorizado;
	
	public Usuario(String nome, String pCpf, String senha, String tipoFuncionario, String empresa, String horario,
			boolean autorizado) {
		this.nome = nome;
		this.cpf = pCpf;
		this.senha = senha;
		this.tipoFuncionario = tipoFuncionario;
		this.empresa = empresa;
		this.horario = horario;
		this.autorizado = autorizado;
	}
	
	public Usuario(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
	
	
}
