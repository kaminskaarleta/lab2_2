package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void multiplyBy2_shouldBeTrue() {
		Money money = new Money(5.00, "PLN");
		double number = 2.00;
		double expected = 10.00;
		
		assertThat(money.multiplyBy(number), is(new Money(expected, "PLN")));	
	}
	
	@Test
	public void multiplyBy2_WrongCurrency_shouldBeFalse() {
		Money money = new Money(5.00, "PLN");
		double number = 2.00;
		double expected = 10.00;
		
		assertThat(money.multiplyBy(number), is(not (new Money(expected, "EUR"))));		
	}
	
}
