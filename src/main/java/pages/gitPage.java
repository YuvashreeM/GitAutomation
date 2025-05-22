package pages;
import utils.gitUtils;

import java.io.IOException;

public class gitPage {

    public void cloneRepo(String repoUrl, String destination) throws IOException {
        try {
            gitUtils.cloneRepo(repoUrl, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewFile(String repoPath, String fileName, String content) throws IOException {
        try {
            gitUtils.addNewFile(repoPath, fileName, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFile(String repoPath, String fileName, String newContent) throws IOException {
        try {
            gitUtils.updateFile(repoPath, fileName, newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String repoPath, String fileName) throws IOException {
        try {
            gitUtils.deleteFile(repoPath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
