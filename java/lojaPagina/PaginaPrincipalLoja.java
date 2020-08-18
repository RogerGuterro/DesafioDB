package lojaPagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaPrincipalLoja {
	public WebDriver driver;

	public PaginaPrincipalLoja(WebDriver driver) {
		this.driver = driver;
	}

	public void clicarBotaoAdicionarCarrinhoPaginaInicial(){
		driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")).click();
	}

	public String obterProdutoCamisetasDeMangaAdicionadoNoCarrinho(){
		return driver.findElement(By.xpath("//*[@class='layer_cart_product_info']//*[text()='Faded Short Sleeve T-shirts']")).getText();
	}

	public String obterValorDoProdutoCamisetasDeMangaAdicionadoNoCarrinho(){
		return driver.findElement(By.id("layer_cart_product_price")).getText();
	}

	public void clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso(){
		driver.findElement(By.xpath("//*[@class='btn btn-default button button-medium']//*[@class='icon-chevron-right right']")).click();
	}

	public String obterProdutoCamisetasDeMangaAdicionadoCorretamentePaginaResumoDoCarrinho(){
		return driver.findElement(By.xpath("//*[@class='product-name']//*[text()='Faded Short Sleeve T-shirts']")).getText();
	}

	public String obterTituloQuantidadeDeProdutosNoCarrinhoPaginaResumoDoCarrinho(){
		return driver.findElement(By.xpath("//*[@id='cart_title']//*[@class='heading-counter']")).getText();
	}

	public void clicarBotaoFazerCheckOutPaginaResumoDoCarrinho(){
		driver.findElement(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']//*[@class='icon-chevron-right right']")).click();
	}

	public String obterTituloDaPaginaAutenticacao(){
		return driver.findElement(By.xpath("//*[text()='Authentication']")).getText();
	}	

	public String obterTituloCrieSuaContaAquiDaPaginaAutenticacao(){
		return driver.findElement(By.xpath("//*[@id='create-account_form']//*[@class='page-subheading']")).getText();
	}	

	public String obterMensagemDeEmailInvalidoPaginaAutenticacao() throws InterruptedException{
		Thread.sleep(2000);
		return driver.findElement(By.id("create_account_error")).getText();
	}	

	public void preencherEnderecoDeEmailCardCrieSuaConta(String valor){
		driver.findElement(By.id("email_create")).sendKeys(valor);
	}

	public void preencherEmailCardClienteJaRegistrado(String valor){
		driver.findElement(By.id("email")).sendKeys(valor);
	}

	public void preencherSenhaCardClienteJaRegistrado(String valor){
		driver.findElement(By.id("passwd")).sendKeys(valor);
	}

	public void clicarBotaoAssinarEmCardClienteJaRegistrado(){
		driver.findElement(By.id("SubmitLogin")).click();
	}

	public void clicarBotaoCrieSuaContaAquiPaginaAutenticacao(){
		driver.findElement(By.id("SubmitCreate")).click();
	}
}
