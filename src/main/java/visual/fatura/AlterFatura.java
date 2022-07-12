/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual.fatura;

import java.awt.Color;
import java.awt.Frame;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Conta;
import model.Fatura;
import model.Item;
import model.Parcela;
import model.Produto;
import model.Servico;

/**
 *
 * @author Victor
 */
public class AlterFatura extends javax.swing.JDialog {

    /**
     * Creates new form CrudAlterConta
     */
    int quantParcelas;
    Conta conta;

    int jaPago = 0;
    Fatura fatura;

    public AlterFatura(java.awt.Frame parent, boolean modal, Fatura fatura) {
        super(parent, modal);
        initComponents();
        this.setTitle("Tela Alterar Fatura");
        this.fatura = fatura;
        quantParcelas = fatura.getQtdParcelas();
        atualiza();
        formatarCampo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelParcela1 = new javax.swing.JLabel();
        jButtonPagar1 = new javax.swing.JButton();
        jLabelDias1 = new javax.swing.JLabel();
        jLabelParcela2 = new javax.swing.JLabel();
        jLabelParcela3 = new javax.swing.JLabel();
        jLabelDias2 = new javax.swing.JLabel();
        jLabelDias3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFTDataA = new javax.swing.JFormattedTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelParcela1.setText("Parcela 1 ");
        getContentPane().add(jLabelParcela1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButtonPagar1.setText("Pagar Parcela");
        jButtonPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jLabelDias1.setText("Data de vencimento: 12 12 2004 : Valor = 1546");
        getContentPane().add(jLabelDias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        jLabelParcela2.setText("Parcela 2 ");
        getContentPane().add(jLabelParcela2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabelParcela3.setText("Parcela 3 ");
        getContentPane().add(jLabelParcela3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabelDias2.setText("Não Existe");
        getContentPane().add(jLabelDias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabelDias3.setText("Não Existe");
        getContentPane().add(jLabelDias3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel6.setText("Data do Pagamento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, 20));

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
        getContentPane().add(jFTDataA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 170, 110));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagar1ActionPerformed

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

        if (jaPago < quantParcelas) {

            fatura.getParcelas()[jaPago].setDataPagamento(date);
            fatura.JurosPorAtraso();
            String h = Double.toString(fatura.getParcelas()[jaPago].getValorfinal());
            int input;
            input = JOptionPane.showConfirmDialog(null, "O preço final é " + h + " ", "Pagar", JOptionPane.OK_CANCEL_OPTION);
            if (input == JOptionPane.OK_OPTION) {
                fatura.getParcelas()[jaPago].setDataPagamento(date);
                if (jaPago + 1 == quantParcelas) {
                    fatura.setDataLiquidacao(fatura.getParcelas()[quantParcelas - 1].getDataPagamento());
                }
                atualiza();

                JOptionPane.showConfirmDialog(null, "Gravou corretamente", "Sucesso",
                        JOptionPane.DEFAULT_OPTION);

            }

        } else {
            JOptionPane.showConfirmDialog(null, "Não tem parcela para pagar", "Erro",
                    JOptionPane.DEFAULT_OPTION);
        }

    }//GEN-LAST:event_jButtonPagar1ActionPerformed

    private void jFTDataAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTDataAFocusGained
        if (jFTDataA.getText().contains("_")) {
            jFTDataA.select(0, 0);
        }
    }//GEN-LAST:event_jFTDataAFocusGained

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                    + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jFTDataAFocusLost

    private void jFTDataAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTDataAActionPerformed

    }//GEN-LAST:event_jFTDataAActionPerformed

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

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jFTDataAKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonPagar1;
    private javax.swing.JFormattedTextField jFTDataA;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDias1;
    private javax.swing.JLabel jLabelDias2;
    private javax.swing.JLabel jLabelDias3;
    private javax.swing.JLabel jLabelParcela1;
    private javax.swing.JLabel jLabelParcela2;
    private javax.swing.JLabel jLabelParcela3;
    // End of variables declaration//GEN-END:variables

    public Fatura showDialog() {

        this.setVisible(true);
        return fatura;
    }

    void atualiza() {
        atualizaPago();
        int quantPago = jaPago + 1;
        jButtonPagar1.setText("Pagar Parcela  " + quantPago);
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String a = Integer.toString(fatura.getParcelas()[0].getDataVencimento().getDayOfMonth());
        String b = Integer.toString(fatura.getParcelas()[0].getDataVencimento().getMonthValue());
        String c = Integer.toString(fatura.getParcelas()[0].getDataVencimento().getYear());
        String d = numberFormat.format(fatura.getParcelas()[0].getValor());
        jLabelDias1.setText("Data de vencimento: " + a + "." + b + "." + c + ": Valor = " + d);
        if (fatura.getParcelas()[0].getDataPagamento() != null) {
            a = Integer.toString(fatura.getParcelas()[0].getDataPagamento().getDayOfMonth());
            b = Integer.toString(fatura.getParcelas()[0].getDataPagamento().getMonthValue());
            c = Integer.toString(fatura.getParcelas()[0].getDataPagamento().getYear());
            d = numberFormat.format(fatura.getParcelas()[0].getValorfinal());
            jLabelParcela1.setText("Parcela paga.");
            jLabelDias1.setText("Data de Pagamento: " + a + "." + b + "." + c + ": Valor = " + d);
            jLabelParcela1.setForeground(Color.green);

        }
        jLabelParcela2.setEnabled(false);
        jLabelDias2.setEnabled(false);
        jLabelParcela3.setEnabled(false);
        jLabelDias3.setEnabled(false);

        if (quantParcelas > 1) {
            jLabelParcela2.setEnabled(true);
            jLabelDias2.setEnabled(true);
            String a2 = Integer.toString(fatura.getParcelas()[1].getDataVencimento().getDayOfMonth());
            String b2 = Integer.toString(fatura.getParcelas()[1].getDataVencimento().getMonthValue());
            String c2 = Integer.toString(fatura.getParcelas()[1].getDataVencimento().getYear());
            String d2 = numberFormat.format(fatura.getParcelas()[1].getValor());
            jLabelDias2.setText("Data de vencimento: " + a2 + "." + b2 + "." + c2 + ": Valor = " + d2);
            if (fatura.getParcelas()[1].getDataPagamento() != null) {
                a = Integer.toString(fatura.getParcelas()[1].getDataPagamento().getDayOfMonth());
                b = Integer.toString(fatura.getParcelas()[1].getDataPagamento().getMonthValue());
                c = Integer.toString(fatura.getParcelas()[1].getDataPagamento().getYear());
                d = numberFormat.format(fatura.getParcelas()[1].getValorfinal());
                jLabelParcela2.setText("Parcela paga.");
                jLabelDias2.setText("Data de Pagamento: " + a + "." + b + "." + c + ": Valor = " + d);
                jLabelParcela2.setForeground(Color.green);
            }

        }
        if (quantParcelas > 2) {
            jLabelParcela3.setEnabled(true);
            jLabelDias3.setEnabled(true);
            String a3 = Integer.toString(fatura.getParcelas()[2].getDataVencimento().getDayOfMonth());
            String b3 = Integer.toString(fatura.getParcelas()[2].getDataVencimento().getMonthValue());
            String c3 = Integer.toString(fatura.getParcelas()[2].getDataVencimento().getYear());
            String d3 = numberFormat.format(fatura.getParcelas()[2].getValor());
            jLabelDias3.setText("Data de vencimento: " + a3 + "." + b3 + "." + c3 + ": Valor = " + d3);
            if (fatura.getParcelas()[2].getDataPagamento() != null) {
                a = Integer.toString(fatura.getParcelas()[2].getDataPagamento().getDayOfMonth());
                b = Integer.toString(fatura.getParcelas()[2].getDataPagamento().getMonthValue());
                c = Integer.toString(fatura.getParcelas()[2].getDataPagamento().getYear());
                d = numberFormat.format(fatura.getParcelas()[2].getValorfinal());
                jLabelParcela3.setText("Parcela paga.");
                jLabelDias3.setText("Data de Pagamento: " + a + "." + b + "." + c + ": Valor = " + d);
                jLabelParcela3.setForeground(Color.green);
            }
        }
        if (fatura.getQtdParcelas() == jaPago) {
            jButtonPagar1.setText("Todas Parcelas pagas");
        }

    }

    public void atualizaPago() {
        int j = 0;
        for (int i = 0; i < quantParcelas; i++) {

            if (fatura.getParcelas()[i].getDataPagamento() != null) {
                j++;

            }
        }

        jaPago = j;
    }

    private void formatarCampo() {
        try {
            MaskFormatter mask = new MaskFormatter("**/**/****");
            mask.setPlaceholder("__/__/____");
            mask.install(jFTDataA);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar", "ERRO", JOptionPane.ERROR);
        }
    }

}
