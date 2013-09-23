package org.alfresco.sample.webservice;

import java.rmi.RemoteException;

import org.alfresco.webservice.authentication.AuthenticationFault;
import org.alfresco.webservice.authentication.AuthenticationResult;
import org.alfresco.webservice.authentication.AuthenticationServiceSoapBindingStub;
import org.alfresco.webservice.authoring.AuthoringServiceSoapBindingStub;
import org.alfresco.webservice.authoring.CheckoutResult;
import org.alfresco.webservice.content.Content;
import org.alfresco.webservice.content.ContentServiceSoapBindingStub;
import org.alfresco.webservice.repository.RepositoryFault;
import org.alfresco.webservice.repository.RepositoryServiceSoapBindingStub;
import org.alfresco.webservice.repository.UpdateResult;
import org.alfresco.webservice.types.CML;
import org.alfresco.webservice.types.CMLAddAspect;
import org.alfresco.webservice.types.CMLCreate;
import org.alfresco.webservice.types.ContentFormat;
import org.alfresco.webservice.types.NamedValue;
import org.alfresco.webservice.types.Node;
import org.alfresco.webservice.types.ParentReference;
import org.alfresco.webservice.types.Predicate;
import org.alfresco.webservice.types.Reference;
import org.alfresco.webservice.types.Store;
import org.alfresco.webservice.types.Version;
import org.alfresco.webservice.types.VersionHistory;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.Constants;
import org.alfresco.webservice.util.ContentUtils;
import org.alfresco.webservice.util.Utils;
import org.alfresco.webservice.util.WebServiceFactory;

public class TestMetodos {

	public static String ticket;
	public static final String USERNAME = "admin";
	public static final String PASSWORD = "admin";
	public static final String END_POINT = "http://192.168.1.38:8095/alfresco/api";
	public static final String MI_FOLDER = "MI_FOLDER";
	public static final String MI_STORE = "SpacesStore";
	public static final String MI_CARPETA_HOME = "/app:company_home";
	private static final String ASSOC_CONTAINS = "{http://www.alfresco.org/model/content/1.0}contains";
	protected final Store STORE = new Store(Constants.WORKSPACE_STORE, "SpacesStore");

	public static boolean spaceUsercreate = false;

	static {
		WebServiceFactory.setEndpointAddress(END_POINT);
	}

	public static void main(String[] args) {
		TestMetodos test = new TestMetodos();
		System.out.println(test.obtenerTiket());
		try {
			Reference r = test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "Documentador", "index");
			System.out.println("Reference");
			System.out.println(r);
//			test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "Documentador", "ecu01");
//			test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "Documentador", "ecu02");
//			test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "Documentador", "ecu03");
//			test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "Documentador", "ecu04");
//			test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "hsd", "index");
//			test.createSpaceInSpace("Documentos html", "ecus", "proyectos", "hsd", "ecu01");
			test.crearNuevoContenido(r,"contentWEB"+System.currentTimeMillis()+".html", "<html> <body> nuevo s contenido web </body> </html>", "html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// test.crearNuevoContenido("contentTEXT1.txt","holaasads este contenido",
		// "texto");
		// System.out.println("version antes:");
		// test.obtenetContenido("contentWEB2123.html");
		// System.out.println("modificando...:");
		// test.modificarContenido("contentWEB2123.html", "<html> <body> nuevo "
		// + System.currentTimeMillis()+
		// " sfew wewfewf contenido web </body> </html>");
		// System.out.println("version modificada...:");
		// test.obtenetContenido("contentWEB2123.html");
		// test.obtenetContenido("contentTEXT1.txt");
		test.termino();
	}

	private Reference createSpaceInSpace(String space, String... foldersHijpos) throws Exception {
		String ruta_completa = getCompanyHome().getPath() + "/cm:" + normilizeNodeName(space);
		String ruta_padre = getCompanyHome().getPath();
		Reference spacereference = null;
		try {
			spacereference = new Reference(STORE, null, ruta_completa);
			getRepositoryService().get(new Predicate(new Reference[] { spacereference }, STORE, null));
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			spacereference = createEspacioTrabajo(ruta_padre, space);
		}
		ruta_padre = ruta_completa;

		for (int i = 0; i < foldersHijpos.length; i++) {
			String folder = foldersHijpos[i];
			ruta_completa += "/cm:" + folder;
			System.out.println(folder + " --- " + ruta_completa);

			try {
				spacereference = new Reference(STORE, null, ruta_completa);
				getRepositoryService().get(new Predicate(new Reference[] { spacereference }, STORE, null));
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
				spacereference =createEspacioTrabajo(ruta_padre, folder);
			}
			ruta_padre = ruta_completa;

		}
		
		return spacereference;
	}

	private Reference createEspacioTrabajo(String ruta_padre, String carpeta) {

		Reference space = null;
		System.out.println("The space named " + carpeta + " does not exist. Creating it.");

		ParentReference companyHome = new ParentReference(STORE, null, ruta_padre, Constants.ASSOC_CONTAINS, null);
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
			getRepositoryService().update(cml);

			space = new Reference(STORE, null, ruta_padre + "/cm:" + carpeta);
			getRepositoryService().get(new Predicate(new Reference[] { space }, STORE, null));

		} catch (Exception e2) {

			System.err.println("Can not create the space.");
		}

		return space;
	}

