package alfresco.com.vst.service.component;

import org.alfresco.webservice.authentication.AuthenticationFault;
import org.alfresco.webservice.authoring.AuthoringServiceSoapBindingStub;
import org.alfresco.webservice.content.ContentServiceSoapBindingStub;
import org.alfresco.webservice.repository.RepositoryServiceSoapBindingStub;
import org.alfresco.webservice.types.CML;
import org.alfresco.webservice.types.CMLCreate;
import org.alfresco.webservice.types.NamedValue;
import org.alfresco.webservice.types.ParentReference;
import org.alfresco.webservice.types.Predicate;
import org.alfresco.webservice.types.Reference;
import org.alfresco.webservice.types.Store;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.Constants;
import org.alfresco.webservice.util.Utils;
import org.alfresco.webservice.util.WebServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vst.deocecu.util.Config;

//@Component
public class AlfrescoServiceConexion {

	private static final Logger logger = LoggerFactory.getLogger(AlfrescoServiceConexion.class);
	
	private static Boolean ISCONEXION = Config.getPropiedadBoolean("alfresco.repository.conexion");
	private static final String STR_ALFRESCO_END_POINT = Config.getPropiedad("alfresco.repository.location.absolute");
	private static final String USUARIO_ADMIN = Config.getPropiedad("alfresco.repository.location.admin.usario");
	private static final String CLAVE_ADMIN = Config.getPropiedad("alfresco.repository.location.admin.clave");

	private static final String ESPACIO_REPOSITORIO = Config.getPropiedad("alfresco.repository.location.space.documentos.html");
	private static final String CARPETA_ECUS = Config.getPropiedad("alfresco.repository.location.space.ecus");
	private static final String CARPETA_PROYECTOS = Config.getPropiedad("alfresco.repository.location.space.proyectos");

	private static AuthoringServiceSoapBindingStub authoringService;
	private static ContentServiceSoapBindingStub contentService;
	private static RepositoryServiceSoapBindingStub repositoryService;
	private static ParentReference companyHomeParent;

	public static class AlfresoConstantes {
		public final static Integer ERROR_CONEXION = -1;
		public final static Integer TERMINO_SESSION = 1;
		public final static Integer ERROR_TERMINO_SESSION = 1;
		public final static Integer USUARIO_AUNTENTICADO = 1;
		public final static Integer USUARIO_NO_AUNTENTICADO = 0;
		public final static Integer SIN_CONEXION_AL_END_POINT = -1;

		private static final Store STORE = new Store(Constants.WORKSPACE_STORE, "SpacesStore");
		private static final String MI_CARPETA_HOME = "/app:company_home";
		private static final String ASSOC_CONTAINS = "{http://www.alfresco.org/model/content/1.0}contains";

	}

	public AlfrescoServiceConexion() {
		logger.info("Inciando Bean AlfrescoServiceConexion");
		WebServiceFactory.setEndpointAddress(STR_ALFRESCO_END_POINT);
		iniciarConexion();
		if (ISCONEXION) {
			setAuthoringService(WebServiceFactory.getAuthoringService());
			setContentService(WebServiceFactory.getContentService());
			setRepositoryService(WebServiceFactory.getRepositoryService());
			companyHome();
		}
		terminarConexion();
	}

