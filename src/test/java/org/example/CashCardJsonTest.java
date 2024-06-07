package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class CashCardJsonTest {

	@Autowired
	private JacksonTester<CashCard> json;

	@Test
	void cashCardSerializationTest() throws IOException {
		CashCard cashCard = new CashCard(99L, 123.45);
		// The isStrictlyEqualToJson method is used to compare the actual JSON output with the expected JSON.
		assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");

		// The hasJsonPathStringValue method is used to check if
		// the JSON output contains a specific value at a specific path.
		assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");

		// The extractingJsonPathStringValue method is used to extract a specific value from the JSON output.
		assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
				.isEqualTo(99);

		assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");

		assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
				.isEqualTo(123.45);
	}
}