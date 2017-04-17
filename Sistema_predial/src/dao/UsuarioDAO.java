package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO extends UsuarioCRUD{
	@Override
	public void incluir(Usuario usuario) {
		// TODO Auto-generated method stub
		String sqlInsert = "INSERT INTO usuario(cpf, nome, tipoFuncionario, horario, empresa, senha) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getTipoFuncionario());
			stm.setString(4, usuario.getHorario());
			stm.setString(5, usuario.getEmpresa());
			stm.setString(6, usuario.getSenha());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		String sqlUpdate = "UPDATE usuario SET nome=?, tipoFuncionario=?, horario=?, empresa=?, senha=? WHERE cpf=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getTipoFuncionario());
			stm.setString(3, usuario.getHorario());
			stm.setString(4, usuario.getEmpresa());
			stm.setString(5, usuario.getSenha());
			stm.setString(6, usuario.getCpf());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario carregar(String cpf) {
		Usuario usuario = new Usuario();
		String sqlSelect = "SELECT nome, tipoFuncionario, horario, empresa, senha FROM usuario WHERE usuario.cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cpf);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setTipoFuncionario(rs.getString("tipoFuncionario"));
					usuario.setHorario(rs.getString("horario"));
					usuario.setEmpresa(rs.getString("empresa"));
					usuario.setSenha(rs.getString("senha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}


	@Override
	public void excluir(Usuario usuario) {
		// TODO Auto-generated method stub
		String sqlDelete = "DELETE FROM usuario WHERE cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, usuario.getCpf());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
