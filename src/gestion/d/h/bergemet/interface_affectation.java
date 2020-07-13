/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//*Created by derkaoui fatima zohra on 2019
 
package gestion.d.h.bergemet;
import static gestion.d.h.bergemet.interface_chambre.con;
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
public class interface_affectation extends javax.swing.JFrame {

    /**
     * Creates new form interface_affectation
     */
    public interface_affectation() {
        initComponents();
    }

      private static String username="root";
  private static String password="";
  private static String url="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
  static Connection con = null;
  
      static   Statement st = null;
        static  ResultSet res = null;
      static PreparedStatement  st1 = null;
      
       private  void table_affectation(){
      
String sql = "select * from affectation";

try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
       
      st=con.createStatement();
      res=st.executeQuery(sql);
           DefaultTableModel T = new DefaultTableModel();
           T.setColumnIdentifiers(new String []{"N° Quittance" ,"N° Pavillon","N° Chambre"});
           while(res.next()){
               T.addRow(new Object[]{res.getObject("nquittance"),res.getObject("npavillon"),res.getObject("nchambre")});
               
           }
           table_affectation.setModel(T);

      
}catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
        JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }
}
       
       
        void create_requet_insert(){
      try{
           String insert="INSERT INTO affectation VALUES('"+nquittance.getText()+"','"+npavillon.getText()+ "','"+chambre.getText()+"');";
           con=DriverManager.getConnection(url, username, password);
       st1 = con.prepareStatement(insert);
      st1.executeUpdate();
      table_affectation();
          
      }catch(Exception e){
          System.out.print("err");
          System.out.print(e);
          JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
      }
       
     
 }
   
        void create_requet_update(){
         int index = table_affectation.getSelectedRow();
        String cell = table_affectation.getValueAt(index, 0).toString();
        try{
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      Statement s = null;
      s = con.createStatement();

       String nquittance = table_affectation.getValueAt(index, 0).toString();
String npavillon = table_affectation.getValueAt(index, 1).toString();
String nchambre = table_affectation.getValueAt(index,2).toString();


   String update = "UPDATE chambre SET nquittance = '"+this.nquittance.getText()+  "', npavillon= '"+
this.npavillon.getText()+  "', nchambre= '"+this.chambre.getText()+ "' where nquittance = '"+nquittance+"'"; 
 s.execute(update);
     table_affectation();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

          
        }
    }
        
        
        void create_requet_delete(){
      
      int index = table_affectation.getSelectedRow();
      String cell = table_affectation.getValueAt(index, 0).toString();
      String delet="DELETE FROM affectation WHERE nquittance = "+cell;
        try {
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      PreparedStatement preparedStmt = con.prepareStatement(delet);
  
      preparedStmt.executeUpdate();
     
    
     table_affectation();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

          
          
      }
       
 }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nquittance = new javax.swing.JTextField();
        npavillon = new javax.swing.JTextField();
        chambre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        supprime = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_affectation = new javax.swing.JTable();
        afficher = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        QittMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        jLabel1.setText("Gestion Affectation");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        nquittance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nquittanceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setText("N° Quittance ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setText("N° Pavillon");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setText("N° Chambre");

        ajouter.setBackground(new java.awt.Color(255, 255, 255));
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-document-50.png")); // NOI18N
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        supprime.setBackground(new java.awt.Color(255, 255, 255));
        supprime.setForeground(new java.awt.Color(255, 255, 255));
        supprime.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-document-50 (1).png")); // NOI18N
        supprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimeActionPerformed(evt);
            }
        });

        modifier.setBackground(new java.awt.Color(255, 255, 255));
        modifier.setForeground(new java.awt.Color(255, 255, 255));
        modifier.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-document-50 (2).png")); // NOI18N
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(npavillon)
                            .addComponent(chambre, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(nquittance)))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supprime, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nquittance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(npavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supprime, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        table_affectation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Quittance", "N° Pavillon", "N° Chambre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_affectation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_affectationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_affectation);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(afficher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QittMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QittMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QittMenuActionPerformed

    private void nquittanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nquittanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nquittanceActionPerformed

    private void table_affectationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_affectationMouseClicked
         int ligne = table_affectation.getSelectedRow();
         String n_quittance= table_affectation.getModel().getValueAt(ligne, 0).toString();
        String n_pavillon = table_affectation.getModel().getValueAt(ligne, 1).toString();
        String n_chambre=table_affectation.getModel().getValueAt(ligne, 2).toString();
        nquittance.setText(n_quittance);
        npavillon.setText(n_pavillon);
        chambre.setText(n_chambre);
    }//GEN-LAST:event_table_affectationMouseClicked

    private void afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherActionPerformed
table_affectation();
    }//GEN-LAST:event_afficherActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        create_requet_insert();
    }//GEN-LAST:event_ajouterActionPerformed

    private void supprimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimeActionPerformed
      create_requet_update();
    }//GEN-LAST:event_supprimeActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        create_requet_delete();
    }//GEN-LAST:event_modifierActionPerformed

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
            java.util.logging.Logger.getLogger(interface_affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface_affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface_affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface_affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interface_affectation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem QittMenu;
    private javax.swing.JButton afficher;
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField chambre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField npavillon;
    private javax.swing.JTextField nquittance;
    private javax.swing.JButton supprime;
    private javax.swing.JTable table_affectation;
    // End of variables declaration//GEN-END:variables
}
