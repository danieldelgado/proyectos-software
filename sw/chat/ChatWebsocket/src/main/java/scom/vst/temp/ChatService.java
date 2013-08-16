package scom.vst.temp;

import java.util.List;


public interface ChatService {

	public boolean existeUsuario(String usuario);

	public Usuario getUsuario(String usuario);

	public List<Usuario> listaUsuarios(); 

	public void guardarUsuario(Usuario usuario);
	
	public void guardarMessageInfo(MessageInfo messageInfo);

	public void guardarStatusInfo(StatusInfo statusInfo);

	public void guardarConexion(Conexion c);

}
