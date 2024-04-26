<%-- 
    Document   : deleteProduct
    Created on : Apr 25, 2024, 6:32:22 PM
    Author     : gustavo
--%>

<%@page import="model.bean.Produto"%>
<%@page import="controller.ControllerVendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 flex justify-center items-center min-h-screen">

        <%
            String cod = request.getParameter("id");
            int id = Integer.parseInt(cod);
            ControllerVendedor sellerCont = new ControllerVendedor();
            Produto product = (Produto) sellerCont.buscarProduto(id);

            if (product == null) {
                out.println("<p class='text-red-500 font-bold'>Produto não encontrado.</p>");
            } else {
        %>

        <div class="max-w-md rounded overflow-hidden shadow-lg bg-white p-8">
            <h1 class="text-2xl font-semibold mb-4">Editar Produto</h1>
            <form action="updateProduct.jsp" method="POST">
                <input type="hidden" name="id" value="<%= product.getId()%>">
                <div class="mb-4">
                    <label for="nome" class="block text-gray-700 font-bold mb-2">Nome:</label>
                    <input type="text" id="nome" name="nome" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value="<%= product.getNomeP()%>" required>
                </div>
                <div class="mb-4">
                    <label for="valor" class="block text-gray-700 font-bold mb-2">Valor (R$):</label>
                    <input type="number" step="0.01" id="valor" name="valor" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value="<%= product.getValor()%>" required>
                </div>
                <div class="mb-4">
                    <label for="tipo" class="block text-gray-700 font-bold mb-2">Tipo:</label>
                    <input type="text"  id="tipo" name="tipo" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value="<%= product.getTipoP()%>" required>
                </div>
                <div class="flex justify-between items-center">
                    <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Atualizar</button>
                    <a href="javascript:history.back()" class="text-gray-500 hover:text-gray-700">Cancelar</a>
                </div>
            </form>
        </div>

        <% }%>

    </body>
</html>

