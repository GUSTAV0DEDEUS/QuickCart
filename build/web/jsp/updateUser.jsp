<%-- 
    Document   : updateUser
    Created on : Apr 25, 2024, 7:26:51 PM
    Author     : gustavo
--%>

<%@page import="model.bean.Usuario"%>
<%@page import="controller.ControllerUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuário Atualizado - QuickCart</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex justify-center items-center h-screen">

<%
  // Get form data (assuming user ID is retrieved from a hidden field)
  String name = request.getParameter("name");
  String password = request.getParameter("password");


  Usuario userOn = (Usuario) session.getAttribute("UserOn");
  ControllerUsuario userCont = new ControllerUsuario();

  try {
    Usuario updatedUser = new Usuario(userOn.getId(), name, password, userOn.getStatus(), userOn.getTipo());

    // Update the user using the controller
    userCont.alterar(updatedUser);
%>

  <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 text-center">
    <h1 class="text-2xl font-semibold mb-4">Usuário Atualizado</h1>
    <p class="text-green-500 font-bold">Dados do usuário atualizados com sucesso!</p>
    <br/>
    <a href="signin.jsp" class="text-blue-500 hover:text-blue-700">Login</a>
  </div>

<% } catch (Exception e) { %>

  <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 text-center">
    <h1 class="text-2xl font-semibold mb-4">Erro</h1>
    <p class="text-red-500 font-bold">Erro ao atualizar usuário</p>
    <a href="javascript:history.back()" class="text-blue-500 hover:text-blue-700">Login</a>
  </div>

<% } %>

</body>
</html>
