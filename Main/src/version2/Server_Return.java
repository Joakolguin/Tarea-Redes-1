/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package version2;

import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author niko
 */
public class Server_Return implements Runnable {
    Socket sock;
    private Scanner input;
    private PrintWriter out;
    String message;
    Server_Return(Socket x) {
        this.sock = x ;
    }
    public void isConnected() throws IOException{
        if(!sock.isConnected()){
            for(int i=1;i<=Server.ConnectionArray.size();i++){
                if(Server.ConnectionArray.get(i)==sock){
                    Server.ConnectionArray.remove(i);
                }
            }
            for(int i=1;i<=Server.ConnectionArray.size();i++){
                Socket temp=(Socket) Server.ConnectionArray.get(i-1);
                PrintWriter temp_o=new PrintWriter(temp.getOutputStream());
                temp_o.println(temp.getLocalAddress().getHostName()+" disconnected");
                
                temp_o.flush();
                
                System.out.println(temp.getLocalAddress().getHostName()+ " disconnected");
            }
        }
    }
    public void run() {
        try{
           try{
               input= new Scanner(sock.getInputStream());
               out = new PrintWriter(sock.getOutputStream());
               while(true){
                   isConnected();
                   if(!input.hasNext()){
                       return;
                   }
                   message=input.nextLine();
                   System.out.println("Cliente dice: "+message);
                   
                   for(int i=1;i<=Server.ConnectionArray.size();i++){
                       Socket temp=(Socket) Server.ConnectionArray.get(i-1);
                       PrintWriter temp_o=new PrintWriter(temp.getOutputStream());
                       temp_o.println(message);
                       temp_o.flush();
                       System.out.println("sent to"+temp.getLocalAddress().getHostName());
                   }
                   
               }
           }
           finally
           {
               sock.close();
           }
           
        }
        catch(Exception x){
            System.out.println(x);
        }
    }
}
