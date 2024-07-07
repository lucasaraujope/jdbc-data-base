package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"UPDATE seller " //a=atualizando a tabela seller
			+ "SET BaseSalary = BaseSalary + ? " //setando o novo valor que o campo ira receber
			+ "WHERE " // comando que serve para informar qual campo do banco de dados será atualizado
			+ "(DepartmentId = ?)"); // nome da coluna que será atualizada

			st.setDouble(1, 200.0);/* inserindo o valor na tabela, o primeiro valor 1 é refeente ao primeiro símbolo
			interrogaçãoo na linha 23, o segundo "200.0" é que será inserindo na tabela como acrescimo */
			st.setInt(2, 2); 

			int rowsAffected = st.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace(); // catch para previnir qualquer exceção do SQL
		} finally { // fechando as conexões abertas
			DB.closeStatment(st);
			DB.closeConnection();
		}

	}
}
