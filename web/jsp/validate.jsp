<%-- 
    Document   : validate
    Created on : Apr 25, 2024, 3:36:32 PM
    Author     : gustavo
--%>

<%@page import="controller.ControllerUsuario"%>
<%@page import="model.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%

    String action = request.getParameter("action");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    ControllerUsuario userCont = new ControllerUsuario();
    Usuario userOut = null;

    if ("signup".equals(action)) {
        String role = request.getParameter("role");
        Usuario newUser = new Usuario(username, password, "ativo", role);
        userOut = (Usuario) userCont.inserir(newUser);
        response.sendRedirect("signin.jsp");

    } else if ("signin".equals(action)) {
        Usuario userIn = new Usuario(username, password);
        userOut = (Usuario) userCont.persist(userIn);
        session.setAttribute("UserOn", userOut);
    } else {
        response.sendRedirect("../index.html");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carregando | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

    </head>
    <body>
    <body class="bg-gray-100 flex justify-center items-center h-screen">
        <%if (userOut != null & "signin".equals(action)) { %>
        <% if ("vendedor".equals(userOut.getTipo())) {
                response.sendRedirect("vendedor/dashboard.jsp");
            } else {
                response.sendRedirect("comprador/dashboard.jsp");
            }
        %>
        <% } else { %>
        <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8 flex flex-col align-center">
            <h1 class="text-2xl font-semibold mb-4">Usuario ou Senha incorreto</h1>                
            <p class="text-gray-600 mb-6 text-center">Tente novamente.</p>
            <a href="javascript:history.back()" class="text-blue-500 hover:text-blue-700 text-center">Voltar</a>
        </div>
        <% }%>

    </body>
</html>
