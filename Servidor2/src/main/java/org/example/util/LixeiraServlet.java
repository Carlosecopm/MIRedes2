package org.example.util;

import org.example.model.Lixeira;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/lixeira")
public class LixeiraServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String requestUrl = request.getRequestURI();
        String nome = requestUrl.substring("/lixeira/".length());

        Lixeira lixeiraServidor = DataStore.getInstance().getLixeira(nome);

        if (lixeiraServidor != null) {
            String json = "{\n";
            json += "\"nome\": " + JSONObject.quote(lixeiraServidor.getNome()) + ",\n";
            json += "\"capacidade\": " + lixeiraServidor.getCapacidade() + ",\n";
            json += "\"quantidade\": " + lixeiraServidor.getQuantidade() + "\n";
            json += "\"disponivel\": " + lixeiraServidor.isDisponivel() + "\n";
            json += "}";
            response.getOutputStream().println(json);
        } else {
            response.getOutputStream().println("{}");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        float capacidade = Float.parseFloat(request.getParameter("capacidade"));
        float quantidade = Float.parseFloat(request.getParameter("quantidade"));
        boolean disponivel = Boolean.parseBoolean(request.getParameter("disponivel"));

        DataStore.getInstance().putLixeira(new Lixeira(nome, capacidade, quantidade, disponivel));
    }

}
