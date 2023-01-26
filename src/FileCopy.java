import java.io.*;

public class FileCopy {



    public static void main(String[] args) {
        copyFile();
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


}