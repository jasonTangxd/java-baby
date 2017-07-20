// Doesn't creates unnecessary duplicate objects - page 21
package com.effectivejava.chapter02.item05.fastversion;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class Person {
	private final Date birthDate;

	public Person(Date birthDate) {
		// Defensive copy - see Item 39
		this.birthDate = new Date(birthDate.getTime());
	}

	// Other fields, methods

	/**
	 * The starting and ending dates of the baby boom.
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}

	public boolean isBabyBoomer() {
		return birthDate.compareTo(BOOM_START) >= 0
				&& birthDate.compareTo(BOOM_END) < 0;
	}


	//Map接口的keySet方法返回该Map对象的Set视图，每次调用keySet都返回同样的Set实例。
	//当其中一个返回对象发生变化时，所以其他的返回对象也要发生 变化。
}
