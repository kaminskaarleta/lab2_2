package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicy;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BookKeeperTest {

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
	public void issuanceTest_shouldBeTrue() {
		BookKeeper bookKeeper = new BookKeeper();
		InvoiceRequest invoiceRequest = new InvoiceRequest(new ClientData(Id.generate(), "Arleta"));
		//nie mozna dodac RequestItem do invoiceRequest poniewaz RequestItem przyjmuje jako parametr ProductData
		//ktory nie ma publicznego konstruktora ani zadnej fabryki która pozwoli na stworzenie obiektu
		
		
		TaxPolicy taxPolicy = (TaxPolicy) new Tax(new Money(23.00, "PLN"), "PLN tax");
		Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
		assertThat(invoice.getGros(), is(new Money(0, "PLN")));
		assertThat(invoice.getNet(), is(new Money(0, "PLN")));
	}

}
