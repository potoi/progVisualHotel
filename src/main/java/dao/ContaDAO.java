package dao;

import model.Conta;
import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Cliente;
import model.Item;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.Servico;

public class ContaDAO {

    private Connection conn = null;

    public ContaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int incluir(Conta cont) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer f = 0;
        Integer j = 0;
        int i = 0;
        sql = "INSERT INTO contas( dataabertura,datafechamento,total,idclientefisico,idclientejuridico,quarto) VALUES (?, ?, ?, ?, ?, ?) returning contas.id";
        if (cont.getCliente() instanceof PessoaFisica) {
            f = cont.getCliente().getId();
        }
        if (cont.getCliente() instanceof PessoaJuridica) {
            j = cont.getCliente().getId();

        }

        if (j <= 0) {
            j = null;
        }
        if (f <= 0) {
            f = null;
        }
        ps = conn.prepareStatement(sql);
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Date data = Date.valueOf(cont.getDataAbertura());
        df.format(data);
        ps.setDate(1, data);
        if (cont.getDataFechamento() == null) {
            ps.setNull(2, java.sql.Types.DATE);
        } else {
            data = Date.valueOf(cont.getDataFechamento());
            df.format(data);
            ps.setDate(2, data);
        }

        ps.setDouble(3, cont.getTotal());
        if (f != null) {
            ps.setInt(4, f);
        } else {
            ps.setNull(4, 4);
        }
        if (j != null) {
            ps.setInt(5, j);
        } else {
            ps.setNull(5, 4);
        }
        ps.setInt(6, cont.getQuarto());
        rs = ps.executeQuery();

        while (rs.next()) {

            i = rs.getInt("id");

        }
        rs.close();
        ps.close();
        return i;

    }

    public void alterar(Conta cont, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "UPDATE contas  set dataabertura = ?,datafechamento = ? ,quarto = ?, total= ? WHERE id = ?";
        ps = conn.prepareStatement(sql);

        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Date data = Date.valueOf(cont.getDataAbertura());
        df.format(data);
        ps.setDate(1, data);

        if (cont.getDataFechamento() == null) {
            ps.setNull(2, java.sql.Types.DATE);
        } else {
            data = Date.valueOf(cont.getDataFechamento());
            df.format(data);
            ps.setDate(2, data);
        }

        ps.setInt(3, cont.getQuarto());
         ps.setDouble(4, cont.getTotal());
        ps.setInt(5, id);
        ps.execute();
        ps.close();

    }

    public void apagar(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "DELETE FROM contas WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public Conta consulta(int id) throws Exception {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conta cont = null;

        sql = "SELECT id,dataabertura,datafechamento,total,idclientefisico,idclientejuridico,quarto FROM contas  WHERE id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            cont = new Conta();

            cont.setId(rs.getInt("id"));

            SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            Date data = (rs.getDate("dataabertura"));
            df.format(data);
            cont.setDataAbertura(data.toLocalDate());
            if (rs.getDate("datafechamento") != null) {
                data = (rs.getDate("datafechamento"));
                df.format(data);
                cont.setDataFechamento(data.toLocalDate());
            }

            cont.setTotal(rs.getDouble("total"));
            int idCliente = rs.getInt("idclientefisico");
            if (idCliente == 0) {
                idCliente = rs.getInt("idclientejuridico");
                cont.setCliente(new PessoaJuridica());
                cont.getCliente().setId(idCliente);
            } else {
                cont.setCliente(new PessoaFisica());
                cont.getCliente().setId(idCliente);

            }
            cont.setQuarto(rs.getInt("quarto"));
        }

        rs.close();
        ps.close();

        return cont;
    }

    public ArrayList<Conta> listar() throws Exception {
        String sql;

        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "SELECT id,dataabertura,datafechamento,total,idclientefisico,idclientejuridico,quarto FROM contas order by datafechamento";

        ArrayList<Conta> contas = new ArrayList<>();

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Conta cont = new Conta();

            cont.setId(rs.getInt("id"));

            SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            Date data = (rs.getDate("dataabertura"));
            df.format(data);
            cont.setDataAbertura(data.toLocalDate());
            if (rs.getDate("datafechamento") != null) {
                data = (rs.getDate("datafechamento"));
                df.format(data);
                cont.setDataFechamento(data.toLocalDate());

            }

            cont.setTotal(rs.getDouble("total"));
            int idCliente = rs.getInt("idclientefisico");
            if (idCliente == 0) {
                idCliente = rs.getInt("idclientejuridico");
                cont.setCliente(new PessoaJuridica());
                cont.getCliente().setId(idCliente);
            } else {
                cont.setCliente(new PessoaFisica());
                cont.getCliente().setId(idCliente);

            }
            cont.setQuarto(rs.getInt("quarto"));

            contas.add(cont);
        }
        rs.close();
        ps.close();

        return contas;
    }

    public String[][] listarString() throws Exception {
        String sql;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String[][] a = new String[tamanho()][7];

        sql = """
              SELECT  v.id,v.dataabertura,v.datafechamento,v.total,v.idclientefisico,v.idclientejuridico,v.quarto,c.nome
              FROM contas v join clientesfisico c on c.id = v.idclientefisico
              union
              SELECT  v.id,v.dataabertura,v.datafechamento,v.total,v.idclientefisico,v.idclientejuridico,v.quarto,c.nome
              FROM contas v join clientesjuridico c on c.id = v.idclientejuridico""";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {

            a[i][0] = rs.getString("id");
            a[i][1] = rs.getString("marca");
            a[i][2] = rs.getString("modelo");
            a[i][3] = rs.getString("cor");
            a[i][4] = rs.getString("placa");
            a[i][5] = rs.getString("vagaOcupada");
            a[i][6] = rs.getString("nome");
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
        sql = "select count(id) as quantidade from contas";
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

    public ArrayList<Produto> listarProduto(int id) throws Exception {
        String sql;
        ArrayList<Produto> produtos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select idproduto from conta_produto where idconta = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {

            Produto prod = new Produto();
            prod.setIdentificador(rs.getInt("idproduto"));
            produtos.add(prod);
        }
        rs.close();
        ps.close();

        return produtos;
    }

    public ArrayList<Servico> listarServico(int id) throws Exception {
        String sql;
        ArrayList<Servico> servicos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select idservico from conta_servico where idconta = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {

            Servico serv = new Servico();
            serv.setIdentificador(rs.getInt("idservico"));
            servicos.add(serv);
        }
        rs.close();
        ps.close();

        return servicos;
    }

    public void insertServico(Servico serv, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "insert into conta_servico(idconta,idservico) values (?, ?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, serv.getIdentificador());
        ps.execute();
        ps.close();
    }

    public void insertProduto(Produto prod, int id) throws Exception {
        String sql;
        PreparedStatement ps = null;

        sql = "insert into conta_produto(idconta,idproduto) values (?, ?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, prod.getIdentificador());
        ps.execute();
        ps.close();
    }
}
