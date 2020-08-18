package lojaTestes.test;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import lojaPagina.PaginaPrincipalLoja;
import lojaPagina.PaginaConfirmacaoCompra;
import lojaPagina.PaginaConfirmacaoEndereco;
import lojaPagina.PaginaEndereco;

public class LojaTestes {
	public WebDriver driver;
	lojaPagina.PaginaPrincipalLoja loja ;
	lojaPagina.PaginaEndereco endereco ;
	lojaPagina.PaginaConfirmacaoEndereco confEndereco ;
	lojaPagina.PaginaConfirmacaoCompra confCompra ;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");	
		loja = new PaginaPrincipalLoja(driver);
		endereco = new PaginaEndereco(driver);
		confEndereco = new PaginaConfirmacaoEndereco(driver);
		confCompra = new PaginaConfirmacaoCompra(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


	//Teste para validar se produto foi adicionado corretamente ao carrinho
	@Test
	public void validarQueProdutoFoiAdicionadoCorretamenteNoCarrinho() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		assertEquals("Faded Short Sleeve T-shirts",loja.obterProdutoCamisetasDeMangaAdicionadoNoCarrinho());
		assertEquals("$16.51",loja.obterValorDoProdutoCamisetasDeMangaAdicionadoNoCarrinho());
	}

