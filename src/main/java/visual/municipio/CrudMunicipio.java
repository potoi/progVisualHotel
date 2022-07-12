/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual.municipio;

import visual.cliente.CrudVeiculo;
import visual.cliente.CrudPessoaF;
import visual.cliente.CrudPessoaJ;
import visual.endereco.CrudEndereco;
import controller.FicharioMunicipio;
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
public class CrudMunicipio extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm;
    private FicharioMunicipio ficharioAtual = new FicharioMunicipio();

    public CrudMunicipio() {

        dtm = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle("Tabela: Municipio");
        atualizaTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonAlter = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonEndereco = new javax.swing.JButton();
        jButtonClienteF = new javax.swing.JButton();
        jButtonVeiculo = new javax.swing.JButton();
        jButtonClienteF1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable.setModel(dtm);
        jTable.setDragEnabled(true);
        jTable.setGridColor(new java.awt.Color(204, 255, 255));
        jTable.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable.setShowGrid(true);
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 620, 240));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 60, 80));
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
        getContentPane().add(filler5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 60, 80));

        jButtonEndereco.setText("Tela Endereço");
        jButtonEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jButtonClienteF.setText("Tela Cliente Físico");
        jButtonClienteF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteFActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClienteF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        jButtonVeiculo.setText("Tela Veículo");
        jButtonVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVeiculoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jButtonClienteF1.setText("Tela Cliente Jurídico");
        jButtonClienteF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteF1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClienteF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterActionPerformed
        if (jTable.getSelectedRow() > -1) {
            try {
                int id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
                Municipio produtoantes = ficharioAtual.achar(id);

                AddMunicipio tela = new AddMunicipio(null, true, produtoantes);
                Municipio produtodps = tela.showDialog();

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

    private void jButtonEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnderecoActionPerformed
        CrudEndereco crud = new CrudEndereco();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEnderecoActionPerformed

    private void jButtonClienteFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteFActionPerformed
        CrudPessoaF crud = new CrudPessoaF();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonClienteFActionPerformed

    private void jButtonVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVeiculoActionPerformed
        CrudVeiculo crud = new CrudVeiculo();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVeiculoActionPerformed

    private void jButtonClienteF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteF1ActionPerformed
        CrudPessoaJ crud = new CrudPessoaJ();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonClienteF1ActionPerformed

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
            Logger.getLogger(CrudMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JButton jButtonAlter;
    private javax.swing.JButton jButtonClienteF;
    private javax.swing.JButton jButtonClienteF1;
    private javax.swing.JButton jButtonEndereco;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonVeiculo;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
