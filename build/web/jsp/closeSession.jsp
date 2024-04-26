<%-- 
    Document   : closeSession
    Created on : Apr 25, 2024, 8:06:56 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("signin.jsp"); 
%>