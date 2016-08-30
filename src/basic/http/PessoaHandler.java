package basic.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por receber requisições para a consulta de Pessoas
 *
 * @author douglas
 */
public class PessoaHandler implements HttpHandler {

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
        sb.append("<title> Consulta de Pessoas </title>");
        sb.append("</head>");

        sb.append("<body>");
        sb.append("<h2>Consulta de Pessoas</h2>");

        sb.append("<table border='1'>");
        sb.append("<tr>");
        sb.append("<th>Nome</th>");
        sb.append("<th>Cidade</th>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>Douglas</td>");
        sb.append("<td>Campo Mourão</td>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>Gilvan</td>");
        sb.append("<td>Hawai</td>");
        sb.append("</tr>");
        sb.append("</table>");

        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

}