	public int iniciarConexion() {
		try {
			logger.info("Usuario autenticado");
			if (ISCONEXION) {
				AuthenticationUtils.startSession(USUARIO_ADMIN, CLAVE_ADMIN);
				return AlfresoConstantes.USUARIO_AUNTENTICADO;
			}
		} catch (AuthenticationFault e) {
			logger.info("Error al authenticar : " + e.getMessage() + " | " + e.getCause() + " | " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error : " + e.getMessage() + " | " + e.getCause() + " | " + e.getLocalizedMessage());
		}
		ISCONEXION = false;
		return AlfresoConstantes.USUARIO_NO_AUNTENTICADO;
	}

	public int terminarConexion() {
		try {
			logger.info("Usuario terminar Conexion");
			if (ISCONEXION) {
				AuthenticationUtils.endSession();
				return AlfresoConstantes.TERMINO_SESSION;
			}
		} catch (Exception e) {
			logger.info("Error al terminarConexion : " + e.getMessage() + " | " + e.getCause() + " | " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		return AlfresoConstantes.ERROR_TERMINO_SESSION;
	}

	public Reference obtenerCarpetaProyectos() {
		if(ISCONEXION){
			String ruta_completa = companyHomeParent.getPath() + "/cm:" + normilizeNodeName(ESPACIO_REPOSITORIO) + "/cm:" + normilizeNodeName(CARPETA_ECUS) + "/cm:" + normilizeNodeName(CARPETA_PROYECTOS);
			logger.info("obtener Carpeta Proyectos en :" + ruta_completa);
			Reference spacereference = existeEspacioCarpeta(ruta_completa);
			if (spacereference == null) {
				logger.info("No existe. Se creara uno nuevo");
				spacereference = crearNuevoEspacioCarpeta(normilizeNodeName(ESPACIO_REPOSITORIO),normilizeNodeName(CARPETA_ECUS), normilizeNodeName(CARPETA_PROYECTOS));
			}
			return spacereference;
		}
		return null;
	}

	public Reference crearSubCarpetaProyecto(String str_proyecto){
		if(ISCONEXION){
			String proyectos = companyHomeParent.getPath() + "/cm:" + normilizeNodeName(ESPACIO_REPOSITORIO) + "/cm:" + normilizeNodeName(CARPETA_ECUS) + "/cm:" + normilizeNodeName(CARPETA_PROYECTOS);
			logger.info("crearSubCarpetaProyecto obtener Carpeta Proyectos en :" + proyectos);
			try {
				Reference spacereference = obtenerSubCarpetaProyecto(str_proyecto);
				if(spacereference==null){
					spacereference = createEspacioTrabajo(proyectos, str_proyecto);					
				}						
				logger.info("Proyecto creado : " +str_proyecto +" en :" + proyectos );
				return spacereference;
			} catch (Exception e) {
				logger.info("No se puede crear");
				logger.info("Can not create the space " + e.getMessage() );
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Reference obtenerSubCarpetaProyecto(String str_proyecto){
		if(ISCONEXION){
			String ruta_completa = companyHomeParent.getPath() + "/cm:" + normilizeNodeName(ESPACIO_REPOSITORIO) + "/cm:" + normilizeNodeName(CARPETA_ECUS) + "/cm:" + normilizeNodeName(CARPETA_PROYECTOS)+ "/cm:"+normilizeNodeName(str_proyecto);
			logger.info("obtenerSubCarpetaProyecto en :" + ruta_completa);
			try {
				Reference spacereference = existeEspacioCarpeta(ruta_completa);
				return spacereference;
			} catch (Exception e) {
				logger.info("No encontrado");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private Reference crearNuevoEspacioCarpeta(String... carpetas) {
		if(ISCONEXION){
			if(carpetas!=null && carpetas.length >0 ){
				Reference spacereference = null;
				logger.info("Creando las "+carpetas.length+" siguientes carpetas ");
				String ruta_completa = companyHomeParent.getPath();
				String ruta_padre = companyHomeParent.getPath();
				for (int i = 0; i < carpetas.length; i++) {
					String folder = carpetas[i];
					ruta_completa += "/cm:" + normilizeNodeName(folder);
					logger.info("Ruta valida : " + ruta_completa);
					try {
						spacereference = createEspacioTrabajo(ruta_padre, folder);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("Can not create the space " + e.getMessage() );
						return null;
					}				
					ruta_padre = ruta_completa;
				}
				return spacereference;
			}
		}
		return null;
	}

	private Reference createEspacioTrabajo(String ruta_padre, String carpeta) throws Exception {
		if(ISCONEXION){
			Reference space = null;
			logger.info("The space named " + carpeta + " does not exist. Creating it.");
			ParentReference companyHome = new ParentReference(AlfresoConstantes.STORE, null, ruta_padre, Constants.ASSOC_CONTAINS, null);
			// Set Company Home as the parent space
			companyHome.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL, normilizeNodeName(carpeta)));
			// Set the space's property name
			NamedValue[] properties = new NamedValue[] { Utils.createNamedValue(Constants.PROP_NAME, carpeta) };
			// Create the space using CML (Content Manipulation Language)
			CMLCreate create = new CMLCreate("1", companyHome, null, null, null, Constants.TYPE_FOLDER, properties);
			CML cml = new CML();
			cml.setCreate(new CMLCreate[] { create });
			// Execute the CML create statement
			try {
				repositoryService.update(cml);
				space = new Reference(AlfresoConstantes.STORE, null, ruta_padre + "/cm:" + carpeta);
				repositoryService.get(new Predicate(new Reference[] { space }, AlfresoConstantes.STORE, null));
				logger.info("Espacio creado : "+carpeta + " en :"+ruta_padre);
				return space;
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Can not create the space.");
				throw new Exception("No se puede crear "+ruta_padre+" : " +carpeta + " || "+ e.getMessage());
			}
		}
		return null;
	}

	private Reference existeEspacioCarpeta(String ruta_completa) {
		try {
			Reference spacereference = new Reference(AlfresoConstantes.STORE, null, ruta_completa);
			repositoryService.get(new Predicate(new Reference[] { spacereference }, AlfresoConstantes.STORE, null));
			logger.info("Si existe el Espacio");
			return spacereference;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("No existe el Espacio");
		}
		return null;
	}

	public void companyHome() {
		companyHomeParent = new ParentReference(AlfresoConstantes.STORE, null, AlfresoConstantes.MI_CARPETA_HOME, Constants.ASSOC_CONTAINS, null);
		logger.info(" iniciando companyHome ");
	}

	protected String normilizeNodeName(String name) {
		return name.replace(" ", "_");
	}

	// private static AuthoringServiceSoapBindingStub getAuthoringService() {
	// return authoringService;
	// }

	private static void setAuthoringService(AuthoringServiceSoapBindingStub authoringService) {
		AlfrescoServiceConexion.authoringService = authoringService;
	}

	// private static ContentServiceSoapBindingStub getContentService() {
	// return contentService;
	// }

	private static void setContentService(ContentServiceSoapBindingStub contentService) {
		AlfrescoServiceConexion.contentService = contentService;
	}

	// private static RepositoryServiceSoapBindingStub getRepositoryService() {
	// return repositoryService;
	// }

	private static void setRepositoryService(RepositoryServiceSoapBindingStub repositoryService) {
		AlfrescoServiceConexion.repositoryService = repositoryService;
	}

}
