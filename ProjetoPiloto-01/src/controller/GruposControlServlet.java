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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Grupos>lista =new ArrayList<Grupos>();
		String erro="";
		GruposDAO gDao=new GruposDAO();
		try {
			lista=gDao.listaGrupos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
		request.setAttribute("erro", erro);
		request.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("pagna.jsp");
		view.forward(request, response);
		
		}
	}

}
