/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Item;
import model.Usuario;
import recursos.Util;

/**
 *
 * @author Victor
 */
public class FicharioUsuario {

    public UsuarioDAO dao = new UsuarioDAO();

    public FicharioUsuario() {
    }

    public void add(Usuario e) throws Exception {
        e.setSenha(Util.sha256Hex(e.getSenha()));
        dao.incluir(e);

    }
    public String toHash(String senha){
        senha = Util.sha256Hex(senha);     
        return senha;
    }
    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof Usuario Usuario) {
                if (Usuario.getIdentificador() == id) {
                    return i;
                }
                i++;
            }

        }
        return -1;

    }
     */
    public void remove(int index) {

    }

    public Usuario achar(String nome) throws Exception {
        Usuario Usuario = dao.consulta(nome);
        return Usuario;
    }
}
