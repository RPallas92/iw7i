package iw7i.bigws.hellows;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
public class HelloWebService {
	
	private String ps = null;
	
    @PostConstruct
    private void init() {
        ps = "PostContruct";
    }
	@WebMethod()
	public String sayHello(String name) {
		return "Hello "+name + ps;
	}

    @PreDestroy
    private void destroy() {
        ps = "PostContruct";
    }
}
