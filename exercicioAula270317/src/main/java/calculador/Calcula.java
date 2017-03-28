package calculador;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contas.Contas;
import contas.Resultado;
import helper.JsonHelper;

@WebServlet(urlPatterns = "/calculadora")
public class Calcula extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private List<Object> lista = new ArrayList<Object>();
	private List<Object> listaRes = new ArrayList<Object>();
	
	private JsonHelper jsonHelper =  new JsonHelper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		String op = req.getParameter("op");
		
		Contas conta = new Contas(n1, n2, op);
		
		lista.add(conta);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(conta));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		double total=0;
		
		if (op.equals("som")){
			total=n1+n2;
		}else if (op.equals("sub")){
			total=n1-n2;
		}else if (op.equals("mult")){
			total=n1*n2;
		}else if (op.equals("div")){
			total=n1/n2;
		}else{
			total=0;
		}
		
		Resultado res=new Resultado(total);
		listaRes.add(res);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String json;
		try {
			json = jsonHelper.gerarJsonLista(listaRes);
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

		
}
