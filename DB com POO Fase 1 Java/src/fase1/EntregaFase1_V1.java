package fase1;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;

public class EntregaFase1_V1 {
	public static void main(String[] args) {
		String connectionString = "mongodb://localhost:27017"; //Alterar a porta de conexão conforme a do localhost
		String databaseName = "moviedatabase";

		try {
			MongoClient mongoClient = MongoClients.create(connectionString);
			System.out.println("Conexão com o MongoDB estabelecida com sucesso!");

			MongoDatabase database = mongoClient.getDatabase(databaseName);

			mongoClient.close(); //Fechar conexão após o fim de uso
		} catch (MongoException e) {
			System.out.println("Erro ao conectar ao MongoDB: " + e.getMessage());
		}
	}
}
