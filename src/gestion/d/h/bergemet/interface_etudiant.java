/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
///*Created by derkaoui fatima zohra on 2019
package gestion.d.h.bergemet;//

import static gestion.d.h.bergemet.interface_pavillon1.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gis
 */
public class interface_etudiant extends javax.swing.JFrame {

   
    public interface_etudiant() {
        initComponents();
    }

    
    
       private static String username="root";
  private static String password="";
  private static String url="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
  static Connection con = null;
      static   Statement st = null;
        static  ResultSet res = null;
      static PreparedStatement  st1 = null;
    
     DefaultTableModel T = new DefaultTableModel();
   void table_etudiant(){
      
String sql = "select netudiant,nom,prenom,date_nai,nquittance from etudiant";
try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      st=con.createStatement();
      res=st.executeQuery(sql);
           DefaultTableModel T = new DefaultTableModel();
           T.setColumnIdentifiers(new String []{"netudiant" ,"nom","prenom","date_nai","nquittance"});
           while(res.next()){
               T.addRow(new Object[]{res.getObject("netudiant"),res.getObject("nom"),res.getObject("prenom"),
               res.getObject("date_nai"),res.getObject("nquittance")});
               
           }
           table_etudiant.setModel(T);

      
}catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
        JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        etudiant = new javax.swing.JTextField();
        Nom = new javax.swing.JTextField();
        Prenom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nquittance = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        date_nai = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_etudiant = new javax.swing.JTable();
        ajouter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        afficher = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        QittMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("Gestion des etudiant ");

        jPanel3.setBackground(new java.awt.Color(251, 252, 218));

        etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etudiantActionPerformed(evt);
            }
        });

        Prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrenomActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setText("N° Etudiant");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setText("Nom");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setText("Prenom");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel5.setText("Date Naissance");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel6.setText("N° Quittance");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nom)
                                    .addComponent(etudiant)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(Prenom))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nquittance, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(date_nai)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(etudiant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addComponent(Nom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(date_nai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nquittance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_etudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Etudiant", "Nom", "Prenom", "Date Naiss", "N° Quittance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_etudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_etudiantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_etudiant);

        ajouter.setBackground(new java.awt.Color(255, 255, 255));
        ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-inscription-d'étudiant-50.png")); // NOI18N
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-étudiant-homme-60.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-étudiant-homme-60 (1).png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        afficher.setBackground(new java.awt.Color(255, 255, 255));
        afficher.setForeground(new java.awt.Color(255, 255, 255));
        afficher.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\arrow_refresh_15732.png")); // NOI18N
        afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(466, 466, 466)
                                .addComponent(afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(ajouter)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(90, 90, 90))
        );

        jMenu1.setText("Menu");

        QittMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        QittMenu.setText("Quitter");
        QittMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QittMenuActionPerformed(evt);
            }
        });
        jMenu1.add(QittMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 void traintement_ajoute_etudiant(){
 }
    
    void create_requite_inser(){
      try{
           String insert="INSERT INTO etudiant VALUES('"+etudiant.getText()+"','"+
                   Nom.getText()+"','"+Prenom.getText()+
                   "','"+date_nai.getText()+"','"+nquittance.getText()+"'   ) where nquittance.etudiant=nquittance.affectation"
                   + "and affectation.nchambre=chambre.nchambre and chambre.nbplacedispo>0   ;";
                                                                                   
           con=DriverManager.getConnection(url, username, password);
       st1 = con.prepareStatement(insert);
      st1.executeUpdate();
      table_etudiant();
          
      }catch(Exception e){
          System.out.print("err");
          System.out.print(e);
          JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
      }
       
      
      
      
  }
  
  
  
    
    void create_requite_delet(){
         int index = table_etudiant.getSelectedRow();
      String cell = table_etudiant.getValueAt(index, 0).toString();
      String delet="DELETE FROM etudiant WHERE netudiant = "+cell;
        try {
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      PreparedStatement preparedStmt = con.prepareStatement(delet);
  
      preparedStmt.executeUpdate();
     
    
     table_etudiant();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

      }
    }
    
      void create_requet_update(){
         int index = table_etudiant.getSelectedRow();
        String cell = table_etudiant.getValueAt(index, 0).toString();
        try{
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      Statement s = null;
      s = con.createStatement();

       String Nom = table_etudiant.getValueAt(index, 1).toString();
String etudiant = table_etudiant.getValueAt(index, 0).toString();
String Prenom = table_etudiant.getValueAt(index, 2).toString();
String date_nai = table_etudiant.getValueAt(index, 3).toString();
String nquittance = table_etudiant.getValueAt(index, 4).toString();
   String update = "UPDATE etudiant SET netudiant = '"+this.etudiant.getText()+
           "', nom= '"+this.Nom.getText()+
   "', prenom= '"+this.Prenom.getText()+
 "', date_nai= '"+this.date_nai.getText()+
  "', nquittance= '"+this.nquittance.getText()+

           "' where netudiant = '"+etudiant+"'"; ;
 s.execute(update);
     table_etudiant();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

          
        }
    }
 
    
    
    
    
    private void QittMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QittMenuActionPerformed

        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_QittMenuActionPerformed

    private void etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etudiantActionPerformed

    private void PrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrenomActionPerformed

    private void afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherActionPerformed
    table_etudiant();
    }//GEN-LAST:event_afficherActionPerformed

    private void table_etudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_etudiantMouseClicked
 int ligne = table_etudiant.getSelectedRow();
    String netudiant=table_etudiant.getModel().getValueAt(ligne, 0).toString();
    String nom = table_etudiant.getModel().getValueAt(ligne, 1).toString();
    String prenom = table_etudiant.getModel().getValueAt(ligne, 2).toString();
    String date_nai = table_etudiant.getModel().getValueAt(ligne, 3).toString();
    String nquittance = table_etudiant.getModel().getValueAt(ligne, 4).toString();



        etudiant.setText(netudiant);
        Nom.setText(nom);  
        Prenom.setText(prenom);   
        this.date_nai.setText(date_nai);   
        this.nquittance.setText(nquittance);       



    }//GEN-LAST:event_table_etudiantMouseClicked

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
     create_requite_inser();
    }//GEN-LAST:event_ajouterActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        create_requite_delet();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
create_requet_update();    }//GEN-LAST:event_jButton3ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interface_etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface_etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface_etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface_etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interface_etudiant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField Prenom;
    private javax.swing.JMenuItem QittMenu;
    private javax.swing.JButton afficher;
    private javax.swing.JButton ajouter;
    private javax.swing.JFormattedTextField date_nai;
    private javax.swing.JTextField etudiant;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nquittance;
    private javax.swing.JTable table_etudiant;
    // End of variables declaration//GEN-END:variables
}
