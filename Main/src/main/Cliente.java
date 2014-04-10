package main;

 import java.io.*;
import java.net.*;
class Cliente {
    public static void main(String[] args) throws Exception{
       Cliente clien = new Cliente();
       clien.run();
   }
   public void run() throws Exception {
       Socket sk = new Socket("Niko",9999);
       PrintStream ps=new PrintStream(sk.getOutputStream());
       ps.println("hola servidor desde cliente");
       InputStreamReader isr= new InputStreamReader(sk.getInputStream());
       BufferedReader br =new BufferedReader(isr);
       String message = br.readLine();
       System.out.println(message);
   }
}
