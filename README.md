# ChatBox - A Simple Java Socket Chat Application

ChatBox is a basic real-time chat application built using **Java Sockets**. It enables communication between a client and a server over a network. With **multithreading**, it ensures seamless message exchange without delays.

## Features
- ✅ Real-time messaging between client and server
- ✅ Uses **Java Socket Programming** for networking
- ✅ **Multithreaded** to allow simultaneous send/receive
- ✅ Simple and easy-to-understand code structure

## Technologies Used
- Java
- TCP Sockets
- Multithreading

## How to Run
### 1️⃣ Start the Server
```bash
javac Server.java
java Server
```

### 2️⃣ Start the Client
```bash
javac Client.java
java Client
```

## How It Works
1. The **server** starts and listens for a connection on a specified port.
2. The **client** connects to the server using its IP and port.
3. Both client and server can send messages in **real-time**.
4. Type `end` to terminate the chat session.

## File Structure
```plaintext
📂 ChatBox
 ├── Server.java   # Server-side implementation
 ├── Client.java   # Client-side implementation
 ├── README.md     # Project documentation
```

## Future Improvements
- 🔹 GUI-based chat interface
- 🔹 Support for multiple clients
- 🔹 Encrypted messaging

## License
This project is open-source and free to use. Feel free to contribute! 🚀
