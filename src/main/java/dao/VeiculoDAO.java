package dao;

import model.Veiculo;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {

    private Connection conn = null;

    public VeiculoDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void incluir(Veiculo veic) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO veiculos( marca,modelo,cor,placa,vagaOcupada,idpessoaf,idpessoaj) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Integer f = veic.getIdF();
        Integer j = veic.getIdJ();
        if (j <= 0) {
            j = null;
        }
        if (f <= 0) {
            f = null;
        }
        ps = conn.prepareStatement(sql);

        ps.setString(1, veic.getMarca());
        ps.setString(2, veic.getModelo());
        ps.setString(3, veic.getCor());
        ps.setString(4, veic.getPlaca());
        ps.setString(5, veic.getVagaOcupada());
        if (f != null) {
            ps.setInt(6, f);
        } else {
            ps.setNull(6, 4);
        }
        if (j != null) {
            ps.setInt(7, j);
        } else {
            ps.setNull(7, 4);
        }

        ps.execute();
        ps.close();

    }

    public void alterar(Veiculo veic, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE veiculos SET marca = ?, modelo = ?, cor = ?, placa = ?, vagaOcupada = ? WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, veic.getMarca());
        ps.setString(2, veic.getModelo());
        ps.setString(3, veic.getCor());
        ps.setString(4, veic.getPlaca());
        ps.setString(5, veic.getVagaOcupada());
        ps.setInt(6, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM veiculos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Veiculo consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Veiculo veic = null;

        sql = "SELECT id, marca, modelo, cor, placa, vagaOcupada, idPessoaF,idPessoaJ FROM veiculos  WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            veic = new Veiculo();

            veic.setId(rs.getInt("id"));
            veic.setMarca(rs.getString("marca"));
            veic.setModelo(rs.getString("modelo"));
            veic.setColor(rs.getString("cor"));
            veic.setPlaca(rs.getString("placa"));
            veic.setVagaOcupada(rs.getString("vagaOcupada"));
            veic.setIdF(rs.getInt("idPessoaF"));
            veic.setIdJ(rs.getInt("idPessoaJ"));

        }

        rs.close();
        ps.close();

        return veic;
    }

    public ArrayList<Veiculo> listar() throws Exception {
        String sql;
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, marca, modelo, cor, placa, vagaOcupada,idPessoaF,idPessoaJ FROM veiculos";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Veiculo veic = new Veiculo();

            veic.setId(rs.getInt("id"));
            veic.setMarca(rs.getString("marca"));
            veic.setModelo(rs.getString("modelo"));
            veic.setColor(rs.getString("cor"));
            veic.setPlaca(rs.getString("placa"));
            veic.setVagaOcupada(rs.getString("vagaOcupada"));
            veic.setIdF(rs.getInt("idPessoaF"));
            veic.setIdJ(rs.getInt("idPessoaJ"));

            veiculos.add(veic);
        }
        rs.close();
        ps.close();

        return veiculos;
    }

    public ArrayList<Veiculo> listarF(int idF) throws Exception {
        String sql;
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, marca, modelo, cor, placa, vagaOcupada,idPessoaF,idPessoaJ FROM veiculos where idPessoaF = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idF);
        rs = ps.executeQuery();
        while (rs.next()) {
            Veiculo veic = new Veiculo();

            veic.setId(rs.getInt("id"));
            veic.setMarca(rs.getString("marca"));
            veic.setModelo(rs.getString("modelo"));
            veic.setColor(rs.getString("cor"));
            veic.setPlaca(rs.getString("placa"));
            veic.setVagaOcupada(rs.getString("vagaOcupada"));
            veic.setIdF(rs.getInt("idPessoaF"));

            veiculos.add(veic);
        }
        rs.close();
        ps.close();

        return veiculos;
    }

    public ArrayList<Veiculo> listarJ(int idJ) throws Exception {
        String sql;
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, marca, modelo, cor, placa, vagaOcupada,idPessoaJ FROM veiculos where idPessoaJ = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idJ);
        rs = ps.executeQuery();
        while (rs.next()) {
            Veiculo veic = new Veiculo();

            veic.setId(rs.getInt("id"));
            veic.setMarca(rs.getString("marca"));
            veic.setModelo(rs.getString("modelo"));
            veic.setColor(rs.getString("cor"));
            veic.setPlaca(rs.getString("placa"));
            veic.setVagaOcupada(rs.getString("vagaOcupada"));
            veic.setIdF(rs.getInt("idPessoaJ"));

            veiculos.add(veic);
        }
        rs.close();
        ps.close();

        return veiculos;
    }

    public String[][] listarString() throws Exception {
        String sql;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String[][] a = new String[tamanho()][7];

        sql = "SELECT  v.id,v.marca, v.modelo, v.cor, v.placa, v.vagaOcupada,v.idPessoaJ,v.idPessoaF,c.nome \n"
                + "FROM veiculos v join clientesfisico c on c.id = v.idpessoaf\n"
                + "union\n"
                + "SELECT v.id,v.marca, v.modelo, v.cor, v.placa, v.vagaOcupada,v.idPessoaJ,v.idPessoaF,c.nome \n"
                + "FROM veiculos v join clientesjuridico c on c.id = v.idpessoaj";
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
        sql = "select count(id) as quantidade from veiculos";
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
