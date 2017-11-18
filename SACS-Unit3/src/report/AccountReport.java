package report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class AccountReport
 */
@WebServlet("/AccountReport")
public class AccountReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAOImpl dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountReport() {
        super();
        dao = new AccountDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPhat = "C:\\Users\\usuario\\eclipse-workspace\\SACS-Unit3\\src\\report\\reportAccounts.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPhat);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("img_dios", this.getServletContext().getRealPath("/") + "image/buen-programador.jpg");
			// data.put("Image",this.getServletContext().getRealPath("/")+"images/helloWordl.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnection());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush(); //Escribe los datos
			response.getOutputStream().close();	//Cierra los datos
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
