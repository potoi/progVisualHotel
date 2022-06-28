package dao;

import model.Funcionario;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class FuncionarioDAO {

    private Connection conn = null;

    public FuncionarioDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void incluir(Funcionario equip) throws Exception {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO funcionarios(matricula,nome,profissao) VALUES (?,?,?)";

        ps = conn.prepareStatement(sql);
        ResultSet rs = null;
        ps.setString(1, equip.getMatricula());
        ps.setString(2, equip.getNome());
        ps.setString(3, equip.getProfissao());

        ps.execute();
        ps.close();
    }

    public void alterar(Funcionario equip, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE funcionarios SET  matricula = ?, nome = ?, profissao = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, equip.getMatricula());
        ps.setString(2, equip.getNome());
        ps.setString(3, equip.getProfissao());
        ps.setInt(4, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM funcionarios WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Funcionario consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Funcionario equip = null;

        sql = "SELECT id, matricula,nome,profissao FROM funcionarios WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            equip = new Funcionario();

            equip.setId(rs.getInt("id"));
            equip.setMatricula(rs.getString("matricula"));
            equip.setNome(rs.getString("nome"));
            equip.setProfissao(rs.getString("profissao"));

        }

        rs.close();
        ps.close();

        return equip;
    }

    public ArrayList<Funcionario> listar() throws Exception {
        String sql;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, matricula,nome,profissao FROM funcionarios";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Funcionario equip = new Funcionario();
            equip.setId(rs.getInt("id"));
            equip.setMatricula(rs.getString("matricula"));
            equip.setNome(rs.getString("nome"));
            equip.setProfissao(rs.getString("profissao"));
            funcionarios.add(equip);
        }
        rs.close();
        ps.close();

        return funcionarios;
    }

}
