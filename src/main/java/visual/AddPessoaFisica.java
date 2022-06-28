/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual;

import controller.FicharioPessoaF;
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
import model.PessoaFisica;
import model.Veiculo;

public class AddPessoaFisica extends javax.swing.JDialog {

    private ArrayList<Veiculo> arrayV = new ArrayList<>();
    private DefaultListModel modelL = new DefaultListModel();
    private PessoaFisica pessoafisica;
    public int check = 0;

    public AddPessoaFisica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Adicionar Pessoa Física");
        initComponents();
        formatarCampo();
        jList1.setModel(modelL);
    }

    public AddPessoaFisica(java.awt.Frame parent, boolean modal, PessoaFisica pessoafisica) {
        super(parent, modal);
        this.setTitle("Alterar Pessoa Física");
        initComponents();
        this.pessoafisica = pessoafisica;
        formatarCampo();
        jList1.setModel(modelL);
        preencher(pessoafisica);
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
        jFTCPF = new javax.swing.JFormattedTextField();
        jFTNumero = new javax.swing.JFormattedTextField();
        jFTTelC = new javax.swing.JFormattedTextField();
        jFTTelF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 410, 36));
        getContentPane().add(jTFNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 44, 165, -1));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 47, -1, -1));

        jLabel3.setText("Telefone Fixo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 81, -1, -1));

        jLabel5.setText("Telefone Celular:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 115, -1, -1));

        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel8.setText("Complemento:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 183, -1, -1));

        jLabel9.setText("CEP:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 217, -1, -1));

        jLabel10.setText("Logradouro:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 251, -1, -1));
        getContentPane().add(jTFComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 165, -1));
        getContentPane().add(jTFLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 248, 165, -1));

        jLabel2.setText("Páis:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 47, -1, -1));

        jLabel4.setText("Estado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 81, -1, -1));

        jLabel11.setText("Município:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 115, -1, -1));

        jLabel12.setText("QntCarros:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 149, -1, -1));
        getContentPane().add(jTFPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 44, 165, -1));
        getContentPane().add(jTFMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 112, 165, -1));
        getContentPane().add(jTFEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 78, 165, -1));

        jTFQntCarros.setEditable(false);
        jTFQntCarros.setText("0");
        getContentPane().add(jTFQntCarros, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 146, 165, -1));

        jButtonRemC.setText("Remover Carro");
        jButtonRemC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemC, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 20, 20));

        jButtonAddV.setText("AddCarro");
        jButtonAddV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddVActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAddV, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 110, -1));

        jButtonAltC.setText("Alterar Carro");
        jButtonAltC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAltC, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 110, -1));

        jFTCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTCepFocusGained(evt);
            }
        });
        getContentPane().add(jFTCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 216, 165, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 110, 130));

        jLabel13.setText("Número:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 280, -1, -1));
        getContentPane().add(jTFBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 312, 165, -1));

        jLabel6.setText("Bairro:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 312, -1, -1));

        jFTCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTCPFFocusGained(evt);
            }
        });
        getContentPane().add(jFTCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 146, 165, -1));
        getContentPane().add(jFTNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 165, -1));

        jFTTelC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTTelCFocusGained(evt);
            }
        });
        getContentPane().add(jFTTelC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 113, 165, -1));
        getContentPane().add(jFTTelF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 165, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        Endereco endereco = new Endereco();
        Municipio municipio = new Municipio();
        PessoaFisica pessoafisica = new PessoaFisica();

        municipio.setNome(jTFMunicipio.getText());
        municipio.setEstado(jTFEstado.getText());
        municipio.setPais(jTFPais.getText());

        endereco.setBairro(jTFBairro.getText());
        endereco.setCep(jFTCep.getText());
        endereco.setComplemento(jTFComplemento.getText());
        endereco.setLogradouro(jTFLogradouro.getText());
        endereco.setNumero(jFTNumero.getText());

        endereco.setMunicipio(municipio);

        pessoafisica.setCpf(jFTCPF.getText());
        pessoafisica.setNome(jTFNome.getText());
        pessoafisica.setTelefoneCelular(jFTTelC.getText());
        pessoafisica.setTelefoneFixo(jFTTelF.getText());
        Veiculo[] arr = new Veiculo[arrayV.size()];

        pessoafisica.setVeiculos(arrayV.toArray(arr));

        pessoafisica.setEnderecoResidencial(endereco);

        if (this.pessoafisica != null) {

            pessoafisica.getEnderecoResidencial().setId(this.pessoafisica.getEnderecoResidencial().getId());
            pessoafisica.getEnderecoResidencial().getMunicipio().setId(this.pessoafisica.getEnderecoResidencial().getMunicipio().getId());
            pessoafisica.setId(this.pessoafisica.getId());
            this.pessoafisica = pessoafisica;
            check = 1;
            this.dispose();
        } else {

            FicharioPessoaF fichario = new FicharioPessoaF();
            try {

                fichario.add(pessoafisica);

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
        AddCarro tela = new AddCarro(null, true);
        Veiculo veiculo = tela.showDialog();
        arrayV.add(veiculo);
        modelL.addElement(veiculo.getMarca() + " " + veiculo.getModelo());
        jTFQntCarros.setText("" + arrayV.size());
    }//GEN-LAST:event_jButtonAddVActionPerformed

    private void jButtonAltCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltCActionPerformed

        int index = jList1.getSelectedIndex();
        if (index > -1) {

            AddCarro tela = new AddCarro((Frame) this.getParent(), true, arrayV.get(index));
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

    private void jFTCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTCPFFocusGained
        jFTCPF.setCaretPosition(0);
    }//GEN-LAST:event_jFTCPFFocusGained

    private void jFTCepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTCepFocusGained
        jFTCep.setCaretPosition(0);
    }//GEN-LAST:event_jFTCepFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonAddV;
    private javax.swing.JButton jButtonAltC;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonRemC;
    private javax.swing.JFormattedTextField jFTCPF;
    private javax.swing.JFormattedTextField jFTCep;
    private javax.swing.JFormattedTextField jFTNumero;
    private javax.swing.JFormattedTextField jFTTelC;
    private javax.swing.JFormattedTextField jFTTelF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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

    PessoaFisica showDialog() {
        this.setVisible(true);
        if (check == 1) {
            return pessoafisica;
        } else {
            return null;
        }

    }

    private void formatarCampo() {
        try {

            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            MaskFormatter mask2 = new MaskFormatter("#####-###");
            MaskFormatter mask3 = new MaskFormatter("+55(##)#####-####");
            mask.install(jFTCPF);
            mask2.install(jFTCep);
            mask3.install(jFTTelC);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar", "ERRO", JOptionPane.ERROR);
        }
    }

    public void preencher(PessoaFisica e) {
        jTFNome.setText(e.getNome());
        jFTTelF.setText(e.getTelefoneFixo());
        jFTTelC.setText(e.getTelefoneCelular());
        jFTCPF.setText(e.getCpf());
        jTFComplemento.setText(e.getEnderecoResidencial().getComplemento());
        jFTCep.setText(e.getEnderecoResidencial().getCep());
        jTFLogradouro.setText(e.getEnderecoResidencial().getLogradouro());
        jFTNumero.setText(e.getEnderecoResidencial().getNumero());
        jTFBairro.setText(e.getEnderecoResidencial().getBairro());
        jTFPais.setText(e.getEnderecoResidencial().getMunicipio().getPais());
        jTFEstado.setText(e.getEnderecoResidencial().getMunicipio().getEstado());
        jTFMunicipio.setText(e.getEnderecoResidencial().getMunicipio().getNome());
        for (Veiculo veiculo : e.getVeiculos()) {
            arrayV.add(veiculo);
            modelL.addElement(veiculo.getMarca() + " " + veiculo.getModelo());
            jTFQntCarros.setText("" + arrayV.size());
        }
    }

}
