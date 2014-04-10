/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import java.net.*;
import java.io.*;
public class Servidor {
   public static void main(String[] args) throws Exception{
       Servidor serv = new Servidor();
       serv.run();
   }
   public void run() throws Exception {
       ServerSocket servidorSK = new ServerSocket(9999);
       Socket sk = servidorSK.accept();
       InputStreamReader isr= new InputStreamReader(sk.getInputStream());
       BufferedReader br =new BufferedReader(isr);
       String message = br.readLine();
       if(message!= null){
           PrintStream ps=new PrintStream(sk.getOutputStream());
           ps.println("mensaje recibido");
       }
   }
}
