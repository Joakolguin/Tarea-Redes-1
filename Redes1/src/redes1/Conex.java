package redes1;

import java.io.*;
import java.net.*;

public class Conex {
    final int puerto= 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;
    
    public void initServer(){
        BufferedReader entrada;
        try{
            sc = new ServerSocket(puerto);
            so = new Socket();
            System.out.println("Esperando una conexión:");
            so = sc.accept();
            System.out.println("Un cliente se ha conectado.");
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            salida = new DataOutputStream(so.getOutputStream());
            System.out.println("Confirmando conexion al cliente....");
            salida.writeUTF("Conexión exitosa...n envia un mensaje :D");
            mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);
            salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
            salida.writeUTF("Gracias por conectarte, adios!");
            System.out.println("Cerrando conexión...");
            sc.close();
            }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());                
        }
    }
}
