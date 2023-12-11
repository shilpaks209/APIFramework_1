package core;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class RandomData {

	public String getRandomEmail() {
		FakeValuesService fakeValueService= new FakeValuesService(new Locale("en-GB"), new RandomService());
		String email = fakeValueService.bothify("????##@gmail.com");
		System.out.println(email);
		return email;
	}
	
	public String getRandomPhoneNo() {
		
		 // FakeValuesService fakeValueService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		Faker faker = new Faker(new Locale("us")); // Use the US locale
		String phoneNumber = faker.phoneNumber().cellPhone();

        System.out.println(phoneNumber);
        return phoneNumber;
	}
	
	public String getRandomAddress() {
		Faker faker=new Faker();
		String email = faker.address().fullAddress();
		System.out.println(email);
		return email;
	}
}
