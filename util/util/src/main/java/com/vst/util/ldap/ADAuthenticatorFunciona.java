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
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class ADAuthenticatorFunciona {
	
	private String domain;
	private String ldapHost;
	private String searchBase;

	public ADAuthenticatorFunciona() {
		this.domain = "vst.server01.com";
		this.ldapHost = "ldap://192.168.1.180:389";
		this.searchBase = "ou=usuario-server01,dc=vst,dc=server01,dc=com";
	}

	 public ADAuthenticatorFunciona(String domain, String host, String dn) {
		 this.domain = domain;
		 this.ldapHost = host;
		 this.searchBase = dn;
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

	public static void main(String[] args) {
		ADAuthenticatorFunciona a = new ADAuthenticatorFunciona();
		System.out.println(a.authenticate("Administrator", ""));
		a = new ADAuthenticatorFunciona("vst.server01.com", "ldap://VST-SERVER01:389", "cn=cliente02,ou=usuario-server01,dc=vst,dc=server01,dc=com");
		System.out.println(a.authenticate("Administrator", ""));
		a = new ADAuthenticatorFunciona("vst.server01.com", "ldap://VST-SERVER01:389", "cn=cliente01,ou=usuario-server01,dc=vst,dc=server01,dc=com");
		System.out.println(a.authenticate("Administrator", ""));
	}

}