import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The main class of our application will extends the HttpServlet class
 * so that it may inherit the required methods to run a web app, such as 
 * doGet()
 */
public class App extends HttpServlet {

    /**
     * The doGet() method answers GET requests on the part of the Web App, and takes in as params
     * the request and response HttpServlet objects so that based on the request, we can
     * define a response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> Sample Servlet </title>");
        out.println("<style> h1 {text-align: center; border: solid 1px rgba(0,0,0,0.5);} </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id = \"main\" style = \"background-color: blue;\">");
        out.println("<h1>Hello and welcome to Java Servlets!</h1>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

}