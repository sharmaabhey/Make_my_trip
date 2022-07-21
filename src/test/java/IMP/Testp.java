package IMP;


import java.util.HashMap;

import org.testng.annotations.Test;


import mytrip.BAset;
import mytrip.Booking;
import mytrip.Home;
import mytrip.Submit;

public class Testp extends BAset {
	
HashMap<String,String> umap = new HashMap<String,String>();
	
	
	
	
	
	@Test
	
	public void gettr() throws Exception {
		
		umap.put("from", "pune,india");
		umap.put("to", "Delhi,india");
		umap.put("from2", "mumbai");
		umap.put("to2", "bangkok");
		umap.put("mobilenumber", "1234567890");
		umap.put("email", "xyz@gmail.com");
		umap.put("selectdate", "19,August 2022");
		
		
		Home h = new Home(driver);
		h.cancelingpopup();
		h.from(umap.get("from"));
		h.to(umap.get("to"));
		h.Setdate(umap.get("selectdate"));
		h.search();
		
		
		Booking b = new Booking(driver);
		b.cancelalert();
		Thread.sleep(2000);
		b.nonstop();
		b.viewpriceandbook();
		
		
		Submit sub = new Submit(driver);
		sub.promocode();
		Thread.sleep(2000);
		sub.securetrip();
		Thread.sleep(2000);
		sub.scroll();
		Thread.sleep(2000);
		sub.mobilenumber(umap.get("mobilenumber"));
		Thread.sleep(2000);
		sub.email(umap.get("email"));
		Thread.sleep(5000);
		
		
		
}
}