/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package version2;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Server {
        public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
        public static ArrayList<String> CurrentUsers = new ArrayList<String>();
        
        public static void main(String[] args) throws IOException{
            try
            {
                final int port = 444;
                ServerSocket SERVER = new ServerSocket(port);
                System.out.println("Esperando cliente");
                while(true){
                    Socket sock = SERVER.accept();
                    ConnectionArray.add(sock);
                    System.out.println("Cliente conectado desde: "+ sock.getLocalAddress().getHostName());
                    AddUserName(sock);
                    Server_Return CHAT = new Server_Return(sock);
                    Thread X = new Thread(CHAT);
                    X.start();
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    private static void AddUserName(Socket S) throws IOException{
        Scanner input = new Scanner(S.getInputStream());
        String UserName = input.nextLine();
        CurrentUsers.add(UserName);
        
        for (int i = 1; i<= Server.CurrentUsers.size(); i++){
            Socket Temp_sock=(Socket) Server.ConnectionArray.get(i-1);
            PrintWriter OUT = new PrintWriter(Temp_sock.getOutputStream());
            OUT.println("#?! "+CurrentUsers);
            OUT.flush();
        }
    }
        
}
