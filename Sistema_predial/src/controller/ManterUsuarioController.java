package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pNome = req.getParameter("nome");
		String pEmpresa = req.getParameter("empresa");
		String pHorario = req.getParameter("horario");
		String pCpf = req.getParameter("cpf");
		String pSenha = req.getParameter("senha");

		// instanciar o javabean
		Usuario usuario = new Usuario();
		usuario.setCpf(pCpf);
		usuario.setNome(pNome);
		usuario.setHorario(pHorario);
		usuario.setEmpresa(pEmpresa);
		usuario.setSenha(pSenha);

		// instanciar o service
		UsuarioService us = new UsuarioService();
		us.criar(usuario);
		usuario = us.carregar(usuario.getCpf());

		req.setAttribute("usuario", usuario);
		
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);
	}

}
