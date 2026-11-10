<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Proyecto Visión - Gestión de Usuarios</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        .container { max-width: 600px; background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1); }
        h2 { color: #333; }
        label { display: block; margin-top: 10px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box; }
        button { margin-top: 15px; background: #007bff; color: white; border: none; padding: 10px 15px; cursor: pointer; border-radius: 4px; }
        button:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registro de Usuarios - Proyecto Visión</h2>
        
        <!-- Formulario usando método POST para enviar datos al Servlet -->
        <form action="usuarioServlet" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>

            <label for="correo">Correo Electrónico:</label>
            <input type="email" id="correo" name="correo" required>

            <label for="rol">Rol:</label>
            <input type="text" id="rol" name="rol" required>

            <button type="submit">Guardar Usuario (POST)</button>
        </form>

        <hr style="margin: 25px 0;">

        <!-- Formulario usando método GET para consultar usuarios -->
        <h3>Consultar Usuarios (GET)</h3>
        <form action="usuarioServlet" method="GET">
            <button type="submit" style="background: #28a745;">Ver Listado</button>
        </form>
    </div>
</body>
</html>