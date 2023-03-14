package com.Husky.superMarket.servlet;

import com.Husky.superMarket.Exceptions.DateException;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.service.fruitService;
import com.Husky.superMarket.serviceImpl.fruitServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet({"/fruit/all","/fruit/add","/fruit/delete","/fruit/modify","/fruit/search"})
public class fruitServlet extends HttpServlet {
    fruitService fs=new fruitServiceImpl();
    List<Fruit> list=new ArrayList<>();
    Fruit fruit=new Fruit();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("account")!=null){
            if("/fruit/all".equals(request.getServletPath())){
                doAll(request,response);
            }
            else if("/fruit/add".equals(request.getServletPath())){
                char flag='A';
                request.setAttribute("flag",flag);
                doAM(request,response);
            }
            else if("/fruit/delete".equals(request.getServletPath())){
                doDel(request,response);

            }
            else if("/fruit/modify".equals(request.getServletPath())){
                char flag='M';
                request.setAttribute("flag",flag);
                doAM(request,response);
            }
            else if("/fruit/search".equals(request.getServletPath())){
                String id=request.getParameter("id");
                doSearch(request,response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String ipName=request.getParameter("ipName");
        String f="fruit";
        request.setAttribute("f",f);
        list=fs.checkFruit(ipName);
        request.setAttribute("fruitList",list);
        String id=request.getParameter("id");
        if("root".equals(id)){
            request.getRequestDispatcher("/user/showAll").forward(request,response);
        }
        else if("user".equals(id)){
            request.getRequestDispatcher("/cart/showAll").forward(request,response);
        }

    }

    private void doAM(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String name=request.getParameter("name");
        double price=Double.parseDouble(request.getParameter("price"));
        int num=Integer.parseInt(request.getParameter("num"));
        //String转Date
        String productionDates = request.getParameter("productionDate");
        java.sql.Date date=java.sql.Date.valueOf(productionDates);
//        DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date productionDate= null;
//        try {
//            productionDate = DateFormat.parse(productionDates);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        int PreservationPeriod=Integer.parseInt(request.getParameter("PreservationPeriod"));
        String Unit=request.getParameter("Unit");
        fruit.setName(name);
        fruit.setUnit(Unit);
        fruit.setNum(num);
        fruit.setPreservationPeriod(PreservationPeriod);
        fruit.setProductionDate(date);
        fruit.setPrice(price);
        char flag=(char)request.getAttribute("flag");
        if(flag=='M'){
            fs.modifyFruit(fruit);
        }
        else if(flag=='A')
        {
            fs.addFruit(fruit);
        }
        doAll(request,response);
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String name=request.getParameter("name");
        fs.deleteFruit(name);
        request.getRequestDispatcher("/fruit/all").forward(request,response);
    }
    private void doAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String id=request.getParameter("id");
        List<Fruit> list=fruitService.allFruit();
        String f="fruit";
        request.setAttribute("f",f);
        request.setAttribute("fruitList",list);
        if("user".equals(id)){
            request.getRequestDispatcher("/cart/showAll").forward(request,response);
        }
        else if("root".equals(id)){
            request.getRequestDispatcher("/user/showAll").forward(request,response);
        }
    }
}
