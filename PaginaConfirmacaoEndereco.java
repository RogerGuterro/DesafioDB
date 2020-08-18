package lojaPagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaConfirmacaoEndereco {
	public WebDriver driver;

	public PaginaConfirmacaoEndereco(WebDriver driver) {
		this.driver = driver;
	}

	public String obterNomeCompletoPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_firstname address_lastname']")).getText();
	}

	public String obterCompanhiaPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_company']")).getText();
	}

	public String obterEnderecoPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_address1 address_address2']")).getText();
	}

	public String obterCidadeEstadoCepPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_city address_state_name address_postcode']")).getText();
	}

	public String obterPaisPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_country_name']")).getText();
	}

	public String obterTelefoneResidencialPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_phone']")).getText();
	}

	public String obterTelefoneCelularPaginaConfirmacaoEndereco(){
		return driver.findElement(By.xpath("//*[@id='address_delivery']//*[@class='address_phone_mobile']")).getText();
	}

	public void clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco(){
		driver.findElement(By.xpath("//*[@class='button btn btn-default button-medium']//*[@class='icon-chevron-right right']")).click();
	}
}
