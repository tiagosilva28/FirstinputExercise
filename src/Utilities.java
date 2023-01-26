import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utilities {

    public static String userAskInput (String msg){
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);

        BufferedReader br = new BufferedReader(reader);
        System.out.println(msg);
        String name;

        {
            try {
                name = br.readLine(); ///Blocking method
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return name;

    }
    protected static void copyFile() {
        int startMilliseconds = (int) System.currentTimeMillis();

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("resources/input.txt");
            out = new FileOutputStream("resources/output.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


        int endMilliseconds = 0;
        System.out.println("Time: " + (endMilliseconds - startMilliseconds) + "ms");

        System.out.println("File copied");

        startMilliseconds = (int) System.currentTimeMillis();
        try {
            in = new FileInputStream("resources/image.jpg");
            out = new FileOutputStream("resources/copy-image.jpg");
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        endMilliseconds = (int) System.currentTimeMillis();
        System.out.println("Time: " + (endMilliseconds - startMilliseconds) + "ms");
    }

    protected static void copyDirectory(String directory){
        FileInputStream in = null;
        File[] files;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(directory+"/input.txt");
            files = new File(directory).listFiles();
            out = new FileOutputStream(directory+"/filesNames.txt");

            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].toString());
                out.write(files[i].toString().getBytes());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }



    }

    protected static String askFileExistence(){
        FileInputStream in = null;
        File[] files;
        FileOutputStream out = null;
        String fileExistence = null;

        String filePath = userAskInput("Whats the directory do you want to check?");
        String fileName = userAskInput("Whats the file do you want to check?");

        try {
            files = new File(filePath).listFiles();

            for (int i = 0; i < files.length; i++) {
                if(fileName.equals(files[i].getName())){
                    fileExistence = "File Exists";
                    break;
                }
                else {
                    fileExistence = "File doesn't Exists";
                }
            }

        }
        catch (NullPointerException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            /*try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

             */
        }
        System.out.println(fileExistence);
        return fileExistence;
    }

    protected static void askPathExistence(){
        String filePath = userAskInput("Whats the path file do you want to check?");
        Path path = Paths.get(filePath);

        try {
            if (Files.exists(path)){
                System.out.println("File Exists");
            } else  {
                System.out.println("File not found");
            }

        }
        catch (NullPointerException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
