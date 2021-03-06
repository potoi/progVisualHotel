package dao;

import model.Fatura;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Conta;

public class FaturaDAO {

    private Connection conn = null;
    private FaturaDAO fatuDao;

    public FaturaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void incluir(Fatura fatu) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO faturas( idconta, dataliquidacao, qtdparcelas,tipopagamento) VALUES (?, ?, ?, ?)";

        ps = conn.prepareStatement(sql);

        ps.setInt(1, fatu.getConta().getId());

        if (fatu.getDataLiquidacao() == null) {
            ps.setNull(2, java.sql.Types.DATE);
        } else {
            SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            Date data = Date.valueOf(fatu.getDataLiquidacao());
            df.format(data);
            ps.setDate(2, data);

        }

        ps.setInt(3, fatu.getQtdParcelas());
        ps.setInt(4, fatu.getTipopagamento());

        ps.execute();
        ps.close();

    }

    public void alterar(Fatura fatu, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE faturas SET dataliquidacao = ? , qtdparcelas= ? ,tipopagamento = ? WHERE idconta = ?";

        ps = conn.prepareStatement(sql);
        if (fatu.getDataLiquidacao() != null) {
            SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            Date data = Date.valueOf(fatu.getDataLiquidacao());
            df.format(data);
            ps.setDate(1, data);
        } else {
            ps.setNull(1, java.sql.Types.DATE);
        }

        ps.setInt(2, fatu.getQtdParcelas());
        ps.setInt(3, fatu.getTipopagamento());
        ps.setInt(4, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM faturas WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Fatura consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fatura fatu = null;

        sql = "SELECT idconta, dataliquidacao, qtdparcelas,tipopagamento FROM faturas WHERE idconta = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            fatu = new Fatura();
            Conta c = new Conta();
            fatu.setConta(c);
            fatu.getConta().setId(rs.getInt("idconta"));
            if (rs.getDate("dataliquidacao") != null) {
                LocalDate ld = rs.getDate("dataliquidacao").toLocalDate();
                fatu.setDataLiquidacao(ld);
            }

            fatu.setQtdParcelas(rs.getInt("qtdparcelas"));
            fatu.setTipopagamento(rs.getInt("tipopagamento"));

        }

        rs.close();
        ps.close();

        return fatu;
    }

    public ArrayList<Fatura> listar() throws Exception {
        String sql;
        ArrayList<Fatura> faturas = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT idconta, dataliquidacao, qtdparcelas,tipopagamento FROM faturas";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Fatura fatu = new Fatura();
            Conta c = new Conta();
            fatu.setConta(c);
            fatu.getConta().setId(rs.getInt("idconta"));
            if (rs.getDate("dataliquidacao") != null) {
                LocalDate ld = rs.getDate("dataliquidacao").toLocalDate();
                fatu.setDataLiquidacao(ld);
            }

            fatu.setQtdParcelas(rs.getInt("qtdparcelas"));
            fatu.setTipopagamento(rs.getInt("tipopagamento"));

            faturas.add(fatu);
        }
        rs.close();
        ps.close();

        return faturas;
    }

    public String[][] listarString() throws Exception {
        String sql;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String[][] a = new String[tamanho()][6];

        sql = """
              SELECT cf.nome as nomeF,cj.nome as nomeJ, f.idconta, f.dataliquidacao, f.qtdparcelas,f.tipopagamento FROM faturas f join contas c
              on f.idconta = c.id
              left join clientesfisico cf
              on
              cf.id = c.idclientefisico
              left join clientesjuridico cj
              on
              cj.id = c.idclientejuridico""";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {

            a[i][0] = rs.getString("nomef");
            a[i][1] = rs.getString("nomej");
            a[i][2] = rs.getString("idconta");
            a[i][3] = rs.getString("dataliquidacao");
            a[i][4] = rs.getString("qtdparcelas");
            a[i][5] = rs.getString("tipopagamento");

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
        sql = "select count(idconta) as quantidade from faturas";
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
