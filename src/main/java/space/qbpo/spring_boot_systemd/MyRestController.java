package space.qbpo.spring_boot_systemd;

import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/")
@Profile (value = {"web"})
public class MyRestController {

	public static class MyResponse {
		private String fstring;
		private Integer finteger;

		public String getFstring() {
			return this.fstring;
		}		

		public Integer getFinteger() {
			return this.finteger;
		}

		public void setFstring(String fstring) {
			this.fstring = fstring;
		}

		public void setFInteger(Integer finteger) {
			this.finteger = finteger;
		}
	}

	@CrossOrigin
	@RequestMapping (value = "hello", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST) 
	public MyResponse hello () {
		MyResponse response = new MyResponse();
		response.setFInteger(0);
		response.setFstring("Hello");
		return response;
	}
	
}
