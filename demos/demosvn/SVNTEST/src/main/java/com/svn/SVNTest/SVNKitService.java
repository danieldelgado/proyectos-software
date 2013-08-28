package com.svn.SVNTest;

import java.io.File;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNRevision;

/**
 * SVNKitService?, ??util
 * 
 * @author ye
 * 
 */
public class SVNKitService {
    private SVNURL url;
    private String localPath;
    private SVNKitUtil util;

    public SVNKitService(SVNKitUtil svnKitUtil){
    	this.util = svnKitUtil;
    }
    
    public SVNRepository getRepository() {
        return util.getRepository();
    }

    public long getLatestRevision() {
        long revision = 0;
        try {
            revision = this.getRepository().getLatestRevision();
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return revision;
    }

    public SVNURL getUrl() {
        return url;
    }

    public String getLocalPath() {
        return localPath;
    }

    public SVNKitUtil getUtil() {
        return util;
    }

    public SVNKitService() {
        // ??????????
        ResourceBundle rb = ResourceBundle
                .getBundle("co.jp.rontech.ofbiz.docmanger.svn.svn", Locale.getDefault());
        String localPath = rb.getString("svn.localpath");
        String svnUrl = rb.getString("svn.svnurl");
        String username = rb.getString("svn.username");
        String password = rb.getString("svn.password");
        this.localPath = localPath;
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
        SVNRepository repository = null;
        try {
            url = SVNURL.parseURIEncoded(svnUrl);
            repository = SVNRepositoryFactory.create(url, null);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        ISVNAuthenticationManager authManager = new BasicAuthenticationManager(
                username, password);
        repository.setAuthenticationManager(authManager);
        util = new SVNKitUtil(url, repository, localPath, username, password);
    }

    /**
     * ????????????(?)??(???)
     * 
     * @param path
     * @return ????
     */
    public Collection<SVNDirEntry> listEntries(String path) {
        Collection<SVNDirEntry> collection = null;
        try {
            collection = util.listEntries(path);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return collection;
    }

    /**
     * ?????????txt????
     * 
     * @param path
     *            ????url
     * @return ?????wenjian
     */
    public boolean isTxtFile(String path) {
        try {
            return util.isTxtFile(path);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * ??????
     * 
     * @param filePath
     *            ????
     * @return ??????
     */
    public String readFile(String filePath) {
        String result = null;
        try {
            result = util.readFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ?????????????
     * 
     * @param path
     *            ???????????
     * @return ???????
     */
    public SVNCommitInfo mkDirInRepo(String path) {
        SVNCommitInfo sci = null;
        try {
            sci = util.makeDirectory(util.getUrl().appendPath(path, false),
                    "?????" + path);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    /**
     * ???????????
     * 
     * @param path
     *            ???????????
     * @return ???????
     */
    public SVNCommitInfo mkDirInLocalAndCommit(String path) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        util.createLocalDir(new File(util.getLocalBaseUrl() + File.separator
                + path));
        SVNCommitInfo sci = null;
        try {
            util.addEntry(file);
            sci = util.commit(file, false, "?????" + path);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    /**
     * ???????????????????
     * 
     * @param path
     *            ???????
     * @param commitMessage
     *            ??
     * @return ???????
     */
    public SVNCommitInfo commit(String path, String commitMessage) {
        SVNCommitInfo sci = null;
        File file = new File(localPath + File.separator + path);
        try {
            sci = util.commit(file, false, commitMessage);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    /**
     * ?????checkout?????
     * 
     * @param revision
     *            ??
     * @param path
     *            ?????/???
     * @return
     */
    public long checkout(SVNRevision revision, String path) {
        long result = 0L;
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        try {
            result = util.checkout(url, revision, file, true);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ????????????
     * 
     * @param path
     *            ????
     */
    public void updateToHEAD(String path) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        try {
            util.update(file, SVNRevision.HEAD, true);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }

    /**
     * ?????????????
     * 
     * @param path
     *            ?????????
     */
    public SVNCommitInfo deleteFile(String path) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        SVNCommitInfo sci = null;
        try {
            util.delete(file, true);
            sci = this.commit(path, "??" + path);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    /**
     * ?????/?????????
     * 
     * @param path
     */
    public void addEntry(String path) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        try {
            util.addEntry(file);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }

    /**
     * ?????/????????????????
     * 
     * @param path
     * @return ???????
     */
    public SVNCommitInfo addAndCommit(String path) {
        this.addEntry(path);
        return this.commit(path, "??" + path);
    }

    /**
     * ?????/?????????????
     * 
     * @param path
     *            ?????????
     * @param revision
     *            ??????
     * @return ???????
     */
    public SVNCommitInfo revertToRevision(String path, long revision) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        SVNCommitInfo sci = null;
        try {
            util.revertToRevision(file, SVNRevision.create(revision));
            sci = this.commit(path, "???" + revision + "??");
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    /**
     * ??????/????????
     * 
     * @param path
     * @return ????
     */
    public Collection<SVNLogEntry> getRevisionHistory(String path) {
        return util.getRevisionHistory(path);
    }

    public SVNCommitInfo copyHEADTo(String addtionalURL) {
        SVNCommitInfo sci = null;
        try {
            sci = util
                    .copyHEADTo(util.getUrl().appendPath(addtionalURL, false));
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    /**
     * ?????SVN??????????
     * 
     * @param localPath
     *            ??????????
     * @param commitMessage
     *            ????
     * @return ?????
     */
    public SVNCommitInfo importDirectory(File localPath, String commitMessage) {
        SVNCommitInfo sci = null;
        try {
            sci = util.importDirectory(localPath, url, "first import", true);
        } catch (SVNException e) {
            e.printStackTrace();
        }
        return sci;
    }

    // git clean
    public void clean(String path) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        util.clean(file);
    }

    public SVNRevision getFileRevision(String path) {
        File file = new File(util.getLocalBaseUrl() + File.separator + path);
        return util.getFileRevision(file);
    }

    public String getFileUrl(String path) {
        return util.getFileUrl(path);
    }
    
    public SVNLogEntry getFileInfoByRev(String path,long rev){
        return util.getFileInfoByRev(path, rev);
    }

}