
package snackbarco;

import Common.OpenPdf;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.BDao;
import dao.CDao;
import dao.PDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;

/**
 *
 * @author Tahscene
 */
public class PlaceOrder extends javax.swing.JFrame {
    public int billId=1;
    public int grandTotal=0;
    public int productprice=0;
    public int producttotal=0;
    public String emailpattern= "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobPattern= "^[0-9]*$";
    
    
    
public String userEmail;
    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
    }
 public PlaceOrder(String email) {
        initComponents();
        txtpronam.setEditable(false);
        txtproprice.setEditable(false);
        txtprototal.setEditable(false);
        addtocart.setEnabled(false);
        generatebill.setEnabled(false);
        JFormattedTextField tf= ((JSpinner.DefaultEditor)jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail= email;
    }
 public void productNameByCategory(String category){
    DefaultTableModel dtm= (DefaultTableModel) jTable1.getModel();
    dtm.setRowCount(0);
        ArrayList<Product> list= PDao.getAllRecordsByCategory(category);
        Iterator<Product> itr= list.iterator();
        while(itr.hasNext())
        {
            Product pObj= itr.next();
             
             dtm.addRow(new Object[]{pObj.getName()});
               }
}

 public void filterProductByname(String name,String category){
    DefaultTableModel dtm= (DefaultTableModel) jTable1.getModel();
    dtm.setRowCount(0);
        ArrayList<Product> list= PDao.filterProductByname(name, category);
        Iterator<Product> itr= list.iterator();
        while(itr.hasNext())
        {
            Product pObj= itr.next();
             
             dtm.addRow(new Object[]{pObj.getName()});
               }
} 
 public void clearProductFields(){
      txtpronam.setText("");
        txtproprice.setText("");
        jSpinner1.setValue(1);
        txtprototal.setText("");
        addtocart.setEnabled(false);
        }
 public void validateField(){
     String cname=txtCusName.getText();
     String cno= txtCusNo.getText();
     String cemail=txtCusmail.getText();
     if(!cemail.equals("")&& cno.matches(mobPattern)&& cno.length()==10 && cemail.matches(emailpattern)&& grandTotal>0){
            generatebill.setEnabled(true);
     }
        else
            generatebill.setEnabled(false);
     
  }
 public boolean qtyZero(int qty) {
        if (qty == 0) {
         
            JOptionPane.showMessageDialog(null, "Please select an item first :)");
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtCusName = new javax.swing.JTextField();
        txtCusmail = new javax.swing.JTextField();
        cat = new javax.swing.JComboBox<>();
        txtproprice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtpronam = new javax.swing.JTextField();
        txtprototal = new javax.swing.JTextField();
        txtsrch = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        generatebill = new javax.swing.JButton();
        addtocart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnclr = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCusNo = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lblgrandtotal = new javax.swing.JLabel();
        grdt = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 159, 70, 30));

        txtCusName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCusName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusNameActionPerformed(evt);
            }
        });
        txtCusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 209, 220, -1));

        txtCusmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCusmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusmailActionPerformed(evt);
            }
        });
        txtCusmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 409, 220, 30));

        cat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catActionPerformed(evt);
            }
        });
        getContentPane().add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 118, 220, -1));

        txtproprice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtproprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpropriceActionPerformed(evt);
            }
        });
        txtproprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpropriceKeyReleased(evt);
            }
        });
        getContentPane().add(txtproprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 118, 220, -1));

        jTable1.setBackground(new java.awt.Color(0, 255, 204));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 305, 220, 285));

        txtpronam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpronam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpronamActionPerformed(evt);
            }
        });
        txtpronam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpronamKeyReleased(evt);
            }
        });
        getContentPane().add(txtpronam, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 118, 220, -1));

        txtprototal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtprototal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprototalActionPerformed(evt);
            }
        });
        txtprototal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprototalKeyReleased(evt);
            }
        });
        getContentPane().add(txtprototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 209, 220, -1));

        txtsrch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtsrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsrchActionPerformed(evt);
            }
        });
        txtsrch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsrchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsrch, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 209, 220, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 209, 220, -1));

        generatebill.setBackground(new java.awt.Color(0, 153, 153));
        generatebill.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        generatebill.setText("Generate Bill & Print");
        generatebill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        generatebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatebillActionPerformed(evt);
            }
        });
        getContentPane().add(generatebill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1046, 609, 184, 40));

        addtocart.setBackground(new java.awt.Color(0, 153, 153));
        addtocart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        addtocart.setText("Add to Cart");
        addtocart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartActionPerformed(evt);
            }
        });
        getContentPane().add(addtocart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 255, 150, 30));

        jTable2.setBackground(new java.awt.Color(0, 255, 204));
        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 305, 527, 285));

        btnclr.setBackground(new java.awt.Color(0, 153, 153));
        btnclr.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnclr.setText("Clear");
        btnclr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclrActionPerformed(evt);
            }
        });
        getContentPane().add(btnclr, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 255, 160, 30));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/21.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, -1, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Place Order");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 1, 250, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Bill ID :--");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 190, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 90, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Email");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 90, 30));

        jPanel7.setBackground(new java.awt.Color(255, 255, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Mobile No");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, 30));

        jPanel10.setBackground(new java.awt.Color(255, 255, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Category");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 100, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 51));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Quantity");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 30));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 110, 30));

        jPanel12.setBackground(new java.awt.Color(255, 255, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Search");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 30));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 100, 30));

        jPanel13.setBackground(new java.awt.Color(255, 255, 51));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Name");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 30));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 110, 30));

        txtCusNo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCusNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusNoActionPerformed(evt);
            }
        });
        txtCusNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusNoKeyReleased(evt);
            }
        });
        jPanel1.add(txtCusNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 220, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setText("Total");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, 90, 30));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 100, 30));

        jPanel14.setBackground(new java.awt.Color(255, 255, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Price");
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 100, 30));

        jPanel15.setBackground(new java.awt.Color(255, 255, 51));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblgrandtotal.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblgrandtotal.setText("000");
        jPanel15.add(lblgrandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 90, 40));

        grdt.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        grdt.setText("Grand Total : Tk.");
        jPanel15.add(grdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 270, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/12.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 760));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCusNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusNameActionPerformed

    private void txtCusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusNameKeyReleased
