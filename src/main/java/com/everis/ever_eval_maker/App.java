package com.everis.ever_eval_maker;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	for (int i = 0; i < 10; i++) {
    		generateRandomData();
		}
    }
    
    public static void generateRandomData() {
    	
    	FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
    	
    	Faker faker = new Faker();

//    	String email = fakeValuesService.bothify("??????#####@gmai.com");
//    	Matcher emailMatcher = Pattern.compile("\\w{4}\\d{2}@gmail.com").matcher(email);

    	String firstName = faker.name().firstName();
    	String lastName = faker.name().lastName();
    	String email = fakeValuesService.bothify(firstName.toLowerCase()+ "." + lastName.toLowerCase() + "#####@gmai.com");
    	String role = randomRoleSelect();
    	String password = "123456";
    	String picture = "/images/profile/image.jpg";
    	

    	System.out.println(firstName);
    	System.out.println(lastName);
    	System.out.println(email);
    	System.out.println(role);
    	System.out.println(password);
    	System.out.println(picture);
    	System.out.println("---------------------");
    }
    
    public static String randomRoleSelect() {
    	Random rand = new Random();
    	int n = rand.nextInt(3);
    	n += 1;
    	
    	String role = null;

    	switch (n) {
			case 1:
				role = "Admin";
				break;
			case 2:
				role = "HR";
				break;
			case 3:
				role = "EVALUATOR";
				break;
		}
    	
		return role;
    }
}
