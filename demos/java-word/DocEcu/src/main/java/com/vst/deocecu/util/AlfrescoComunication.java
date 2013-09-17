
package com.vst.deocecu.util;

import java.net.URL;

import org.alfresco.webservice.authentication.AuthenticationService;
import org.alfresco.webservice.authentication.AuthenticationServiceLocator;
import org.alfresco.webservice.authentication.AuthenticationServiceSoapPort;
import org.alfresco.webservice.content.ContentServiceSoapBindingStub;
import org.alfresco.webservice.repository.UpdateResult;
import org.alfresco.webservice.types.CML;
import org.alfresco.webservice.types.CMLAddAspect;
import org.alfresco.webservice.types.CMLCreate;
import org.alfresco.webservice.types.ContentFormat;
import org.alfresco.webservice.types.NamedValue;
import org.alfresco.webservice.types.ParentReference;
import org.alfresco.webservice.types.Reference;
import org.alfresco.webservice.types.Store;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.Constants;
import org.alfresco.webservice.util.Utils;
import org.alfresco.webservice.util.WebServiceFactory;

public class AlfrescoComunication  
{  
	
	public static void main(String[] args) {
		try {
			addContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
     public static void addContent()  throws Exception{  
          
     
          
         try  
        {  
        	 
        	   //Iniciamos la sesion 
         	
             WebServiceFactory.setEndpointAddress("http://192.168.1.215:8080/alfresco/api");
            AuthenticationUtils.startSession("admin", "admin");   
        	 
            // Creamos la referencia del nodo padre, donde se añadirá  el contenido  
            // En este caso el nodo padre es company_home  
            Store storeRef = new Store(Constants.WORKSPACE_STORE, "SpacesStore");  
            ParentReference companyHomeParent = new ParentReference(storeRef, null, "/app:company_home", Constants.ASSOC_CONTAINS, null);  
  
            // Asignamos un nombre para el nodo que vamos a crea en company_home  
            String name = "Web Services sample (" + System.currentTimeMillis() + ")";  
            companyHomeParent.setChildName("cm:" + name);  
              
            // Comienza la construcción de nodo   
              
            NamedValue[] contentProps = new NamedValue[1];   
            contentProps[0] = Utils.createNamedValue(Constants.PROP_NAME, name);   
            CMLCreate create = new CMLCreate("1", companyHomeParent, null, null, null, Constants.TYPE_CONTENT, contentProps);  
              
            // Añadimos aspectos al nodo  
              
            NamedValue[] titledProps = new NamedValue[2];  
            titledProps[0] = Utils.createNamedValue(Constants.PROP_TITLE, name);  
            titledProps[1] = Utils.createNamedValue(Constants.PROP_DESCRIPTION, name);  
            CMLAddAspect addAspect = new CMLAddAspect(Constants.ASPECT_TITLED, titledProps, null, "1");  
              
              
            // Contruimos CML Block, con el nodo y sus aspectos  
              
            CML cml = new CML();  
            cml.setCreate(new CMLCreate[] {create});  
            cml.setAddAspect(new CMLAddAspect[] {addAspect});  
  
              
            // Creamos y recuperamos el contenido vía Repository Web Service  

            UpdateResult[] result = WebServiceFactory.getRepositoryService().update(cml);
            Reference content = result[0].getDestination();  
  
            //  
            // Escribimos el contenido  
            //  
              
            ContentServiceSoapBindingStub contentService = WebServiceFactory.getContentService();  
            String text = "The quick brown fox jumps over the lazy dog";  
            ContentFormat contentFormat = new ContentFormat("text/plain", "UTF-8");  
            contentService.write(content, Constants.PROP_CONTENT, text.getBytes(), contentFormat);  
              System.out.println(" termino ");
        }  catch (Exception e) {
			e.printStackTrace();
		}
          
        finally  
        {  
            // Finalizamos la sesión  
            AuthenticationUtils.endSession();  
  
        }      
       
     }  
}  