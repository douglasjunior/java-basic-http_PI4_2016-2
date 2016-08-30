package basic.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por receber requisições para a consulta de Produtos
 *
 * @author douglas
 */
public class ProdutoHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {
        // Define o código de sucesso 200 para a resposta
        t.sendResponseHeaders(200, 0);
        // Recupera o objeto Writer responsável por escrever a resposta
        PrintWriter pw = new PrintWriter(t.getResponseBody());
        String response = getResponse();
        // escreve a resposta
        pw.println(response);
        // fecha o fluxo de bytes
        pw.close();
    }

    /**
     * Monta o retorno que será enviado como Resposta. Neste exemplo está sendo
     * enviado um código HTML.
     *
     * @return
     */
    private String getResponse() {
        StringBuilder sb = new StringBuilder();

        sb.append("<html>");

        sb.append("<head>");
        sb.append("<meta charset='utf-8' />");
        sb.append("<title> Consulta de Produtos </title>");
        sb.append("</head>");

        sb.append("<body>");

        sb.append("<body>");
        sb.append("<h2>Consulta de Produtos</h2>");

        sb.append("<ul>");
        sb.append("<li>Produto 1</li>");
        sb.append("<li>Produto 2</li>");
        sb.append("<li>Produto 3</li>");
        sb.append("</ul>");

        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

}
