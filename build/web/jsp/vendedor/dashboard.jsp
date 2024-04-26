<%-- 
    Document   : dashboard
    Created on : Apr 25, 2024, 4:40:52 PM
    Author     : gustavo
--%>

<%@page import="controller.ControllerVendedor"%>
<%@page import="model.bean.Produto"%>
<%@page import="java.util.List"%>
<%@page import="model.bean.Compra"%>
<%@page import="model.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario userOn = (Usuario) session.getAttribute("UserOn");
    ControllerVendedor seller = new ControllerVendedor();
    List<Object> sales = null;
    List<Object> products = null;
    if (userOn != null) {
        products = seller.listar(userOn);
        sales = seller.listarVendas(userOn);
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vendedor Dashboard | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 w-dvw overflow-x-hidden">
        <%if (userOn != null) {%>
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
                    <div class="flex justify-between items-center">
                        <h2 class="text-xl font-bold mb-2 pl-2">Produtos</h2> 
                        <a href="createProduct.jsp" class="inline-flex items-center ml-4 px-2 py-1 bg-green-500 hover:bg-green-700 text-white rounded-full">
                            +
                            
                            Criar Produto
                        </a>
                    </div>
                    <div class="flex overflow-x-auto space-x-8">  
                        <%if (products != null && !products.isEmpty()) { %>
                        <%for (Object product : products) { %>
                        <%Produto productOut = (Produto) product;%>
                        <div class="bg-white rounded shadow-md p-4">
                            <img src="../../assets/product.jpg" alt="Product Image" class="w-full h-40 object-cover rounded-t-md">
                            <div class="flex justify-between items-center pt-2">
                                <h3 class="text-base font-medium text-gray-700"><%= productOut.getNomeP()%></h3>
                                <span class="text-gray-500 text-sm">R$<%= productOut.getValor()%></span>
                            </div>
                            <div class="flex justify-between pt-4">
                                <a href="editProduct.jsp?id=<%=productOut.getId()%>" class="text-blue-500 hover:text-blue-700">Editar</a>
                                <a href="deleteProduct.jsp?id=<%=productOut.getId()%>" class="text-red-500 hover:text-red-700">Excluir</a>
                            </div>
                        </div>
                        <%} %>
                        <%} else { %>
                        <p class="text-gray-500">Nenhum produto encontrado.</p>
                        <%}
                        %>
                    </div>
                </div>

                <h2 class="text-xl font-bold mb-2">Vendas</h2>
                <%if (sales != null && !sales.isEmpty()) { %>
                <table class="w-full table-auto border border-gray-300 rounded shadow-md">
                    <thead>
                        <tr class="bg-gray-200 text-left text-gray-600 font-medium">
                            <th class="px-4 py-2">Nome do Produto</th>
                            <th class="px-4 py-2">Metodo de Pagamento</th>
                            <th class="px-4 py-2">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Object compraObj : sales) { %>
                        <% Compra compra = (Compra) compraObj;%>
                        <tr>
                            <td class="px-4 py-2"><%= compra.getNomeP()%></td>  
                            <td class="px-4 py-2"><%= compra.getMetodoPagamento()%>
                            </td> <td class="px-4 py-2">R$<%= compra.getValorP()%></td>  
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% } else { %>
                <p class="text-gray-500">Nenhuma venda encontrada.</p>
                <% } %>

            </div>
        </div>
        <%} else { %>
        <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 flex flex-col align-center mx-auto mt-20 ">
            <h1 class="text-2xl font-semibold mb-4 text-center">Usuario desconectado</h1>                
            <p class="text-gray-600 mb-6 text-center">Tente novamente.</p>
            <a href="../signin.jsp" class="text-blue-500 hover:text-blue-700 text-center">Voltar</a>
        </div>
        <% }%>

    </body>
</html>
