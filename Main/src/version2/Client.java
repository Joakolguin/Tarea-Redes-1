/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package version2;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author niko
 */
public class Client implements Runnable {
    Socket Sock;
    Scanner Input;
    Scanner Send= new Scanner(System.in);
    PrintWriter out;
    public Client(Socket x) {
        this.Sock=x;
    }
    public void run(){
        try{
            try{
                Input=new Scanner(Sock.getInputStream());
                out= new PrintWriter(Sock.getOutputStream());
                out.flush();
                CheckStream();
                
            }
            finally{
                Sock.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void CheckStream() {
        while(true){
            Receive();
        }
      
    }

    private void Receive() {
        if(Input.hasNext()){
            String mess= Input.nextLine();
            if(mess.contains("#?!")){
                String Temp1=mess.substring(3);
                       Temp1=Temp1.replace("[", "");
                       Temp1=Temp1.replace("]", "");
                String[] CurrentUsers=Temp1.split(", ");
                gui.Li_Online.setListData(CurrentUsers);
                
            }
            else{
                gui.T_Conversation.append(mess+"\n");
            }
        }
    }
    
}
