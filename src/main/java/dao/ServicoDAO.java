package dao;

import model.Servico;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Equipamento;
import model.Funcionario;

public class ServicoDAO {

    private Connection conn = null;
    private ServicoDAO servDao;

    public ServicoDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int incluir(Servico serv) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = "INSERT INTO servicos( descricao, preco) VALUES (?, ?)returning servicos.id ";

        ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(1, serv.getDescricao());
        ps.setDouble(2, serv.getPreco());
        rs = ps.executeQuery();

        while (rs.next()) {

            i = rs.getInt("id");

        }
        rs.close();
        ps.close();
        return i;

    }

    public void alterar(Servico serv, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE servicos SET descricao = ?, preco = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, serv.getDescricao());
        ps.setDouble(2, serv.getPreco());
        ps.setInt(3, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM servicos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Servico consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Servico serv = null;

        sql = "SELECT id, descricao, preco FROM servicos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            serv = new Servico();
            serv.setIdentificador(rs.getInt("id"));
            serv.setDescricao(rs.getString("descricao"));
            serv.setPreco(rs.getDouble("preco"));
        }

        rs.close();
        ps.close();

        return serv;
    }

    public ArrayList<Servico> listar() throws Exception {
        String sql;
        ArrayList<Servico> servicos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, descricao,preco FROM servicos";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Servico serv = new Servico();
            serv.setIdentificador(rs.getInt("id"));
            serv.setDescricao(rs.getString("descricao"));
            serv.setPreco(rs.getDouble("preco"));
            servicos.add(serv);
        }
        rs.close();
        ps.close();

        return servicos;
    }

    public ArrayList<Funcionario> listarFuncionario(int id) throws Exception {
        String sql;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select idfuncionario from servico_funcionario where idservico = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {

            Funcionario func = new Funcionario();
            func.setId(rs.getInt("idfuncionario"));
            funcionarios.add(func);
        }
        rs.close();
        ps.close();

        return funcionarios;
    }

    public ArrayList<Equipamento> listarEquipamento(int id) throws Exception {
        String sql;
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select idequipamento from servico_equipamento where idservico = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {

            Equipamento func = new Equipamento();
            func.setIdentificador(rs.getInt("idequipamento"));
            equipamentos.add(func);
        }
        rs.close();
        ps.close();

        return equipamentos;
    }

    public void incluirRelacaoFunc(Funcionario func, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO servico_funcionario(idservico,idfuncionario) VALUES (?, ?)";

        ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setInt(2, func.getId());
        ps.execute();
        ps.close();

    }

    public void incluirRelacaoEquip(Equipamento func, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO servico_equipamento(idservico,idequipamento) VALUES (?, ?)";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, func.getIdentificador());

        ps.execute();
        ps.close();

    }
}
