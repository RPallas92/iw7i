package iw7i.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/hello" })
public class HelloWorld extends HttpServlet implements Runnable {

	private AtomicInteger ticks;
	private int tocks;
	private boolean exit;

	@Override
	public void init() throws ServletException {
		ticks = new AtomicInteger();
		tocks = 0;
		exit = false;
		Thread t = new Thread(this);
		t.setPriority(1);
		t.start();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h2>Hello (dynamic) World!</h2>");
		String value = req.getParameter("name");
		if (value != null && value.trim().length() > 0) {
			out.println("Hello " + value.trim() + "!!");
		}
		out.println("You requested with "+req.getMethod()+" to know my tick " + ticks.incrementAndGet()
				+ " and my tock " + tocks);
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		ticks = null;
		exit = true;
	}

	@Override
	public void run() {
		while(!exit) {
			tocks++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
