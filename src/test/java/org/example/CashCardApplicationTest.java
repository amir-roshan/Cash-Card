package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CashCardApplicationTests {

	@Test
	void myFirstTest() {
		// This is a failing test
		assertThat(1).isEqualTo(42);
	}
	@Test
	void mySecondTest() {
		// This is a passing test
		assertThat(42).isEqualTo(42);
	}

}