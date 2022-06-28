package dao;

import model.Endereco;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Municipio;

public class EnderecoDAO {

    private Connection conn = null;
    private EnderecoDAO prodDao;

    public EnderecoDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Endereco incluir(Endereco ende) throws Exception {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO enderecos( logradouro, numero, bairro, complemento, cep, municipioid) VALUES (?, ?, ?, ?, ?, ?) returning enderecos.id";

        ps = conn.prepareStatement(sql);
        ResultSet rs = null;
        ps.setString(1, ende.getLogradouro());
        ps.setString(2, ende.getNumero());
        ps.setString(3, ende.getBairro());
        ps.setString(4, ende.getComplemento());
        ps.setString(5, ende.getCep());
        ps.setInt(6, ende.getMunicipio().getId());
        rs = ps.executeQuery();

        while (rs.next()) {

            ende.setId(rs.getInt("id"));


        }

        rs.close();
        ps.close();
        return ende;

    }

    public void alterar(Endereco ende, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE enderecos SET logradouro = ?, numero = ?, bairro = ?, complemento = ? , cep = ? , municipioid = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, ende.getLogradouro());
        ps.setString(2, ende.getNumero());
        ps.setString(3, ende.getBairro());
        ps.setString(4, ende.getComplemento());
        ps.setString(5, ende.getCep());
        ps.setInt(6, ende.getMunicipio().getId());
        ps.setInt(7, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM enderecos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Endereco consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Endereco ende = null;

        sql = "SELECT id, logradouro, numero, bairro, complemento, cep , municipioid FROM enderecos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            ende = new Endereco();
            ende.setMunicipio(new Municipio());
            ende.setId(rs.getInt("id"));
            ende.setLogradouro(rs.getString("logradouro"));
            ende.setNumero(rs.getString("numero"));
            ende.setBairro(rs.getString("bairro"));
            ende.setComplemento(rs.getString("complemento"));
            ende.setCep(rs.getString("cep"));
            ende.getMunicipio().setId(rs.getInt("municipioid"));

        }

        rs.close();
        ps.close();

        return ende;
    }

    public ArrayList<Endereco> listar() throws Exception {
        String sql;
        ArrayList<Endereco> enderecos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, logradouro, numero, bairro, complemento, cep , municipioid FROM enderecos";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Endereco ende = new Endereco();
            ende.setMunicipio(new Municipio());
            ende.setId(rs.getInt("id"));
            ende.setLogradouro(rs.getString("logradouro"));
            ende.setNumero(rs.getString("numero"));
            ende.setBairro(rs.getString("bairro"));
            ende.setComplemento(rs.getString("complemento"));
            ende.setCep(rs.getString("cep"));
            ende.getMunicipio().setId(rs.getInt("municipioid"));

            enderecos.add(ende);
        }
        rs.close();
        ps.close();

        return enderecos;
    }

}
