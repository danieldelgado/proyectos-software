package com.svn.SVNTest;


public class App {

	
	public static void main( String[] args ) {
        String username = "danieldelgado22g@gmail.com";
        String password =  "pf4KA5ng4kp7";
        String svn_url =  "https://proyectos-software.googlecode.com/svn/trunk/demos/AsyncTask-UI/android-hilos-asynctask/bin/";
        String folder_checkOut =  "C:\\svn\\checkout";
        String proyecto =  "prueba01svn";
//        boolean createIsNotExistsfolder =  true;
        folder_checkOut = folder_checkOut.concat("\\").concat(proyecto);        
        SVNKitUtil svnKitUtil = new SVNKitUtil(svn_url, folder_checkOut, username, password);

        try {
	        SVNKitService svnKitService = new SVNKitService(svnKitUtil); 
        	System.out.println(svnKitService.listEntries(svn_url));               
//	        System.out.println(svnKitService.getLatestRevision());
//			svnKitUtil.checkout(svnKitUtil.getUrl(), SVNRevision.create(svnKitService.getLatestRevision()), new File(folder_checkOut), true);
//			System.out.println("checkout");
		} catch (Exception e) {
			e.printStackTrace();
		}
     
    }
	
}
