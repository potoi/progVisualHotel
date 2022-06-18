package dao;

import model.Produto;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoDAO {

    private Connection conn = null;
    private ProdutoDAO prodDao;

    public ProdutoDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
                System.out.println(ex);
        }
    }

    public void incluir(Produto prod) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO produtos( descricao, preco, marca, validade) VALUES (?, ?, ?, ?)";

        ps = conn.prepareStatement(sql);

        ps.setString(1, prod.getDescricao());
        ps.setDouble(2, prod.getPreco());
        ps.setString(3, prod.getMarca());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date data = Date.valueOf(prod.getValidade());
        df.format(data);
        ps.setDate(4, data);

        ps.execute();
        ps.close();

    }

    public void alterar(Produto prod, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE produtos SET descricao = ?, preco = ?, marca = ?, validade = ? WHERE id = ?";

        ps = conn.prepareStatement(sql);

        ps.setString(1, prod.getDescricao());
        ps.setDouble(2, prod.getPreco());
        ps.setString(3, prod.getMarca());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date data = Date.valueOf(prod.getValidade());
        df.format(data);
        ps.setDate(4, data);
        ps.setInt(5, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM produtos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Produto consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Produto prod = null;

        sql = "SELECT id, descricao, preco, marca, validade FROM produtos WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            prod = new Produto();

            prod.setIdentificador(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setMarca(rs.getString("marca"));
            prod.setPreco(rs.getDouble("preco"));

            LocalDate ld = rs.getDate("validade").toLocalDate();
            prod.setValidade(ld);

        }

        rs.close();
        ps.close();

        return prod;
    }

    public ArrayList<Produto> listar() throws Exception {
        String sql;
        ArrayList<Produto> produtos = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id, descricao, preco, marca, validade FROM produtos";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setIdentificador(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setMarca(rs.getString("marca"));
            prod.setPreco(rs.getDouble("preco"));

            LocalDate ld = rs.getDate("validade").toLocalDate();
            prod.setValidade(ld);
    

            produtos.add(prod);
        }
        rs.close();
        ps.close();

        return produtos;
    }









}
