import java.io.*;
public class DirectoryAnalyser {
    private BufferedReader consoleReader;
    private BufferedWriter writer;

    public void createStreams() throws IOException {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new FileWriter("resources/list.txt"));
    }

    public void writeDownFiles() throws IOException {
        if (checkNullableStrems()){
            System.out.println(Messages.NO_STREAMS);
            return;
        }
        File directory = askforDirectory();
        System.out.println(Messages.LISTINING_MESSAGE);

        for (File directoryFile :
                directory.listFiles()) {
            writer.write(directoryFile.getName());
            writer.newLine();
            writer.flush();
        }
    }

    public void createField() throws IOException {
        if(checkNullableStrems()){
            System.out.println(Messages.NO_STREAMS);
            return;
        }
        File directory = askforDirectory();
        String secondUserInput = getUserInput(Messages.FILE_CREATION_QUESTION);
        boolean newFile = new File(directory.getPath() + "/" + secondUserInput).createNewFile();
        System.out.println(newFile ? Messages.FILE_CREATED : Messages.FILE_NOT_CREATED);

    }

    private File askforDirectory() throws IOException {
        String userInput = getUserInput(Messages.DIRECTORY_QUESTION);
        File dir = new File(userInput);
        return checkIfNoDirectory(dir) ? askforDirectory() : dir;

    }

    private boolean checkIfNoDirectory(File file) {
        if(!file.isDirectory()){
            System.out.println(Messages.NOT_DIRECTORY_MESSAGE);
        }
        return true;
    }

    private String getUserInput(String message) throws IOException {
        System.out.println(message);
        return consoleReader.readLine();
    }

    private boolean checkNullableStrems() {
       return writer == null || consoleReader == null;
    }

    void closeStreams() throws IOException {
        if(consoleReader != null){
            consoleReader.close();
        }
        if (writer != null){
            consoleReader.close();
        }
    }

    private void checkFilePresence() throws IOException {
        if(checkNullableStrems()){
            System.out.println(Messages.NO_STREAMS);
            return;
        }
        String userInput = getUserInput(Messages.NO_STREAMS);

        if(new File(userInput).exists()){
            System.out.println(Messages.FILE_EXISTS);
            return;
        }
        System.out.println(Messages.FILE_DOES_NOT_EXISTS);

    }

}
