<%-- 
    Document   : addProduct
    Created on : Apr 25, 2024, 8:37:12 PM
    Author     : gustavo
--%>

<%-- 
  Document  : createProduct
  Created on : Apr 25, 2024, 7:11:35 PM
  Author   : gustavo
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

    // Get form data (assuming form uses POST method)
    String name = request.getParameter("name");
    String valueStr = request.getParameter("value");
    String type = request.getParameter("type");

    // Convert valor to double (assuming valor is a number)
    float value = Float.parseFloat(valueStr);

    // Create a new Produto object
    Produto novoProduto = new Produto(userOn.getId(), name, value, type);

    // Controller to interact with business logic (replace with your implementation)
    ControllerVendedor controller = new ControllerVendedor();
    Produto created = (Produto) controller.inserir(novoProduto);

    String message = "";
    if (created != null) {
        message = "Produto criado com sucesso!";
    } else {
        message = "Erro ao criar produto. Tente novamente.";
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

        <% if (userOn != null) { %>  
        <div class="max-w-md rounded overflow-hidden shadow-lg bg-white p-8 flex flex-col justify-center">
            <p><%= message%></p>
            <a href="javascript:history.back()" class="text-gray-500 hover:text-gray-700">Voltar</a>
            <% }%>
        </div>   
    </body>