import java.io.*;
public class Main {

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




    public static void main(String[] args) {

        Utilities.copyFile();
        /*String name = userAskInput("What's your name mate?");
        System.out.println("Nice to meet you: " + name);

        String directory = userAskInput("What's the directory you want to see?");*/
    }
}