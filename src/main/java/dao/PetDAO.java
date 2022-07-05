package dao;

import model.Pet;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetDAO {

    private Connection conn = null;

    public PetDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void incluir(Pet veic) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO pets( animal,descricao,idpessoaf,idpessoaj) VALUES (?, ?, ?, ?)";

        Integer f = veic.getIdF();
        Integer j = veic.getIdJ();
        if (j <= 0) {
            j = null;
        }
        if (f <= 0) {
            f = null;
        }
        ps = conn.prepareStatement(sql);

        ps.setString(1, veic.getAnimal());
        ps.setString(2, veic.getDescricao());

        if (f != null) {
            ps.setInt(3, veic.getIdF());;
        } else {
            ps.setNull(3, 4);
        }
        if (j != null) {
            ps.setInt(4, veic.getIdJ());
        } else {
            ps.setNull(4, 4);
        }

        ps.execute();
        ps.close();

    }

    public void alterar(Pet veic, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE pets SET animal = ?, descricao = ? WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, veic.getAnimal());
        ps.setString(2, veic.getDescricao());
        ps.setInt(3, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM pets WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Pet consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet veic = null;

        sql = "SELECT id, animal,descricao idPessoaF,idPessoaJ FROM pets  WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            veic = new Pet();

            veic.setId(rs.getInt("id"));
            veic.setAnimal(rs.getString("animal"));
            veic.setDescricao(rs.getString("descricao"));
            veic.setIdF(rs.getInt("idPessoaF"));
            veic.setIdJ(rs.getInt("idPessoaJ"));

        }

        rs.close();
        ps.close();

        return veic;
    }

    public ArrayList<Pet> listar() throws Exception {
        String sql;
        ArrayList<Pet> pets = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, animal,descricao idPessoaF,idPessoaJ FROM pets";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Pet veic = new Pet();

            veic.setId(rs.getInt("id"));
            veic.setAnimal(rs.getString("animal"));
            veic.setDescricao(rs.getString("descricao"));
            veic.setIdF(rs.getInt("idPessoaF"));
            veic.setIdJ(rs.getInt("idPessoaJ"));

            pets.add(veic);
        }
        rs.close();
        ps.close();

        return pets;
    }

    public ArrayList<Pet> listarF(int idF) throws Exception {
        String sql;
        ArrayList<Pet> pets = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, animal,descricao idPessoaF,idPessoaJ FROM pets  WHERE idpessoaF = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idF);
        rs = ps.executeQuery();
        while (rs.next()) {
            Pet veic = new Pet();

            veic.setId(rs.getInt("id"));
            veic.setAnimal(rs.getString("animal"));
            veic.setDescricao(rs.getString("descricao"));
            veic.setIdF(rs.getInt("idPessoaF"));
            veic.setIdJ(rs.getInt("idPessoaJ"));

            pets.add(veic);
        }
        rs.close();
        ps.close();

        return pets;
    }

    public ArrayList<Pet> listarJ(int idJ) throws Exception {
        String sql;
        ArrayList<Pet> pets = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, animal,descricao idPessoaF,idPessoaJ FROM pets  WHERE idpessoaJ = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idJ);
        rs = ps.executeQuery();
        while (rs.next()) {
            Pet veic = new Pet();

            veic.setId(rs.getInt("id"));
            veic.setAnimal(rs.getString("animal"));
            veic.setDescricao(rs.getString("descricao"));
            veic.setIdF(rs.getInt("idPessoaF"));
            veic.setIdJ(rs.getInt("idPessoaJ"));

            pets.add(veic);
        }
        rs.close();
        ps.close();

        return pets;
    }

    public String[][] listarString() throws Exception {
        String sql;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String[][] a = new String[tamanho()][7];

        sql = "SELECT  v.*,c.nome \n"
                + "FROM pets v join clientesfisico c on c.id = v.idpessoaf\n"
                + "union\n"
                + "SELECT v.*,c.nome \n"
                + "FROM pets v join clientesjuridico c on c.id = v.idpessoaj";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {

            a[i][0] = rs.getString("id");
            a[i][1] = rs.getString("marca");
            a[i][2] = rs.getString("modelo");
            a[i][3] = rs.getString("cor");
            a[i][4] = rs.getString("placa");
            a[i][5] = rs.getString("vagaOcupada");
            a[i][6] = rs.getString("nome");
            i++;
        }
        rs.close();
        ps.close();

        return a;
    }

    public int tamanho() throws Exception {
        String sql;

        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = "select count(id) as quantidade from pets";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int a = 0;
        while (rs.next()) {

            a = rs.getInt("quantidade");

        }
        rs.close();
        ps.close();

        return a;
    }

}
