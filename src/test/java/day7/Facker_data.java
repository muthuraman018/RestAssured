package day7;

import com.github.javafaker.Faker;

public class Facker_data {
	void dummy_data() {
		Faker fake = new Faker();
		String name = fake.name().fullName();
		String new_name = fake.name().firstName();
		String last_name = fake.name().lastName();
		String phone = fake.phoneNumber().phoneNumber();
		String email = fake.internet().emailAddress();
	}

}
