import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author almir
 *
 */
public class Cliente {

	public static void main(String[] args) throws Exception {

		System.out.println("Iniciando cliente");

		System.out.println("Iniciando conexao com o servidor");
		//Estabelecer conexao com o servidor
		//host: onde o servidor está(maquina), inteiro a porta 
		//Cria a conexao entre o cliente e o servidor
		Socket socket = new Socket("localhost", 2529);

		System.out.println("Conexão estabelecida!");
		
		//criação dos streams de entrada e saida 
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			//string digitada pelo cliente
			System.out.println("Digite uma mensagem: ");
			String mensagem = scanner.nextLine();
			
			//Escreve a mensagem de saida
			out.println(mensagem);

			if ("FIM".equals(mensagem)) {
				break;
			}
			//Pega a mensagem do lciente e faz uma leitura da string
			mensagem = in.readLine();

			System.out.println("Mensagem recebida no servidor: " + mensagem);

		}

		System.out.println("Encerrando conexao");
		
		//fechar streams
		in.close();

		out.close();
		//fechar servidor
		socket.close();
	}

}
