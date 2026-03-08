import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server.");

            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("sample.txt");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully!");

            // Close streams and socket
            fileInputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
