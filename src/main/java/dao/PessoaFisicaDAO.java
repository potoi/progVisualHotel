package dao;

import model.PessoaFisica;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Endereco;

public class PessoaFisicaDAO {

    private Connection conn = null;

    public PessoaFisicaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public PessoaFisica incluir(PessoaFisica pess) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = "INSERT INTO clientesfisico( nome, enderecoid, telefonefixo, telefonecelular, cpf) VALUES (?, ?, ?, ?, ?) returning clientesfisico.id ";

        ps = conn.prepareStatement(sql);

        ps.setString(1, pess.getNome());
        ps.setInt(2, pess.getEnderecoResidencial().getId());
        ps.setString(3, pess.getTelefoneFixo());
        ps.setString(4, pess.getTelefoneCelular());
        ps.setString(5, pess.getCpf());
        rs = ps.executeQuery();

        while (rs.next()) {

            pess.setId(rs.getInt("id"));

        }

        rs.close();
        ps.close();
        return pess;

    }

    public void alterar(PessoaFisica pess, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        sql = "UPDATE clientesfisico SET nome = ?, enderecoid = ?, telefonefixo = ?, telefonecelular = ?, cpf = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, pess.getNome());
        ps.setInt(2, pess.getEnderecoResidencial().getId());
        ps.setString(3, pess.getTelefoneFixo());
        ps.setString(4, pess.getTelefoneCelular());
        ps.setString(5, pess.getCpf());
        ps.setInt(6, id);

        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM clientesfisico WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public PessoaFisica consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PessoaFisica pess = null;

        sql = "SELECT id, nome, enderecoid, telefonefixo, telefonecelular, cpf FROM clientesfisico WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            pess = new PessoaFisica();
            pess.setEnderecoResidencial(new Endereco());

            pess.setId(rs.getInt("id"));
            pess.setNome(rs.getString("nome"));
            pess.getEnderecoResidencial().setId(rs.getInt("enderecoid"));
            pess.setTelefoneFixo(rs.getString("telefonefixo"));
            pess.setTelefoneCelular(rs.getString("telefonecelular"));
            pess.setCpf(rs.getString("cpf"));

        }

        rs.close();
        ps.close();

        return pess;
    }

    public ArrayList<PessoaFisica> listar() throws Exception {
        String sql;
        ArrayList<PessoaFisica> pessoasF = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, nome, enderecoid, telefonefixo, telefonecelular, cpf FROM clientesfisico";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            PessoaFisica pess = new PessoaFisica();
            pess.setEnderecoResidencial(new Endereco());
            pess.setId(rs.getInt("id"));
            pess.setNome(rs.getString("nome"));
            pess.getEnderecoResidencial().setId(rs.getInt("enderecoid"));
            pess.setTelefoneFixo(rs.getString("telefonefixo"));
            pess.setTelefoneCelular(rs.getString("telefonecelular"));
            pess.setCpf(rs.getString("cpf"));

            pessoasF.add(pess);
        }
        rs.close();
        ps.close();

        return pessoasF;
    }

}
