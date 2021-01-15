package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class TimeUtilsTest {

	@Test
	void test() {
		
		LocalDateTime time = LocalDateTime.now().minus(3,ChronoUnit.MINUTES);
		assertFalse(TimeUtils.isOver24Hours(time));
		
		time = LocalDateTime.now().minus(3,ChronoUnit.DAYS);
		assertTrue(TimeUtils.isOver24Hours(time));
	}

}
