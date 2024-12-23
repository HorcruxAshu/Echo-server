## Steps to Execute the Reverse Echo Server Program

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/yourusername/Echo-server.git
    cd Echo-server
    ```

2. **Compile the Java Program**:
    ```sh
    javac ReverseEchoServer.java
    ```

3. **Run the Server**:
    ```sh
    java ReverseEchoServer
    ```

4. **Connect to the Server**:
    - Open another terminal window.
    - Use `telnet` to connect to the server:
        ```sh
        telnet localhost 12345
        ```
    - Type a message and press Enter. The server will respond with the reversed message.

5. **Stop the Server**:
    - Press `Ctrl+C` in the terminal where the server is running.

Make sure you have Java installed on your system. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).