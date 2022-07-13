/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual.cliente;

import controller.FicharioVeiculo;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import recursos.ImagemFichario;
import recursos.Util;
import visual.equipamento.CrudEquipamento;
import visual.fatura.CrudFatura;
import visual.funcionario.CrudFuncionario;
import visual.produto.CrudProduto;
import visual.servico.CrudServico;
import visual.principal.TelaPrincipalAntiga;
import visual.conta.CrudConta;

/**
 *
 * @author Victor
 */
public class CrudVeiculo extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm;
    private FicharioVeiculo ficharioAtual = new FicharioVeiculo();

    public CrudVeiculo() {

        dtm = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle("Tabela: Veiculo");
        atualizaTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonAlter = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(742, 476));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable.setModel(dtm);
        jTable.setDragEnabled(true);
        jTable.setGridColor(new java.awt.Color(204, 255, 255));
        jTable.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable.setShowGrid(true);
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 620, 240));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 40, 40));

        jButtonAlter.setText("Alterar");
        jButtonAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jButtonRemove.setText("Remover");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));
        getContentPane().add(filler4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 60, 80));

        jButton1.setText("Exibir relatório de veículos de clientes físicos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jButton2.setText("Exibir relatório de veículos de clientes jurídicos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jButton3.setText("Exibir relatório de veículos de clientes físicos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterActionPerformed
        if (jTable.getSelectedRow() > -1) {
            try {
                int id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
                Veiculo produtoantes = ficharioAtual.achar(id);
                TelaAddVeiculo tela = new TelaAddVeiculo(null, true, produtoantes);
                Veiculo produtodps = tela.showDialog();

                if (produtodps != null) {
                    ficharioAtual.alterar(produtodps, id);
                    ImagemFichario imagem = new ImagemFichario();
                    JOptionPane.showMessageDialog(null, "O dado foi gravado corretamente.",
                            "Sucesso", JOptionPane.ERROR_MESSAGE, imagem.sucesso());
                    atualizaTabela();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                        + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAlterActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        if (jTable.getSelectedRow() > -1) {

            int input = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Excluir", JOptionPane.WARNING_MESSAGE);
            if (input == 0) {
                try {
                    int id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
                    ficharioAtual.remove(id);
                    atualizaTabela();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                            + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                }

            }
        }

    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Util.fazRelatorio("veiculosF.jasper");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Util.fazRelatorio("veiculosJ.jasper");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void atualizaTabela() {

        try {
            String[][] a = ficharioAtual.listar();
            String b[] = ficharioAtual.getColumnName();
            dtm.setRowCount(0);
            dtm.setColumnCount(0);

            for (String n : b) {
                dtm.addColumn(n);
            }
            for (String[] n2 : a) {
                dtm.insertRow(0, n2);
            }
        } catch (Exception ex) {
            Logger.getLogger(CrudVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAlter;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
