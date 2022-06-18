/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import model.*;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class CrudDefault extends javax.swing.JFrame {

    private DefaultTableModel dtm;

    public CrudDefault() {

        dtm = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle("Tabela: Conta");
      //preencheTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonPendente = new javax.swing.JButton();
        jButtonTodos = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonAlter = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable.setModel(dtm);
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 430, 240));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 60, 80));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 40, 40));

        jButtonPendente.setText("Mostar Pendentes");
        jButtonPendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPendenteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        jButtonTodos.setText("Mostar Todos");
        jButtonTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTodosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTodosActionPerformed
        
//        preencheTabela(dados.ficharioConta.getDataString(arrayAtual),
//                dados.ficharioConta.getColumnName());
    }//GEN-LAST:event_jButtonTodosActionPerformed

    private void jButtonPendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPendenteActionPerformed
//        ArrayList<Conta> arrayfiltro = new ArrayList<>();
//        for (Conta conta : arrayAtual) {
//            if (conta.getDataFechamento() == null) {
//                arrayfiltro.add(conta);
//            }
//        }
//
//        preencheTabela(dados.ficharioConta.getDataString(arrayfiltro),
//                dados.ficharioConta.getColumnName());
    }//GEN-LAST:event_jButtonPendenteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        //        CrudAddConta crud = new CrudAddConta(dados);
        //        crud.setVisible(true);
        //        this.dispose();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterActionPerformed
        /*     if (jTable.getSelectedRow() != -1) {
            int id = Integer.parseInt((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
            int index = ficharioAtual.findIndex(id);
            if (dados.ficharioConta.arrayCont.get(index).getDataFechamento() == null) {

                CrudAlterConta tela;
                tela = new CrudAlterConta(this, true, dados, dados.ficharioConta.arrayCont.get(index), index);
                tela.showDialog();
                preencheTabela(dados.ficharioConta.getDataString(arrayAtual), dados.ficharioConta.getColumnName());

            } else {
                JOptionPane.showConfirmDialog(null, "A conta ja foi encerrada", "Aviso",
                    JOptionPane.DEFAULT_OPTION);
            }

        }
        */
    }//GEN-LAST:event_jButtonAlterActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        /*
        if ((jTable.getSelectedRow()) > -1) {
            int id = Integer.parseInt((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
            int index = ficharioAtual.findIndex(id);
            if (dados.ficharioConta.arrayCont.get(index).getDataFechamento() == null) {

                int input;
                input = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Remover Conta", JOptionPane.OK_CANCEL_OPTION);
                if (input == JOptionPane.OK_OPTION) {
                    ficharioAtual.remove(index);
                    dtm.removeRow(jTable.getSelectedRow());
                    preencheTabela(ficharioAtual.getDataString(arrayAtual), ficharioAtual.getColumnName());

                }

            } else {
                JOptionPane.showConfirmDialog(null, "A conta ja foi encerrada", "Aviso",
                    JOptionPane.DEFAULT_OPTION);
            }
        }
        */
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void preencheTabela(String a[][], String b[]) {
        dtm.setRowCount(0);
        dtm.setColumnCount(0);

        for (String n : b) {
            dtm.addColumn(n);
        }
        for (String[] n2 : a) {
            dtm.insertRow(0, n2);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAlter;
    private javax.swing.JButton jButtonPendente;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonTodos;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