validateField();         
    }//GEN-LAST:event_txtCusNameKeyReleased

    private void txtCusNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusNoActionPerformed

    private void txtCusNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusNoKeyReleased
validateField();        
    }//GEN-LAST:event_txtCusNoKeyReleased

    private void txtCusmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusmailActionPerformed

    private void txtCusmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusmailKeyReleased
validateField();         
    }//GEN-LAST:event_txtCusmailKeyReleased

    private void txtpropriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpropriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpropriceActionPerformed

    private void txtpropriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpropriceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpropriceKeyReleased

    private void txtpronamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpronamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpronamActionPerformed

    private void txtpronamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpronamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpronamKeyReleased

    private void txtprototalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprototalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprototalActionPerformed

    private void txtprototalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprototalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprototalKeyReleased

    private void txtsrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsrchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsrchActionPerformed

    private void txtsrchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsrchKeyReleased
      String name=txtsrch.getText();
      String category =(String)cat.getSelectedItem();
      filterProductByname(name,category);
    }//GEN-LAST:event_txtsrchKeyReleased

    private void generatebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatebillActionPerformed
        String cname=txtCusName.getText();
        String cmob=txtCusNo.getText();
        String cemail=txtCusmail.getText();
        SimpleDateFormat dFormat= new SimpleDateFormat("dd-MM-yyyy");
        Date date=new Date();
        String todaydate=dFormat.format(date);
        String total=String.valueOf(grandTotal);
        String createdBy =userEmail;
        Bill bill= new Bill();
        bill.setId(billId);
        bill.setName(cname);
        bill.setNo(cmob);
        bill.setEmail(cemail);
        bill.setDate(todaydate);
        bill.setTotal(total);
        bill.setCreatedBy(createdBy);
       BDao.save(bill);
       String path = "D:\\";
       com.itextpdf.text.Document doc= new  com.itextpdf.text.Document();
       try{
           PdfWriter.getInstance(doc, new FileOutputStream(path + " "+ billId + ".pdf"));
           doc.open();
         Paragraph cafeName= new  Paragraph("                                                                        Bean Haven\n");
         doc.add(cafeName);
         Paragraph starLine = new Paragraph("****************************************************************************************************************");
         doc.add(starLine);
         Paragraph paragraph3= new Paragraph("\tBill ID:"+billId+"\nCustomer Name : "+cname+"\nTotal Paid: "+grandTotal);
         doc.add(paragraph3);
         doc.add(starLine);
         PdfPTable tbl= new PdfPTable(4);
         tbl.addCell("Name");
         tbl.addCell("Price");
         tbl.addCell("Quantity");
         tbl.addCell("Total");
         for(int i=0; i<jTable2.getRowCount();i++){
         String n= jTable2.getValueAt(i,0).toString();
         String d= jTable2.getValueAt(i,1).toString();
         String r= jTable2.getValueAt(i,2).toString();
         String q= jTable2.getValueAt(i,3).toString();
         tbl.addCell(n);
         tbl.addCell(d);
         tbl.addCell(r);
         tbl.addCell(q);
         }
         doc.add(tbl);
         doc.add(starLine);
         Paragraph thankMsg = new Paragraph("Thank You, Plase Visit Again <3");
         doc.add(thankMsg);
         OpenPdf.openById(String.valueOf(billId));
         
         
    }//GEN-LAST:event_generatebillActionPerformed
