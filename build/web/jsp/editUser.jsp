<%-- 
    Document   : editUser
    Created on : Apr 25, 2024, 7:23:11 PM
    Author     : gustavo
--%>

<%@page import="model.bean.Usuario"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
    Usuario userOn = (Usuario) session.getAttribute("UserOn");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar Usuário | QuickCart</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex justify-center items-center h-screen">
    <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8">
        <h1 class="text-2xl font-semibold mb-4">Editar Usuário</h1>
        <form action="updateUser.jsp" method="POST">
            <div class="mb-4">
                <label for="name" class="block text-gray-700 font-bold mb-2">Nome Completo:</label>
                <input type="text" id="name" name="name" placeholder="<%=userOn.getLogin()%>" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
            </div>
            <div class="mb-4">
                <label for="password" class="block text-gray-700 font-bold mb-2">Senha:</label>
                <input type="password" id="password" placeholder="<%=userOn.getSenha()%>" name="password" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
            </div>
            <div class="flex justify-between items-center">
                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Atualizar</button>
                <a href="javascript:history.back()" class="text-gray-500 hover:text-gray-700">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>
