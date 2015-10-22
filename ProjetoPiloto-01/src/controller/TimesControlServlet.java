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

import model.Times;
import persistence.TimesDAO;

/**
 * Servlet implementation class TimesControlServlet
 */
@WebServlet("/TimesControlServlet")
public class TimesControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Times>lista =new ArrayList<Times>();
		String erro="";
		TimesDAO tDao=new TimesDAO();
		try {
			lista=tDao.listaTimes();
			System.out.println("Lista : " + lista);
			System.out.println("Size : " + lista.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
		request.setAttribute("erro", erro);
		request.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("carregarTimes.jsp");
		view.forward(request, response);
		
		}
	}

}
