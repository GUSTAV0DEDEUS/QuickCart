<%-- 
    Document   : updateProduct
    Created on : Apr 25, 2024, 7:11:22 PM
    Author     : gustavo
--%>

<%@page import="model.bean.Usuario"%>
<%@page import="model.bean.Produto"%>
<%@page import="controller.ControllerVendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto Atualizado - QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 flex justify-center items-center h-screen">

        <%
            // Get form data
            String idStr = request.getParameter("id");
            String name = request.getParameter("nome");
            String priceStr = request.getParameter("valor");
            String type = request.getParameter("tipo");
            Usuario userOn = (Usuario) session.getAttribute("UserOn");
            // Convert values
            int id = Integer.parseInt(idStr);
            float price = Float.parseFloat(priceStr);

            ControllerVendedor sellerCont = new ControllerVendedor();

            try {
                Produto updatedProduct = new Produto(id, userOn.getId(), name, price, type);

                // Update the product using the controller
                sellerCont.alterar(updatedProduct);
        %>

        <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 text-center">
            <h1 class="text-2xl font-semibold mb-4">Produto Atualizado</h1>
            <p class="text-green-500 font-bold">Produto editado com sucesso!</p>
            <br/>
            <a href="dashboard.jsp" class="text-blue-500 hover:text-blue-700">Ver Produtos</a>
        </div>

        <% } catch (Exception e) { %>

        <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 text-center">
            <h1 class="text-2xl font-semibold mb-4">Erro</h1>
            <p class="text-red-500 font-bold">Erro ao atualizar produto%></p>
            <a href="dashboard.jsp" class="text-blue-500 hover:text-blue-700">Voltar aos Produtos</a>
        </div>

        <% }%>

    </body>
</html>
