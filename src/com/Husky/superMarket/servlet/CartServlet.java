package com.Husky.superMarket.servlet;

import com.Husky.superMarket.Exceptions.CartException;
import com.Husky.superMarket.pojo.CartGoods;
import com.Husky.superMarket.service.cartService;
import com.Husky.superMarket.serviceImpl.cartGoodsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/cart/showAll","/cart/delete","/cart/add","/cart/clear"})
public class CartServlet extends HttpServlet {
    cartService CS=new cartGoodsServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String servletPath=request.getServletPath();
            HttpSession session=request.getSession(false);
            if(session!=null&&session.getAttribute("account")!=null){
                if("/cart/showAll".equals(servletPath)){
                    doShow(request,response);
                }
                if("/cart/delete".equals(servletPath)){
                    doDel(request,response);
                }
                if("/cart/add".equals(servletPath)){
                    doAdd(request,response);
                }
                if("/cart/clear".equals(servletPath)){
                    doClear(request,response);
                }
            }
            else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
    }
    private void doClear(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException{
        cartService.clear();
        String Fi=request.getParameter("Fi");
        if("buy".equals(Fi)){
            response.sendRedirect(request.getContextPath()+"/thank.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/mainInterface.jsp");
        }


    }
    private void doShow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        List<CartGoods> list=new ArrayList<>();
        list= cartService.allGoods();
        String f=(String) request.getAttribute("f");
        request.setAttribute("cartList",list);
        if("fruit".equals(f)){
            request.getRequestDispatcher("/fruits.jsp").forward(request,response);
        }
        else if("stationary".equals(f)){
            request.getRequestDispatcher("/stationary.jsp").forward(request,response);
        }
    }
    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String name=request.getParameter("name");
        String kind=null;
//        String ic=null;
        kind=request.getParameter("kind");
//        ic=request.getParameter("ic");
        if(CS.check(name).getName()!=null){
            CS.B(name);
        }
        else {
            new CartException("啊哦，购物车出错了");
         }
//        if("A".equals(ic)){
            if("stationary".equals(kind)){
                request.getRequestDispatcher("/stationary/all").forward(request,response);
            }
            else if("fruit".equals(kind)){
                request.getRequestDispatcher("/fruit/all").forward(request,response);
            }
//        }
//        else if("B".equals(ic)){
//            if("stationary".equals(kind)){
//                request.getRequestDispatcher("/stationary/search").forward(request,response);
//            }
//            else if("fruit".equals(kind)){
//                request.getRequestDispatcher("/fruit/search").forward(request,response);
//            }
//        }
    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String name=request.getParameter("name");
        String kind=null;
//        String ic=null;
        kind=request.getParameter("kind");
//        ic=request.getParameter("ic");
        if(CS.check(name).getName()!=null){
            CS.A(name);
        }
        else {
            CS.addGoods(name);
        }
//        if("A".equals(ic)){
            if("stationary".equals(kind)){
                request.getRequestDispatcher("/stationary/all").forward(request,response);
            }
            else if("fruit".equals(kind)){
                request.getRequestDispatcher("/fruit/all").forward(request,response);
            }
//        }
//        else if("B".equals(ic)){
//            if("stationary".equals(kind)){
//                request.getRequestDispatcher("/stationary/search").forward(request,response);
//            }
//            else if("fruit".equals(kind)){
//                request.getRequestDispatcher("/fruit/search").forward(request,response);
//            }
//        }
    }
}
