package urbantechsolution.com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urbantechsolution.com.model.LightDTO;
import urbantechsolution.com.model.flyweight.SharedStreetLight;
import urbantechsolution.com.model.flyweight.StreetLight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/streetLight")
public class StreetLightController extends HttpServlet {

    private List<LightDTO> lightDTOList;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String location = req.getParameter("location");
        String type = req.getParameter("type");
        String color = req.getParameter("color");
        String status = req.getParameter("status");
        int brightness = Integer.parseInt(req.getParameter("brightness"));

        StreetLight streetLight = new StreetLight(status, type, color,brightness,location);
        LightDTO streetLightDto = streetLight.getStreetLights();

        if(lightDTOList==null){
            lightDTOList=new ArrayList<>();
        }

        lightDTOList.add(streetLightDto);


        req.getSession().setAttribute("streetLights",lightDTOList);

        resp.sendRedirect(req.getContextPath() + "/streetlight.jsp");


    }
}
