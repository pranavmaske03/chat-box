import java.net.*;
import java.io.*;

class Client {
    public static void main(String arg[]) throws Exception {
        System.out.println("Client Application is running...");

        Socket s = new Socket("127.0.0.1", 2100); // Connect to server
        System.out.println("Connected to server!");

        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        // Thread to receive messages from the server
        Thread receiveThread = new Thread(() -> {
            try {
                String str;
                while ((str = br1.readLine()) != null) {
                    System.out.println("\nServer says: " + str);
                    System.out.print("Enter message: "); // Keep input prompt
                }
            } catch (Exception e) {
                System.out.println("Connection closed.");
            }
        });
        receiveThread.start();

        // Main thread for sending messages
        String str1;
        while (!(str1 = br2.readLine()).equalsIgnoreCase("end")) {
            ps.println(str1);
        }

        System.out.println("Chat ended.");
        ps.close();
        br1.close();
        br2.close();
        s.close();
    }
}
