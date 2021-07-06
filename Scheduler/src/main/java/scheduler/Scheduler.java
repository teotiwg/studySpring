package scheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	/*
	cron 설정
	형식 : 초   분   시   일   월   요일 연도
		=> 0~59 0~59 0~23 1~31 1~12 0~6  연도(생략가능)
		
	설정예)
		(cron = "0/10 * * * * *") => 매 10초마다 호출
		(cron = "0 45 11 * * *") => 매일 11시 45분에 호출
	
	요일의 경우 0(일요일)~6(토요일)
	 */
	@Scheduled(cron = "0/10 * * * * *")
	public void myAutoUpdate() {
		//시간에 대한 포맷 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		//현재 시간을 위에서 설정한 포맷으로 변경 후 출력
		String nowTime = LocalTime.now().format(formatter);
		System.out.println("스케쥴러 자동 호출:"+ nowTime);
	}
}
