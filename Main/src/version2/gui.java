/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package version2;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author niko
 */
public class gui {
    private static Client chatcliente;
    public static   String Username= "anonimo";
    
    public static JFrame MainWindow= new JFrame();
    private static JButton B_About= new JButton();
    private static JButton B_Connect = new JButton();
    private static JButton B_Disconnect = new JButton();
    private static JButton B_Help = new JButton();
    private static JButton B_Send = new JButton();
    private static JLabel L_Message = new JLabel();
    public static JTextField T_Message = new JTextField(20);
    private static JLabel L_Conversation = new JLabel();
    public static JTextArea T_Conversation = new JTextArea();
    private static JScrollPane S_Conversation = new JScrollPane();
    private static JLabel L_Online = new JLabel();
    
    public static JList Li_Online = new JList();
    private static JScrollPane S_Online = new JScrollPane();
    private static JLabel L_Loggedinas = new JLabel();
    private static JLabel L_Loggedinasbox= new JLabel();
    
    //gui window
    public static JFrame Loginwindow = new JFrame();
    public static JTextField T_username = new JTextField(20);
    private static JButton B_Enter = new JButton("Enter");
    private static JLabel L_Enterusername = new JLabel("Enter username: ");
    private static JPanel P_Login = new JPanel();
    
    public static void main(String args[]){
        BuildMainWindow();
        Initialize();
    }
    public static void Connect(){
        try{
            final int port= 9999;
            final String host = "Chulactica";
            Socket sock= new Socket(host,port);
            System.out.println("You connected to: "+host);
            
            chatcliente = new Client(sock);
            
            PrintWriter out= new PrintWriter(sock.getOutputStream());
            out.println(Username);
            out.flush();
            Thread x= new Thread(chatcliente);
            x.start();
            
            
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "server not responding");
            System.exit(0);
        }
    }

    public static void BuildMainWindow() {
        MainWindow.setTitle(Username+ " ChatBox");
        MainWindow.setSize(450,500);
        MainWindow.setLocation(220,180);
        MainWindow.setResizable(false);
        ConfigureMainWindow();
        //MainWindow_Action();
        MainWindow.setVisible(true);
        
    }
    public static void ConfigureMainWindow(){
        MainWindow.setBackground(new java.awt.Color(255,255,255));
        MainWindow.setSize(500,320);
        MainWindow.getContentPane().setLayout(null);
        
        B_Send.setBackground(new java.awt.Color(0,0,255));
        B_Send.setForeground(new java.awt.Color(255,255,255));
        B_Send.setText("Enviar");
        MainWindow.getContentPane().add(B_Send);
        B_Send.setBounds(250,40,81,25);
        
        B_Disconnect.setBackground(new java.awt.Color(0,0,255));
        B_Disconnect.setForeground(new java.awt.Color(255,255,255));
        B_Disconnect.setText("Disconnect");
        MainWindow.getContentPane().add(B_Disconnect);
        B_Disconnect.setBounds(10,40,110,25);
        
        B_Connect.setBackground(new java.awt.Color(0,0,255));
        B_Connect.setForeground(new java.awt.Color(255,255,255));
        B_Connect.setText("Connect");
        B_Connect.setToolTipText("");
        MainWindow.getContentPane().add(B_Connect);
        B_Connect.setBounds(130,40,81,25);
        
        B_Help.setBackground(new java.awt.Color(0,0,255));
        B_Help.setForeground(new java.awt.Color(255,255,255));
        B_Help.setText("Help");
        MainWindow.getContentPane().add(B_Help);
        B_Help.setBounds(420,40,70,25);
        
        B_About.setBackground(new java.awt.Color(0,0,255));
        B_About.setForeground(new java.awt.Color(255,255,255));
        B_About.setText("Disconnect");
        MainWindow.getContentPane().add(B_About);
        B_About.setBounds(340,40,75,25);
        
        L_Message.setText("Message: ");
        MainWindow.getContentPane().add(L_Message);
        L_Message.setBounds(10,10,60,20);
        
        T_Message.setForeground(new java.awt.Color(0,0,255));
        T_Message.requestFocus();
        MainWindow.getContentPane().add(T_Message);
        T_Message.setBounds(70,4,260,30);
        
         L_Message.setText("Message: ");
        MainWindow.getContentPane().add(L_Message);
        L_Message.setBounds(10,10,60,20);
        
        T_Message.setForeground(new java.awt.Color(0,0,255));
        T_Message.requestFocus();
        MainWindow.getContentPane().add(T_Message);
        T_Message.setBounds(70,4,260,30);
        
        L_Conversation.setHorizontalAlignment(SwingConstants.CENTER);
        L_Conversation.setText("Conversation");
        MainWindow.getContentPane().add(L_Conversation);
        L_Message.setBounds(100,70,140,16);
        
        T_Conversation.setColumns(20);
        T_Conversation.setFont(new java.awt.Font("Tahoma",0,12));
        T_Conversation.setForeground(new java.awt.Color(0,0,255));
        T_Conversation.setLineWrap(true);
        T_Conversation.setRows(5);
        T_Conversation.setEditable(false);
        
        S_Conversation.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        S_Conversation.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        S_Conversation.setViewportView(T_Conversation);
        MainWindow.getContentPane().add(S_Conversation);
        S_Conversation.setBounds(10, 90, 330, 180);
        
        L_Online.setHorizontalAlignment(SwingConstants.CENTER);
        L_Online.setText("Currently online");
        L_Online.setToolTipText("");
        MainWindow.getContentPane().add(L_Online);
        L_Online.setBounds(350,70,130,16);
        
        String[] testn={"joak","nik","Harper","Carlo"};
        Li_Online.setForeground(new java.awt.Color(0,0,255));
        Li_Online.setListData(testn);
        S_Online.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        S_Online.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        S_Online.setViewportView(Li_Online);
        MainWindow.getContentPane().add(S_Online);
        S_Online.setBounds(350,90,130,180);
        
        L_Loggedinas.setFont(new java.awt.Font("Tahoma",0,12));
        L_Loggedinas.setText("Currently logged in as ");
        MainWindow.getContentPane().add(L_Loggedinas);
        L_Loggedinas.setBounds(348, 0, 140, 15);
        
        L_Loggedinasbox.setHorizontalAlignment(SwingConstants.CENTER);
        L_Loggedinasbox.setFont(new java.awt.Font("Tahoma",0,12));
        L_Loggedinasbox.setForeground(new java.awt.Color(255,0,0));
        L_Loggedinasbox.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        MainWindow.getContentPane().add(L_Loggedinasbox);
        L_Loggedinasbox.setBounds(340,17,150,20);
        
        
    }


    public static void BuildLogInWindow() {
        Loginwindow.setTitle("Como te llamas? ");
        Loginwindow.setSize(400,100);
        Loginwindow.setLocation(250,200); 
        Loginwindow.setResizable(false);
        P_Login= new JPanel();
        P_Login.add(L_Enterusername);   
        P_Login.add(T_username);
        P_Login.add(B_Enter);
        Loginwindow.add(P_Login);
        Login_Action();
        Loginwindow.setVisible(true);
    }
    public static void Login_Action(){
        B_Enter.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent ev){
                ACTION_B_Enter();
            }
        });
    }
    public static void ACTION_B_Enter(){
        if(!T_username.getText().equals("")){
            Username=T_username.getText().trim();
            L_Loggedinasbox.setText(Username);
            Server.CurrentUsers.add(Username);
            MainWindow.setTitle(Username + "Chat box");
            Loginwindow.setVisible(false);
            B_Send.setEnabled(true);
            B_Disconnect.setEnabled(true);
            B_Connect.setEnabled(false);
            Connect();
        }
        else{
            JOptionPane.showMessageDialog(null, "please enter a name: ");
    }
        
    }
    public static void Initialize() {
        B_Send.setEnabled(false);
        B_Disconnect.setEnabled(false);
        B_Connect.setEnabled(true);
    }
    
}
