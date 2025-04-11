package api;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONParserConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import oracle.jdbc.driver.configuration.JsonParser;

// CRUD

/* 
 * jackson => ajax => JSON, GSON 라이브러리
 * /api/data.do/{data}
 * @PutMapping - C 
 * @DeleteMapping - D
 * @PatchMapping - U
 * 
 * @GetMapping,@PostMapping -R (HTML 형식) => JSON 허락 예) /api/data.do/
 * 
 * 
 * 
 * Front-end (DTO) name => Mybatis => insert
 * 1. Mybatis => DTO => insert
 * 2. Map<k,v> => Mybatis => insert
 * 
 * */

@Controller // @RestController :  API 전용
public class api_controller {
	// log로 문제사항 및 실행사항을 체크하는 라이브러리
	private static final Logger logger = LoggerFactory.getLogger(api_controller.class);
	/*
	 * this.logger.info : 해당 메소드에서 실행된 값을 출력하는 역할 this.logger.error : catch에서 사용하는
	 * 형태 error발생시 출력되는 메세지 this.logger.debug : 해당 코드가 정상적으로 작동하는 테스트 메세지를 출력할 때 씀
	 * this.logger.trace : 해당 코드에 문제가 발생 시 좀 더 상세하게 문제사항을 출력 this.logger.warn : 현재
	 * 코드에 대해서 향후 문제가 발생될 수 있는 원인에 대한 메세지 출력 this.logger.fatal : 치명적인 오류 발생 시 출력되는
	 * 역할
	 */
	// js - Ajax(GET)
	PrintWriter pw = null;
	
	@Resource(name="api_dao")
	api_dao dao;

	@PutMapping("/ajax/ajax14/{key}")		//insert (DTO기본)
	public String ajax14(ServletResponse res,
			             @PathVariable(name = "key") String key,
			             @RequestBody String data
			) {
		try {
			this.pw = res.getWriter();
			if (key.equals("a123456")) {
				this.logger.info(data);
				/*Map<String,String> mp = new HashMap<String,String>();
				JSONObject jo = new JSONObject(data);
				Iterator<String> keys = jo.keys();
				while (keys.hasNext()) {
					String keynm = keys.next(); // 키 명
					mp.put(keynm, jo.getString(keynm).toString());*/
				//}
				//int result = this.dao.api_mapper(mp);
				//this.logger.info(String.valueOf(result));
				this.pw.write("ok");
				//this.logger.info(mp.toString());

			} else {
				this.pw.write("key error");
			}

		} catch (Exception e) {

		}
		return null;
	}

	// @RequestPart  : MultipartFile
	// @RequestParam : name 또는 파라미터
	// @ResponseBody : method 선언 시 Mapping과 함께 사용
	//               : 응답에 대한 결과값을 해당 메소드에 바로 출력할 때 사용
	// @RequestBody  : 배열값을 처리하는 어노테이션
	// FormData() => @RequestBody
	@DeleteMapping("/ajax/ajax13/{key}") //delete
    public String ajax13(ServletResponse res, 
          @PathVariable(name = "key") String key,
          @RequestBody String midx
          //@RequestBody String midx 
             ) {
       try {
          this.pw = res.getWriter();
          if (key.equals("a123456")) {
             this.logger.info(midx);
             
             this.pw.write("delete_ok");
          } else {
             this.pw.write("key error");
          }
       } catch (Exception e) {
          this.pw.write("error");
       }
       return null;
    }
    

	/*
	 * @PathVariable : URL 파라미터 값을 가져오는 어노테이션 {id} 가상의 파라미터 값 JSON.stringify에 대한
	 * 정보값을 처리하지 못함
	 */
	@PatchMapping("/ajax/ajax12.do/{data}")
//	public String ajax12(@PathVariable(name="data") String mid, ServletResponse res) {	//하나만 보낼때, 배열로 보낼때 
	public String ajax12(@PathVariable(name = "data") String data, @RequestBody String myinfo, ServletResponse res) { // JSON으로
																														// 보낼때
		try {
			/*
			 * 하나만 보낼때, 배열로 보낼때 String user[] = mid.split(","); this.logger.info(user[1]);
			 * this.logger.info(user[2]);
			 */

			this.pw = res.getWriter();
			if (data.equals("patch_myinfo")) {
				this.logger.info(myinfo);
				this.pw.write("ok");
			} else {
				this.pw.write("error");
			}

		} catch (Exception e) {

		}
		return null;
	}

