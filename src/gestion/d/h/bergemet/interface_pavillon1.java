/////*Created by derkaoui fatima zohra on 2019
package gestion.d.h.bergemet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class interface_pavillon1 extends javax.swing.JFrame {
    public interface_pavillon1() {
        initComponents(); }
  private static String username="root";
  private static String password="";
  private static String url="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
  static Connection con = null;
      static   Statement st = null;
        static  ResultSet res = null;
      static PreparedStatement  st1 = null;
     void create_requet_insert(){
     
      try{
           String insert="INSERT INTO pavillon VALUES('"+npavillon.getText()+"','"+nompavillon.getText()+"')       ;";
         
           con=DriverManager.getConnection(url, username, password);
       st1 = con.prepareStatement(insert);
      st1.executeUpdate();
      table_pavillon();
          
      }catch(Exception e){
          System.out.print("err");
          System.out.print(e);
          JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
      }
       
     
 }
   
 
 void visulation_etudiant(){
    
     String sql = "SELECT * FROM etudiant INNER JOIN affectation ON etudiant.nquittance=affectation.nquittance "
             + "INNER JOIN pavillon ON pavillon.npavillon=affectation.npavillon WHERE pavillon.npavillon ='"+ npavillon_rec.getText()+"'";
 ResultSet res1=null;
try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      st=con.createStatement();
      res1=st.executeQuery(sql);
          DefaultTableModel T = new DefaultTableModel();   
          T.setColumnIdentifiers(new String []{"netudiant" ,"nom","prenom","date_nai","nquittance"});

          while(res1.next()){  

               T.addRow(new Object[]{res1.getObject("netudiant"),
                   res1.getObject("nom"),res1.getObject("prenom"),
                   res1.getObject("date_nai"),
                   res1.getObject("nquittance")});
           }
           
            etud.setModel(T);

      
}catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
        JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }
     
 }
    
 void visulation_chambre(){     
     String sql = "SELECT * FROM chambre INNER JOIN pavillon "
             + "ON chambre.npavillon= pavillon.npavillon "
             + " WHERE pavillon.npavillon ='"+ pavillon_chambre.getText()+"'";
 ResultSet res1=null;
try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      st=con.createStatement();
      res1=st.executeQuery(sql);
          DefaultTableModel T = new DefaultTableModel();   
          T.setColumnIdentifiers(new String []{"npavillon" ,"nchambre","nbplace","nbplacedispo"});
          while(res1.next()){  
               T.addRow(new Object[]{res1.getObject("npavillon"),
                   res1.getObject("nchambre"),res1.getObject("nbplace"),
                   res1.getObject("nbplacedispo")});
           }
            cham.setModel(T);
}catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
        JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }
     
 }
 
 void visulation_chambre_place_libre(){
        
     String sql = "SELECT * FROM chambre INNER JOIN pavillon ON chambre.npavillon= pavillon.npavillon "
             + " WHERE pavillon.npavillon ='"+ pavillon_chambre_libre.getText()+"' and nbplacedispo > "+0;
 ResultSet res1=null;
try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      st=con.createStatement();
      res1=st.executeQuery(sql);
          DefaultTableModel T = new DefaultTableModel();   
          T.setColumnIdentifiers(new String []{"npavillon" ,"nchambre","nbplace","nbplacedispo"});

          while(res1.next()){  

               T.addRow(new Object[]{res1.getObject("npavillon"),
                   res1.getObject("nchambre"),res1.getObject("nbplace"),
                   res1.getObject("nbplacedispo")});
           }
           
            table_place_libre.setModel(T);

      
}catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
        JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }
     
 }
 
 void create_requet_delete(){
      
      int index = table_paviilon.getSelectedRow();
      String cell = table_paviilon.getValueAt(index, 0).toString();
      String delet="DELETE FROM pavillon WHERE npavillon = "+cell;
        try {
    String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      PreparedStatement preparedStmt = con.prepareStatement(delet);
  
      preparedStmt.executeUpdate();
     
    
     table_pavillon();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

          
          
      }
       
 }
  private  void table_pavillon(){  
String sql = "select npavillon,nompavillon from pavillon";
try{
       String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      st=con.createStatement();
      res=st.executeQuery(sql);
           DefaultTableModel T = new DefaultTableModel();
           T.setColumnIdentifiers(new String []{"npavillion" ,"nompavillon"});
           while(res.next()){
               T.addRow(new Object[]{res.getObject("npavillon"),res.getObject("nompavillon")});}
           table_paviilon.setModel(T);}
catch(SQLException e){
        System.out.println(e.getMessage());     
        System.err.print("problem de connexion ");
        JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);
         }}
      
    void create_requet_update(){
         int index = table_paviilon.getSelectedRow();
        String cell = table_paviilon.getValueAt(index, 0).toString();
        try{
        String url1="jdbc:mysql://localhost:3306/gestion_hebergement?zeroDateTimeBehavior=convertToNull";
       con=DriverManager.getConnection(url1,"root","");
      Statement s = null;
      s = con.createStatement();

       String npavillon = table_paviilon.getValueAt(index, 0).toString();
       String nompavillon = table_paviilon.getValueAt(index, 1).toString();

   String update = "UPDATE pavillon SET nompavillon = '"
           +this.nompavillon.getText()+"', npavillon= '"
           +this.npavillon.getText()+"' where npavillon = '"
           +npavillon+"'"; ;
 s.execute(update);
     table_pavillon();     
      }catch(Exception e){
          System.err.println(e);
  JOptionPane.showMessageDialog(null, e.getMessage(), "errur", 1);

          
        }
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        npavillon = new javax.swing.JTextField();
        nompavillon = new javax.swing.JTextField();
        Button_ajouter = new javax.swing.JButton();
        Button_supp = new javax.swing.JButton();
        Button_rech = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_paviilon = new javax.swing.JTable();
        Button_affiche = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        npavillon_rec = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        etud = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        cham = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pavillon_chambre = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pavillon_chambre_libre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_place_libre = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        npa = new javax.swing.JLabel();
        nompav = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        QittMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel5.setText("Gestion de pavillon ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setText("N° Pavillon");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel7.setText("Nom Pavillon");

        npavillon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                npavillonKeyReleased(evt);
            }
        });

        nompavillon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nompavillonKeyReleased(evt);
            }
        });

        Button_ajouter.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Button_ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\1486485588-add-create-new-math-sign-cross-plus_81186 (1).png")); // NOI18N
        Button_ajouter.setText("Ajouter");
        Button_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ajouterActionPerformed(evt);
            }
        });

        Button_supp.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Button_supp.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\Error_36910.png")); // NOI18N
        Button_supp.setText("Supprimer");
        Button_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_suppActionPerformed(evt);
            }
        });

        Button_rech.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Button_rech.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\recycle_256_icon-icons.com_76004.png")); // NOI18N
        Button_rech.setText("Modifier");
        Button_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_rechActionPerformed(evt);
            }
        });

        jScrollPane3.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane3MouseWheelMoved(evt);
            }
        });

        table_paviilon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pavillon", "Nom Pavillon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_paviilon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_paviilonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_paviilon);

        Button_affiche.setBackground(new java.awt.Color(255, 255, 255));
        Button_affiche.setForeground(new java.awt.Color(255, 255, 255));
        Button_affiche.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\arrow_refresh_15732.png")); // NOI18N
        Button_affiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_afficheActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(242, 226, 161));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\arrow_refresh_15732.png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Traditional Arabic", 3, 14)); // NOI18N
        jLabel8.setText("npavillon");

        etud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "netudiant", "nom", "prenom", "date_nai", "nquittance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(etud);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel1.setText("Visulation des etudiant par pavillon ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(478, 478, 478))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(npavillon_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(npavillon_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 231, 187));

        cham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pavillon", "N° Chambre", "NB Place", "NB Place Dispo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cham);

        jScrollPane4.setViewportView(jScrollPane2);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\arrow_refresh_15732.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setText("Visulation les chambre par pavillon");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setText("N° Pavillon");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(pavillon_chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pavillon_chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(240, 220, 172));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setText("Visulation les place libre de chambre par pavillon  ");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel9.setText("N° Pavillon");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\arrow_refresh_15732.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(253, 226, 226));

        table_place_libre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pavillon", "N° Chambre", "NB Place", "NB Place Dispo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table_place_libre);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pavillon_chambre_libre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pavillon_chambre_libre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\gis\\Documents\\NetBeansProjects\\gestion-d-h-bergemet\\image\\etudiant-teen-mignon-vecteur-caractere-retour-au-contenu-ecole_78094-522.jpg")); // NOI18N

        npa.setForeground(new java.awt.Color(255, 0, 0));

        nompav.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Button_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Button_supp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Button_rech, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nompavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(npavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(npa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nompav, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button_affiche, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(npavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(npa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nompavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nompav, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_ajouter)
                            .addComponent(Button_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_rech))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(Button_affiche, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void Button_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ajouterActionPerformed

        create_requet_insert();

    }//GEN-LAST:event_Button_ajouterActionPerformed

    private void Button_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_suppActionPerformed

        create_requet_delete();
    }//GEN-LAST:event_Button_suppActionPerformed

    private void Button_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_rechActionPerformed
        create_requet_update();
    }//GEN-LAST:event_Button_rechActionPerformed

    private void table_paviilonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_paviilonMouseClicked
        int ligne = table_paviilon.getSelectedRow();
        String nam_pavillon = table_paviilon.getModel().getValueAt(ligne, 1).toString();
        String n_pavillon=table_paviilon.getModel().getValueAt(ligne, 0).toString();
        npavillon.setText(n_pavillon);
        nompavillon.setText(nam_pavillon);

    }//GEN-LAST:event_table_paviilonMouseClicked

    private void jScrollPane3MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane3MouseWheelMoved

        int selectedRow = table_paviilon.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table_paviilon.getModel();
        npavillon.setText(model.getValueAt(selectedRow, 0).toString());
        nompavillon.setText(model.getValueAt(selectedRow, 1).toString());

    }//GEN-LAST:event_jScrollPane3MouseWheelMoved

    private void Button_afficheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_afficheActionPerformed
        table_pavillon();
    }//GEN-LAST:event_Button_afficheActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        visulation_etudiant();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        visulation_chambre();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
visulation_chambre_place_libre();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void npavillonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npavillonKeyReleased
        
      
        

    }//GEN-LAST:event_npavillonKeyReleased

    private void nompavillonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nompavillonKeyReleased
     
    }//GEN-LAST:event_nompavillonKeyReleased

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
            java.util.logging.Logger.getLogger(interface_pavillon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface_pavillon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface_pavillon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface_pavillon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interface_pavillon1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_affiche;
    private javax.swing.JButton Button_ajouter;
    private javax.swing.JButton Button_rech;
    private javax.swing.JButton Button_supp;
    private javax.swing.JMenuItem QittMenu;
    private javax.swing.JTable cham;
    private javax.swing.JTable etud;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nompav;
    private javax.swing.JTextField nompavillon;
    private javax.swing.JLabel npa;
    private javax.swing.JTextField npavillon;
    private javax.swing.JTextField npavillon_rec;
    private javax.swing.JTextField pavillon_chambre;
    private javax.swing.JTextField pavillon_chambre_libre;
    private javax.swing.JTable table_paviilon;
    private javax.swing.JTable table_place_libre;
    // End of variables declaration//GEN-END:variables
}
