package basic.http;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 * Classe principal responsável por iniciar o Serviço HTTP
 *
 * @author douglas
 */
public class JavaSimpleHttp {

    public static void main(String[] args) throws Exception {
        // Cria uma instância de HttpServer defindindo a porta 8090
        HttpServer server = HttpServer.create(new InetSocketAddress(8090), 0);

        /*
        Define as classes Handler que irão tratar as requisições recebidos 
        pelo Serviço HTTP
         */
        // Define a URL e a classe Handler para a URL /produto
        server.createContext("/produto", new ProdutoHandler());
        // Define a URL e a classe Handler para a URL /pessoa
        server.createContext("/pessoa", new PessoaHandler());

        // Confitura para um Executor padrão (não precisa alterar)
        server.setExecutor(null);
        // inicia o Serviço HTTP
        server.start();

        System.out.println("Servidor iniciado!");

        /*
        Para testar abra no Browser as seguintes URLs:
        http://localhost:8090/pessoa
        http://localhost:8090/produto
         */
    }

}
