<%-- 
    Document   : login
    Created on : Apr 25, 2024, 9:43:33 AM
    Author     : gustavo
--%>

<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar | QuickCart</title>
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <script>
            function validarFormulario() {
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;

                if (username.trim() === '' || password.trim() === '') {
                    alert("Por favor, preencha todos os campos.");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body class="bg-gray-100 flex justify-center items-center h-screen">
        <div class="max-w-sm rounded overflow-hidden shadow-lg bg-white p-8">
            <h1 class="text-2xl font-semibold mb-4">Login</h1>
            <form action="validate.jsp" method="POST" onsubmit="return validarFormulario()">
                <input type="hidden" name="action" value="signin">
                <div class="mb-4">
                    <label for="username" class="block text-gray-700 font-bold mb-2">Usuário:</label>
                    <input type="text" id="username" name="username" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </div>
                <div class="mb-4">
                    <label for="password" class="block text-gray-700 font-bold mb-2">Senha:</label>
                    <input type="password" id="password" name="password" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </div>
                <div class="mb-6">
                    <input type="submit" value="Entrar" class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                </div>
            </form>
            <p>Não tem uma conta? <a href="signup.jsp" class="text-blue-500 hover:text-blue-700">Inscreva-se</a></p>
        </div>
    </body>
</html>
