package semananove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class ProdutoControlador {
	
	public void criarProduto() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insira o nome do produto: ");
		String nome = scan.next();
		System.out.println("Insira o preco do produto: ");
		double preco = scan.nextDouble();
		
		ProdutoModelo p = new ProdutoModelo(nome, preco);
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (nome,preco)VALUES(?,?)");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
        	System.out.println("Criado com Sucesso!");
            ConnectionFactory.closeConnection(con, stmt);
        }  
	}

	public void listarProduto() {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome") + " | Preco: " + rs.getDouble("preco"));       
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
	
    public void deletarProduto() {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Insira o nome do produto: ");
		String nome = scan.next();
    	
        Connection con = ConnectionFactory.getConnection();    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE nome = ?");
            stmt.setString(1, nome);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
        	System.out.println("Excluído com Sucesso!");
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
