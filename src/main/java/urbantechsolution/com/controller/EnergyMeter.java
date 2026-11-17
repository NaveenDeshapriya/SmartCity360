package urbantechsolution.com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urbantechsolution.com.model.decorator.Authentication;
import urbantechsolution.com.model.decorator.Compression;
import urbantechsolution.com.model.decorator.Encryption;
import urbantechsolution.com.model.decorator.LocalSecurity;
import urbantechsolution.com.service.Security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/energyMeeter")
public class EnergyMeter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String voltage = req.getParameter("voltage");


        Map<String,String> data= new HashMap<>();
        data.put("username",username);
        data.put("password",password);
        data.put("voltage",voltage);


        Security localSecurity=new LocalSecurity();
        localSecurity=new Encryption(localSecurity);
        localSecurity=new Authentication(localSecurity);
        localSecurity=new Compression(localSecurity);


        Map<String,String> secureData=localSecurity.checkData(data);

        if (secureData==null){
            resp.getWriter().write("Security Failed...");
        }else{
            req.getSession().setAttribute("data",secureData);
            resp.sendRedirect(req.getContextPath()+"/dashboard.jsp");
        }




    }
}
