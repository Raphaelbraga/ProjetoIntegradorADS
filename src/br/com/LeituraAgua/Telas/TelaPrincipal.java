/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.Telas;

<<<<<<< HEAD
import static java.awt.SystemColor.window;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import br.com.LeituraAgua.Telas.jIResumo;

=======
>>>>>>> vinicius
/**
 *
 * @author Alunos
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        carregaResumo();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        Fundo = new javax.swing.JPanel();
        Usuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        footer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2048, 1024));
        setPreferredSize(null);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setToolTipText("");
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(2048, 1024));
        jPanel1.setLayout(new java.awt.BorderLayout());

        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        header.setMaximumSize(new java.awt.Dimension(2048, 1024));
        header.setMinimumSize(new java.awt.Dimension(1020, 585));
        header.setPreferredSize(new java.awt.Dimension(80, 40));
        header.setLayout(new java.awt.GridLayout(1, 0));

        Menu.setBackground(getBackground());
        Menu.setMaximumSize(new java.awt.Dimension(100, 150));
        Menu.setLayout(new javax.swing.BoxLayout(Menu, javax.swing.BoxLayout.LINE_AXIS));

        jComboBox2.setBackground(new java.awt.Color(0, 204, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consulta", "Cadastros" }));
        jComboBox2.setMaximumSize(new java.awt.Dimension(200, 30));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        Menu.add(jComboBox2);

        header.add(Menu);

        Fundo.setBackground(new java.awt.Color(216, 216, 216));
        Fundo.setToolTipText("");
        Fundo.setMaximumSize(new java.awt.Dimension(1020, 585));
        header.add(Fundo);

        Usuario.setMaximumSize(new java.awt.Dimension(10, 10));
        Usuario.setMinimumSize(new java.awt.Dimension(10, 40));
        Usuario.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOME USUARIO");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Usuario.add(jLabel1);
        jLabel1.setBounds(0, 0, 354, 40);

        header.add(Usuario);

        jPanel1.add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(51, 204, 255));
        body.setMaximumSize(new java.awt.Dimension(2048, 1024));
        body.setPreferredSize(new java.awt.Dimension(900, 700));
        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(2048, 1024));
        jPanel5.setPreferredSize(new java.awt.Dimension(1525, 1800));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        body.add(jPanel5);

        jPanel1.add(body, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(204, 204, 204));
        footer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        footer.setMaximumSize(new java.awt.Dimension(20, 20));
        footer.setPreferredSize(new java.awt.Dimension(80, 40));
        footer.setLayout(new javax.swing.BoxLayout(footer, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("jLabel2");
        footer.add(jLabel2);

        jPanel1.add(footer, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(1175, 702));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Object selected = jComboBox2.getSelectedItem();

        body.removeAll();

        if (selected.toString().equals("Cadastros")) {

            NewJInternalFrame internalFrame = new NewJInternalFrame();

            body.add(internalFrame);
            internalFrame.setVisible(true);
            body.repaint();

        } else {

            carregaResumo();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void carregaResumo() {
        
        body.removeAll();
        jIResumo internalFrame = new jIResumo();
        
        body.add(internalFrame);
        internalFrame.setVisible(true);
        body.repaint();
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fundo;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Usuario;
    private javax.swing.JPanel body;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}