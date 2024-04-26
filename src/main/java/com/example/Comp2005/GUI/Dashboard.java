package com.example.Comp2005.GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.example.Comp2005.AppConfig;
import com.example.Comp2005.GUI.Models.CustomTextField;
import com.example.Comp2005.GUI.Models.ModelTable;
import com.example.Comp2005.maternityAPIService;
import com.example.Comp2005.models.Admission;
import com.example.Comp2005.models.Patient;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajbu
 */
public class Dashboard extends JFrame {



    /**
     * Creates new form Dashboard
     */
    public Dashboard(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        initComponents();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold default state="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel4 = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new CustomTextField("Search Patient Admissions");
        jPanel5 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("MaternityDashboard");

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 204)));

        jPanel4.setBackground(new Color(153, 204, 255));

        jLabel1.setIcon(new ImageIcon("C:\\Users\\rajbu\\Downloads\\output-onlinepngtools-removebg-preview.png")); // NOI18N
        jLabel1.setText("jLabel1");

        jTextField1.setBackground(UIManager.getDefaults().getColor("Button.default.pressedBackground"));
        //jTextField1.setText("Search Patient Admissions");
        jTextField1.setPreferredSize(new Dimension(153, 45));
        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    clearCellContent();
                    errorCode = 0;
                    searchBarInput = jTextField1.getText();
                    try {
                        processInput(searchBarInput);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(patientAdmissions.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Patient has no admissions");
                    }
                    if (errorCode < 400)
                        try {
                            setCellContent_Admissions(searchBarInput);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                }
            }
        });




        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
                                .addGap(214, 214, 214))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("hospitalIcon");

        jPanel5.setBackground(new Color(153, 204, 255));

        jButton1.setBackground(UIManager.getDefaults().getColor("Button.default.pressedBackground"));
        jButton1.setText("Home");

        jButton2.setBackground(UIManager.getDefaults().getColor("Button.default.pressedBackground"));
        jButton2.setText("Patients");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(UIManager.getDefaults().getColor("Button.default.pressedBackground"));
        jButton3.setText("Documents");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(345, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(153, 204, 255));
        jPanel2.setPreferredSize(new Dimension(796, 50));

        jScrollPane1.setBackground(UIManager.getDefaults().getColor("Button.focusedBorderColor"));
        jScrollPane1.setForeground(UIManager.getDefaults().getColor("Button.focusedBorderColor"));

        jTable1.setBackground(UIManager.getDefaults().getColor("Button.focusedBorderColor"));
        jTable1.setForeground(UIManager.getDefaults().getColor("Button.default.hoverBorderColor"));
        jTable1.setModel(new ModelTable(

                new Object [][] {
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null}
                },
                new String [] {
                        "Admission ID","Patient ID","Patient Name","Nhs Number", "Admission Date", "Discharge Date"
                }

        ));
        jTable1.setName("Admissiontable"); // NOI18N
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("AdmissionTable");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void jButton2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(restTemplate).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private CustomTextField jTextField1;
    public String searchBarInput;
    public JOptionPane errorPopup;
    public int errorCode;
    // 404 = patient not found 400 = invalid input (no input or no spaces in input or too many spaces in input)
    // 418 = teapot lmao 200 = no error yippee

    // End of variables declaration
    // Gui Processing and Logic

    private static RestTemplate restTemplate = new RestTemplate();

    //public String searchBarInput;

    public List<Admission> patientAdmissions = new ArrayList<>();

    //public GuiProcessor(RestTemplate restTemplate) {
        //this.restTemplate = restTemplate;
    //}

    public void processInput(String input) throws IOException {
        if(searchBarInput != null){
            input = input.trim();
            String[] splitInput = input.split("\\s+");

            for(int p = 0; p < splitInput.length; p++){
                if(!splitInput[p].isEmpty()){
                    splitInput[p] = Character.toUpperCase(splitInput[p].charAt(0)) + splitInput[p].substring(1).toLowerCase();
                }
            }

            if(splitInput.length == 2){
                maternityAPIService newMAS = new maternityAPIService(restTemplate, AppConfig.apiURL);
                patientAdmissions = newMAS.F1(splitInput[0], splitInput[1]);
                if(newMAS.errorCode > 400){
                    errorHandling(newMAS.errorCode);
                }
            } else if (splitInput.length < 2) {
                errorCode = 400;
                errorHandling(errorCode);
                System.out.println("Error Code: " + errorCode + "(Invalid Input)");
            }
        }
    }



    public void clearCellContent(){
        int rowCount = jTable1.getRowCount();
        int colCount = jTable1.getColumnCount();

        for (int row = 0; row < rowCount; row++){
            for ( int col = 0; col < colCount; col++ ){
                jTable1.setValueAt(null, row, col);
            }
        }
    }

    public void errorHandling(int errorcode){
        switch(errorcode){
            case 400:
                JOptionPane.showMessageDialog(null, "Error Code:" + errorcode +"\n" + "Please input patient name in format"+"\n" +"(forename) (surname)");
                jTextField1.setText("");
                break;
            case 404:
                JOptionPane.showMessageDialog(null, "Error Code:" + errorcode +"\n" + "Patient not found");
                jTextField1.setText("");
                break;
            default:
                System.out.println("no error, yippee");
                break;
        }
    }


    public void setCellContent_Admissions(String input) throws IOException {
        int rowCount = jTable1.getRowCount();
        int colCount = jTable1.getColumnCount();

        maternityAPIService newMAS = new maternityAPIService(restTemplate, AppConfig.apiURL);

        String[] splitInput = input.split("\\s+");

        for(int p = 0; p < splitInput.length; p++){
            if(!splitInput[p].isEmpty()){
                splitInput[p] = Character.toUpperCase(splitInput[p].charAt(0)) + splitInput[p].substring(1).toLowerCase();
            }
        }

        Patient searchedPatient = newMAS.getPatientDetails(splitInput[0], splitInput[1]);


        for (int row = 0; row < rowCount; row++){
            for ( int col = 0; col < colCount; col++ ){
                switch(col){
                    case 0:
                        if(row < patientAdmissions.size()){
                            jTable1.setValueAt(patientAdmissions.get(row).getId(), row, col);
                        }else{
                            break;
                        }
                        break;
                    case 1:
                        if(row < patientAdmissions.size()){
                            jTable1.setValueAt(patientAdmissions.get(row).getPatientID(), row, col);
                        }else{
                            break;
                        }
                        break;
                    case 2:
                        if(row < patientAdmissions.size()){
                            jTable1.setValueAt(searchedPatient.getForename() + " " + searchedPatient.getSurname(), row, col);
                        }else{
                            break;
                        }
                        break;
                    case 3:
                        if(row < patientAdmissions.size()){
                            jTable1.setValueAt(searchedPatient.getNhsNumber(), row, col);
                        }else{
                            break;
                        }
                        break;
                    case 4:
                        if(row < patientAdmissions.size()){
                            jTable1.setValueAt(patientAdmissions.get(row).getAdmissionDate(), row, col);
                        }else{
                            break;
                        }
                        break;
                    case 5:
                        if(row < patientAdmissions.size()){
                            if(Objects.equals(patientAdmissions.get(row).getDischargeDate(), "0001-01-01T00:00:00")) {
                                jTable1.setValueAt("Not Discharged yet", row, col);

                            }else {
                                jTable1.setValueAt(patientAdmissions.get(row).getDischargeDate(), row, col);

                            }
                        }else{
                            break;
                        }
                        break;
                }
            }
        }
    }

}

