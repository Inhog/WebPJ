package JSPPrac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/AnnotationWebServlet")
@WebFilter(urlPatterns = {"/*"}, initParams = {
@WebInitParam(name = "test-param", value = "Initialization Parameter")})

public class AnnotationWebServlet extends HttpServlet implements Filter {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); // �ؼ���� ����
		PrintWriter out = resp.getWriter();

		Enumeration headerNames = req.getHeaderNames();
		String paramName = "";
		String paramValue = "";

		while (headerNames.hasMoreElements()) {
			paramName = (String) headerNames.nextElement();
			paramValue = req.getHeader(paramName);
			out.print("<div class=\"form-group\">\n" + "" + paramName + ": " + paramValue + "\n" + "</div>\n");
		}

		out.print("<div>Client IP: " + req.getRemoteAddr() + "</div>");
		out.print("<div>Client HOST: " + req.getRemoteHost() + "</div>");
		out.print("<div>Client PORT: " + req.getRemotePort() + "</div>");
		out.print("<div>Client USER: " + req.getRemoteUser() + "</div>");

	}

	public void init(FilterConfig config) throws ServletException {
//		String testParam = config.getInitParameter("test-param");
//		System.out.println("Test Param: " + testParam);
//		System.out.println("init Time " + new Date().toString());
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("doFilter Time " + new Date().toString());
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void destroy() {
//		System.out.println("destroy Time " + new Date().toString());
	}
}
