/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//*Created by derkaoui fatima zohra on 2019
package gestion.d.h.bergemet;

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
public class interface_chambre extends javax.swing.JFrame {

    /**
     * Creates new form interface_chambre
     */
    public interface_chambre() {
        initComponents();
    }
    
     
    
    
 private static String username="root";
  private static String password="";
  private static String url="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
  static Connection con = null;
  
      static   Statement st = null;
        static  ResultSet res = null;
      static PreparedStatement  st1 = null;
      
     void table_chambre(){
               
String sql = "select * from chambre";

try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
       
      st=con.createStatement();
      res=st.executeQuery(sql);
           DefaultTableModel T = new DefaultTableModel();
           T.setColumnIdentifiers(new String []{"N° Pavillion" ,"N° chambre","NB Place","NB Place Dispo"});
           while(res.next()){
               T.addRow(new Object[]{res.getObject("npavillon"),res.getObject("nchambre"),res.getObject("nbplace"),res.getObject("nbplacedispo")});
               
           }
           table_chambre.setModel(T);

      
}catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
         JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }

      }
     
      void create_requet_insert(){
      try{
           String insert="INSERT INTO chambre VALUES('"+npavillon.getText()+"','"+nchambre.getText()+ "','"+nbplace.getText()+"','"+nbplacedispo.getText()+"');";
           con=DriverManager.getConnection(url, username, password);
       st1 = con.prepareStatement(insert);
      st1.executeUpdate();
      table_chambre();
          
      }catch(Exception e){
          System.out.print("err");
          System.out.print(e);
          JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
      }
       
     
 }
      void create_requet_delete(){
      
      int index = table_chambre.getSelectedRow();
      String cell = table_chambre.getValueAt(index, 0).toString();
      String delet="DELETE FROM chambre WHERE nchambre = "+cell;
        try {
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      PreparedStatement preparedStmt = con.prepareStatement(delet);
  
      preparedStmt.executeUpdate();
     
    
     table_chambre();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

          
          
      }
       
 }
      
      
      
        void create_requet_update(){
         int index = table_chambre.getSelectedRow();
        String cell = table_chambre.getValueAt(index, 0).toString();
        try{
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      Statement s = null;
      s = con.createStatement();

       String nchambre = table_chambre.getValueAt(index, 0).toString();
String npavillon = table_chambre.getValueAt(index, 1).toString();
String nbplace = table_chambre.getValueAt(index,2).toString();
String nbplacedispo = table_chambre.getValueAt(index, 3).toString();

   String update = "UPDATE chambre SET npavillon = '"+this.npavillon.getText()+
           "', nchambre= '"+this.nchambre.getText()+
            "', nbplace= '"+this.nbplace.getText()+
            "', nbplacedispo= '"+this.nbplacedispo.getText()+
           "' where nchambre = '"+this.nchambre.getText()+"'"; 
 s.execute(update);
     table_chambre();     
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        npavillon = new javax.swing.JTextField();
        nchambre = new javax.swing.JTextField();
        nbplace = new javax.swing.JTextField();
        nbplacedispo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_chambre = new javax.swing.JTable();
        Ajouter = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        QittMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("Gestion de Chambre ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setText("N° Pavillon");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setText("N° Chambre");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setText("NB Place");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel5.setText("NB Place dispo");

        nchambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nchambreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbplace, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbplacedispo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nchambre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(npavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(npavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(nchambre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(nbplace, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(nbplacedispo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_chambre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pavillon", "N° Chambre", "NB Place", "NB Place dispo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_chambre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_chambreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_chambre);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        Ajouter.setForeground(new java.awt.Color(255, 255, 255));
        Ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-clé-50.png")); // NOI18N
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        supprimer.setForeground(new java.awt.Color(255, 255, 255));
        supprimer.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-clé-50 (1).png")); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        modifier.setForeground(new java.awt.Color(240, 240, 240));
        modifier.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\icons8-clé-50 (2).png")); // NOI18N
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\arrow_refresh_15732.png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
       create_requet_delete();
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       table_chambre();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
      create_requet_insert();
    }//GEN-LAST:event_AjouterActionPerformed

    private void table_chambreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_chambreMouseClicked
         int ligne = table_chambre.getSelectedRow();
        String n_pavillon = table_chambre.getModel().getValueAt(ligne, 0).toString();
        String n_chambre=table_chambre.getModel().getValueAt(ligne, 1).toString();
 String nb_place=table_chambre.getModel().getValueAt(ligne, 2).toString();
         String nb_placedispo=table_chambre.getModel().getValueAt(ligne, 3).toString();


        npavillon.setText(n_pavillon);
        nchambre.setText(n_chambre);
         nbplace.setText(nb_place);
          nbplacedispo.setText(nb_placedispo);


        
    }//GEN-LAST:event_table_chambreMouseClicked

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
create_requet_update();    }//GEN-LAST:event_modifierActionPerformed

    private void nchambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nchambreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nchambreActionPerformed

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
            java.util.logging.Logger.getLogger(interface_chambre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface_chambre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface_chambre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface_chambre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interface_chambre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private javax.swing.JMenuItem QittMenu;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nbplace;
    private javax.swing.JTextField nbplacedispo;
    private javax.swing.JTextField nchambre;
    private javax.swing.JTextField npavillon;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable table_chambre;
    // End of variables declaration//GEN-END:variables
}
