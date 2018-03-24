package service;

import dao.IDao;

public class ServiceDaoPlus implements IService {

	@Override
	public void serviceDao(IDao dao) {
		System.out.println("ServiceDaoPlus:serviceDao");
		dao.delete();
	}	
}
