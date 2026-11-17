package urbantechsolution.com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urbantechsolution.com.model.composite.Building;
import urbantechsolution.com.model.composite.City;
import urbantechsolution.com.model.composite.District;
import urbantechsolution.com.model.composite.Street;

import java.io.IOException;
import java.util.List;

@WebServlet("/cityZone")
public class CityZone extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String building = request.getParameter("building");
        String shutDownZone = request.getParameter("shutDown-zone");


        District districtZone = new District(district);
        City cityZone = new City(city);
        Street streetZone = new Street(street);
        Building buildingZone = new Building(building);

        districtZone.addZoneControl(cityZone);
        cityZone.addZoneControl(streetZone);
        streetZone.addZoneControl(buildingZone);

        if (shutDownZone.equals("District")) {

            districtZone.shutdownPower();
            List<String> districtReport = districtZone.reportUsage();
            request.getSession().setAttribute("report", districtReport);



        } else if (shutDownZone.equals("City")) {

            cityZone.shutdownPower();
            List<String> cityReport=cityZone.reportUsage();
            request.getSession().setAttribute("report", cityReport);




        } else if (shutDownZone.equals("Street")) {
            streetZone.shutdownPower();
            List<String> streetReport=streetZone.reportUsage();
            request.getSession().setAttribute("report",streetReport);


        } else if (shutDownZone.equals("Building")) {

            buildingZone.shutdownPower();
            List<String> buildingReport=buildingZone.reportUsage();
            request.getSession().setAttribute("report",buildingReport);

        }


        response.sendRedirect(request.getContextPath() + "/zone.jsp");


    }
}
