package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupos;
import persistence.GruposDAO;
import persistence.TimesDAO;

/**
 * Servlet implementation class GruposControlServlet
 */
@WebServlet("/GruposControlServlet")
public class GruposControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GruposControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carregarGrupo(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carregarGrupo(request, response);
		
	}
	
	
	protected void carregarGrupo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String resp="distribuição dos Grupos com sucesso.";
		String erro="";
		
		GruposDAO gDao = new GruposDAO();
		
		try {
			gDao.criarGrupos();
			gDao.carregarGrupos(1);
			
			request.setAttribute("erro", erro);
			request.setAttribute("resp", resp);
			RequestDispatcher view = request.getRequestDispatcher("gerarGrupos.jsp");
			view.forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	 
	
	

}
