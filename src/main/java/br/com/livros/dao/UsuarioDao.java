package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Usuario;

public interface UsuarioDao {

	List<Usuario> listarUsuarios();

	boolean existeUsuarioCadastrado();

	Usuario pesquisarUsuario(Usuario usuario);

}
