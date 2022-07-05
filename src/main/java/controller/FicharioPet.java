/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PetDAO;
import java.util.ArrayList;
import model.Pet;

/**
 *
 * @author Victor
 */
public class FicharioPet {

    public PetDAO dao = new PetDAO();

    public FicharioPet() {
    }

    public String[] getColumnName() {
        String[] a = {"ID", "Tipo de animal", "Descrição"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Pet> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 3;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Pet c : data) {

            stringTotal[i][0] = c.getId()+"";
            stringTotal[i][1] = c.getAnimal();
            stringTotal[i][2] = c.getDescricao();

            i++;
        }

        return stringTotal;
    }

    public void add(Pet e) throws Exception {
        dao.incluir(e);

    }

    public String[][] listar() throws Exception {
        return dao.listarString();
    }

    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof Pet pet) {
                if (pet.getIdentificador() == id) {
                    return i;
                }
                i++;
            }

        }
        return -1;

    }
     */
    public void remove(int index) throws Exception {
        dao.apagar(index);
    }

    public Pet achar(int index) throws Exception {
        Pet pet = dao.consulta(index);
        return pet;
    }

    public void alterar(Pet pet, int id) throws Exception {
        dao.alterar(pet, id);
    }
}
