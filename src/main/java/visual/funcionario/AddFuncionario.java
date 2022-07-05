/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual.funcionario;

import controller.FicharioFuncionario;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import model.Funcionario;

/**
 *
 * @author Victor
 */
public class AddFuncionario extends javax.swing.JDialog {

    private Funcionario funcionario;
    private int check = 0;

    public AddFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Adicionar Funcionario");
        initComponents();

    }

    public AddFuncionario(java.awt.Frame parent, boolean modal, Funcionario funcionario) {
        super(parent, modal);
        this.setTitle("Alterar Funcionario");
        initComponents();
        this.funcionario = funcionario;
        preencher(funcionario);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGravar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jFTMatricula = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFTNome = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jFTProfissao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jButtonGravar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonGravarKeyPressed(evt);
            }
        });

        jLabel3.setText("Matrícula:");

        jLabel5.setText("Nome:");

        jFTNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTNomeFocusLost(evt);
            }
        });
        jFTNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFTNomeMouseClicked(evt);
            }
        });
        jFTNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTNomeActionPerformed(evt);
            }
        });
        jFTNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFTNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFTNomeKeyTyped(evt);
            }
        });

        jLabel6.setText("Profissão:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFTMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jFTNome)
                            .addComponent(jFTProfissao))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFTProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        grava();
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jFTNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTNomeKeyTyped


    }//GEN-LAST:event_jFTNomeKeyTyped

    private void jFTNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTNomeKeyReleased

    }//GEN-LAST:event_jFTNomeKeyReleased

    private void jFTNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFTNomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTNomeMouseClicked

    private void jFTNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTNomeFocusGained

    }//GEN-LAST:event_jFTNomeFocusGained

    private void jFTNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTNomeFocusLost


    }//GEN-LAST:event_jFTNomeFocusLost

    private void jButtonGravarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonGravarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            grava();
        }
    }//GEN-LAST:event_jButtonGravarKeyPressed

    private void jFTNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTNomeActionPerformed
    private void grava() {
        Funcionario equi = new Funcionario();
        equi.setMatricula(jFTMatricula.getText());
        equi.setNome(jFTNome.getText());
        equi.setProfissao(jFTProfissao.getText());
        if (funcionario != null) {
            equi.setId(funcionario.getId());
            funcionario = equi;
            check = 1;
            this.dispose();
        } else
        try {
            FicharioFuncionario fichario = new FicharioFuncionario();
            fichario.add(equi);

            int input = JOptionPane.showConfirmDialog(null, "Registrar outro?", "Gravou com Sucesso", JOptionPane.OK_OPTION);
            if (input != 0) {
                this.dispose();
            } else {
                jFTMatricula.setText("");
                jFTNome.setText("");
                jFTProfissao.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                    + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JFormattedTextField jFTMatricula;
    private javax.swing.JFormattedTextField jFTNome;
    private javax.swing.JFormattedTextField jFTProfissao;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    Funcionario showDialog() {
        this.setVisible(true);
        if (check == 1) {
            return funcionario;
        } else {
            return null;
        }

    }

    private void preencher(Funcionario funcionario) {;
        jFTMatricula.setText(funcionario.getNome());
        jFTNome.setText(funcionario.getNome());
        jFTProfissao.setText(funcionario.getProfissao());
    }

}