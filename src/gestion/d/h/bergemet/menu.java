///*Created by derkaoui fatima zohra  on 2019
package gestion.d.h.bergemet;

public class menu extends javax.swing.JFrame {

  
    public menu() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        butoon_etudiant = new javax.swing.JButton();
        button_affectation = new javax.swing.JButton();
        button_pavillon = new javax.swing.JButton();
        button_chambre = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 160, 240));
        jLabel1.setText("Gestion D'hebergement");

        butoon_etudiant.setBackground(new java.awt.Color(253, 160, 240));
        butoon_etudiant.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        butoon_etudiant.setText("Etudiant");
        butoon_etudiant.setMaximumSize(new java.awt.Dimension(100, 100));
        butoon_etudiant.setMinimumSize(new java.awt.Dimension(100, 100));
        butoon_etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butoon_etudiantActionPerformed(evt);
            }
        });

        button_affectation.setBackground(new java.awt.Color(253, 160, 240));
        button_affectation.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        button_affectation.setText("Affectation");
        button_affectation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_affectationActionPerformed(evt);
            }
        });

        button_pavillon.setBackground(new java.awt.Color(253, 160, 240));
        button_pavillon.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        button_pavillon.setText("Pavillon");
        button_pavillon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pavillonActionPerformed(evt);
            }
        });

        button_chambre.setBackground(new java.awt.Color(253, 160, 240));
        button_chambre.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        button_chambre.setText("Chambre");
        button_chambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chambreActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Desktop\\RESIN\\WS\\download.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_pavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(button_chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(butoon_etudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(button_affectation)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butoon_etudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_pavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(button_affectation, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butoon_etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butoon_etudiantActionPerformed
     interface_etudiant etudiant = new interface_etudiant();
     etudiant.setVisible(true);
     etudiant.pack();
             
    }//GEN-LAST:event_butoon_etudiantActionPerformed

    private void button_chambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chambreActionPerformed
interface_chambre chambre= new interface_chambre();
chambre.setVisible(true);
chambre.pack();
    }//GEN-LAST:event_button_chambreActionPerformed

    private void button_affectationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_affectationActionPerformed
 interface_affectation affectation= new interface_affectation();
affectation.setVisible(true);
affectation.pack();
    }//GEN-LAST:event_button_affectationActionPerformed

    private void button_pavillonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pavillonActionPerformed
interface_pavillon1 pavi=new interface_pavillon1();
pavi.setVisible(true);
pavi.pack();
      
       // pavi.setDefaultCloseOperation(Tab.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_button_pavillonActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butoon_etudiant;
    private javax.swing.JButton button_affectation;
    private javax.swing.JButton button_chambre;
    private javax.swing.JButton button_pavillon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
