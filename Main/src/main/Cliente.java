/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import java.io.*;
import java.net.*;
public class Cliente {
    int port;
    public static void main(String[] args) throws IOException{
        //Declaracion
        Socket cliente =null;
        DataOutputStream os =null;
        DataInputStream is =null;
        //Inicializacion
        try{
            cliente = new Socket("prueba",25);
            os = new DataOutputStream(cliente.getOutputStream());
            is = new DataInputStream(cliente.getInputStream());
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
        if(cliente != null & os!=null &is!=null){
            try{
                os.writeBytes("Hola Hijo de PUTA\n");
                os.writeBytes("QUIT");

                String responseLine;
                while((responseLine=is.readLine())!=null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("Ok")!=-1){
                        break;
                    }
                }
                os.close();
                is.close();
                cliente.close();
            }
            catch(UnknownHostException e){
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }
}