catch(Exception e){
    
    JOptionPane.showMessageDialog(null,e);
}
       doc.close();
       setVisible(false);
       new PlaceOrder(createdBy).setVisible(true);
    }
    private void addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartActionPerformed
String name= txtpronam.getText();
String price= txtproprice.getText();
String quantity= String.valueOf(jSpinner1.getValue());
DefaultTableModel dtm= (DefaultTableModel) jTable2.getModel();
dtm.addRow(new Object[]{name, price, quantity, producttotal});
grandTotal= grandTotal+producttotal;
lblgrandtotal.setText(String.valueOf(grandTotal));
clearProductFields();
validateField();
    }//GEN-LAST:event_addtocartActionPerformed

    private void btnclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnclrActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
     billId= Integer.parseInt(BDao.getId());
     jLabel3.setText(BDao.getId());
     
        ArrayList<Category> list= CDao.getAllRecords();
        Iterator<Category> itr= list.iterator();
        while(itr.hasNext())
        {
            Category categoryObj= itr.next();
            cat.addItem(categoryObj.getName());
            
    } 
        String category =(String)cat.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index= jTable1.getSelectedRow();
        TableModel model= jTable1.getModel();
        String pname= model.getValueAt(index,0).toString();
        Product product= PDao.getAllProductByName(pname);
        txtpronam.setText(product.getName());
        txtproprice.setText(product.getPrice());
        jSpinner1.setValue(1);
        txtprototal.setText(product.getPrice());
        productprice=Integer.parseInt(product.getPrice());
        producttotal=Integer.parseInt(product.getPrice());
        
        addtocart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        int quantity=(Integer)jSpinner1.getValue();
        if(quantity<=1){
            jSpinner1.setValue(1);
            quantity=1;
        }
        producttotal= productprice*quantity;
        txtprototal.setText(String.valueOf(producttotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catActionPerformed
       String category= (String)cat.getSelectedItem();
       productNameByCategory(category);
    }//GEN-LAST:event_catActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         int index= jTable2.getSelectedRow();
        
        int a= JOptionPane.showConfirmDialog(null,"Do You Want to Remove this Product ?", "Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model= jTable2.getModel();
        String total= model.getValueAt(index,3).toString();
        grandTotal= grandTotal- Integer.parseInt(total);
        lblgrandtotal.setText(String.valueOf(grandTotal));
        ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new HomePage(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtocart;
    private javax.swing.JButton btnclr;
    private javax.swing.JComboBox<String> cat;
    private javax.swing.JButton generatebill;
    private javax.swing.JLabel grdt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblgrandtotal;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtCusNo;
    private javax.swing.JTextField txtCusmail;
    private javax.swing.JTextField txtpronam;
    private javax.swing.JTextField txtproprice;
    private javax.swing.JTextField txtprototal;
    private javax.swing.JTextField txtsrch;
    // End of variables declaration//GEN-END:variables
}
