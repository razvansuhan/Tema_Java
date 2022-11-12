import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostName="127.0.0.1";
        int portNumber=1200;
        try{
            Socket me =new Socket(hostName,portNumber);
            PrintWriter out=new PrintWriter(me.getOutputStream(),true);
            BufferedReader in=new BufferedReader(
                    new InputStreamReader(me.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            String fromServer,fromUser;

            String mesaje[]={"Student Uta Marian 3 ATM 22",
                    "Student Suhan Razvan 3 ATM 25",
                    "Student Ureche Cosmin 4 ATM 23",
                    "Student Cosau Daniel 4 UPB 22",
                    "Profesor Ursache Marcella UPB 30 Engleza",
                    "Profesor Magurean Marius UMF 65 Biologie",
                    "Profesor Salar Iuliana UB 60 Matematica"};
            System.out.println("Se trimit mesajele ");
            for(int i=0;i<7;i++){
                out =new PrintWriter(me.getOutputStream(),true);
                out.println(mesaje[i]);
                if(i==6)
                    out.println("Bye.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
