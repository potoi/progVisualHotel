/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual.cliente;

import controller.FicharioPessoaJ;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.Endereco;
import model.Municipio;
import model.PessoaJuridica;
import model.Veiculo;

public class AddPessoaJuridica extends javax.swing.JDialog {

    private ArrayList<Veiculo> arrayV = new ArrayList<>();
    private DefaultListModel modelL = new DefaultListModel();
    private PessoaJuridica pessoajuridica;
    public int check = 0;

    public AddPessoaJuridica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Adicionar Pessoa Jurídica");
        initComponents();
        formatarCampo();
        jList1.setModel(modelL);
    }

    public AddPessoaJuridica(java.awt.Frame parent, boolean modal, PessoaJuridica pessoajuridica) {
        super(parent, modal);
        this.setTitle("Alterar Pessoa Jurídica");
        initComponents();
        this.pessoajuridica = pessoajuridica;
        formatarCampo();
        jList1.setModel(modelL);
        preencher(pessoajuridica);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGravar = new javax.swing.JButton();
        jTFNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jTFLogradouro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTFPais = new javax.swing.JTextField();
        jTFMunicipio = new javax.swing.JTextField();
        jTFEstado = new javax.swing.JTextField();
        jTFQntCarros = new javax.swing.JTextField();
        jButtonRemC = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jButtonAddV = new javax.swing.JButton();
        jButtonAltC = new javax.swing.JButton();
        jFTCep = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jFTCNPJ = new javax.swing.JFormattedTextField();
        jFTNumero = new javax.swing.JFormattedTextField();
        jFTTelC = new javax.swing.JFormattedTextField();
        jFTTelF = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jFTNomeFantasia = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel3.setText("Telefone Fixo:");

        jLabel5.setText("Telefone Comercial:");

        jLabel7.setText("CNPJ:");

        jLabel8.setText("Complemento:");

        jLabel9.setText("CEP:");

        jLabel10.setText("Logradouro:");

        jLabel2.setText("Páis:");

        jLabel4.setText("Estado:");

        jLabel11.setText("Município:");

        jLabel12.setText("QntCarros:");

        jTFQntCarros.setEditable(false);
        jTFQntCarros.setText("0");

        jButtonRemC.setText("Remover Carro");
        jButtonRemC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemCActionPerformed(evt);
            }
        });

        jButtonAddV.setText("AddCarro");
        jButtonAddV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddVActionPerformed(evt);
            }
        });

        jButtonAltC.setText("Alterar Carro");
        jButtonAltC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltCActionPerformed(evt);
            }
        });

        jFTCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTCepFocusGained(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel13.setText("Número:");

        jLabel6.setText("Bairro:");

        jFTCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTCNPJFocusGained(evt);
            }
        });

        jFTTelC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTTelCFocusGained(evt);
            }
        });

        jLabel14.setText("Nome Fantasia:");

        jFTNomeFantasia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTNomeFantasiaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(6, 6, 6)
                                    .addComponent(jFTTelC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel7)
                                    .addGap(6, 6, 6)
                                    .addComponent(jFTCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel14)
                                    .addGap(6, 6, 6)
                                    .addComponent(jFTNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(jLabel1)
                                    .addGap(6, 6, 6)
                                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel3)
                                    .addGap(6, 6, 6)
                                    .addComponent(jFTTelF, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(56, 56, 56)
                                            .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addComponent(jLabel13)))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFTCep, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTFLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFTNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel2)
                                    .addGap(6, 6, 6)
                                    .addComponent(jTFPais, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel4)
                                    .addGap(6, 6, 6)
                                    .addComponent(jTFEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel11)
                                    .addGap(6, 6, 6)
                                    .addComponent(jTFMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel12)
                                    .addGap(6, 6, 6)
                                    .addComponent(jTFQntCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonAddV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAltC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonRemC))))
                            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel14))
                                    .addComponent(jFTNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel1)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jFTTelF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel5))
                                    .addComponent(jFTTelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel7))
                                    .addComponent(jFTCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel2)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                    .addComponent(jTFEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel11))
                                    .addComponent(jTFMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel12))
                                    .addComponent(jTFQntCarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButtonAddV)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonAltC)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonRemC))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jFTCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTFLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jFTNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        Endereco endereco = new Endereco();
        Municipio municipio = new Municipio();
        PessoaJuridica pessoajuridica = new PessoaJuridica();

        municipio.setNome(jTFMunicipio.getText());
        municipio.setEstado(jTFEstado.getText());
        municipio.setPais(jTFPais.getText());

        endereco.setBairro(jTFBairro.getText());
        endereco.setCep(jFTCep.getText());
        endereco.setComplemento(jTFComplemento.getText());
        endereco.setLogradouro(jTFLogradouro.getText());
        endereco.setNumero(jFTNumero.getText());

        endereco.setMunicipio(municipio);
        pessoajuridica.setNomeFantasia(jFTNomeFantasia.getText());
        pessoajuridica.setCnpj(jFTCNPJ.getText());
        pessoajuridica.setNome(jTFNome.getText());
        pessoajuridica.setTelefoneComercial(jFTTelC.getText());
        pessoajuridica.setTelefoneFixo(jFTTelF.getText());
        Veiculo[] arr = new Veiculo[arrayV.size()];

        pessoajuridica.setVeiculos(arrayV.toArray(arr));

        pessoajuridica.setEnderecoComercial(endereco);

        if (this.pessoajuridica != null) {

            pessoajuridica.getEnderecoComercial().setId(this.pessoajuridica.getEnderecoComercial().getId());
            pessoajuridica.getEnderecoComercial().getMunicipio().setId(this.pessoajuridica.getEnderecoComercial().getMunicipio().getId());
            pessoajuridica.setId(this.pessoajuridica.getId());
            this.pessoajuridica = pessoajuridica;
            check = 1;
            this.dispose();
        } else {

            FicharioPessoaJ fichario = new FicharioPessoaJ();
            try {

                fichario.add(pessoajuridica);

                int input = JOptionPane.showConfirmDialog(null, "Registrar outro?", "Gravou com Sucesso", JOptionPane.OK_OPTION);
                if (input != 0) {
                    this.dispose();
                } else {
                    arrayV.clear();
                    Container con = this.getContentPane();
                    for (Component c : con.getComponents()) {
                        if (c instanceof JTextField) {
                            JTextField j = (JTextField) c;
                            j.setText("");
                        }
                    }

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro, motivo: "
                        + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonAddVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddVActionPerformed
        TelaAddVeiculo tela = new TelaAddVeiculo(null, true);
        Veiculo veiculo = tela.showDialog();
        arrayV.add(veiculo);
        modelL.addElement(veiculo.getMarca() + " " + veiculo.getModelo());
        jTFQntCarros.setText("" + arrayV.size());
    }//GEN-LAST:event_jButtonAddVActionPerformed

    private void jButtonAltCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltCActionPerformed

        int index = jList1.getSelectedIndex();
        if (index > -1) {

            TelaAddVeiculo tela = new TelaAddVeiculo((Frame) this.getParent(), true, arrayV.get(index));
            Veiculo veiculo = tela.showDialog();
            veiculo.setId(arrayV.get(index).getId());
            arrayV.set(index, veiculo);
            modelL.setElementAt(veiculo.getMarca() + " " + veiculo.getModelo(), index);
        }
    }//GEN-LAST:event_jButtonAltCActionPerformed

    private void jButtonRemCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemCActionPerformed
        int index = jList1.getSelectedIndex();
        if (index > -1) {
            int input = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Excluir", JOptionPane.WARNING_MESSAGE);
            if (input == 0) {
                arrayV.remove(index);
                modelL.remove(index);
                jTFQntCarros.setText("" + arrayV.size());

            }
        }
    }//GEN-LAST:event_jButtonRemCActionPerformed

    private void jFTTelCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTTelCFocusGained
        jFTTelC.setCaretPosition(4);
    }//GEN-LAST:event_jFTTelCFocusGained

    private void jFTCNPJFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTCNPJFocusGained
        jFTCNPJ.setCaretPosition(0);
    }//GEN-LAST:event_jFTCNPJFocusGained

    private void jFTCepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTCepFocusGained
        jFTCep.setCaretPosition(0);
    }//GEN-LAST:event_jFTCepFocusGained

    private void jFTNomeFantasiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTNomeFantasiaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTNomeFantasiaFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonAddV;
    private javax.swing.JButton jButtonAltC;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonRemC;
    private javax.swing.JFormattedTextField jFTCNPJ;
    private javax.swing.JFormattedTextField jFTCep;
    private javax.swing.JFormattedTextField jFTNomeFantasia;
    private javax.swing.JFormattedTextField jFTNumero;
    private javax.swing.JFormattedTextField jFTTelC;
    private javax.swing.JFormattedTextField jFTTelF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFEstado;
    private javax.swing.JTextField jTFLogradouro;
    private javax.swing.JTextField jTFMunicipio;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPais;
    private javax.swing.JTextField jTFQntCarros;
    // End of variables declaration//GEN-END:variables

    PessoaJuridica showDialog() {
        this.setVisible(true);
        if (check == 1) {
            return pessoajuridica;
        } else {
            return null;
        }

    }

    private void formatarCampo() {
        try {

            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
            MaskFormatter mask2 = new MaskFormatter("#####-###");
            MaskFormatter mask3 = new MaskFormatter("+55(##)#####-####");
            mask.install(jFTCNPJ);
            mask2.install(jFTCep);
            mask3.install(jFTTelC);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar", "ERRO", JOptionPane.ERROR);
        }
    }

    public void preencher(PessoaJuridica e) {
        jTFNome.setText(e.getNome());
        jFTTelF.setText(e.getTelefoneFixo());
        jFTTelC.setText(e.getTelefoneComercial());
        jFTCNPJ.setText(e.getCnpj());
        jFTNomeFantasia.setText(e.getNomeFantasia());
        jTFComplemento.setText(e.getEnderecoComercial().getComplemento());
        jFTCep.setText(e.getEnderecoComercial().getCep());
        jTFLogradouro.setText(e.getEnderecoComercial().getLogradouro());
        jFTNumero.setText(e.getEnderecoComercial().getNumero());
        jTFBairro.setText(e.getEnderecoComercial().getBairro());
        jTFPais.setText(e.getEnderecoComercial().getMunicipio().getPais());
        jTFEstado.setText(e.getEnderecoComercial().getMunicipio().getEstado());
        jTFMunicipio.setText(e.getEnderecoComercial().getMunicipio().getNome());
        for (Veiculo veiculo : e.getVeiculos()) {
            arrayV.add(veiculo);
            modelL.addElement(veiculo.getMarca() + " " + veiculo.getModelo());
            jTFQntCarros.setText("" + arrayV.size());
        }
    }

}
