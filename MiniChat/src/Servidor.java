import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author almir
 *
 */
public class Servidor {

	public static void main(String[] args) throws Exception {

		System.out.println("Iniciando servidor");
		//Cria o servidor de conexoes, passando uma posta TCD
		ServerSocket server = new ServerSocket(2529);

		System.out.println("Aguardando conexão...");
		//Espera o server aceitar o pedido de conexao
		Socket socket = server.accept();
		//Apos isso permite enviar e receber msg
		System.out.println("Conexão estabelecida!");
		
		//Parte do protocolo de conexao
		
		//Cria stream de entrada de dados (enviar coisas) Cliente ---> Socket ---> servidor
		InputStream input = socket.getInputStream();
		
		//Stream de saida de dados
		OutputStream output = socket.getOutputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);

		while (true) {
			//Pega a mensagem do lciente e faz uma leitura da string
			String mensagem = in.readLine();
			
			System.out.println(
					"Mensagem recebida do cliente [" + socket.getInetAddress().getHostName() + "]: " + mensagem);

			if ("FIM".equals(mensagem)) {
				break;
			}
			//Escreve a mensagem de saida
			out.println(mensagem);
		}

		System.out.println("Encerrando conexão");

		//fecha streams de entrada e saida de dados
		in.close(); 
		out.close();
		socket.close();//mata o socket do cliente com o servidor

		System.out.println("Encerrando servidor");

		server.close();//final do tratamento do protocolo

	}

}
