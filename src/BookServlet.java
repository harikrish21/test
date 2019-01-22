	
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String btnsel = request.getParameter("btn");
			response.setContentType("text/html");
			try {
				switch (btnsel) {
				case "AddBook":
					int id = Integer.parseInt(request.getParameter("bid"));
					String name = request.getParameter("bname");
					int price = Integer.parseInt(request.getParameter("bprice"));

					if (new BusinessLogic().AddBook(new Bookk(id, name, price))) {

						response.getWriter().print("<h3>book added</h3>");

					} else {
						response.getWriter().println("<h3>book not added</h3>");
					}
					response.getWriter().println("<a href='index.html'>Back</a>");
					break;

				case "UpdateBook":
					id = Integer.parseInt(request.getParameter("bid"));
					name = request.getParameter("bname");
					price = Integer.parseInt(request.getParameter("bprice"));

					if (new BusinessLogic().UpdateBook(new Bookk(id, name, price))) {

						response.getWriter().print("<h3>book updated</h3>");

					} else {
						response.getWriter().println("<h3>book not updated</h3>");
					}
					response.getWriter().println("<a href='index.html'>Back</a>");

					break;

				case "DeleteBook":
					id = Integer.parseInt(request.getParameter("bid"));
					name = request.getParameter("bname");
					price = Integer.parseInt(request.getParameter("bprice"));

					if (new BusinessLogic().DeleteBook(new Bookk(id, name, price))) {

						response.getWriter().print("<h3>book Deleted</h3>");

					} else {
						response.getWriter().println("<h3>book not Delete</h3>");
					}
					response.getWriter().println("<a href='index.html'>Back</a>");

					break;

				case "show":
					ArrayList<Bookk> list = new BusinessLogic().showBooks();
					for (Bookk bk : list) {

						response.getWriter().println("<table><tr><td>"+ "   "+bk.getBid()+"  "+ bk.getBname()+"  "+bk.getBprice()+"</td></tr>");
					}

					break;
				}
			} catch (Exception ex) {
				response.getWriter().println(ex.getMessage());
			}
		}

	

		
		
		
}
