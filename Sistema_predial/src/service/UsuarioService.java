package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public void criar(Usuario usuario) {
		dao.incluir(usuario);
	}

	public void atualizar(Usuario usuario) {
		dao.atualizar(usuario);
	}

	public void excluir(Usuario usuario) {
		dao.excluir(usuario);
	}

	public Usuario carregar(String cpf) {
		Usuario usuario = dao.carregar(cpf);
		return usuario;
	}

}
