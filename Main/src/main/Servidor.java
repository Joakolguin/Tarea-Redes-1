/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import java.net.*;
import java.io.*;
public class Servidor {
    public static void main(String[] args){
        ServerSocket servidor= null;
        String line;
        PrintStream os= null;
        DataInputStream is= null;
        Socket clientSocket= null;
        try{
            servidor= new ServerSocket(9999);
        }
        catch(IOException e){
            System.out.println(e);
        }
        try{
            clientSocket = servidor.accept();
            is= new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            
            while (true){
                line= is.readLine();
                os.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        
    }
}
