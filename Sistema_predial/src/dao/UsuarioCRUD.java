package dao;

import model.Usuario;

public abstract class UsuarioCRUD {
	
	public abstract void incluir(Usuario usuario);
	
	public abstract void atualizar(Usuario usuario);
	
	public abstract Usuario carregar(String cpf);
	
	public abstract void excluir(Usuario usuario);

}
