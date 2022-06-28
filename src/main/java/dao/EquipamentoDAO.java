package dao;

import model.Equipamento;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class EquipamentoDAO {

    private Connection conn = null;

    public EquipamentoDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void incluir(Equipamento equip) throws Exception {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO equipamentos( descricao) VALUES (?)";

        ps = conn.prepareStatement(sql);
        ResultSet rs = null;
        ps.setString(1, equip.getDescricao());

         ps.execute();
         ps.close();
    }

    public void alterar(Equipamento equip, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE equipamentos SET descricao = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, equip.getDescricao());


        ps.setInt(2, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM equipamentos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Equipamento consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Equipamento equip = null;

        sql = "SELECT id, descricao FROM equipamentos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            equip = new Equipamento();

            equip.setIdentificador(rs.getInt("id"));
            equip.setDescricao(rs.getString("descricao"));

        }

        rs.close();
        ps.close();

        return equip;
    }

    public ArrayList<Equipamento> listar() throws Exception {
        String sql;
        ArrayList<Equipamento> equipamentos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id,descricao FROM equipamentos";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Equipamento equip = new Equipamento();

            equip.setIdentificador(rs.getInt("id"));
            equip.setDescricao(rs.getString("descricao"));

            equipamentos.add(equip);
        }
        rs.close();
        ps.close();

        return equipamentos;
    }

}
