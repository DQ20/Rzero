package com.Husky.superMarket.servlet;

import com.Husky.superMarket.pojo.stationary;
import com.Husky.superMarket.service.stationaryService;
import com.Husky.superMarket.serviceImpl.stationaryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet({"/stationary/all","/stationary/add","/stationary/delete","/stationary/modify","/stationary/search"})
public class stationaryServlet extends HttpServlet {
    stationaryService ss=new stationaryServiceImpl();
    List<stationary> list=new ArrayList<>();
    stationary sn=new stationary();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("account")!=null){
            if("/stationary/all".equals(servletPath)){
                doAll(request,response);
            }
            else if("/stationary/add".equals(servletPath)){
                char flag='A';
                request.setAttribute("flag",flag);
                doAM(request,response);
            }
            else if("/stationary/delete".equals(servletPath)){
                doDel(request,response);
            }
            else if("/stationary/modify".equals(servletPath)){
                char flag='M';
                request.setAttribute("flag",flag);
                doAM(request,response);
            }
            else if("/stationary/search".equals(servletPath)){
                doSearch(request,response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String ipName=request.getParameter("ipName");
        list=ss.checkSt(ipName);
        request.setAttribute("stationaryList",list);
        String f="stationary";
        request.setAttribute("f",f);
        String id=request.getParameter("id");
        if("root".equals(id)){
            request.getRequestDispatcher("/user/showAll").forward(request,response);
        }
        else if("user".equals(id)){
            request.getRequestDispatcher("/cart/showAll").forward(request,response);
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String name=request.getParameter("name");
        ss.deleteSt(name);
        request.getRequestDispatcher("/stationary/all").forward(request,response);
    }

    private void doAM(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{

            String name=request.getParameter("name");
            double price=Double.parseDouble(request.getParameter("price"));
            String ProductPlace=request.getParameter("ProductPlace");
            String Unit=request.getParameter("Unit");
            int num= Integer.parseInt(request.getParameter("num"));
            sn.setName(name);
            sn.setProductPlace(ProductPlace);
            sn.setNum(num);
            sn.setUnit(Unit);
            sn.setPrice(price);
        char flag=(char)request.getAttribute("flag");
        if(flag=='M'){
            ss.modifyst(sn);
//            request.getRequestDispatcher("/stationary/all").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/stationary/all");
        }
        else if(flag=='A')
        {
            ss.addSt(sn);

        }
        doAll(request,response);
    }

    private void doAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String id=request.getParameter("id");
        List<stationary> list=new ArrayList<>();
        list=stationaryService.allFruit();
        String f="stationary";
        request.setAttribute("f",f);
        request.setAttribute("stationaryList",list);
        if("user".equals(id)){
            request.getRequestDispatcher("/cart/showAll").forward(request,response);
        }
        else if("root".equals(id)){
            request.getRequestDispatcher("/user/showAll").forward(request,response);
        }
    }
}
