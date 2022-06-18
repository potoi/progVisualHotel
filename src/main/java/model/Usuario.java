/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 *
 * @author Saulo Barbosa
 */
public class Usuario {
   private  String login;
    private String Senha;

    public Usuario(String login, String Senha) {
        this.login = login;
        this.Senha = Senha;
    }

    public Usuario() {
    }

    public Usuario(ArrayList<Usuario> arrayUsuario) {
   
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {

        this.Senha = Senha;
    }
    
}
