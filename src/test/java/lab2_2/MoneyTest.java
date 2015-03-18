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
	
	@Test
	public void addMoney_shouldBeTrue() {
		Money money1 = new Money(5.00, "PLN");
		Money money2 = new Money(1.00, "PLN");
		Money expected = new Money(6.00, "PLN");
		
		assertThat(money1.add(money2), is(expected));		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addMoneyWrongCurrency_shouldBeException() {
		Money money1 = new Money(5.00, "PLN");
		Money money2 = new Money(1.00, "EUR");
		money1.add(money2);		
	}
	

	@Test
	public void subtractMoney_shouldBeTrue() {
		Money money1 = new Money(5.00, "PLN");
		Money money2 = new Money(0.00, "PLN");
		Money expected = new Money(5.00, "PLN");
		
		assertThat(money1.add(money2), is(expected));		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void subtractMoneyWrongCurrency_shouldBeException() {
		Money money1 = new Money(1.00, "PLN");
		Money money2 = new Money(2.00, "EUR");
		money1.add(money2);		
	}
	
	@Test
	public void greaterThan_shouldBeTrue(){
		Money money1 = new Money(2.50, "PLN");
		Money money2 = new Money(0.00, "PLN");
		boolean excepted = true;
		
		assertThat(money1.greaterThan(money2), is(excepted));
	}
	
	@Test
	public void greaterThan_shouldBeFalse(){
		Money money1 = new Money(2.50, "PLN");
		Money money2 = new Money(2.50, "PLN");
		boolean excepted = false;
		
		assertThat(money1.greaterThan(money2), is(excepted));
	}
	
	@Test
	public void lessThan_shouldBeTrue(){
		Money money1 = new Money(2.50, "PLN");
		Money money2 = new Money(5.00, "PLN");
		boolean excepted = true;
		
		assertThat(money1.lessThan(money2), is(excepted));
	}
	
	@Test
	public void lessThan_shouldBeFalse(){
		Money money1 = new Money(2.50, "PLN");
		Money money2 = new Money(2.50, "PLN");
		boolean excepted = false;
		
		assertThat(money1.lessThan(money2), is(excepted));
	}
}
