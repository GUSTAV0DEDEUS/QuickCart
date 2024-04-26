<%-- 
    Document   : dashboard
    Created on : Apr 25, 2024, 4:40:44 PM
    Author     : gustavo
--%>

<%@page import="controller.ControllerComprador"%>
<%@page import="model.bean.Produto"%>
<%@page import="java.util.List"%>
<%@page import="model.bean.Compra"%>
<%@page import="model.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario userOn = (Usuario) session.getAttribute("UserOn");
    ControllerComprador buyerCont = new ControllerComprador();
    List<Object> purchases = null;
    List<Object> products = null;

    if (userOn != null) {
        purchases = buyerCont.listarCompras(userOn);
        products = buyerCont.listar();
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Comprador Dashboard | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 w-dvw overflow-x-hidden">
        <% if (userOn != null) {%>
        <div class="flex min-h-screen">
            <div class="fixed w-full bg-white shadow-md flex justify-between items-center h-16 px-4">
                <a href="../closeSession.jsp"><h1 class="text-xl font-bold">QuickCart</h1></a>
                <div class="flex items-center">
                    <a href="../editUser.jsp"><img src="../../assets/avatar.jpg" alt="Avatar" class="w-10 h-10 rounded-full mr-2"></a>
                    <span class="text-gray-700 font-medium"><%=userOn.getLogin()%></span>
                </div>
            </div>
            <div class="flex flex-col flex-grow px-4 pt-16 my-5">
                <div class="mb-4">
                    <h2 class="text-xl font-bold mb-2 pl-2">Produtos</h2>
                    <div class="flex overflow-x-auto space-x-8">
                        <% if (products != null && !products.isEmpty()) { %>
                        <% for (Object product : products) { %>
                        <% Produto productOut = (Produto) product;%>
                        <div class="bg-white rounded shadow-md p-4">
                            <img src="../../assets/product.jpg" alt="Product Image" class="w-full h-40 object-cover rounded-t-md">
                            <div class="flex justify-between items-center pt-2">
                                <h3 class="text-base font-medium text-gray-700"><%= productOut.getNomeP()%></h3>
                                <span class="text-gray-500 text-sm">R$<%= productOut.getValor()%></span>
                            </div>
                            <div class="flex justify-center pt-4">
                                <a href="buyProduct.jsp?id=<%= productOut.getId()%>" class="text-green-500 hover:text-green-700">Comprar</a>
                            </div>
                        </div>
                        <% } %>
                        <% } else { %>
                        <p class="text-gray-500">Nenhum produto encontrado.</p>
                        <% } %>
                    </div>
                </div>

                <h2 class="text-xl font-bold mb-2">Minhas Compras</h2>
                <% if (purchases != null && !purchases.isEmpty()) { %>
                <table class="w-full table-auto border border-gray-300 rounded shadow-md">
                    <thead>
                        <tr class="bg-gray-200 text-left text-gray-600 font-medium">
                            <th class="px-4 py-2">Nome do Produto</th>
                            <th class="px-4 py-2">Metodo de Pagamento</th>
                            <th class="px-4 py-2">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Object compraObj : purchases) { %>
                        <% Compra compra = (Compra) compraObj; %>
                        <tr>
                            <td class="px-4 py-2"><%= compra.getNomeP()%></td>  
                            <td class="px-4 py-2"><%= compra.getMetodoPagamento()%>
                            </td> <td class="px-4 py-2">R$<%= compra.getValorP()%></td>  
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% } else { %>
                <p class="text-gray-500">Você ainda não realizou nenhuma compra.</p>
                <% } %>
            </div>
        </div>
    </div>
    <% } else { %>
    <p class="text-center text-gray-500 pt-10">Você precisa estar logado para acessar o painel do comprador.</p>
    <% }%>
</body>
</html>