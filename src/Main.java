import java.io.*;
public class Main {

    public static void main(String[] args) {

        //Utilities.copyFile();
       /*String name = Utilities.userAskInput("What's your name mate?");
        System.out.println("Nice to meet you: " + name);

        String directory = Utilities.userAskInput("What's the directory you want to see?");
        */

       /* Utilities.copyDirectory("resources");

        Utilities.askFileExistence();

        Utilities.askPathExistence();

        */

        DirectoryAnalyser directoryAnalyser = new DirectoryAnalyser();
        try{
            directoryAnalyser.createStreams();
            directoryAnalyser.writeDownFiles();
            directoryAnalyser.checkFilePresence();
            directoryAnalyser.createField();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                directoryAnalyser.closeStreams();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}