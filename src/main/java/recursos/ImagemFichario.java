/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public  class ImagemFichario {

    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public ImageIcon createImageIcon(String path, int tamanho) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);

            Image image = icon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(tamanho, tamanho, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            icon = new ImageIcon(newimg);  // transform it back

            return (icon);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public  ImageIcon sucesso(){
        ImageIcon icon = createImageIcon("sucesso.png", 70);
        return icon;
    }
}
