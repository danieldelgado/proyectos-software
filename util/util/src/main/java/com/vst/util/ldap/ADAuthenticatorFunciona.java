package com.vst.util.ldap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class ADAuthenticatorFunciona {

	private String domain;
	private String ldapHost;
	private String searchBase;
	LdapContext ldapConext = null;
	Hashtable<String, Object> env2 = new Hashtable<String, Object>();

	public ADAuthenticatorFunciona() {
		this.domain = "vst.server01.com";
		this.ldapHost = "ldap://192.168.1.37:389";
		this.searchBase = "ou=usuario-server01,dc=vst,dc=server01,dc=com";
	}

	public ADAuthenticatorFunciona(String domain, String host, String dn) {
		this.domain = domain;
		this.ldapHost = host;
		this.searchBase = dn;
	}

	public void newInstanceContext(String user, String pass) {
		env2.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env2.put(Context.PROVIDER_URL, ldapHost);
		env2.put(Context.SECURITY_AUTHENTICATION, "simple");
		env2.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env2.put(Context.SECURITY_CREDENTIALS, pass);

		try {
			ldapConext = new InitialLdapContext(env2, null);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void printUserBasicAttributes(String username, LdapContext ctx) {
		try {

			// SearchControls constraints = new SearchControls();
			// constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			// // NOTE: The attributes mentioned in array below are the ones
			// that
			// // will be retrieved, you can add more.
			// String[] attrIDs = { "distinguishedName", "sn", "givenname",
			// "mail", "telephonenumber", "canonicalName", "userAccountControl",
			// "accountExpires" };
			// constraints.setReturningAttributes(attrIDs);
			String returnedAtts[] = { "sAMAccountName", "givenName", "cn", "mail" };
			// Create the search controls
			SearchControls searchCtls = new SearchControls();
			searchCtls.setReturningAttributes(returnedAtts);
			// Specify the search scope
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			String searchFilter = "(|(objectClass=user)(sAMAccountName=" + username + "))";

			// NOTE: replace DC=domain,DC=com below with your domain info. It is
			// essentially the Base Node for Search.
			NamingEnumeration answer = ctx.search("ou=usuario-server01,dc=vst,dc=server01,dc=com", searchFilter, searchCtls);

			while (answer.hasMore()) {
				Attributes attrs = ((SearchResult) answer.next()).getAttributes();
				
				System.out.println(attrs.get("distinguishedName"));
				System.out.println(attrs.get("givenname"));
				System.out.println(attrs.get("sn"));
				System.out.println(attrs.get("mail"));
				System.out.println(attrs.get("telephonenumber"));
				System.out.println(attrs.get("canonicalName"));
				System.out.println(attrs.get("userAccountControl"));
				System.out.println(attrs.get("accountExpires"));
				System.out.println(attrs.get("userPrincipalName"));
				System.out.println("--------------------------------------");
			}

			// else {
			// throw new Exception("Invalid User");
			// }
			ldapConext.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateUsuario(String update) {
		try {
			ModificationItem[] mods = new ModificationItem[2];
			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("mail", update+"@vst.server01.com"));
			
			// Add additional value to "telephonenumber"//ADD_ATTRIBUTE
			mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("telephonenumber", "+1 555 555 5555"));
			DirContext ctx = new InitialDirContext(env2);
			ctx.modifyAttributes("cn="+update+",ou=usuario-server01,dc=vst,dc=server01,dc=com", mods);
			
			ctx.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Map<String, Object>> authenticate(String user, String pass) {

		LdapContext ctxGC = null;

		Hashtable<String, Object> env = new Hashtable<String, Object>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapHost);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env.put(Context.SECURITY_CREDENTIALS, pass);

		String returnedAtts[] = { "sAMAccountName", "givenName", "cn", "mail" };
		// Create the search controls
		SearchControls searchCtls = new SearchControls();
		searchCtls.setReturningAttributes(returnedAtts);
		// Specify the search scope
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		String searchFilter = "(|(objectClass=user)(sAMAccountName=" + user + "))";

		try {
			ctxGC = new InitialLdapContext(env, null);

			// Search objects in GC using filters
			NamingEnumeration<SearchResult> answer = ctxGC.search(searchBase, searchFilter, searchCtls);
			List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				Map<String, Object> amap = null;
				if (attrs != null) {
					amap = new HashMap<String, Object>();
					NamingEnumeration<? extends Attribute> ne = attrs.getAll();
					while (ne.hasMore()) {
						Attribute attr = (Attribute) ne.next();
						amap.put(attr.getID(), attr.get());
					}
					ne.close();
				}
				lst.add(amap);
			}
			answer.close();
			ctxGC.close();
			return lst;
		} catch (NamingException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private void registrarNuevoUsuario(String user, String pass, String usuario, String clpass) {

		LdapContext ctxGC = null;
		Hashtable<String, Object> env = new Hashtable<String, Object>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapHost);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env.put(Context.SECURITY_CREDENTIALS, "");

		try {
			ctxGC = new InitialLdapContext(env, null);
			BasicAttributes attrs = new BasicAttributes();
			Attribute classes = new BasicAttribute("objectclass");
			classes.add("top");
			classes.add("person");
			classes.add("organizationalPerson");
			classes.add("user");
			Attribute userPassword = new BasicAttribute("userpassword", clpass);
			attrs.put(classes);
			attrs.put("sn", "Tippin");
			attrs.put("sn", usuario);
			// attrs.put("msDS-UserAccountDisabled", "FALSE");
			// attrs.put("msDS-UserDontExpirePassword", "TRUE");
			attrs.put("name", usuario + " nuevoUsuario");
			attrs.put("displayName", usuario);
			attrs.put("givenName", usuario);
			attrs.put("title", "Nuevo");
			attrs.put("mail", usuario + "@vst.server01.com");			
			attrs.put("telephonenumber", "+516 6846 4654");
			attrs.put(userPassword);
			ctxGC.createSubcontext("cn=" + usuario + ",ou=usuario-server01,dc=vst,dc=server01,dc=com", attrs);
			ctxGC.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removeUser(String username, String groupName) throws NamingException {
		try {
			ldapConext.destroySubcontext("cn=" + username + ",ou=usuario-server01,dc=vst,dc=server01,dc=com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGroup(String groupName) throws NamingException {
		try {
			ldapConext.destroySubcontext("ou=" + groupName + ",dc=vst,dc=server01,dc=com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addGroup(String name, String description) throws NamingException {

		// Create a container set of attributes
		Attributes container = new BasicAttributes();

		// Create the objectclass to add
		Attribute objClasses = new BasicAttribute("objectClass");
		objClasses.add("organizationalUnit");
		objClasses.add("top");
		// objClasses.add("groupOfUniqueNames");
		// objClasses.add("groupOfForethoughtNames");

		// Assign the name and description to the group
		Attribute cn = new BasicAttribute("cn", name);
		Attribute desc = new BasicAttribute("description", description);
		Attribute distinguishedName = new BasicAttribute("distinguishedName", "ou=" + name + ",DC=vst,DC=server01,DC=com");
		Attribute nameGroup = new BasicAttribute("name", name);
		// Add these to the container
		container.put(objClasses);
		container.put(cn);
		container.put(desc);
		container.put(nameGroup);
		container.put(distinguishedName);

		// Create the entry
		ldapConext.createSubcontext("ou=" + name + ",dc=vst,dc=server01,dc=com", container);
	}

	public LdapContext getLdapConext() {
		return ldapConext;
	}

	public void setLdapConext(LdapContext ldapConext) {
		this.ldapConext = ldapConext;
	}
	
	

	public Hashtable<String, Object> getEnv2() {
		return env2;
	}

	public void setEnv2(Hashtable<String, Object> env2) {
		this.env2 = env2;
	}

	public static void main(String[] args) {
		ADAuthenticatorFunciona a = new ADAuthenticatorFunciona();
		// System.out.println(a.authenticate("Administrator", ""));
		// a = new
		// ADAuthenticatorFunciona("vst.server01.com","ldap://VST-SERVER01:389",
		// "cn=cliente02,ou=usuario-server01,dc=vst,dc=server01,dc=com");
		// System.out.println(a.authenticate("Administrator", ""));
		// a = new
		// ADAuthenticatorFunciona("vst.server01.com","ldap://VST-SERVER01:389",
		// "cn=cliente01,ou=usuario-server01,dc=vst,dc=server01,dc=com");
		// System.out.println(a.authenticate("Administrator", ""));
		try {

			a.newInstanceContext("Administrator", "");
			// a.removeUser("nuevousuario02", "");
			// a.registrarNuevoUsuario("Administrator", "", "nuevousuario02",
			// "qwaszx123");
			// a.removeGroup("otroGrupo");
			// a.addGroup("otroGrupo", "grupostest");
//			a.updateUsuario("nuevousuario02");
			a.printUserBasicAttributes("nuevousuario02", a.getLdapConext());
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}