	// ECMA - POST 통신 (배열방식) - array
	@PostMapping("/ajax/ajax11.do")
	/*
	 * JSON.stringify => 전송 시 public String ajax11(HttpServletResponse
	 * res, @RequestBody String data) {
	 */
	/* public String ajax11(HttpServletResponse res, @RequestBody String data) { */
	public String ajax11(HttpServletResponse res, @ModelAttribute api_dto dto) {
		try {
			this.logger.info(dto.getMid().toString());
			this.logger.info(dto.getMname().toString());
			this.logger.info(dto.getMage().toString());
			this.pw = res.getWriter();
			this.pw.write("ok");

		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// ECMA - Ajax(POST)
	@PostMapping("/ajax/ajax10.do")
	public String ajax10(HttpServletResponse res, @RequestParam(name = "mid") String mid) {
		try {
			this.logger.info(mid);
			this.pw = res.getWriter();
			this.pw.write("ok");

		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// ECMA - Ajax(GET)
	@GetMapping("/ajax/ajax9.do")
	public String ajax9(HttpServletResponse res, @RequestParam(name = "mid") String mid) {
		try {
			this.logger.info(mid);
			this.pw = res.getWriter();
			this.pw.write("ok");

		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// value = "name값 명", defaultValue = "기본값", required = false (필수가 아님) - Ajax
	// FormData()
	@PostMapping("/ajax/ajax8.do")
	public String ajax8(@RequestParam(value = "fdata", defaultValue = "", required = false) String fdata,
			HttpServletResponse res) {
		try {
			System.out.println(fdata);
			String rdata[] = fdata.split(",");
			this.logger.info(rdata[0]);
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}

		return null;
	}

	// 각각의 다른 키로 POST 전송 시 (JQuery) = DTO
	// Front-end에서 파라미터 형태로 문자열 기준으로 POST 전송 시 Back-end에서는 dto로 활성화
	@PostMapping("/ajax/ajax7.do")
	public String ajax7(ServletResponse res, api_dto dto) {
		try {
			this.logger.info(dto.getPd1());
			this.logger.info(dto.getPd4());
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// Jquery=Ajax (POST) => JSON.stirngify (대표키가 없는 경우)
	@PostMapping("/ajax/ajax6.do")
	public String ajax6(ServletResponse res, @RequestBody String all_data) {
		try {
			this.logger.info(all_data);
			// 대표키가 있는 경우
			JSONObject jo = new JSONObject(all_data);
			this.logger.info(jo.get("userdata").toString());
			// JSONArray ja = new JSONArray(all_data);
			// this.logger.info(ja.get(0).toString(0));
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// Jquery - 배열값을 GET으로 받아서 처리한 메소드
	@GetMapping("/ajax/ajax5.do")
	public String ajax5(ServletResponse res, @RequestParam("no") String no) {
		try {
			this.logger.info(no);

			JSONArray ja = new JSONArray(no);
			int w = 0;
			while (w < ja.length()) {
				this.logger.info(ja.getString(w).toString());
				w++;
			}

			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// DTO => {"pd1":"", "pd2":""}

	// JSON.stringify : Front-end가 전송 시 무조건 @RequestBody 처리
	@PostMapping("/ajax/ajax4.do")
	public String ajax4(ServletResponse res, @RequestBody String pd) {
		try {
			this.logger.info(pd);
			JSONArray ja = new JSONArray(pd); // {}
			int w = 0;
			while (w < ja.length()) {
				JSONObject jo = (JSONObject) ja.get(w);
				String usernm = jo.get("pd" + (w + 1)).toString();
				this.logger.info(usernm);
				w++;
			}

			this.pw = res.getWriter();
			this.pw.write("ok"); // 응답 문자열
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	/*
	 * @RequestHeader : Ajax에서만 사용한느 Headers의 값이며, 키에 맞는 데이터를 가져올 수 있음 Front-end :
	 * setRequestHeader에 key, value값을 보낼 경우에만 사용함
	 * 
	 * @RequestBody : content-type, application/json 으로 전송했을 경우
	 */
	@PostMapping("/ajax/ajax3.do")
	public String ajax3(ServletResponse res, @RequestBody String pd) {

		this.logger.info(pd);

		try {
			this.pw = res.getWriter();
			this.pw.print("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// Array 형태로 전송 시 GET 형태의 메소드와 동일하게 POST 값을 처리하면 됨
	@PostMapping("/ajax/ajax2.do")
	public String ajax2(ServletResponse res, @RequestParam(name = "product") String pd[],
			@RequestParam(name = "person") String person) {
		try {
			this.logger.info(person);
			this.logger.info(pd[0]);
			this.pw = res.getWriter();
			this.pw.write("ok");

		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}

	// 문자열 + ok,no,error => GET (product)
	@GetMapping("/ajax/ajax1.do")
	public String ajax1(@RequestParam(name = "product") String data[], HttpServletResponse res) {
		// Front-end에서 보낸 name을 원시배열로 받을 경우 자동으로 배열로 변경처리
		// 단, String으로 배열 자료형을 사용하지 않을 경우 split을 이용하여 값을 분리 시켜야 함
		this.logger.info(data[0]);
		this.logger.info(data[1]);
		this.logger.info(data[2]);
		try {
			this.pw = res.getWriter();
			this.pw.print("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}

		return null;
	}
}