	protected ParentReference getCompanyHome() {
		ParentReference companyHomeParent = new ParentReference(STORE, null, "/app:company_home", Constants.ASSOC_CONTAINS, null);
		return companyHomeParent;
	}

	protected String normilizeNodeName(String name) {
		return name.replace(" ", "_");
	}

	protected Reference createSpace(String spacename) throws Exception {
		Reference space = null;

		// Create the space if it is not already existent
		try {

			// Therefore a reference to the maybe not existent space is required

			System.out.println("Entering space " + spacename);

			space = new Reference(STORE, null, getCompanyHome().getPath() + "/cm:" + normilizeNodeName(spacename));
			getRepositoryService().get(new Predicate(new Reference[] { space }, STORE, null));
		} catch (Exception e1) {
			System.out.println("The space named " + spacename + " does not exist. Creating it.");

			ParentReference companyHome = getCompanyHome();

			// Set Company Home as the parent space
			companyHome.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL, normilizeNodeName(spacename)));

			// Set the space's property name
			NamedValue[] properties = new NamedValue[] { Utils.createNamedValue(Constants.PROP_NAME, spacename) };

			// Create the space using CML (Content Manipulation Language)
			CMLCreate create = new CMLCreate("1", companyHome, null, null, null, Constants.TYPE_FOLDER, properties);
			CML cml = new CML();
			cml.setCreate(new CMLCreate[] { create });

