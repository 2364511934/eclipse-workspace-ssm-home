package action;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListenr implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestListenr£ºrequestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestListenr:requestInitialized");
	}

}
