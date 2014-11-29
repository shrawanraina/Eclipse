package learn.webservice;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class webservice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1){
			System.out.println("No input");
		}
		else{
			String ip = args[0];
			GeoIPService geoipservice = new GeoIPService();
			GeoIPServiceSoap geoipservicesoap = geoipservice.getGeoIPServiceSoap();
			GeoIP geoip = geoipservicesoap.getGeoIP(ip);
			System.out.println(geoip.getCountryName());
		}
	}

}
