// JAVA Servlet programming (form and servlet)
//Created By : Simul Bista (Jan 26, 2023)

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProcess
 */
@WebServlet("/UserProcess")
public class UserProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// storing the submitted parameters from the html form into variables
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		String zip = request.getParameter("zcode");
		String uName = request.getParameter("uname");
		String password = request.getParameter("pass");
		String repassword = request.getParameter("repass");
		String music[] = request.getParameterValues("music");
		String notification = request.getParameter("notification");

		// string to store the concatenated values from the music array
		String musicList = "";

		// set the text when music array has no incoming values
		if (music == null) {
			musicList = "Music not selected!";
		}

		// setting content type to html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//input data validation
		if (fName.isEmpty()) {
			out.println("First Name field cannot be empty!");
		} else if (lName.isEmpty()) {
			out.println("Last Name field cannot be empty!");
		} else if (email.isEmpty()) {
			out.println("Email field cannot be empty!");
		} else if (zip.isEmpty()) {
			out.println("Zip Code field cannot be empty!");
		} else if (uName.isEmpty()) {
			out.println("User Name field cannot be empty!");
		} else if (password.isEmpty()) {
			out.println("Password field cannot be empty!");
		} else if (lName.isEmpty()) {
			out.println("Confirm password field cannot be empty!");
		} else if (!password.equals(repassword)) {
			out.println("Both passwords must match!");
		} else {
			if (music != null) {
				// concatenating music fields (values from the checkbox)
				for (int i = 0; i < music.length; i++) {
					if (music[i] != music[music.length - 1]) {
						musicList += music[i] + ", ";
					} else {
						musicList += music[i];
					}
					// for debugging purpose
					// out.println(music[i]);
				}
			}
			
			//displaying the result if success in validation
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='result.css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table>");
			
			out.println("<tr>");
			out.println("<td colspan='2'><div class='title'>Thank you for joining our "
					+ "mailing list</div><div class='subtitle'>Here is the "
					+ "information that you entered:</div></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>First Name</td>");
			out.println("<td>" + fName + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Last Name</td>");
			out.println("<td>" + lName + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td>" + email + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Zip Code</td>");
			out.println("<td>" + zip + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>User Name</td>");
			out.println("<td>" + uName + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Password</td>");
			out.println("<td>" + password + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Favorite Music</td>");
			out.println("<td>" + musicList + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Receive special sale notification</td>");
			out.println("<td>" + notification + "</td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		}

	}

}
