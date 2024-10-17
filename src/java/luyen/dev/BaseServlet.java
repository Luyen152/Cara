/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyen.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import luyen.dev.data.dao.CategoryDao;
import luyen.dev.data.dao.Database;
import luyen.dev.data.dao.DatabaseDao;
import luyen.dev.data.model.Category;

/**
 *
 * @author Admin
 */
public class BaseServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        DatabaseDao.init(new Database());  // Khởi tạo database
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();
        
        request.setAttribute("categoryList", categoryList);
    }
}