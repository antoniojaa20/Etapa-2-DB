package fase1;

public class EntregaFase1_V1 {
    public static void main(String[] args) {
      
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
  			 System.out.println("Driver carregado com sucesso!");
  			 }
  			 catch (Exception ex) {
  			 System.out.println("Driver nao pode ser carregado!");
  			 }
        }
    }


