/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual.conta;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.Conta;
import model.Item;
import model.Produto;
import model.Servico;

public class AlterConta extends javax.swing.JDialog {

    private ArrayList<Item> arrayI = new ArrayList<>();
    private ArrayList<Produto> arrayP = new ArrayList<>();
    private ArrayList<Servico> arrayS = new ArrayList<>();

    private DefaultListModel modelL = new DefaultListModel();
    private Conta conta;
    public int check = 0;
    private double total;

    public AlterConta(java.awt.Frame parent, boolean modal, Conta conta) {
        super(parent, modal);
        this.setTitle("Alterar Conta");
        initComponents();
        this.conta = conta;
        total = conta.getTotal();
        formatarCampo();
        jList1.setModel(modelL);
        preencher(conta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGravar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jButtonAddProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jFTQuarto = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jFTAbertura = new javax.swing.JFormattedTextField();
        jFTFechamento = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jButtonAddServico = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jFTTotal = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jLabel7.setText("Quarto:");

        jLabel12.setText("Total: R$");

        jButtonAddProduto.setText("AddProduto");
        jButtonAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProdutoActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

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

        jLabel14.setText("Data Abertura:");

        jFTAbertura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTAberturaFocusGained(evt);
            }
        });
        jFTAbertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFTAberturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFTAberturaKeyTyped(evt);
            }
        });

        jFTFechamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFechamentoFocusGained(evt);
            }
        });
        jFTFechamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFTFechamentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFTFechamentoKeyTyped(evt);
            }
        });

        jLabel15.setText("Data Fechamento:");

        jButtonAddServico.setText("AddServiço");
        jButtonAddServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddServicoActionPerformed(evt);
            }
        });

        jFTTotal.setEditable(false);
        jFTTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFTTotal.setText("0");
        jFTTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTTotalFocusLost(evt);
            }
        });
        jFTTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFTTotalMouseClicked(evt);
            }
        });
        jFTTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFTTotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFTTotalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddServico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFTQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jFTFechamento)
                            .addComponent(jFTAbertura))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFTAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jFTFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFTQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddProduto)
                        .addGap(51, 51, 51)
                        .addComponent(jButtonAddServico)
                        .addGap(46, 46, 46))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jFTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        try {

            Conta conta = new Conta();
            int dia, mes, ano, index;
            String texto = jFTAbertura.getText();
            index = texto.indexOf("-");
            dia = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            index = texto.indexOf("-");
            mes = Integer.parseInt(texto.substring(0, index));
            texto = texto.substring(index + 1);
            ano = Integer.parseInt(texto);
            LocalDate date = LocalDate.of(ano, mes, dia);
            conta.setDataAbertura(date);

            texto = jFTFechamento.getText().trim();
            if (texto.length() < 7) {
                conta.setDataFechamento(null);

            } else {
                index = texto.indexOf("-");
                dia = Integer.parseInt(texto.substring(0, index));
                texto = texto.substring(index + 1);
                index = texto.indexOf("-");
                mes = Integer.parseInt(texto.substring(0, index));
                texto = texto.substring(index + 1);
                ano = Integer.parseInt(texto);
                date = LocalDate.of(ano, mes, dia);
                conta.setDataFechamento(date);
            }

            conta.setQuarto(Integer.parseInt(jFTQuarto.getText().trim()));

            conta.setId(this.conta.getId());
            conta.setCliente(this.conta.getCliente());

            for (Produto c : arrayP) {
                arrayI.add(c);
            }
            for (Servico c : arrayS) {
                arrayI.add(c);
            }
            Item[] arr = new Item[arrayI.size()];
            conta.setItens(arrayI.toArray(arr));
            conta.setTotal(Double.parseDouble(jFTTotal.getText().replaceAll(",", ".")));
            check = 1;
            conta.setTotal(total);
            this.conta = conta;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                    + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(CrudConta.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProdutoActionPerformed
        TelaAddProduto tela = new TelaAddProduto(null, true, arrayP);
        ArrayList<Produto> array = tela.showDialog();
        if (array != null) {
            arrayP = array;
        }
        atualiza();
    }//GEN-LAST:event_jButtonAddProdutoActionPerformed

    private void jFTQuartoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTQuartoFocusGained
        jFTQuarto.setCaretPosition(0);
    }//GEN-LAST:event_jFTQuartoFocusGained

    private void jFTAberturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTAberturaFocusGained
        jFTAbertura.setCaretPosition(0);
    }//GEN-LAST:event_jFTAberturaFocusGained

    private void jFTAberturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTAberturaKeyReleased

    }//GEN-LAST:event_jFTAberturaKeyReleased

    private void jFTAberturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTAberturaKeyTyped

    }//GEN-LAST:event_jFTAberturaKeyTyped

    private void jFTFechamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFechamentoFocusGained
        jFTFechamento.setCaretPosition(0);
    }//GEN-LAST:event_jFTFechamentoFocusGained

    private void jFTFechamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTFechamentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFechamentoKeyReleased

    private void jFTFechamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTFechamentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFechamentoKeyTyped

    private void jButtonAddServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddServicoActionPerformed
        TelaAddServico tela = new TelaAddServico(null, true, arrayS);
        ArrayList<Servico> array = tela.showDialog();
        if (array != null) {
            arrayS = array;
        }
        atualiza();


    }//GEN-LAST:event_jButtonAddServicoActionPerformed
    private void atualiza() {
        double total = 0;
        modelL.clear();

        for (Item prod : arrayP) {
            total += prod.getPreco();
            modelL.addElement(prod.getDescricao());

        }
        
        for (Item prod : arrayS) {
            total += prod.getPreco();
            modelL.addElement(prod.getDescricao());

        }

        this.total = total;
        try {

            jFTTotal.setValue(this.total);
            jFTTotal.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(AlterConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jFTTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTTotalFocusGained

    }//GEN-LAST:event_jFTTotalFocusGained

    private void jFTTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTTotalFocusLost

    }//GEN-LAST:event_jFTTotalFocusLost

    private void jFTTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFTTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTTotalMouseClicked

    private void jFTTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTTotalKeyReleased
        if (jFTTotal.getText().length() > 0) {

            try {
                int pos = jFTTotal.getCaretPosition();
                jFTTotal.commitEdit();
                jFTTotal.setValue(jFTTotal.getValue());
                jFTTotal.setCaretPosition(pos);
            } catch (ParseException ex) {
            }

        }
    }//GEN-LAST:event_jFTTotalKeyReleased

    private void jFTTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTTotalKeyTyped

    }//GEN-LAST:event_jFTTotalKeyTyped

    private void jFTQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTQuartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTQuartoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButtonAddProduto;
    private javax.swing.JButton jButtonAddServico;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JFormattedTextField jFTAbertura;
    private javax.swing.JFormattedTextField jFTFechamento;
    private javax.swing.JFormattedTextField jFTQuarto;
    private javax.swing.JFormattedTextField jFTTotal;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    Conta showDialog() {
        this.setVisible(true);
        if (check == 1) {
            return conta;
        } else {
            return null;
        }

    }

    private void formatarCampo() {
        try {
            MaskFormatter mask = new MaskFormatter();
            MaskFormatter mask2 = new MaskFormatter();
            MaskFormatter mask3 = new MaskFormatter();
            mask.setMask("##-##-####");
            mask2.setMask("##-##-####");
            mask3.setMask("##");

            mask.install(jFTAbertura);
            mask2.install(jFTFechamento);
            mask3.install(jFTQuarto);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar", "ERRO", JOptionPane.ERROR);
        }
    }

    public void preencher(Conta e) {
        int dia, mes, ano;
        dia = e.getDataAbertura().getDayOfMonth();
        mes = e.getDataAbertura().getMonthValue();
        ano = e.getDataAbertura().getYear();
        String diaFormat = String.format("%02d", dia);
        String mesFormat = String.format("%02d", mes);
        jFTAbertura.setText(diaFormat + "-" + mesFormat + "-" + ano);
        jFTQuarto.setText(e.getQuarto() + "");

        if (e.getDataFechamento() != null) {
            dia = e.getDataFechamento().getDayOfMonth();
            mes = e.getDataFechamento().getMonthValue();
            ano = e.getDataFechamento().getYear();
            diaFormat = String.format("%02d", dia);
            mesFormat = String.format("%02d", mes);
            jFTFechamento.setValue(e.getDataFechamento());
            jFTFechamento.setValue(diaFormat + "-" + mesFormat + "-" + ano);
        }

        for (Item i : e.getItens()) {
            modelL.addElement(i.getIdentificador() + " : " + i.getDescricao());
            if (i instanceof Produto p) {
                arrayP.add(p);
            }
            if (i instanceof Servico s) {
                arrayS.add(s);
            }

        }
    }

}
