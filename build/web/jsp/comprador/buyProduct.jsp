<%-- 
    Document   : purchase
    Created on : Apr 25, 2024, 8:19:10 PM
    Author     : gustavo
--%>

<%@page import="model.bean.Compra"%>
<%@page import="model.bean.Produto"%>
<%@page import="java.util.List"%>
<%@page import="controller.ControllerComprador"%>
<%@page import="model.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Check if user is logged in (userOn exists)
    Usuario userOn = (Usuario) session.getAttribute("UserOn");

    if (userOn == null) {
        response.sendRedirect("../closeSession.jsp"); // Redirect to login page if not logged in
    }

    // Get product ID parameter
    int productId = 0;
    try {
        productId = Integer.parseInt(request.getParameter("id"));
    } catch (NumberFormatException e) {
        // Handle invalid ID format (redirect or error message)
        response.sendRedirect("dashboard.jsp"); // Redirect to dashboard on invalid ID
    }

    // Controller to interact with business logic
    ControllerComprador controller = new ControllerComprador();
    Produto product = (Produto) controller.buscarProduto(productId);

    // Check if product exists
    if (product == null) {
        response.sendRedirect("dashboard.jsp"); // Redirect to dashboard if product not found
    }

    // Create Compra object with default payment method (PIX)
    Compra novaCompra = controller.insert(product, userOn.getId(), "pix");

    String message = "";
    if (novaCompra != null) {
        message = "Compra realizada com sucesso!";
    } else {
        message = "Erro ao realizar a compra. Tente novamente.";
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Comprar Produto | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 w-full h-screen overflow-hidden flex justify-center items-center">
        <% if (userOn != null && product != null) { %>
        <% if (novaCompra != null) {%>
        <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 text-center">
            <h1 class="text-2xl font-semibold mb-4">Compra Realizada!</h1>
            <p class="text-green-500 font-bold"><%= message%></p>
            <br/>
            <a href="dashboard.jsp" class="text-blue-500 hover:text-blue-700 py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                Voltar para o painel
            </a>
        </div>
        <% } else { %>
        <p class="text-center text-gray-500 pt-10">Erro ao realizar a compra. Tente novamente.</p>
        <a href="dashboard.jsp" class="text-blue-500 hover:text-blue-700 py-2 px-4 rounded focus:outline-none focus:shadow-outline">
            Voltar para o painel
        </a>
        <% } %>
        <% } else { %>
        <p class="text-center text-gray-500 pt-10">Erro ao processar a compra. Tente novamente.</p>
        <a href="dashboard.jsp" class="text-blue-500 hover:text-blue-700 py-2 px-4 rounded focus:outline-none focus:shadow-outline">
            Voltar para o painel
        </a>
        <% }%>
    </body>
</html>
