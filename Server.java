import java.net.*;
import java.io.*;

class Server {
    public static void main(String arg[]) throws Exception {
        System.out.println("Server Application is running...");
        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Waiting for client to connect...");

        Socket s = ssobj.accept();
        System.out.println("Client connected!");

        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        // Thread to receive messages from the client
        Thread receiveThread = new Thread(() -> {
            try {
                String str;
                while ((str = br1.readLine()) != null) {
                    System.out.println("\nClient says: " + str);
                    System.out.print("Enter message: "); // Keep input prompt
                }
            } catch (Exception e) {
                System.out.println("Connection closed.");
            }
        });
        receiveThread.start();

        // Main thread for sending messages
        String str2;
        while (!(str2 = br2.readLine()).equalsIgnoreCase("end")) {
            ps.println(str2);
        }

        System.out.println("Chat ended.");
        ps.close();
        br1.close();
        br2.close();
        s.close();
        ssobj.close();
    }
}
