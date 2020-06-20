package struts.servlets;

import org.springframework.context.ApplicationContext;
import struts.beans.Person;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 从 application 域对象中得到 IOC 容器的引用
        ServletContext servletContext = getServletContext();
        ApplicationContext ctx = (ApplicationContext) servletContext.getAttribute("ApplicationContext");

        //2. 从 IOC 容器中得到需要的 bean
        Person person = ctx.getBean(Person.class);
        person.hello();
    }
}
