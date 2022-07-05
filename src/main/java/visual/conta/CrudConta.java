/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual.conta;

import visual.conta.TelaAddFatura;
import visual.conta.AddConta;
import visual.conta.AlterConta;
import controller.FicharioConta;
import controller.FicharioFatura;
import controller.FicharioPessoaF;
import controller.FicharioPessoaJ;
import java.awt.Color;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DropMode;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import recursos.ImagemFichario;
import recursos.Util;
import visual.equipamento.CrudEquipamento;
import visual.fatura.CrudFatura;
import visual.funcionario.CrudFuncionario;
import visual.cliente.CrudPessoaF;
import visual.produto.CrudProduto;
import visual.servico.CrudServico;
import visual.principal.TelaPrincipal;

/**
 *
 * @author Victor
 */
public class CrudConta extends javax.swing.JFrame {

    private DefaultTableModel dtmConta;
    private DefaultTableModel dtmCliente;
    private FicharioPessoaF ficharioAtual = new FicharioPessoaF();
    private FicharioPessoaJ ficharioJ = new FicharioPessoaJ();
    private FicharioConta ficharioConta = new FicharioConta();
    private boolean isF = true;

    public CrudConta() {

        dtmConta = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmCliente = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        jTableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableConta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle("Tabela: Conta");
        preencheClientesF();
        atualizaTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonAdd = new javax.swing.JButton();
        jButtonAlter = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonMCJ = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableConta = new javax.swing.JTable();
        jButtonMCF = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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

        jTableCliente.setModel(dtmCliente       );
        jTableCliente.setDragEnabled(true);
        jTableCliente.setGridColor(new java.awt.Color(204, 255, 255));
        jTableCliente.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTableCliente.setShowGrid(true);
        jScrollPane2.setViewportView(jTableCliente);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 290, 240));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 60, 80));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 40, 40));

        jButtonAdd.setText("Adicionar Nova Conta");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jButtonAlter.setText("Alterar Conta");
        jButtonAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jButtonRemove.setText("Remover Conta");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jButtonMCJ.setText("Mostrar Clientes Jurídicos");
        jButtonMCJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMCJActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMCJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

        jTableConta.setModel(dtmConta);
        jTableConta.setDragEnabled(true);
        jTableConta.setGridColor(new java.awt.Color(204, 255, 255));
        jTableConta.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTableConta.setShowGrid(true);
        jScrollPane3.setViewportView(jTableConta);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, 240));

        jButtonMCF.setText("Mostrar Clientes Físicos");
        jButtonMCF.setEnabled(false);
        jButtonMCF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMCFActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMCF, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, -1, -1));
        getContentPane().add(filler4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 80, 40, -1));

        jButton1.setText("Exibir relatório de contas de clientes físicos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jButton2.setText("Exibir relatório de contas de clientes jurídicos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jButton3.setText("Agendamento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 120, -1));

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

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (jTableCliente.getSelectedRow() > -1) {
            try {
                Cliente produtoantes;
                int id = Integer.parseInt(jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 0).toString());
                if (isF) {
                    produtoantes = ficharioAtual.achar(id);
                } else {
                    produtoantes = ficharioJ.achar(id);
                }
                AddConta tela = new AddConta(this, true, produtoantes);
                Conta produtodps = tela.showDialog();
                if (produtodps != null) {
                    produtodps.setCliente(produtoantes);
                    ficharioConta.add(produtodps);
                    ImagemFichario imagem = new ImagemFichario();
                    JOptionPane.showMessageDialog(null, "O dado foi gravado corretamente.",
                            "Sucesso", JOptionPane.ERROR_MESSAGE, imagem.sucesso());
                    atualizaTabela();
                } else {
    
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                        + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(CrudConta.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um elemento na tabela de clientes",
                    "Erro", JOptionPane.WARNING_MESSAGE);
        }
        atualizaTabela();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterActionPerformed
        if (jTableConta.getSelectedRow() > -1) {
            try {
                int id = Integer.parseInt(jTableConta.getValueAt(jTableConta.getSelectedRow(), 0).toString());
                Conta contaantes = ficharioConta.achar(id);
                if (contaantes.getDataFechamento() == null) {
                    AlterConta tela = new AlterConta(this, true, contaantes);
                    Conta contadps = tela.showDialog();

                    if (contadps != null) {
                        if (contadps.getDataFechamento() != null) {
                            TelaAddFatura telaf = new TelaAddFatura(this, true, contadps);
                            Fatura fatura = telaf.showDialog();
                            if (fatura != null) {
                                FicharioFatura ficharioFatura = new FicharioFatura();
                                ficharioFatura.add(fatura);
                                ficharioConta.alterar(contadps, id);
                                ImagemFichario imagem = new ImagemFichario();
                                JOptionPane.showMessageDialog(null, "O dado foi gravado corretamente.",
                                        "Sucesso", JOptionPane.INFORMATION_MESSAGE, imagem.sucesso());
                                atualizaTabela();

                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Erro. A conta não foi salva pois não preencheu a fatura. ",
                                        "Erro", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            ficharioConta.alterar(contadps, id);
                            ImagemFichario imagem = new ImagemFichario();
                            JOptionPane.showMessageDialog(null, "O dado foi gravado corretamente.",
                                    "Sucesso", JOptionPane.ERROR_MESSAGE, imagem.sucesso());
                            atualizaTabela();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro. Não é possível alterar uma conta fechada. ",
                            "Erro", JOptionPane.WARNING_MESSAGE);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                        + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(CrudConta.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jButtonAlterActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed

        if (jTableConta.getSelectedRow() > -1) {

            int input = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Excluir", JOptionPane.WARNING_MESSAGE);
            if (input == 0) {
                try {
                    int id = Integer.parseInt(jTableConta.getValueAt(jTableConta.getSelectedRow(), 0).toString());
                    ficharioAtual.remove(id);
                    atualizaTabela();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                            + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonMCJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMCJActionPerformed
        isF = false;
        preencheClientesJ();
        jButtonMCJ.setEnabled(false);
        jButtonMCF.setEnabled(true);
    }//GEN-LAST:event_jButtonMCJActionPerformed

    private void jButtonMCFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMCFActionPerformed
        isF = true;
        preencheClientesF();
        jButtonMCF.setEnabled(false);
        jButtonMCJ.setEnabled(true);

    }//GEN-LAST:event_jButtonMCFActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Util.fazRelatorio("contaF.jasper");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Util.fazRelatorio("contaJ.jasper");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Util.fazRelatorio("agenda.jasper");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void atualizaTabela() {

        try {
            String[][] a = ficharioConta.getDataString();
            String b[] = ficharioConta.getColumnName();
            dtmConta.setRowCount(0);
            dtmConta.setColumnCount(0);

            for (String n : b) {
                dtmConta.addColumn(n);
            }
            for (String[] n2 : a) {
                dtmConta.insertRow(0, n2);

            }
        } catch (Exception ex) {
            Logger.getLogger(CrudConta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void preencheClientesF() {
        try {
            String[][] a = ficharioAtual.getDataStringSmall();
            String b[] = ficharioAtual.getColumnNameSmall();
            dtmCliente.setRowCount(0);
            dtmCliente.setColumnCount(0);

            for (String n : b) {
                dtmCliente.addColumn(n);
            }
            for (String[] n2 : a) {
                dtmCliente.insertRow(0, n2);

            }
        } catch (Exception ex) {
            Logger.getLogger(CrudConta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencheClientesJ() {
        try {
            String[][] a = ficharioAtual.getDataStringJuridico();
            String b[] = ficharioAtual.getColumnNameJuridico();
            dtmCliente.setRowCount(0);
            dtmCliente.setColumnCount(0);

            for (String n : b) {
                dtmCliente.addColumn(n);
            }
            for (String[] n2 : a) {
                dtmCliente.insertRow(0, n2);

            }
        } catch (Exception ex) {
            Logger.getLogger(CrudConta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAlter;
    private javax.swing.JButton jButtonMCF;
    private javax.swing.JButton jButtonMCJ;
    private javax.swing.JButton jButtonRemove;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableConta;
    // End of variables declaration//GEN-END:variables
}
