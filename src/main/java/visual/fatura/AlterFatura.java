/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual.fatura;

import java.awt.Frame;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelParcela1 = new javax.swing.JLabel();
        jButtonPagar1 = new javax.swing.JButton();
        jLabelDias1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelParcela2 = new javax.swing.JLabel();
        jLabelParcela3 = new javax.swing.JLabel();
        jLabelDias2 = new javax.swing.JLabel();
        jLabelDias3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Alterar Fatura");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel5.setText("Cliente");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabelParcela1.setText("Parcela 1 ");
        getContentPane().add(jLabelParcela1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jButtonPagar1.setText("Pagar Parcela");
        jButtonPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabelDias1.setText("Data de vencimento: 12 12 2004 : Valor = 1546");
        getContentPane().add(jLabelDias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 20));

        jLabel19.setText("Dia");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jLabelParcela2.setText("Parcela 2 ");
        getContentPane().add(jLabelParcela2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabelParcela3.setText("Parcela 3 ");
        getContentPane().add(jLabelParcela3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabelDias2.setText("Não Existe");
        getContentPane().add(jLabelDias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabelDias3.setText("Não Existe");
        getContentPane().add(jLabelDias3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 30, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 30, -1));

        jTextField3.setPreferredSize(new java.awt.Dimension(64, 42));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 97, 20));

        jLabel3.setText("Mês");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel4.setText("Ano");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel6.setText("Data do Pagamento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagar1ActionPerformed

        int dia = Integer.parseInt(jTextField1.getText());
        int mes = Integer.parseInt(jTextField2.getText());
        int ano = Integer.parseInt(jTextField3.getText());
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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPagar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDias1;
    private javax.swing.JLabel jLabelDias2;
    private javax.swing.JLabel jLabelDias3;
    private javax.swing.JLabel jLabelParcela1;
    private javax.swing.JLabel jLabelParcela2;
    private javax.swing.JLabel jLabelParcela3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    Fatura showDialog() {

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

}
