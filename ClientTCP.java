import java.io.*;
import java.net.*;
public class ClientTCP {
    public static void main(String argv[]) throws UnknownHostException, IOException {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser =  new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhostOl", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("Mensagem do Servidor: " + modifiedSentence);
        clientSocket.close();
    }
}
