package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.SkipException;
import org.testng.annotations.*;
import pages.gitPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
//@Listeners ({AllureTestNg.class})
@Epic("Git Operations")
@Feature("File Management in Cloned Git Repository")
public class gitTest {

    private gitPage GitPage;
    private String repoUrl;
    private String cloneDir = System.getProperty("user.dir") + File.separator + "AutomationClonedRepo" ;
    private String newFileName;
    private String newFileContent;
    private String updatedFileContent;

   public gitTest() throws IOException {
        GitPage = new gitPage();
        String jsonData = new String(Files.readAllBytes(Paths.get("testData/gitData.json")));
        JSONObject gitData = new JSONObject(jsonData);

        this.repoUrl = gitData.getString("repoUrl");
        this.newFileName = gitData.getString("newFileName");
        this.newFileContent = gitData.getString("newFileContent");
        this.updatedFileContent = gitData.getString("updatedFileContent");
    }

    @BeforeClass
    @Description("Cloning the Git repository")
    @Step("Cloning the repository")
    public void cloneRepo() throws IOException {
        // Check if the directory already exists
        if (Files.exists(Paths.get(cloneDir))) {
            Allure.step("Directory already exists: " + cloneDir);
        }else {
            GitPage.cloneRepo(repoUrl, cloneDir);
            Allure.step("Directory created: " + cloneDir);
        }
    }

    @Test(priority = 1)
    @Description("Adding a file to the cloned Git repository")
    @Step("Adding a new file to the repository")
    public void addNewFile() throws IOException {
        // Check if the file already exists
        System.out.println("Starting to add a new file...");
        Allure.step("Checking if file exists: " + newFileName);
        if (Files.exists(Paths.get(cloneDir, newFileName))) {
            Allure.step("File already exists: " + newFileName);
            throw new SkipException("File already exists: " + newFileName);
        }else {
            GitPage.addNewFile(cloneDir, newFileName, newFileContent);
            Allure.step("File created: " + newFileName);
            Allure.step("File content: " + newFileContent);
        }
    }

    @Test(priority = 2)
    @Description("Updating a file content to the existing file in the cloned Git repository")
    @Step("Updating the file in the repository")
    public void updateFile() throws IOException {
        System.out.println("Starting to update the file...");
        if (!Files.exists(Paths.get(cloneDir, newFileName))) {
            Allure.step("File doesn't exists: " + newFileName);
            throw new SkipException("File doesn't exist: " + newFileName);
        }else {
            Allure.step("File already exists: " + newFileName);
            GitPage.updateFile(cloneDir, newFileName, updatedFileContent);
            Allure.step("Updated File: " + newFileName);
            Allure.step("Updated File content: " + updatedFileContent);
        }
    }

    @AfterClass
    @Description("Deleting the file from the cloned Git repository")
    @Step("Deleting the file from the repository")
    public void deleteFile() throws IOException {
        System.out.println("Starting to delete the file...");
        if (!Files.exists(Paths.get(cloneDir, newFileName))) {
            Allure.step("File doesn't exists: " + newFileName);
            throw new SkipException("File doesn't exist: " + newFileName);
        }else {
            Allure.step("File already exists: " + newFileName);
            GitPage.deleteFile(cloneDir, newFileName);
            Allure.step("Deleting the file: " + newFileName);
        }

    }
}