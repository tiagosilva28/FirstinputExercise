import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utilities {

    private BufferedReader consoleReader;
    private BufferedWriter writer;

    public void createStreams() throws IOException {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new FileWriter("resources/list.txt"));
    }

    public String userAskInput(String message) throws IOException {

        System.out.println(message);
        return consoleReader.readLine();

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

    protected void copyDirectory(String directory) {

        File files = new File(directory);

        try {

            //files = new File(directory).listFiles();
            for (File directoryFiles : files.listFiles()) {
                writer.write(directoryFiles.getName());
                System.out.println(directoryFiles.getName());
                writer.newLine();
                writer.flush();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected String askFileExistence() throws IOException {
        File[] files;
        String fileExistence = null;

        String filePath = userAskInput("Whats the directory do you want to check?");
        String fileName = userAskInput("Whats the file do you want to check?");

        try {
            files = new File(filePath).listFiles();

            for (int i = 0; i < files.length; i++) {
                if (fileName.equals(files[i].getName())) {
                    fileExistence = "File Exists";
                    break;
                } else {
                    fileExistence = "File doesn't Exists";
                }
            }

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(fileExistence);
        return fileExistence;
    }

    protected void askPathExistence() throws IOException {
        String filePath = userAskInput("Whats the path file do you want to check?");
        Path path = Paths.get(filePath);

        try {
            if (Files.exists(path)) {
                System.out.println("File Exists");
            } else {
                System.out.println("File not found");
            }

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

  void fileNameFilter(String filterName) {
        File files = new File("resources");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        };

        try {
            //files = new File(directory).listFiles();
            for (File directoryFiles : files.listFiles()) {
                if (filter.accept(files, filterName)) {
                    System.out.println(directoryFiles.getName());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
