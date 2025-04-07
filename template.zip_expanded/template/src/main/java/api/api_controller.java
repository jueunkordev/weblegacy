package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		@GetMapping("/ajax/ajax1.do")
		public String ajax1() {
			this.logger.info("test");
			return null;
		}
}
