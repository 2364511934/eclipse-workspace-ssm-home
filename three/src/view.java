import dao.DaoPlus;
import dao.DaoSub;
import dao.IDao;
import service.IService;
import service.ServiceDaoPlus;

public class view {

	public static void main(String[] args) {
		IService service = new ServiceDaoPlus();
		IDao dao = new DaoSub();
		service.serviceDao(dao);
	}

}
