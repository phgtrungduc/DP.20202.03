package subsystem.interbank;

import common.exception.UnrecognizedException;
import utils.ApplicationProgrammingInterface;
// Ap dung Singleton
public class InterbankBoundary {

	private static InterbankBoundary instance;

		private  InterbankBoundary(){

		}
		public static InterbankBoundary getInstance(){
			if(instance == null) instance = new InterbankBoundary();
			return instance;
		}


	String query(String url, String data) {
		String response = null;
		try {
			response = ApplicationProgrammingInterface.post(url, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UnrecognizedException();
		}
		return response;
	}

}
