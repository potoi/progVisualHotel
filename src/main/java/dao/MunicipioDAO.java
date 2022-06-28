package dao;

import model.Municipio;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class MunicipioDAO {

    private Connection conn = null;
    private MunicipioDAO muniDao;

    public MunicipioDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Municipio incluir(Municipio muni) throws Exception {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO municipios( nome, estado, pais) VALUES (?, ?, ?) returning municipios.id,municipios.nome,municipios.estado,municipios.pais";

        ps = conn.prepareStatement(sql);
        ResultSet rs = null;
        ps.setString(1, muni.getNome());
        ps.setString(2, muni.getEstado());
        ps.setString(3, muni.getPais());

        rs = ps.executeQuery();

        while (rs.next()) {

            muni.setId(rs.getInt("id"));
            muni.setNome(rs.getString("nome"));
            muni.setEstado(rs.getString("estado"));
            muni.setPais(rs.getString("pais"));

        }
     
        rs.close();
        ps.close();
        return muni;

    }

    public void alterar(Municipio muni, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE municipios SET nome = ?, estado = ?, pais = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, muni.getNome());
        ps.setString(2, muni.getEstado());
        ps.setString(3, muni.getPais());

        ps.setInt(4, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM municipios WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Municipio consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Municipio muni = null;

        sql = "SELECT id,nome,estado,pais FROM municipios WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            muni = new Municipio();

            muni.setId(rs.getInt("id"));
            muni.setNome(rs.getString("nome"));
            muni.setEstado(rs.getString("estado"));
            muni.setPais(rs.getString("pais"));
        }

        rs.close();
        ps.close();

        return muni;
    }

    public ArrayList<Municipio> listar() throws Exception {
        String sql;
        ArrayList<Municipio> municipios = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id,nome,estado,pais FROM municipios";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Municipio muni = new Municipio();

            muni.setId(rs.getInt("id"));
            muni.setNome(rs.getString("nome"));
            muni.setEstado(rs.getString("estado"));
            muni.setPais(rs.getString("pais"));

            municipios.add(muni);
        }
        rs.close();
        ps.close();

        return municipios;
    }

}