	//Teste para validar se produto foi adicionado corretamente ao Resumo do Carrinho
	@Test
	public void validarQueProdutoFoiAdicionadoCorretamenteAoResumoDoCarrinho() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		assertEquals("Faded Short Sleeve T-shirts",loja.obterProdutoCamisetasDeMangaAdicionadoCorretamentePaginaResumoDoCarrinho());
		assertEquals("Your shopping cart contains: 1 Product",loja.obterTituloQuantidadeDeProdutosNoCarrinhoPaginaResumoDoCarrinho());
	}

	//Teste para validar se produto foi adicionado corretamente ao carrinho
	@Test
	public void validarQueProdutoFoiAdicionadoCorretamenteNoCarrinhoESeguiuAutenticacaoConta() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		assertEquals("AUTHENTICATION",loja.obterTituloDaPaginaAutenticacao());
		assertEquals("CREATE AN ACCOUNT",loja.obterTituloCrieSuaContaAquiDaPaginaAutenticacao());
	}

	//Teste para validar Email inválido na Pagina de Autenticação da Conta
	@Test
	public void validarEmailInvalidoAutenticacaoConta() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEnderecoDeEmailCardCrieSuaConta("hahaha");
		loja.clicarBotaoCrieSuaContaAquiPaginaAutenticacao();
		assertEquals("AUTHENTICATION",loja.obterTituloDaPaginaAutenticacao());
		assertEquals("Invalid email address.",loja.obterMensagemDeEmailInvalidoPaginaAutenticacao());
	}

	//Teste para validar Email inválido já cadastrado no sistema Pagina de Autenticação da Conta
	@Test
	public void validarEmailInvalidoJáCadastradoNoSistemsAutenticacaoConta() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEnderecoDeEmailCardCrieSuaConta("hahhaadssaa@teste.com");
		loja.clicarBotaoCrieSuaContaAquiPaginaAutenticacao();
		assertEquals("AUTHENTICATION",loja.obterTituloDaPaginaAutenticacao());
		assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",loja.obterMensagemDeEmailInvalidoPaginaAutenticacao());
	}

	//Teste para validar se preenchimento de e-mail é valido para cadastro 
	@Test
	public void validarQueProdutoFoiAdicionadoCorretamenteNoCarrinhoESeguiuEndereco() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEnderecoDeEmailCardCrieSuaConta("hahhaahaha@teste.com");
		loja.clicarBotaoCrieSuaContaAquiPaginaAutenticacao();
		assertEquals("CREATE AN ACCOUNT",endereco.obterTituloDaPaginaEndereco());
		assertEquals("YOUR PERSONAL INFORMATION",endereco.obterSubTituloSuasInformacoesPessoaisDaPaginaEndereco());
	}

	//Teste para validar Campos Obrigatorios Pagina Endereço
	@Test
	public void validarCamposObrigatoriosPaginaEndereco() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEnderecoDeEmailCardCrieSuaConta("hadshaa@teste.com");
		loja.clicarBotaoCrieSuaContaAquiPaginaAutenticacao();
		endereco.clicarBotaoRegistroPaginaInformacoesPessoais();
		assertEquals("There are 8 errors\n"
				+ "You must register at least one phone number.\n"
				+ "lastname is required.\n"
				+ "firstname is required.\n"
				+ "passwd is required.\n"
				+ "address1 is required.\n"
				+ "city is required.\n"
				+ "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n"
				+ "This country requires you to choose a State.",
				endereco.obterMensagemCampoObrigatorioPaginaEndereco());	
	}

	//Teste para validar preenchimento do Endereço corretamente e confirmação do Endereço
	@Test
	public void validarPreenchimentoDoEnderecoCorretamente() {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEnderecoDeEmailCardCrieSuaConta("teste62325@teste.com");
		loja.clicarBotaoCrieSuaContaAquiPaginaAutenticacao();
		endereco.clicarRadioSrPaginaInformacoesPessoais();
		endereco.preencherPrimeiroNomePaginaInformacoesPessoais("Suzana");
		endereco.preencherSobrenomePaginaInformacoesPessoais("Voltz");
		endereco.preencherSenhaPaginaInformacoesPessoais("123456");
		endereco.clicarComboDiaDataNascimentoPaginaInformacoesPessoais();
		endereco.clicarDiaPrimeiroDataNascimentoPaginaInformacoesPessoais();
		endereco.clicarComboMesDataNascimentoPaginaInformacoesPessoais();
		endereco.clicarMesPrimeiroDataNascimentoPaginaInformacoesPessoais();
		endereco.clicarComboAnoDataNascimentoPaginaInformacoesPessoais();
		endereco.clicarAnoPrimeiroDataNascimentoPaginaInformacoesPessoais();
		endereco.clicarAssineNewsletterPaginaInformacoesPessoais();
		endereco.clicarRecebaNossasOfertasPaginaInformacoesPessoais();
		endereco.preencherCompanhiaSeuEnderecoPaginaInformacoesPessoais("companhia");
		endereco.clicarComboEstadoPaginaInformacoesPessoais();
		endereco.clicarOpcaoArizonaEnderecoPaginaInformacoesPessoais();
		endereco.preencherEnderecoSeuEnderecoPaginaInformacoesPessoais("rua dos ruas , 15, 020, 005");
		endereco.preencherEnderecoLinha2SeuEnderecoPaginaInformacoesPessoais("haha1 , haha2");
		endereco.preencherCidadeSeuEnderecoPaginaInformacoesPessoais("california");
		endereco.preencherCepSeuEnderecoPaginaInformacoesPessoais("00000");
		endereco.preencherInformacoesAdicionaisSeuEnderecoPaginaInformacoesPessoais("Nao possui");
		endereco.preencherTelefoneResidencialSeuEnderecoPaginaInformacoesPessoais("275275727");
		endereco.preencherTelefoneCelularSeuEnderecoPaginaInformacoesPessoais("272752752752");
		endereco.preencherEnderecoAlternativoSeuEnderecoPaginaInformacoesPessoais("rua dos ruasislek, 0");
		endereco.clicarBotaoRegistroPaginaInformacoesPessoais();
		assertEquals("Suzana Voltz",confEndereco.obterNomeCompletoPaginaConfirmacaoEndereco());
		assertEquals("rua dos ruas , 15, 020, 005 haha1 , haha2",confEndereco.obterEnderecoPaginaConfirmacaoEndereco());
		assertEquals("california, Arizona 00000",confEndereco.obterCidadeEstadoCepPaginaConfirmacaoEndereco());
		assertEquals("275275727",confEndereco.obterTelefoneResidencialPaginaConfirmacaoEndereco());
		assertEquals("272752752752",confEndereco.obterTelefoneCelularPaginaConfirmacaoEndereco());
	}

	//Teste para validar Pagina Confirmacao de Endereço cliente já registrado
	@Test
	public void validarPaginaConfirmacaoEnderecoClienteJaCadastrado() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		assertEquals("Suzana Voltz",confEndereco.obterNomeCompletoPaginaConfirmacaoEndereco());
		assertEquals("companhia",confEndereco.obterCompanhiaPaginaConfirmacaoEndereco());
		assertEquals("rua dos ruas , 15, 020, 005 haha1 , haha2",confEndereco.obterEnderecoPaginaConfirmacaoEndereco());
		assertEquals("california, Arizona 00000",confEndereco.obterCidadeEstadoCepPaginaConfirmacaoEndereco());
		assertEquals("United States",confEndereco.obterPaisPaginaConfirmacaoEndereco());
		assertEquals("275275727",confEndereco.obterTelefoneResidencialPaginaConfirmacaoEndereco());
		assertEquals("272752752752",confEndereco.obterTelefoneCelularPaginaConfirmacaoEndereco());
	}

	//Teste para validar Pagina Remessa 
	@Test
	public void validarPaginaRemessaEfetivadaComSucesso() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEnderecoDeEmailCardCrieSuaConta("teste_154aa@teste.com");
		loja.clicarBotaoCrieSuaContaAquiPaginaAutenticacao();
		endereco.fazerCadastroComSucesso();
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		assertEquals("Shipping",confCompra.obterTituloDaPaginaRemessa());
		assertEquals("I agree to the terms of service and will adhere to them unconditionally.",confCompra.obterTermosDeUsoPaginaRemessa());			
	}

	//Teste para validar Valores da Compra Pagina Metodo de Pagamento 
	@Test
	public void validarValoresDaCompraEfetivadaComSucessoPaginaMetodoPagamento() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD",confCompra.obterTituloDaPaginaMetodoPagamento());
		assertEquals("$16.51",confCompra.obterValorTotalDeProdutos());
		assertEquals("$2.00", confCompra.obterValorEnvioTotalDaCompra());
		assertEquals("$18.51",confCompra.obterValorTotalDaCompra());
	}

	//Teste para validar Pagina Resumo do Pedido - Pagamento por Transferencia Bancária
	@Test
	public void validarPaginaResumoDoPedidoPagamentoPorTransferenciaBancaria() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		confCompra.clicarCardPagamentoTransferenciaBancariaPaginaMetodoPagamento();
		assertEquals("You have chosen to pay by bank wire. Here is a short summary of your order:",confCompra.obterConfirmacaoDePedido());
		assertEquals("$18.51",confCompra.obterValorTotalDoPedidoPaginaResumoDoPedido());
	}

	//Teste para validar Pagina Resumo do Pedido - Pagamento por Cheque
	@Test
	public void validarPaginaResumoDoPedidoPagamentoPorCheque() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		confCompra.clicarCardPagamentoEmChequePaginaMetodoPagamento();
		assertEquals("You have chosen to pay by check. Here is a short summary of your order:",confCompra.obterConfirmacaoDePedido());
		assertEquals("$18.51",confCompra.obterValorTotalDoPedidoPaginaResumoDoPedido());
	}

	//Teste para validar Pagina Confirmacao de Pedido - Pagamento por Cheque
	@Test
	public void validarPaginaConfirmacaoPedidoPagamentoCheque() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		confCompra.clicarCardPagamentoEmChequePaginaMetodoPagamento();
		confCompra.clicarBotaoEuConfirmoMeuPedidoPaginaConfirmacaoDaCompra();
		assertEquals("Your order on My Store is complete.",confCompra.obterAlertDePedidoConcluidoComSucessoPaginaConfirmacaoDePedidoPagamentoCheque());
		assertEquals("YOUR CHECK MUST INCLUDE:",confCompra.obterTituloDeInformacoesSobreChequePaginaConfirmacaoDePedido());
	}

	//Teste para validar Pagina Confirmacao de Pedido - Pagamento por Transferencia
	@Test
	public void validarPaginaConfirmacaoPedidoPagamentoTransferencia() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		confCompra.clicarCardPagamentoEmChequePaginaMetodoPagamento();
		confCompra.clicarBotaoEuConfirmoMeuPedidoPaginaConfirmacaoDaCompra();
		assertEquals("Your order on My Store is complete.",confCompra.obterAlertDePedidoConcluidoComSucessoPaginaConfirmacaoDePedidoPagamentoCheque());
		assertEquals("YOUR CHECK MUST INCLUDE:",confCompra.obterTituloDeInformacoesSobreChequePaginaConfirmacaoDePedido());
	}

	//Teste para validar Status da Compra - Pagamento por Cheque
	@Test
	public void validarPaginaStatusDaCompraPagamentoCheque() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		confCompra.clicarCardPagamentoEmChequePaginaMetodoPagamento();
		confCompra.clicarBotaoEuConfirmoMeuPedidoPaginaConfirmacaoDaCompra();
		confCompra.clicarBotaoDeVoltaAsEncomendasConfirmacaoDaCompra();
		assertEquals("On backorder",confCompra.obterStatusDaCompraPaginaHistoricoDePedido());
	}

	//Teste para validar Status da Compra - Pagamento Transferencia Bancária
	@Test
	public void validarPaginaStatusDaCompraPagamentoTransferenciaBancaria() throws Exception {
		loja.clicarBotaoAdicionarCarrinhoPaginaInicial();
		loja.clicarBotaoFazerCheckOutModalProdutoAdicionadoComSucesso();
		loja.clicarBotaoFazerCheckOutPaginaResumoDoCarrinho();
		loja.preencherEmailCardClienteJaRegistrado("hahhaadssaa@teste.com");
		loja.preencherSenhaCardClienteJaRegistrado("123456");
		loja.clicarBotaoAssinarEmCardClienteJaRegistrado();		
		confEndereco.clicarBotaoFazerCheckOutPaginaConfirmacaoEndereco();
		confCompra.clicarCheckBoxConcordoComOsTermosDeUsoPaginaFrete();
		confCompra.clicarBotaoCheckOutPaginaFrete();
		confCompra.clicarCardPagamentoTransferenciaBancariaPaginaMetodoPagamento();
		confCompra.clicarBotaoEuConfirmoMeuPedidoPaginaConfirmacaoDaCompra();
		confCompra.clicarBotaoDeVoltaAsEncomendasConfirmacaoDaCompra();
		assertEquals("On backorder",confCompra.obterStatusDaCompraPaginaHistoricoDePedido());
	}
}
