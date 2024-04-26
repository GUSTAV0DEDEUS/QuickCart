<%-- 
    Document   : createProduct
    Created on : Apr 25, 2024, 7:11:35 PM
    Author     : gustavo
--%>

<%@page import="model.bean.Usuario"%>
<%@page import="controller.ControllerVendedor"%>
<%@page import="model.bean.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Check if user is logged in (userOn exists)
    Usuario userOn = (Usuario) session.getAttribute("UserOn");

    if (userOn == null) {
        response.sendRedirect("../closeSession.jsp"); // Redirect to login page if not logged in
    }

%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Criar Produto | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 w-full h-screen overflow-hidden flex justify-center items-center relative">
        <div class="w-full bg-white shadow-md flex justify-between items-center h-16 px-4 absolute top-0">
            <a href="../closeSession.jsp"><h1 class="text-xl font-bold">QuickCart</h1></a>
            <div class="flex items-center">
                <a href="dashboard.jsp"><img src="../../assets/avatar.jpg" alt="Avatar" class="w-10 h-10 rounded-full mr-2"></a>
                <span class="text-gray-700 font-medium"><%= userOn.getLogin()%></span>
            </div>
        </div>

        <div class="max-w-md rounded overflow-hidden shadow-lg bg-white p-8 flex flex-col justify-center">
            <h1 class="text-2xl font-semibold mb-4">Criar Produto</h1>
            <form action="addProduct.jsp" method="POST">
                <div class="mb-4">
                    <label for="name" class="block text-gray-700 font-bold mb-2">Nome:</label>
                    <input type="text" id="name" name="name" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
                </div>
                <div class="mb-4">
                    <label for="value" class="block text-gray-700 font-bold mb-2">Valor (R$):</label>
                    <input type="number" step="0.01" id="value" name="value" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
                </div>
                <div class="mb-4">
                    <label for="type" class="block text-gray-700 font-bold mb-2">Tipo:</label>
                    <input type="text" id="type" name="type" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
                </div>
                <div class="flex justify-between items-center">
                    <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Criar</button>
                    <a href="javascript:history.back()" class="text-gray-500 hover:text-gray-700">Cancelar</a>
                </div>
            </form>
        </div>
    </body>
</html>