/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Utilidades {

    public void popUpadicionou() {
        Icon icon = createImageIcon("images/middle.gif",
                "a pretty but meaningless splat");
        JOptionPane.showMessageDialog(null, "Erro. ",
                "Erro encontrado.", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Deu certo", "foi", 0, icon);
    }

    public static void popUpErro(Exception e) {
        JOptionPane.showMessageDialog(null, "Erro. " + e,
                "Erro encontrado.", JOptionPane.ERROR_MESSAGE);
    }

    public ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }

    }
}
