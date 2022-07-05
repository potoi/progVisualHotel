/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import controller.Conexao;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import visual.conta.CrudConta;

/**
 *
 * @author Victor
 */
public class Util {

    public static String sha256Hex(String message) {
        try {
            MessageDigest md
                    = MessageDigest.getInstance("SHA-256");
            return hex(md.digest(message.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i]
                    & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static void fazRelatorio(String nome) {
        try {
            Connection conn = Conexao.getConexao();
            String path = "src/main/java/recursos/relatorios/" + nome;
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperViewer jv = new JasperViewer(JasperFillManager.fillReport(jr, null, conn), false);
            jv.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jv.setVisible(true);
            jv.setTitle("Relatório Produtos.");

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar relatório, motivo: " + e.getMessage(),
                    "Erro", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(CrudConta.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar relatório, motivo: " + ex.getMessage(),
                    "Erro", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(CrudConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
