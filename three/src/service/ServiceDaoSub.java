package service;

import dao.IDao;

public class ServiceDaoSub  implements IService{

	@Override
	public void serviceDao(IDao dao) {
		System.out.println("ServiceDaoSub:serviceDao");
		dao.delete();
	}
	
}
