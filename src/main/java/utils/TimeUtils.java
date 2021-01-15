package utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class TimeUtils {
	
	public static boolean isOver24Hours(LocalDateTime localDateTime) {
		
		if (localDateTime.isBefore(LocalDateTime.now().minus(24,ChronoUnit.HOURS))){
			return true;
		}
		return false;
	}
}
