import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true) {
            Socket client = welcomeSocket.accept();
            System.out.println("Cliente conectado:" + client.getInetAddress().getHostAddress() );
            BufferedReader inFromClient = new BufferedReader(new
            InputStreamReader(client.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
            
        }
    }
}
