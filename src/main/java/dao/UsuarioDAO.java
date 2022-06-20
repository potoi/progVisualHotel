package dao;

import model.Usuario;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioDAO {

    private Connection conn = null;
    private UsuarioDAO UsuaDao;

    public UsuarioDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
                System.out.println(ex);
        }
    }

    public void incluir(Usuario usua) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO usuarios( nome, senha) VALUES (?, ?)";

        ps = conn.prepareStatement(sql);

        ps.setString(1, usua.getLogin());
        ps.setString(2, usua.getSenha());

        ps.execute();
        ps.close();

    }


    public void apagar(String id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM usuarios WHERE nome = ?";

        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.execute();
        ps.close();

    }

    public Usuario consulta(String id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usua = null;

        sql = "SELECT nome, senha FROM usuarios WHERE nome = ?";

        ps = conn.prepareStatement(sql);
        ps.setString(1,id);
        rs = ps.executeQuery();

        while (rs.next()) {
            usua = new Usuario();

            usua.setLogin(rs.getString("nome"));
            usua.setSenha(rs.getString("senha"));
        }

        rs.close();
        ps.close();

        return usua;
    }










}
