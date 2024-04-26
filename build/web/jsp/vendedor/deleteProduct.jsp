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
        <title>Erro - QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 flex justify-center items-center h-screen">

        <%
            String cod = request.getParameter("id");
            int id = Integer.parseInt(cod);
            ControllerVendedor sellerCont = new ControllerVendedor();
            Produto product = (Produto) sellerCont.buscarProduto(id);

            try {
                product = (Produto) sellerCont.excluir(product);
            } catch (java.sql.SQLIntegrityConstraintViolationException e) { %>
                <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 text-center">
                    <h1 class="text-2xl font-semibold mb-4 ">Erro</h1>
                    <p class="text-red-500 font-bold text-left">Este produto está sendo comercializado no momento.</p>
                    <br/>
                    <p class="text-left">Não é possível excluir produtos com vendas associadas.</p>
                    <br/>
                    <a href="javascript:history.back()" class="text-blue-500 hover:text-blue-700 text-center">Voltar</a>
                </div>
        <% }%>

    </body>
</html>

<%-- Rest of your original code --%>
