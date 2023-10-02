package fase1;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoException;
import org.bson.Document;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InserirDados extends JFrame {
	private static final long serialVersionUID = 1L;

	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=983da70";

	public InserirDados() {
		String connectionString = "mongodb://localhost:27017"; //Alterar a porta de conexão conforme a do localhost
		String databaseName = "moviedatabase";
		String collectionName = "movies";

		try (MongoClient mongoClient = MongoClients.create(connectionString)) {
			MongoDatabase database = mongoClient.getDatabase(databaseName);
			MongoCollection<Document> collection = database.getCollection(collectionName);

			String title = "Exemplo de Filme";
			int year = 2023;
			String rated = "Diretor Exemplo";

			Document document = new Document("title", title)
					.append("year", year)
					.append("rated", rated);

			collection.insertOne(document);

			JOptionPane.showMessageDialog(this, "Dados do filme inseridos com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

		} catch (MongoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao inserir dados do filme:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		InserirDados ex = new InserirDados();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
