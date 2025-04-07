package api;

import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class api_controller {
	// log로 문제사항 및 실행사항을 체크하는 라이브러리
		private static final Logger logger = LoggerFactory.getLogger(api_controller.class);
		/*
		 this.logger.info : 해당 메소드에서 실행된 값을 출력하는 역할
		 this.logger.error : catch에서 사용하는 형태 error발생시 출력되는 메세지
		 this.logger.debug : 해당 코드가 정상적으로 작동하는 테스트 메세지를 출력할 때 씀
		 this.logger.trace : 해당 코드에 문제가 발생 시 좀 더 상세하게 문제사항을 출력
		 this.logger.warn : 현재 코드에 대해서 향후 문제가 발생될 수 있는 원인에 대한 메세지 출력
		 this.logger.fatal : 치명적인 오류 발생 시 출력되는 역할
		 */
		// js - Ajax(GET)
		PrintWriter pw = null;
		
		// Array 형태로 전송 시 GET 형태의 메소드와 동일하게 POST 값을 처리하면 됨
		@PostMapping("/ajax/ajax2.do")
		public String ajax2(ServletResponse res,@RequestParam(name="product")String pd[], @RequestParam(name="product")String person) {
			try {
				this.logger.info(person);
				this.logger.info(pd[0]);
				this.pw = res.getWriter();
				this.pw.write("ok");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		// 문자열 + ok,no,error => GET (product)
		@GetMapping("/ajax/ajax1.do")
		public String ajax1(@RequestParam(name="product")String data[], HttpServletResponse res) {
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










