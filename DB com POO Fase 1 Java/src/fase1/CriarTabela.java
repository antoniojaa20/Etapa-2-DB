package fase1;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoException;
import org.bson.Document;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.FlowLayout;

public class InserirDadosMongoDB extends JFrame {
	private static final long serialVersionUID = 1L;

	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=983da70";

	public InserirDadosMongoDB() {
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

		Container P = getContentPane();
		P.setLayout(new FlowLayout());
		JLabel mensagem = new JLabel("Você acabou de testar um exemplo usando MongoDB!");
		P.add(mensagem);
	}

	public static void main(String[] args) {
		InserirDadosMongoDB ex = new InserirDadosMongoDB();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setTitle("USANDO MONGODB");
		ex.setVisible(true);
		ex.setSize(400, 300);
	}
}
