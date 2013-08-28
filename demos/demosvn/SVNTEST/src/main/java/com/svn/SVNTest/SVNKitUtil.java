package com.svn.SVNTest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNProperty;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNCopySource;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVNKitUtil {
    // ????
    private SVNClientManager cm;
    private SVNRepository repository;
    private SVNURL url;
    private String localBaseUrl;

    public String getLocalBaseUrl() {
        return localBaseUrl;
    }

    public SVNURL getUrl() {
        return url;
    }

    public SVNRepository getRepository() {
        return repository;
    }

    public SVNKitUtil(String URL, String localBaseUrl, String USERNAME,
            String PASSWORD) {
        super();
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
        SVNRepository repository = null;
        try {
            url = SVNURL.parseURIEncoded(URL);
            repository = SVNRepositoryFactory.create(url, null);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        ISVNAuthenticationManager authManager = new BasicAuthenticationManager(
                USERNAME, PASSWORD);
        repository.setAuthenticationManager(authManager);
        this.repository = repository;
        this.localBaseUrl = localBaseUrl;
        cm = SVNClientManager.newInstance(
                SVNWCUtil.createDefaultOptions(false), USERNAME, PASSWORD);
    }

    public SVNKitUtil(SVNURL svnUrl, SVNRepository repository,
            String localBaseUrl, String USERNAME, String PASSWORD) {
        super();
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
        this.url = svnUrl;
        this.repository = repository;
        this.localBaseUrl = localBaseUrl;
        cm = SVNClientManager.newInstance(
                SVNWCUtil.createDefaultOptions(false), USERNAME, PASSWORD);
    }

    /**
     * ???????????
     * 
     * @param path
     *            ??
     * @return ???????
     * @throws SVNException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Collection<SVNDirEntry> listEntries(String path) throws SVNException {
        Collection<SVNDirEntry> entries = null;
        entries = (Collection<SVNDirEntry>) repository.getDir(path, -1, null,
                (Collection) null);
        // Iterator iterator = entries.iterator();
        // while (iterator.hasNext()) {
        // SVNDirEntry entry = (SVNDirEntry) iterator.next();
        // System.out.println("/" + (path.equals("") ? "" : path + "/")
        // + entry.getName() + " ( author: '" + entry.getAuthor()
        // + "'; revision: " + entry.getRevision() + "; date: "
        // + entry.getDate() + ")");
        // if (entry.getKind() == SVNNodeKind.DIR) {
        // listEntries(repository, (path.equals("")) ? entry.getName()
        // : path + "/" + entry.getName());
        // }
        // }
        return entries;
    }

    /**
     * ??????
     * 
     * @param filePath
     *            ????????
     * @return ???????(???)
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public String readFile(final String filePath) throws SVNException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        SVNNodeKind nodeKind = repository.checkPath(filePath, -1);
        if (nodeKind == SVNNodeKind.NONE) {
            // System.err.println("'" + filePath + "'????");
        } else if (nodeKind == SVNNodeKind.DIR) {
            // System.err.println("'" + filePath + "'?????");
        }
        SVNProperties prop = new SVNProperties();
        Map fileProperties = prop.asMap();
        repository.getFile(filePath, -1, prop, baos);
        String mimeType = (String) fileProperties.get(SVNProperty.MIME_TYPE);
        boolean isTextType = SVNProperty.isTextMimeType(mimeType);
        // Iterator iterator = fileProperties.keySet().iterator();
        // while (iterator.hasNext()) {
        // String propertyName = (String) iterator.next();
        // String propertyValue = (String) fileProperties
        // .get(propertyName);
        // }

        if (isTextType) {
            // baos.writeTo(System.out);
        } else {
            return "????????";
        }

        return baos.toString();
    }

    /**
     * ?????????????
     * 
     * @param url
     *            ???????
     * @param commitMessage
     *            ??
     * @return ???????
     * @throws SVNException
     */
    public SVNCommitInfo makeDirectory(SVNURL url, String commitMessage)
            throws SVNException {
        return cm.getCommitClient()
                .doMkDir(new SVNURL[] { url }, commitMessage);
    }

    /**
     * ?????????
     * 
     * @param wcPath
     *            ???????/???
     * @param keepLocks
     *            ????
     * @param commitMessage
     *            ??
     * @return ???????
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public SVNCommitInfo commit(File wcPath, boolean keepLocks,
            String commitMessage) throws SVNException {
        // ?????????out of date??
        this.update(new File(this.localBaseUrl), SVNRevision.HEAD, true);
        // ??????? ????, ?????????????????????true, ???false
        return cm.getCommitClient().doCommit(new File[] { wcPath }, keepLocks,
                commitMessage, false, true);
    }

    /**
     * ???url checkout???revision
     * 
     * @param url
     *            ??checkout???/?????
     * @param revision
     *            ???
     * @param destPath
     *            ?????
     * @param isRecursive
     *            ????
     * @return checkout??revision
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public long checkout(SVNURL url, SVNRevision revision, File destPath,
            boolean isRecursive) throws SVNException {

        SVNUpdateClient updateClient = cm.getUpdateClient();
        // sets externals not to be ignored during the checkout
        updateClient.setIgnoreExternals(false);
        // returns the number of the revision at which the working copy is
        return updateClient.doCheckout(url, destPath, revision, revision,
                isRecursive);
    }

    /**
     * ???????????revision
     * 
     * @param wcPath
     *            ????????
     * @param updateToRevision
     *            ????revision
     * @param isRecursive
     *            ????
     * @return ????revision
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public long update(File wcPath, SVNRevision updateToRevision,
            boolean isRecursive) throws SVNException {
        SVNUpdateClient updateClient = cm.getUpdateClient();
        // sets externals not to be ignored during the update
        updateClient.setIgnoreExternals(false);
        // returns the number of the revision wcPath was updated to
        // cm.getWCClient().doCleanup(wcPath);
        return updateClient.doUpdate(wcPath, updateToRevision, isRecursive);
    }

    /**
     * ?????????????????
     * 
     * @param wcPath
     *            ????
     * @param url
     *            ??????????
     * @param updateToRevision
     *            ??????revision
     * @param isRecursive
     *            ????
     * @return ????revision
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public long switchToURL(File wcPath, SVNURL url,
            SVNRevision updateToRevision, boolean isRecursive)
            throws SVNException {
        SVNUpdateClient updateClient = cm.getUpdateClient();
        // sets externals not to be ignored during the switch
        updateClient.setIgnoreExternals(false);
        // returns the number of the revision wcPath was updated to
        return updateClient
                .doSwitch(wcPath, url, updateToRevision, isRecursive);
    }

    /**
     * ???/??????svn?
     * 
     * @param wcPath
     *            ??/?????
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public void addEntry(File wcPath) throws SVNException {
        File[] files = null;
        if (wcPath.isDirectory()) {
            files = wcPath.listFiles();
            try {
                /*
                 * boolean force, boolean mkdir, boolean
                 * climbUnversionedParents, boolean recursive)
                 */
                cm.getWCClient().doAdd(wcPath, true, true, true, true);
            } catch (SVNException e) {
                // e.printStackTrace();
            } finally {
                for (File file : files) {
                    if (file.isDirectory()) {
                        addEntry(file);
                    }
                }
            }
        } else {
            cm.getWCClient().doAdd(wcPath, false, false, false, true);
        }
    }

    /**
     * ???/?????
     * 
     * @param wcPath
     *            ???????/???
     * @param force
     *            ????
     * @throws SVNException
     */
    public void delete(File wcPath, boolean force) throws SVNException {
        cm.getWCClient().doDelete(wcPath, force, false);
    }

    /**
     * ??????????
     * 
     * @param aNewDir
     *            ????????
     * @param localFiles
     *            ???????
     * @param fileContents
     *            ????
     */
    public void createLocalDir(File aNewDir, File[] localFiles,
            String[] fileContents) {
        if (!aNewDir.mkdirs()) {
            System.err.println("failed to create a new directory '"
                    + aNewDir.getAbsolutePath() + "'.");
        }

        for (int i = 0; i < localFiles.length; i++) {
            File aNewFile = localFiles[i];
            try {
                if (!aNewFile.createNewFile()) {
                    System.err.println("failed to create a new file '"
                            + aNewFile.getAbsolutePath() + "'.");
                }
            } catch (IOException ioe) {
                aNewFile.delete();
                System.err.println("error while creating a new file '"
                        + aNewFile.getAbsolutePath() + "'");
                ioe.printStackTrace();
            }

            String contents = null;
            if (i > fileContents.length - 1) {
                continue;
            }
            contents = fileContents[i];

            /*
             * writing a text into the file
             */
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(aNewFile);
                fos.write(contents.getBytes());
            } catch (FileNotFoundException fnfe) {
                System.err.println("the file '" + aNewFile.getAbsolutePath()
                        + "' is not found");
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                System.err.println("error while writing into the file '"
                        + aNewFile.getAbsolutePath() + "'");
                ioe.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ioe) {
                        //
                    }
                }
            }
        }
    }

    /**
     * ???????
     * 
     * @param ????????
     */
    public void createLocalDir(File aNewDir) {
        if (!aNewDir.exists()) {
            aNewDir.mkdirs();
        }
    }

    /**
     * ???????????
     * 
     * @param file
     *            ???????/???
     * @param rev
     *            ???????
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public void revertToRevision(File file, SVNRevision rev)
            throws SVNException {
        cm.getDiffClient().doMerge(file, SVNRevision.HEAD, file, rev, file,
                true, true, true, false);
    }

    /**
     * ?????????
     * 
     * @param path
     *            ??
     * @return ???????
     * @throws SVNException
     */
    @SuppressWarnings("rawtypes")
    public boolean isTxtFile(String path) throws SVNException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SVNNodeKind nodeKind = repository.checkPath(path, -1);
        if (nodeKind == SVNNodeKind.NONE) {
            // System.err.println("'" + path + "'????");
            return false;
        } else if (nodeKind == SVNNodeKind.DIR) {
            // System.err.println("'" + path + "'?????");
            return false;
        } else {
            SVNProperties prop = new SVNProperties();
            Map fileProperties = prop.asMap();
            repository.getFile(path, -1, prop, baos);
            String mimeType = (String) fileProperties
                    .get(SVNProperty.MIME_TYPE);
            boolean isTextType = SVNProperty.isTextMimeType(mimeType);
            return isTextType;
        }
    }

    @SuppressWarnings("unchecked")
    public Collection<SVNLogEntry> getRevisionHistory(String path) {
        long startRevision = 1;
        long endRevision = SVNRevision.HEAD.getNumber();
        try {
            endRevision = repository.getLatestRevision();
        } catch (SVNException svne) {
            System.err
                    .println("error while fetching the latest repository revision: "
                            + svne.getMessage());
        }
        Collection<SVNLogEntry> logEntries = null;
        try {
            logEntries = repository.log(new String[] { path }, null,
                    startRevision, endRevision, true, true);

        } catch (SVNException svne) {
            System.out.println("error while collecting log information for '"
                    + url + "': " + svne.getMessage());
        }
        return logEntries;
        // for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
        // SVNLogEntry logEntry = (SVNLogEntry) entries.next();
        // System.out.println("---------------------------------------------");
        // System.out.println("revision: " + logEntry.getRevision());
        // System.out.println("author: " + logEntry.getAuthor());
        // System.out.println("date: " + logEntry.getDate());
        // System.out.println("log message: " + logEntry.getMessage());
        // if (logEntry.getChangedPaths().size() > 0) {
        // System.out.println();
        // System.out.println("changed paths:");
        // Set changedPathsSet = logEntry.getChangedPaths().keySet();
        //
        // for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths
        // .hasNext();) {
        //
        // SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry
        // .getChangedPaths().get(changedPaths.next());
        //
        // System.out.println(" "
        // + entryPath.getType()
        // + "	"
        // + entryPath.getPath()
        // + ((entryPath.getCopyPath() != null) ? " (from "
        // + entryPath.getCopyPath() + " revision "
        // + entryPath.getCopyRevision() + ")" : ""));
        // }
        // }
        // }
    }

    /**
     * ?HEAD??????svn??
     * 
     * @param dstURL
     *            ??url
     * @return ???????
     * @throws SVNException
     */
    public SVNCommitInfo copyHEADTo(SVNURL dstURL) throws SVNException {
        String message = "copy " + this.url + "/trunk" + " to " + dstURL;
        return cm.getCopyClient()
                .doCopy(new SVNCopySource[] { new SVNCopySource(
                        SVNRevision.HEAD, SVNRevision.HEAD,
                        this.url.appendPath("/trunk", false)) }, dstURL, false,
                        true, false, message, new SVNProperties());
    }

    /**
     * ?????????????
     * 
     * @param localPath
     *            ?????
     * @param dstURL
     *            ????
     * @param commitMessage
     * @param isRecursive
     * @return
     * @throws SVNException
     */
    @SuppressWarnings("deprecation")
    public SVNCommitInfo importDirectory(File localPath, SVNURL dstURL,
            String commitMessage, boolean isRecursive) throws SVNException {
        return cm.getCommitClient().doImport(localPath, dstURL, commitMessage,
                isRecursive);
    }

    /**
     * clean?????
     * 
     * @param path
     */
    public void clean(File path) {
        try {
            cm.getWCClient().doCleanup(path);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }

    /**
     * ????????revision
     * 
     * @param path
     * @return ?????revision
     */
    public SVNRevision getFileRevision(File path) {
        SVNRevision rev = null;
        try {
            rev = cm.getWCClient().doInfo(path, SVNRevision.HEAD).getRevision();
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return rev;
    }

    /**
     * ????????????svn???????
     * 
     * @param path
     *            ????
     * @return ?svn???????
     */
    public String getFileUrl(String path) {
        SVNURL u = null;
        try {
            u = url.appendPath(path, false);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return u.getPath();
    }
    
    @SuppressWarnings("unchecked")
    public SVNLogEntry getFileInfoByRev(String path,long rev){
        long startRevision = rev;
        long endRevision = rev;
        Collection<SVNLogEntry> logEntries = null;
        try {
            logEntries = repository.log(new String[] { path }, null,
                    startRevision, endRevision, true, true);

        } catch (SVNException svne) {
            System.out.println("error while collecting log information for '"
                    + url + "': " + svne.getMessage());
        }
        return logEntries.iterator().next();
    }
}