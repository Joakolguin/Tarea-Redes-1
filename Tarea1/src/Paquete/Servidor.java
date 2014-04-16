package Paquete;

import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String[] parametro) throws IOException {
		int puerto = 5550;
		int ini=0, fin=0;
		String peticion =null;
		String ruta=null;
		BufferedReader entrada;
		DataOutputStream salida;
		ServerSocket ss = new ServerSocket(puerto);
		Socket conex = new Socket();
		while(true){
			conex = ss.accept();
			System.out.println("Conexion aceptada");
			entrada = new BufferedReader(new InputStreamReader(conex.getInputStream()));
			System.out.println(""+entrada);
			salida = new DataOutputStream(conex.getOutputStream());
			System.out.println(""+salida);
			peticion = entrada.readLine();
			System.out.println(""+peticion);
            for (int pos=0; pos<peticion.length(); pos++){
                // Buscamos el ultimo espacio en blanco en la linea
                if (peticion.charAt(pos)==' ' && ini!=0){
                    fin=pos;
                    break;
                }
                // Buscamos el primer espacio en blanco en la linea
                if (peticion.charAt(pos)==' ' && ini==0){
                    ini=pos;
                }
            }
            ruta=peticion.substring(ini+1, fin);
            System.out.println(""+ruta);
			conex.close();
		}
	}
}
