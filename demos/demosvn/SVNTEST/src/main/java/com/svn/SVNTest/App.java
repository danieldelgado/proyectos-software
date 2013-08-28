package com.svn.SVNTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

import org.tmatesoft.svn.core.wc.SVNRevision;

public class App {

	public static void main(String[] args) {
		String username = "danieldelgado22g@gmail.com";
		String password = "pf4KA5ng4kp7";
		String svn_url = "https://proyectos-software.googlecode.com/svn/trunk/demos/demosvn/";
		String folder_checkOut = "C:\\svn\\checkout";
		String proyecto = "prueba01svn";
		final String carpetaProyecto = "SVNTEST";
		// String proyectoWar = "SVNTEST";
		folder_checkOut = folder_checkOut.concat("\\").concat(proyecto).concat("\\").concat(carpetaProyecto).concat("\\");
		SVNKitUtil svnKitUtil = new SVNKitUtil(svn_url, folder_checkOut, username, password);
		File fileProyecto = new File(folder_checkOut);

//		try {
//			SVNKitService svnKitService = new SVNKitService(svnKitUtil);
//			System.out.println(svnKitService.getLatestRevision());
//			svnKitUtil.checkout(svnKitUtil.getUrl(), SVNRevision.create(svnKitService.getLatestRevision()), fileProyecto, true);
//			System.out.println("checkout");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		FilenameFilter fileNameFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.equals(carpetaProyecto)) {
					return true;
				}
				return false;
			}
		};
		// proyectoWar
		fileProyecto = fileProyecto.listFiles(fileNameFilter)[0];

		System.out.println(fileProyecto);
		try {
			String[] command = { "CMD", "/C", "dir" };
			ProcessBuilder builder = new ProcessBuilder(command);
			// Map<String, String> environ = builder.environment();
			builder.directory(fileProyecto);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
