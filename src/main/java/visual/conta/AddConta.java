/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual.conta;

import controller.FicharioConta;
import java.awt.Frame;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.Conta;
import visual.produto.CrudProduto;

/**
 *
 * @author Victor
 */
public class AddConta extends javax.swing.JDialog {

    /**
     * Creates new form CrudAlterConta
     */
    private Conta conta;
    private FicharioConta fichario = new FicharioConta();

    public AddConta(java.awt.Frame parent, boolean modal, Cliente c) {

        super(parent, modal);
        this.setTitle("Nova Conta:Cliente " + c.getNome());
        initComponents();
        formatarCampo();
        jFTDataA.setText(getDataAtual());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButtonGravar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jFTDataA = new javax.swing.JFormattedTextField();
        jFTQuarto = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Quarto:");

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jLabel2.setText("Data Abertura:");

        jFTDataA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTDataAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTDataAFocusLost(evt);
            }
        });
        jFTDataA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTDataAActionPerformed(evt);
            }
        });
        jFTDataA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFTDataAKeyReleased(evt);
            }
        });

        jFTQuarto.setEditable(false);
        jFTQuarto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTQuartoFocusGained(evt);
            }
        });
        jFTQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTQuartoActionPerformed(evt);
            }
        });

        jButton1.setText("Escolher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFTQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jFTDataA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFTDataA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFTQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        try {
            Conta conta = new Conta();
            int dia, mes, ano, index;
            String texto = jFTDataA.getText();
            index = texto.indexOf("/");
            dia = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            index = texto.indexOf("/");
            mes = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            ano = Integer.parseInt(texto);
            LocalDate date = LocalDate.of(ano, mes, dia);
            conta.setDataAbertura(date);
            conta.setQuarto(Integer.parseInt(jFTQuarto.getText().trim()));
            this.conta = conta;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                    + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(AddConta.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jFTDataAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTDataAFocusGained
        if (jFTDataA.getText().contains("_")) {
            jFTDataA.select(0, 0);
        }
    }//GEN-LAST:event_jFTDataAFocusGained

    private void jFTDataAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTDataAActionPerformed

    }//GEN-LAST:event_jFTDataAActionPerformed

    private void jFTDataAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTDataAFocusLost
        if (!jFTDataA.getText().contains("_"))
        try {
            int dia, mes, ano, index;
            String texto = jFTDataA.getText();
            index = texto.indexOf("/");
            dia = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            index = texto.indexOf("/");
            mes = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            ano = Integer.parseInt(texto);
            LocalDate date = LocalDate.of(ano, mes, dia);
            jFTQuarto.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                    + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(CrudProduto.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jFTDataAFocusLost

    private void jFTQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTQuartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTQuartoActionPerformed

    private void jFTDataAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTDataAKeyReleased
        if (!jFTDataA.getText().contains("_"))
        try {
            int dia, mes, ano, index;
            String texto = jFTDataA.getText();
            index = texto.indexOf("/");
            dia = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            index = texto.indexOf("/");
            mes = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            ano = Integer.parseInt(texto);
            LocalDate date = LocalDate.of(ano, mes, dia);
            jFTQuarto.requestFocus();

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jFTDataAKeyReleased

    private void jFTQuartoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTQuartoFocusGained
        jFTQuarto.setCaretPosition(0);
    }//GEN-LAST:event_jFTQuartoFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JComboBox cb;
        try {
            cb = new JComboBox(fichario.quartosDisponivel().toArray());

            int input;
            input = JOptionPane.showConfirmDialog(this, cb,
                    "Selecione o quarto disponível", JOptionPane.DEFAULT_OPTION);
            if (input == JOptionPane.OK_OPTION) {
                String str = (String) cb.getSelectedItem();
                jFTQuarto.setText(str);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JFormattedTextField jFTDataA;
    private javax.swing.JFormattedTextField jFTQuarto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    public Conta showDialog() {
        this.setVisible(true);
        return conta;

    }

    private void formatarCampo() {
        try {
            MaskFormatter mask = new MaskFormatter("**/**/****");
            MaskFormatter mask2 = new MaskFormatter("##");
            mask.setPlaceholder("__/__/____");
            mask.install(jFTDataA);
            mask2.install(jFTQuarto);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar", "ERRO", JOptionPane.ERROR);
        }
    }

    private String getDataAtual() {
        LocalDate date = LocalDate.now();
        int dia, mes, ano;
        dia = date.getDayOfMonth();
        String diaFormat = String.format("%02d", dia);
        mes = date.getMonthValue();
        String mesFormat = String.format("%02d", mes);
        ano = date.getYear();
        return (diaFormat + "/" + mesFormat + "/" + ano);
    }

}
