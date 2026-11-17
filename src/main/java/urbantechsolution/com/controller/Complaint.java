package urbantechsolution.com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urbantechsolution.com.model.Chain.*;

import java.io.IOException;

@WebServlet("/complaint")
public class Complaint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String title=req.getParameter("title");


        Resident resident=new Resident(name,title);

        LocalStaff localStaff=new LocalStaff();
        Supervisor supervisor=new Supervisor();
        CityManager cityManager=new CityManager();

        localStaff.setStaff(supervisor);
        supervisor.setStaff(cityManager);

       resp.getWriter().write(localStaff.handle(resident));




    }


}
