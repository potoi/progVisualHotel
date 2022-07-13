/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual.cliente;

import controller.FicharioPessoaF;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import recursos.ImagemFichario;

/**
 *
 * @author Victor
 */
public class CrudPessoaF extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm;
    private FicharioPessoaF ficharioAtual = new FicharioPessoaF();

    public CrudPessoaF() {

        dtm = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle("Tabela: Cliente Físico");
        atualizaTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonAdd = new javax.swing.JButton();
        jButtonAlter = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();

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

        jButtonAdd.setText("Adicionar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        AddPessoaFisica tela = new AddPessoaFisica(null, true);
        tela.showDialog();
        atualizaTabela();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterActionPerformed
        if (jTable.getSelectedRow() > -1) {
            try {
                int id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
                PessoaFisica produtoantes = ficharioAtual.achar(id);

                AddPessoaFisica tela = new AddPessoaFisica(null, true, produtoantes);
                PessoaFisica produtodps = tela.showDialog();

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
                Logger.getLogger(CrudPessoaF.class.getName()).log(Level.SEVERE, null, e);
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

    private void atualizaTabela() {

        try {
            String[][] a = ficharioAtual.getDataString();
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
            Logger.getLogger(CrudPessoaF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAlter;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
