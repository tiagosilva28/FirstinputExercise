import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Utilities utilities = new Utilities();

        //String directory = Utilities.userAskInput("What's the directory you want to see?");



       utilities.createStreams();
       //utilities.copyDirectory("resources");
        utilities.fileNameFilter("co");

        //Utilities.askFileExistence();

        //Utilities.askPathExistence();



        /*DirectoryAnalyser directoryAnalyser = new DirectoryAnalyser();
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

         */
    }


}