package dasdtemp;


public interface UsuarioDAO extends IDAO<Usuario> {

	Usuario buscarUsuario(Usuario usuario);
	Usuario buscarUsuario(String usuario);

}
