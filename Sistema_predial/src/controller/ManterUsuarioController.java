package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@WebServlet ("/ManterUsuario")
public class ManterUsuarioController extends HttpServlet {

	/**
	 * Esther Souza
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pNome = req.getParameter("nome");
		String pTipoFuncionario = req.getParameter("cargo");
		String pEmpresa = req.getParameter("empresa");
		String pHorario = req.getParameter("horario");
		String pCpf = req.getParameter("cpf");
		String pSenha = req.getParameter("senha");

		// instanciar o javabean
		Usuario usuario = new Usuario();
		usuario.setCpf(pCpf);
		usuario.setNome(pNome);
		usuario.setTipoFuncionario(pTipoFuncionario);
		usuario.setHorario(pHorario);
		usuario.setEmpresa(pEmpresa);
		usuario.setSenha(pSenha);

		// instanciar o service
		UsuarioService us = new UsuarioService();
		us.criar(usuario);
		usuario = us.carregar(usuario.getCpf());

		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Usuário Cadastrado</title></head><body>");
		out.println("CPF: " + usuario.getCpf() + "<br>");
		out.println("Nome: " + usuario.getNome() + "<br>");
		out.println("Cargo: " + usuario.getTipoFuncionario() + "<br>");
		out.println("Horário: " + usuario.getHorario() + "<br>");
		out.println("Empresa: " + usuario.getEmpresa() + "<br>");
		out.println("Senha: " + usuario.getSenha() + "<br>");
		out.println("</body></html>");
	}

}
