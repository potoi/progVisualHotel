/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual.fatura;

import visual.funcionario.CrudFuncionario;
import visual.equipamento.CrudEquipamento;
import visual.cliente.CrudPessoaF;
import visual.conta.CrudConta;
import controller.FicharioFatura;
import java.awt.Color;
import java.awt.Frame;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DropMode;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import recursos.ImagemFichario;
import visual.produto.CrudProduto;
import visual.servico.CrudServico;
import visual.principal.TelaPrincipal;

/**
 *
 * @author Victor
 */
public class CrudFatura extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private FicharioFatura ficharioAtual = new FicharioFatura();

    public CrudFatura() {

        dtm = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle("Tabela: Fatura");
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuCliente = new javax.swing.JMenuItem();
        jMenuConta = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenuServicos = new javax.swing.JMenuItem();
        jMenuFaturas = new javax.swing.JMenuItem();
        jMenuEquipamentos = new javax.swing.JMenuItem();
        jMenuFuncionarios = new javax.swing.JMenuItem();
        jMenuTelaPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable.setModel(dtm);
        jTable.setDragEnabled(true);
        jTable.setGridColor(new java.awt.Color(204, 255, 255));
        jTable.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable.setShowGrid(true);
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 620, 240));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 60, 80));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 40, 40));

        jButtonAlter.setText("Alterar");
        jButtonAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, -1));

        jMenu2.setText("Telas");

        jMenuCliente.setText("Cliente");
        jMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuCliente);

        jMenuConta.setText("Conta");
        jMenuConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuContaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuConta);

        jMenuProdutos.setText("Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuProdutos);

        jMenuServicos.setText("Serviços");
        jMenuServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuServicosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuServicos);

        jMenuFaturas.setText("Faturas");
        jMenuFaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFaturasActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuFaturas);

        jMenuEquipamentos.setText("Equipamento");
        jMenuEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEquipamentosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuEquipamentos);

        jMenuFuncionarios.setText("Funcionário");
        jMenuFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFuncionariosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuFuncionarios);

        jMenuTelaPrincipal.setText("Tela Principal");
        jMenuTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTelaPrincipalActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuTelaPrincipal);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterActionPerformed
        if (jTable.getSelectedRow() > -1) {
            try {
                int id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
                Fatura faturaantes = ficharioAtual.achar(id);

                AlterFatura tela = new AlterFatura((Frame)this, true, faturaantes);
                Fatura faturadps = tela.showDialog();
 
                if (faturadps != null) {
                    ficharioAtual.alterar(faturadps, id);
                    atualizaTabela();
                }

            } catch (Exception e) {
               JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                        + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(CrudConta.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jButtonAlterActionPerformed

    private void jMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClienteActionPerformed
        CrudPessoaF crud = new CrudPessoaF();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuClienteActionPerformed

    private void jMenuContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuContaActionPerformed
        CrudConta crud = new CrudConta();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuContaActionPerformed

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        CrudProduto crud = new CrudProduto();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    private void jMenuServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuServicosActionPerformed
        CrudServico crud = new CrudServico();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuServicosActionPerformed

    private void jMenuFaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFaturasActionPerformed
        CrudFatura crud = new CrudFatura();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuFaturasActionPerformed

    private void jMenuEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEquipamentosActionPerformed
        CrudEquipamento crud = new CrudEquipamento();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuEquipamentosActionPerformed

    private void jMenuFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFuncionariosActionPerformed
        CrudFuncionario crud = new CrudFuncionario();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuFuncionariosActionPerformed

    private void jMenuTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTelaPrincipalActionPerformed
        TelaPrincipal principal = TelaPrincipal.voltarTelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuTelaPrincipalActionPerformed

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
            Logger.getLogger(CrudFatura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButtonAlter;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCliente;
    private javax.swing.JMenuItem jMenuConta;
    private javax.swing.JMenuItem jMenuEquipamentos;
    private javax.swing.JMenuItem jMenuFaturas;
    private javax.swing.JMenuItem jMenuFuncionarios;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenuItem jMenuServicos;
    private javax.swing.JMenuItem jMenuTelaPrincipal;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}