			// Execute the CML create statement
			try {
				getRepositoryService().update(cml);
			} catch (Exception e2) {

				System.err.println("Can not create the space.");
				throw e2;
			}

		}

		return space;
	}

	private void buscarFolder(String string) throws RepositoryFault, RemoteException {
		String mifolder = "Documentos_html";
		String mistore = "SpacesStore";
		String micarpeta = "/app:user_homes";
		// private static final String ASSOC_CONTAINS =
		// "{http://www.alfresco.org/model/content/1.0}contains";
		Store store = new Store(Constants.WORKSPACE_STORE, mistore);
		Reference samplefolder = new Reference(store, null, micarpeta + "/cm:" + mifolder);
		Node[] node = null;
		try {
			System.out.println("Buscando si existe este espacio " + mifolder);
			node = WebServiceFactory.getRepositoryService().get(new Predicate(new Reference[] { samplefolder }, store, null));
			System.out.println("Si existe el espacio " + mifolder);
			System.out.println(node.length);
			System.out.println(node[0]);
		} catch (Exception e) {
			System.out.println("No encontro y lanzo una excepcion asi que ahora a crear este espacio");
			e.printStackTrace();
		}

		if (node != null) {
			return;
		}
		System.out.println("crear");
		ParentReference parentReference = new ParentReference(store, null, micarpeta, Constants.ASSOC_CONTAINS, Constants.createQNameString(
				Constants.NAMESPACE_CONTENT_MODEL, mifolder));

		// Create folder
		NamedValue[] properties = new NamedValue[] { Utils.createNamedValue(Constants.PROP_NAME, mifolder) };
		CMLCreate create = new CMLCreate("1", parentReference, null, null, null, Constants.TYPE_FOLDER, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[] { create });
		WebServiceFactory.getRepositoryService().update(cml);
		System.out.println("creando MI_FOLDER:" + mifolder);

	}

	public RepositoryServiceSoapBindingStub getRepositoryService() {
		return WebServiceFactory.getRepositoryService();
	}

	public ContentServiceSoapBindingStub getContentService() {
		return WebServiceFactory.getContentService();
	}

	public TestMetodos() {
		try {
			AuthenticationUtils.startSession(USERNAME, PASSWORD);
			System.out.println("conectado");
		} catch (AuthenticationFault e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modificarContenido(String str, String nuevoContenido) {

		try {
			AuthoringServiceSoapBindingStub authoringService = WebServiceFactory.getAuthoringService();
			ContentServiceSoapBindingStub contentService = WebServiceFactory.getContentService();
			Store STORE = new Store(Constants.WORKSPACE_STORE, MI_STORE);
			Reference reference = new Reference(STORE, null, MI_CARPETA_HOME + "/cm:" + MI_FOLDER + "/*[@cm:name=\"" + str + "\"]");
			ContentFormat format = new ContentFormat(Constants.MIMETYPE_TEXT_PLAIN, "UTF-8");
			Predicate itemsToCheckOut = new Predicate(new Reference[] { reference }, null, null);
			CheckoutResult checkOutResult = authoringService.checkout(itemsToCheckOut, null);
			Reference workingCopyReference = checkOutResult.getWorkingCopies()[0];
			contentService.write(workingCopyReference, Constants.PROP_CONTENT, nuevoContenido.getBytes(), format);
			Predicate predicate = new Predicate(new Reference[] { workingCopyReference }, null, null);

			NamedValue[] comments = new NamedValue[] { Utils.createNamedValue("description",
					"The content has been updated " + System.currentTimeMillis()) };
			authoringService.checkin(predicate, comments, false);

		} catch (Exception e) {
			System.out.println("e:" + e.getMessage());
			e.printStackTrace();
		}

	}

	private static void outputVersion(Version version) {
		String description = "none";
		for (NamedValue namedValue : version.getCommentaries()) {
			// System.out.println("namedValue.getName():"+namedValue.getName());
			// System.out.println("namedValue.getValue():"+namedValue.getValue());
			if (namedValue.getName().equals("description") == true) {
				description = namedValue.getValue();
			}
		}
		System.out.println("Version label = " + version.getLabel() + "; Version description = " + description);
	}

	private void obtenetContenido(String str) {
		try {
			AuthoringServiceSoapBindingStub authoringService = WebServiceFactory.getAuthoringService();
			ContentServiceSoapBindingStub contentService = WebServiceFactory.getContentService();
			Store STORE = new Store(Constants.WORKSPACE_STORE, MI_STORE);
			Reference reference = new Reference(STORE, null, MI_CARPETA_HOME + "/cm:" + MI_FOLDER + "/*[@cm:name=\"" + str + "\"]");
			Content[] readResult = contentService.read(new Predicate(new Reference[] { reference }, STORE, null), Constants.PROP_CONTENT);
			Content content = readResult[0];
			System.out.println(ContentUtils.getContentAsString(content));
			VersionHistory versionHistory = authoringService.getVersionHistory(reference);
			for (Version version : versionHistory.getVersions()) {
				outputVersion(version);
			}
		} catch (RepositoryFault e) {
			System.out.println("e1:" + e.getMessage());
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("e2:" + e.getMessage());
			e.printStackTrace();
		}

	}

	private void termino() {
		AuthenticationUtils.endSession();
		System.out.println("terminado");
	}

	private void crearFolder() throws RepositoryFault, RemoteException {
		// public static final String MI_FOLDER = "MI_FOLDER";
		// public static final String MI_STORE = "SpacesStore";
		// public static final String MI_CARPETA_HOME = "/app:company_home";
		// private static final String ASSOC_CONTAINS =
		// "{http://www.alfresco.org/model/content/1.0}contains";
		Store STORE = new Store(Constants.WORKSPACE_STORE, MI_STORE);
		Reference SAMPLE_FOLDER = new Reference(STORE, null, MI_CARPETA_HOME + "/cm:" + MI_FOLDER);
		Node[] node = null;
		try {
			System.out.println("Buscando si existe este espacio " + MI_FOLDER);
			node = WebServiceFactory.getRepositoryService().get(new Predicate(new Reference[] { SAMPLE_FOLDER }, STORE, null));
			System.out.println("Si existe el espacio " + MI_FOLDER);
			System.out.println(node.length);
			System.out.println(node[0]);
		} catch (Exception e) {
			System.out.println("No encontro y lanzo una excepcion asi que ahora a crear este espacio");
			e.printStackTrace();
		}
		if (node != null) {
			return;
		}
		System.out.println("crear");
		ParentReference parentReference = new ParentReference(STORE, null, MI_CARPETA_HOME, Constants.ASSOC_CONTAINS, Constants.createQNameString(
				Constants.NAMESPACE_CONTENT_MODEL, MI_FOLDER));

		// Create folder
		NamedValue[] properties = new NamedValue[] { Utils.createNamedValue(Constants.PROP_NAME, "Web Service " + MI_FOLDER) };
		CMLCreate create = new CMLCreate("1", parentReference, null, null, null, Constants.TYPE_FOLDER, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[] { create });
		WebServiceFactory.getRepositoryService().update(cml);
		System.out.println("creando MI_FOLDER:" + MI_FOLDER);

	}

	private void crearNuevoContenido(Reference r, String nombreContenido, String content, String tipo) {
		ContentServiceSoapBindingStub contentService = WebServiceFactory.getContentService();
		RepositoryServiceSoapBindingStub repositoryService = WebServiceFactory.getRepositoryService();
		try {
			Reference contentReference = createNewContent(r,contentService, nombreContenido, content, tipo);
			System.out.println("contentReference : " + contentReference);
			makeVersionable(repositoryService, contentReference);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void makeVersionable(RepositoryServiceSoapBindingStub respositoryService, Reference reference) throws Exception {
		Predicate predicate = new Predicate(new Reference[] { reference }, null, null);
		CMLAddAspect addAspect = new CMLAddAspect(Constants.ASPECT_VERSIONABLE, null, predicate, null);
		CML cml = new CML();
		cml.setAddAspect(new CMLAddAspect[] { addAspect });
		respositoryService.update(cml);
	}

	public static Reference createNewContent(Reference r, ContentServiceSoapBindingStub contentService, String name, String contentString, String tipo)
			throws Exception {
		System.out.println("r.getPath()"+r.getPath());
		Store STORE = new Store(Constants.WORKSPACE_STORE, MI_STORE);
		ParentReference parentReference = new ParentReference(STORE, null, r.getPath(), ASSOC_CONTAINS, "{"
				+ Constants.NAMESPACE_CONTENT_MODEL + "}" + name);
		ContentFormat contentFormat = null;
		if (tipo.equalsIgnoreCase("html")) {
			// contentFormat = new ContentFormat("application/msword", "UTF-8");
			contentFormat = new ContentFormat("plain/text", "UTF-8");
		}
		if (tipo.equalsIgnoreCase("txt")) {
			contentFormat = new ContentFormat("plain/text", "UTF-8");
		}
		if (tipo.equalsIgnoreCase("pdf")) {
			contentFormat = new ContentFormat("application/pdf", "UTF-8");
		}
		NamedValue[] properties = new NamedValue[] { Utils.createNamedValue(Constants.PROP_NAME, name) };
		CMLCreate create = new CMLCreate("1", parentReference, null, null, null, Constants.TYPE_CONTENT, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[] { create });
		UpdateResult[] result = WebServiceFactory.getRepositoryService().update(cml);
		Reference newContentNode = result[0].getDestination();
		Content content = contentService.write(newContentNode, Constants.PROP_CONTENT, contentString.getBytes(), contentFormat);
		return content.getNode();
	}

	private String obtenerTiket() {
		AuthenticationServiceSoapBindingStub authService = WebServiceFactory.getAuthenticationService();
		AuthenticationResult authenticationResult;
		try {
			authenticationResult = authService.startSession(USERNAME, PASSWORD);
			ticket = authenticationResult.getTicket();
			System.out.println(authenticationResult.getSessionid());
			System.out.println(authenticationResult.getUsername());
		} catch (AuthenticationFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ticket;
	}

}
