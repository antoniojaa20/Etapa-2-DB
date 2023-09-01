package fase1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InserirDados extends JFrame {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=983da70";
	
	public InserirDados() throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String sUsuario = "root";
		String sSenha = "Isa29052003_Belly";
		String sFonte = "jdbc:mysql://127.0.0.1:3306/moviedatabase";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(sFonte, sUsuario, sSenha);
			JOptionPane.showMessageDialog(this,"Banco conectado com sucesso!","Mensagem", JOptionPane.WARNING_MESSAGE);
		}catch (SQLException eSQL) {
			eSQL.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conexão com o banco!\n" +"Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conexão com o banco!\n" +"Mensagem: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		String title = "Exemplo de Filme";
		int year = 2023;
		String rated = "Diretor Exemplo";

		String insertQuery = "INSERT INTO movies (title, year, rated) VALUES (%s, %d, %s)";

		try {
		    PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		    preparedStatement.setString(1, title);
		    preparedStatement.setInt(2, year);
		    preparedStatement.setString(3, rated);

		    int rowsAffected = preparedStatement.executeUpdate();
		    if (rowsAffected > 0) {
		        JOptionPane.showMessageDialog(this, "Dados do filme inseridos com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        JOptionPane.showMessageDialog(this, "Falha ao inserir dados do filme", "Erro", JOptionPane.ERROR_MESSAGE);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(this, "Erro ao inserir dados do filme:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}


		try {
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();
			System.exit(2);
		}
		
	}
	
	public static void main(String args[]) throws SQLException{
		InserirDados ex = new InserirDados();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
