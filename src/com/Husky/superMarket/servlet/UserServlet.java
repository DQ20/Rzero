package com.Husky.superMarket.servlet;

import com.Husky.superMarket.pojo.User;
import com.Husky.superMarket.service.userService;
import com.Husky.superMarket.serviceImpl.userServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

@WebServlet({"/user/login","/user/register","/user/exit","/welcome","/user/showAll"})
public class UserServlet extends HttpServlet {
    userService us = new userServiceImpl();
    User user = new User();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("/welcome".equals(request.getServletPath())) {
            doWelcome(request, response);
        } else if ("/user/login".equals(request.getServletPath())) {
            doLogin(request, response);
        } else if ("/user/register".equals(request.getServletPath())) {
            doRegister(request, response);
        }
        else {
            HttpSession session=request.getSession(false);
            if(session!=null&&session.getAttribute("account")!=null) {
                if ("/user/showAll".equals(request.getServletPath())) {
                    doShow(request, response);
                } else if ("/user/exit".equals(request.getServletPath())) {
                    doExit(request, response);
                }
            }
            else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
                return;
            }
        }

    }

    private void doShow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        List<User> list=userService.QueryAll();
        String kind=request.getParameter("kind");
        request.setAttribute("userList",list);
        if("fruit".equals(kind))
        {
            request.getRequestDispatcher("/AdminiF.jsp").forward(request,response);
        }
        else if("stationary".equals(kind)){
            request.getRequestDispatcher("/AdminiS.jsp").forward(request,response);
        }

    }

    private void doWelcome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Cookie[] cookies = request.getCookies();
            String account = null;
            String password = null;
            if (cookies != null) {
                for (Cookie cookie :
                        cookies) {
                    String name = cookie.getName();
                    if ("account".equals(name)) {
                        account = cookie.getValue();
                    }
                    else if ("password".equals(name)) {
                        password = cookie.getValue();
                    }
                }
            }
            if (account != null && password != null) {
                user.setAccount(account);
                user.setPassword(password);
                if (us.login(user)) {
                    HttpSession session =request.getSession();
                    session.setAttribute("account",account);
                    response.sendRedirect(request.getContextPath() + "/mainInterface.jsp");
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            }
    private void doExit (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
            response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    private void doLogin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        ResourceBundle bundle=ResourceBundle.getBundle("resources.Admini");
        String king=bundle.getString("Account");
        String root=bundle.getString("password");
        if(account.equals(king)&&password.equals(root)){
            HttpSession seesion=request.getSession();
            seesion.setAttribute("account",king);
            request.getRequestDispatcher("/Admini.jsp").forward(request,response);
        }
        user.setAccount(account);
        user.setPassword(password);
        if (us.login(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            String flag = request.getParameter("flag");
            if ("1".equals(flag)) {
                Cookie A = new Cookie("account", account);
                Cookie B = new Cookie("password", password);
                A.setMaxAge(60 * 60 * 24 * 10);
                B.setMaxAge(60 * 60 * 24 * 10);
                A.setPath(request.getContextPath());
                B.setPath(request.getContextPath());
                response.addCookie(A);
                response.addCookie(B);
            }
            response.sendRedirect(request.getContextPath() + "/mainInterface.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/loginError.jsp");
        }
    }
    private void doRegister (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        ResourceBundle bundle=ResourceBundle.getBundle("resources.Admini");
        String king=bundle.getString("Account");
        if(account.equals(king)){
            response.sendRedirect(request.getContextPath() + "/registerError.jsp");
            return;
        }
        user.setAccount(account);
        user.setPassword(password);
        if (us.register(user)) {
            request.getRequestDispatcher("/user/login").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/registerError.jsp");
        }
    }
}