package utils;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class gitUtils {

    private static void runCommand(ProcessBuilder builder) throws IOException, InterruptedException{
        //standard output and error output are combined into a single stream
        builder.redirectErrorStream(true);
        Process process = builder.start();
        //read the output from the command
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        //read the output line by line
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
        //wait for the process to finish
        int exitCode = process.waitFor();
        //check the exit code
        if(exitCode != 0){
            throw new IOException("Command failed with exit code " + exitCode);
        }
    }

    public static void cloneRepo(String repoUrl, String destination) throws IOException {
        try {
            if (!(Files.exists(Paths.get(destination)))) {
                runCommand(new ProcessBuilder("git", "clone", repoUrl, destination));
            }else throw new IOException("Destination already exists: " + destination);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addNewFile(String repoPath, String fileName, String content) throws IOException {
        try {
            Path filePath = Paths.get(repoPath, fileName);
            Files.write(filePath, content.getBytes());
            runCommand(new ProcessBuilder("git", "add", fileName).directory(new File(repoPath)));
            runCommand(new ProcessBuilder("git", "commit", "-m", "Add new file" + fileName).directory(new File(repoPath)));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void updateFile(String repoPath, String fileName, String newContent) throws IOException {
        try {
            Path filePath = Paths.get(repoPath, fileName);
            Files.write(filePath, newContent.getBytes(), StandardOpenOption.APPEND);
            runCommand(new ProcessBuilder("git", "add", fileName).directory(new File(repoPath)));
            runCommand(new ProcessBuilder("git", "commit", "-m", "Update file" + fileName).directory(new File(repoPath)));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String repoPath, String fileName) throws IOException {
        try {
            Path filePath = Paths.get(repoPath, fileName);
            Files.delete(filePath);
            runCommand(new ProcessBuilder("git", "add", fileName).directory(new File(repoPath)));
            runCommand(new ProcessBuilder("git", "commit", "-m", "Delete file" + fileName).directory(new File(repoPath)));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
