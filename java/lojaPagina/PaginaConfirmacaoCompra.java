package lojaPagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaConfirmacaoCompra {
	public WebDriver driver;

	public PaginaConfirmacaoCompra(WebDriver driver) {
		this.driver = driver;
	}

	public String obterTituloDaPaginaRemessa(){
		return driver.findElement(By.xpath("//*[text()='Shipping']")).getText();
	}	

	public String obterTermosDeUsoPaginaRemessa(){
		return driver.findElement(By.xpath("//*[@class='checkbox']//*[@for='cgv']")).getText();
	}	

	public String obterTituloDaPaginaMetodoPagamento(){
		return driver.findElement(By.xpath("//*[text()='Please choose your payment method']")).getText();
	}	

	public void clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete(){
		driver.findElement(By.id("cgv")).click();
	}

	public void clicarBotaoCheckOutPaginaFrete(){
		driver.findElement(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']//*[@class='icon-chevron-right right']")).click();
	}

	public String obterValorTotalDeProdutos(){
		return driver.findElement(By.id("total_product")).getText();
	}

	public String obterValorEnvioTotalDaCompra(){
		return driver.findElement(By.id("total_shipping")).getText();
	}

	public String obterValorTotalDaCompra(){
		return driver.findElement(By.id("total_price")).getText();
	}

	public void clicarCardPagamentoTransferenciaBancariaPaginaMetodoPagamento(){
		driver.findElement(By.cssSelector(".bankwire")).click();
	}

	public void clicarCardPagamentoEmChequePaginaMetodoPagamento(){
		driver.findElement(By.cssSelector(".cheque")).click();
	}

	public String obterPagamentoTransferenciaBancariaPaginaConfirmacaoDaCompra(){
		return driver.findElement(By.xpath("//*[@class='box cheque-box']//*[@class='page-subheading']")).getText();
	}

	public void clicarBotaoEuConfirmoMeuPedidoPaginaConfirmacaoDaCompra(){
		driver.findElement(By.xpath("//*[@class='button btn btn-default button-medium']//*[@class='icon-chevron-right right']")).click();
	}

	public String obterConfirmacaoDePedido(){
		return driver.findElement(By.xpath("//*[@class='cheque-indent']//*[@class='dark']")).getText();
	}

	public String obterValorTotalDoPedidoPaginaResumoDoPedido(){
		return driver.findElement(By.id("amount")).getText();
	}

	public String obterAlertDePedidoConcluidoComSucessoPaginaConfirmacaoDePedidoPagamentoCheque(){
		return driver.findElement(By.cssSelector(".alert-success")).getText();
	}

	public String obterAlertDePedidoConcluidoComSucessoPaginaConfirmacaoDePedidoPagamentoTransferencia(){
		return driver.findElement(By.cssSelector(".cheque-indent")).getText();
	}

	public String obterTituloDeInformacoesSobreChequePaginaConfirmacaoDePedido(){
		return driver.findElement(By.cssSelector(".page-subheading")).getText();
	}

	public void clicarBotaoDeVoltaAsEncomendasConfirmacaoDaCompra(){
		driver.findElement(By.xpath("//*[@class='button-exclusive btn btn-default']//*[@class='icon-chevron-left']")).click();
	}

	public String obterStatusDaCompraPaginaHistoricoDePedido(){
		return driver.findElement(By.xpath("//*[@class='history_state footable-last-column']//*[@class='label dark']")).getText();
	}
}
