/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikiupdater;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Graphics extends javax.swing.JPanel{
    /*
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea Input;
    private javax.swing.JTextArea Output;
    private javax.swing.JTextArea Template;
    */
    private Scanner scanner;
    
    public void Graphics (){
    }
    
    String ConsoleInput(){
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (!s.isEmpty()) {
            ConsoleOutput("Waiting for next line...");
            s = s + ConsoleInput();
            return s;
        }
        return s;
    }
    
    void ConsoleOutput(String s){
        System.out.println(s);
    }
    
    public String GetInput(){
        String result;
        //result = Input.getText();
        ConsoleOutput("Please give the old version code:");
        result = ConsoleInput();
        ConsoleOutput("Graphics/Input: I have -- "+result);
        return result;
    }
    
    public void PrintOutput(String s){
        //Output.setText(s);
        ConsoleOutput(s);
    }
    
    public String GetTemplate(){
        String result = "";
        //result = Template.getText();
        ConsoleOutput("Please give the template:");
        result = ConsoleInput();
        ConsoleOutput("Graphics/Template: I have -- "+result);        
        return result;
    }
    /*
    public void initComponents() {
        System.out.println("initComponents");
        jScrollPane1 = new javax.swing.JScrollPane();
        Input = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Template = new javax.swing.JTextArea();
        jFrame1 = new javax.swing.JFrame();
        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Input.setColumns(20);
        Input.setRows(5);
        jScrollPane1.setViewportView(Input);

        jButton1.setText("Clear");

        jButton2.setText("Run");

        Output.setColumns(20);
        Output.setRows(5);
        jScrollPane2.setViewportView(Output);

        Template.setColumns(20);
        Template.setRows(5);
        jScrollPane3.setViewportView(Template);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(245, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(226, 226, 226))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }
    */
}