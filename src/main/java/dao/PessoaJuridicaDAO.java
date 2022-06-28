package dao;

import model.PessoaJuridica;
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Endereco;

public class PessoaJuridicaDAO {

    private Connection conn = null;

    public PessoaJuridicaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public PessoaJuridica incluir(PessoaJuridica pess) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = "INSERT INTO clientesjuridico( nome, enderecoid, telefonefixo, telefonecomercial, cnpj, nomefantasia) VALUES (?, ?, ?, ?, ?, ?) returning clientesjuridico.id ";

        ps = conn.prepareStatement(sql);

        ps.setString(1, pess.getNome());
        ps.setInt(2, pess.getEnderecoComercial().getId());
        ps.setString(3, pess.getTelefoneFixo());
        ps.setString(4, pess.getTelefoneComercial());
        ps.setString(5, pess.getCnpj());
        ps.setString(6, pess.getNomeFantasia());
        rs = ps.executeQuery();

        while (rs.next()) {

            pess.setId(rs.getInt("id"));

        }

        rs.close();
        ps.close();
        return pess;

    }

    public void alterar(PessoaJuridica pess, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        sql = "UPDATE clientesjuridico SET nome = ?, enderecoid = ?, telefonefixo = ?, telefonecomercial = ?, cnpj = ?, nomefantasia = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, pess.getNome());
        ps.setInt(2, pess.getEnderecoComercial().getId());
        ps.setString(3, pess.getTelefoneFixo());
        ps.setString(4, pess.getTelefoneComercial());
        ps.setString(5, pess.getCnpj());
        ps.setString(6, pess.getNomeFantasia());
        ps.setInt(7, id);

        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM clientesjuridico WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public PessoaJuridica consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PessoaJuridica pess = null;

        sql = "SELECT id, nome, enderecoid, telefonefixo, telefonecomercial, cnpj, nomefantasia FROM clientesjuridico WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            pess = new PessoaJuridica();
            pess.setEnderecoComercial(new Endereco());

            pess.setId(rs.getInt("id"));
            pess.setNome(rs.getString("nome"));
            pess.getEnderecoComercial().setId(rs.getInt("enderecoid"));
            pess.setTelefoneFixo(rs.getString("telefonefixo"));
            pess.setTelefoneComercial(rs.getString("telefonecomercial"));
            pess.setCnpj(rs.getString("cnpj"));
            pess.setNomeFantasia(rs.getString("nomefantasia"));

        }

        rs.close();
        ps.close();

        return pess;
    }

    public ArrayList<PessoaJuridica> listar() throws Exception {
        String sql;
        ArrayList<PessoaJuridica> pessoasJ = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, nome, enderecoid, telefonefixo, telefonecomercial, cnpj, nomefantasia FROM clientesjuridico";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            PessoaJuridica pess = new PessoaJuridica();
            pess.setEnderecoComercial(new Endereco());
            pess.setId(rs.getInt("id"));
            pess.setNome(rs.getString("nome"));
            pess.getEnderecoComercial().setId(rs.getInt("enderecoid"));
            pess.setTelefoneFixo(rs.getString("telefonefixo"));
            pess.setTelefoneComercial(rs.getString("telefonecomercial"));
            pess.setCnpj(rs.getString("cnpj"));
            pess.setNomeFantasia(rs.getString("nomefantasia"));

            pessoasJ.add(pess);
        }
        rs.close();
        ps.close();

        return pessoasJ;
    }

}
