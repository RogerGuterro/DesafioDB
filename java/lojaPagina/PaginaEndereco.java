package lojaPagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaEndereco {
	public WebDriver driver;

	public PaginaEndereco(WebDriver driver) {
		this.driver = driver;
	}

	public String obterTituloDaPaginaEndereco(){
		return driver.findElement(By.xpath("//*[text()='Create an account']")).getText();
	}

	public String obterSubTituloSuasInformacoesPessoaisDaPaginaEndereco(){
		return driver.findElement(By.xpath("//*[@id='account-creation_form']//*[text()='Your personal information']")).getText();
	}

	public void clicarRadioSrPaginaInformacoesPessoais(){
		driver.findElement(By.id("id_gender1")).click();
	}

	public void preencherPrimeiroNomePaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("customer_firstname")).sendKeys(valor);
	}

	public void preencherSobrenomePaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("customer_lastname")).sendKeys(valor);
	}

	public void preencherEmailPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("email")).sendKeys(valor);
	}

	public void preencherSenhaPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("passwd")).sendKeys(valor);
	}

	public void clicarComboDiaDataNascimentoPaginaInformacoesPessoais(){
		driver.findElement(By.id("days")).click();
	}

	public void clicarDiaPrimeiroDataNascimentoPaginaInformacoesPessoais(){
		driver.findElement(By.xpath("//*[@id='days']//*[@value='1']")).click();
	}

	public void clicarComboMesDataNascimentoPaginaInformacoesPessoais(){
		driver.findElement(By.id("months")).click();
	}

	public void clicarMesPrimeiroDataNascimentoPaginaInformacoesPessoais(){
		driver.findElement(By.xpath("//*[@id='months']//*[@value='1']")).click();
	}

	public void clicarComboAnoDataNascimentoPaginaInformacoesPessoais(){
		driver.findElement(By.id("years")).click();
	}

	public void clicarAnoPrimeiroDataNascimentoPaginaInformacoesPessoais(){
		driver.findElement(By.xpath("//*[@id='years']//*[@value='2000']")).click();
	}

	public void clicarAssineNewsletterPaginaInformacoesPessoais(){
		driver.findElement(By.id("newsletter")).click();
	}

	public void clicarRecebaNossasOfertasPaginaInformacoesPessoais(){
		driver.findElement(By.id("optin")).click();
	}

	public void preencherPrimeiroNomeSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("firstname")).sendKeys(valor);
	}

	public void preencherSobrenomeSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("lastname")).sendKeys(valor);
	}

	public void preencherCompanhiaSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("company")).sendKeys(valor);
	}

	public void preencherEnderecoSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("address1")).sendKeys(valor);
	}

	public void preencherEnderecoLinha2SeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("address2")).sendKeys(valor);
	}

	public void preencherCidadeSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("city")).sendKeys(valor);
	}

	public void clicarComboEstadoPaginaInformacoesPessoais(){
		driver.findElement(By.id("id_state")).click();
	}

	public void clicarOpcaoArizonaEnderecoPaginaInformacoesPessoais(){
		driver.findElement(By.xpath("//*[@id='id_state']//*[@value='3']")).click();
	}

	public void preencherCepSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("postcode")).sendKeys(valor);
	}	

	public void clicarComboPaisPaginaInformacoesPessoais(){
		driver.findElement(By.id("id_country")).click();
	}

	public void preencherInformacoesAdicionaisSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("other")).sendKeys(valor);
	}	

	public void preencherTelefoneResidencialSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("phone")).sendKeys(valor);
	}	

	public void preencherTelefoneCelularSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("phone_mobile")).sendKeys(valor);
	}	

	public void preencherEnderecoAlternativoSeuEnderecoPaginaInformacoesPessoais(String valor){
		driver.findElement(By.id("alias")).sendKeys(valor);
	}	

	public void clicarBotaoRegistroPaginaInformacoesPessoais(){
		driver.findElement(By.id("submitAccount")).click();
	}

	public String obterMensagemCampoObrigatorioPaginaEndereco(){
		return driver.findElement(By.cssSelector(".alert-danger")).getText();
	}	

	public void fazerCadastroComSucesso() throws Exception{
		this.clicarRadioSrPaginaInformacoesPessoais();
		this.preencherPrimeiroNomePaginaInformacoesPessoais("Suzana");
		this.preencherSobrenomePaginaInformacoesPessoais("Voltz");
		this.preencherSenhaPaginaInformacoesPessoais("123456");
		this.clicarComboDiaDataNascimentoPaginaInformacoesPessoais();
		this.clicarDiaPrimeiroDataNascimentoPaginaInformacoesPessoais();
		this.clicarComboMesDataNascimentoPaginaInformacoesPessoais();
		this.clicarMesPrimeiroDataNascimentoPaginaInformacoesPessoais();
		this.clicarComboAnoDataNascimentoPaginaInformacoesPessoais();
		this.clicarAnoPrimeiroDataNascimentoPaginaInformacoesPessoais();
		this.clicarAssineNewsletterPaginaInformacoesPessoais();
		this.clicarRecebaNossasOfertasPaginaInformacoesPessoais();
		this.preencherCompanhiaSeuEnderecoPaginaInformacoesPessoais("haha");
		this.clicarComboEstadoPaginaInformacoesPessoais();
		this.clicarOpcaoArizonaEnderecoPaginaInformacoesPessoais();
		this.preencherEnderecoSeuEnderecoPaginaInformacoesPessoais("rua dos ruas , 15, 020, 005");
		this.preencherEnderecoLinha2SeuEnderecoPaginaInformacoesPessoais("hahaha , hahaha");
		this.preencherCidadeSeuEnderecoPaginaInformacoesPessoais("california");
		this.preencherCepSeuEnderecoPaginaInformacoesPessoais("00000");
		this.preencherInformacoesAdicionaisSeuEnderecoPaginaInformacoesPessoais("Nao possui");
		this.preencherTelefoneResidencialSeuEnderecoPaginaInformacoesPessoais("275275727");
		this.preencherTelefoneCelularSeuEnderecoPaginaInformacoesPessoais("272752752752");
		this.preencherEnderecoAlternativoSeuEnderecoPaginaInformacoesPessoais("rua dos ruasislek, 0");
		this.clicarBotaoRegistroPaginaInformacoesPessoais();
	}
}
