package controller;

import model.Giohang;
import model.Sanpham;
import sevice.SanphamDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "trangchu", value = "/Taphoa")
public class Webbanhang extends HttpServlet {
    SanphamDatabase sanphamDatabase = new SanphamDatabase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreateSP(req, resp);
                break;
            default:
                trangchu(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createSP(req, resp);
                break;
            case "oder":
                oderSP(req, resp);
                break;
            default:
                trangchu(req, resp);
        }
    }

    private void oderSP(HttpServletRequest req, HttpServletResponse resp) {
        int idkh = 1;
        int idsp = Integer.parseInt(req.getParameter("idsp"));
            int soluongmua = Integer.parseInt(req.getParameter("soluong" + idsp));
            sanphamDatabase.oderSP(idkh, idsp, soluongmua);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Taphoa?action=&&idsp=&&soluong=");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    private void createSP(HttpServletRequest req, HttpServletResponse resp) {
        String tenSP = req.getParameter("ten");
        int dongia = Integer.parseInt(req.getParameter("dongia"));
        int soluong = Integer.parseInt(req.getParameter("soluong"));
        sanphamDatabase.createSP(tenSP,dongia,soluong);
        try {
            resp.sendRedirect("/Taphoa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateSP(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void trangchu(HttpServletRequest req, HttpServletResponse resp) {
        int idkh= 1;
        List<Sanpham> sanphamList = sanphamDatabase.getListSanpham();
        req.setAttribute("listSP", sanphamList);
        List<Giohang> giohangList = sanphamDatabase.getListGioHang(idkh);
        req.setAttribute("giohang",giohangList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("trangchu.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
