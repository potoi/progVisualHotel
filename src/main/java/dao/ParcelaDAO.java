package dao;

import model.Parcela;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class ParcelaDAO {

    private Connection conn = null;
    private ParcelaDAO parcDao;

    public ParcelaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void incluir(Parcela parc) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO parcelas( idfatura,datavencimento,datapagamento,valor,juromoraaplicado,valorfinal) VALUES (?, ?, ?, ?, ? , ?)";

        ps = conn.prepareStatement(sql);

        ps.setInt(1, parc.getIdFatura());
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Date data = Date.valueOf(parc.getDataVencimento());
        df.format(data);
        ps.setDate(2, data);
        ps.setDouble(4, parc.getValor());
        if (parc.getDataPagamento() == null) {
            ps.setNull(3, java.sql.Types.DATE);
            ps.setNull(5, java.sql.Types.DOUBLE);
            ps.setNull(6, java.sql.Types.DOUBLE);
        } else {
            data = Date.valueOf(parc.getDataPagamento());
            df.format(data);
            ps.setDate(3, data);
            ps.setDouble(4, parc.getValor());
            ps.setDouble(5, parc.getJurosMoraAplicado());
            ps.setDouble(6, parc.getValorfinal());
        }

        ps.execute();
        ps.close();

    }

    public void alterar(Parcela parc, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE parcelas set datapagamento = ? , valor = ? , juromoraaplicado = ? , valorfinal = ? WHERE id = ? ";

        ps = conn.prepareStatement(sql);

        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        if (parc.getDataPagamento() == null) {
            ps.setNull(1, java.sql.Types.DATE);
        } else {
            Date data = Date.valueOf(parc.getDataPagamento());
            df.format(data);
            ps.setDate(1, data);
        }

        ps.setDouble(2, parc.getValor());
        ps.setDouble(3, parc.getJurosMoraAplicado());
        ps.setDouble(4, parc.getValorfinal());
        ps.setInt(5, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM parcelas WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }
    
    public void apagarFaturaId(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM parcelas WHERE idfatura = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Parcela consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Parcela parc = null;

        sql = "SELECT id,idfatura,datavencimento,datapagamento,valor,juromoraaplicado,valorfinal WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            parc = new Parcela();

            parc.setIdentificador(rs.getInt("id"));
            parc.setIdFatura(rs.getInt("idfatura"));
            LocalDate date = rs.getDate("Datavencimento").toLocalDate();
            parc.setDataVencimento(date);
            parc.setValor(rs.getDouble("valor"));
            if (rs.getDate("datapagamento") != null) {
                date = rs.getDate("datapagamento").toLocalDate();
                parc.setDataPagamento(date);

                parc.setJurosMoraAplicado(rs.getDouble("juromoraaplicado"));
                parc.setValorfinal(rs.getDouble("valorfinal"));
            }

        }

        rs.close();
        ps.close();

        return parc;
    }

    public Parcela[] consultaFatura(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Parcela parc = null;

        sql = "SELECT id ,idfatura,datavencimento,datapagamento,valor,juromoraaplicado,valorfinal from parcelas WHERE idfatura = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        ArrayList<Parcela> array = new ArrayList<>();
        while (rs.next()) {
            parc = new Parcela();

            parc.setIdentificador(rs.getInt("id"));
            parc.setIdFatura(rs.getInt("idfatura"));
            LocalDate date = rs.getDate("Datavencimento").toLocalDate();
            parc.setDataVencimento(date);
            parc.setValor(rs.getDouble("valor"));
            if (rs.getDate("datapagamento") != null) {
                date = rs.getDate("datapagamento").toLocalDate();
                parc.setDataPagamento(date);

                parc.setJurosMoraAplicado(rs.getDouble("juromoraaplicado"));
                parc.setValorfinal(rs.getDouble("valorfinal"));
            }
            array.add(parc);

        }

        rs.close();
        ps.close();
        Parcela parce[] = new Parcela[array.size()];
        int i = 0;
        for (Parcela p : array) {
            parce[i] = p;
            i++;
        }

        return parce;
    }

}
