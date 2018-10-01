package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

	public static void main(String[] args) {
		String logMsg = "log test ..";
		Logger logger = LoggerFactory.getLogger("my");
		logger.info(logMsg);

	}
}
