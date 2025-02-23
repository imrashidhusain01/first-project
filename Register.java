package studentData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Regist")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String client = request.getParameter("Client_name");
        String email = request.getParameter("User_email");
        String pass = request.getParameter("User_password");
        String cond = request.getParameter("Condition");

        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            final String URL = "jdbc:postgresql://localhost:5432/postgres";
            final String USER = "postgres";
            final String PASS = "Rashid12";

            // Establish connection
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // Create table if it doesn't exist
            //PreparedStatement ps=con.prepareStatement("create table Servlet(id serial primary key, client varchar(50), email varchar(70), password varchar(100))");

            PreparedStatement ps = con.prepareStatement("INSERT INTO  servlet(client, email, password) VALUES(?,?,?)");
            ps.setString(1, client);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.executeUpdate(); 

            pw.print("<p>Data added successfully .</p>");
//            pw.print("<p>Client Name: " + client + "</p>");
//            pw.print("<p>User Email: " + email + "</p>");
//            pw.print("<p>User Password: " + pass + "</p>");
        } catch (Exception e) {
            pw.print("<p>Error: " + e.getMessage() + "</p>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
            return;
        }

        // Check if terms and conditions are accepted
        if (cond!=null) {
//            pw.print("<p>Client Name: " + client + "</p>");
//            pw.print("<p>User Email: " + email + "</p>");
//            pw.print("<p>User Password: " + pass + "</p>");
        } else {
            pw.print("<p><h1>You have not accepted terms and conditions</h1></p>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
    }
}