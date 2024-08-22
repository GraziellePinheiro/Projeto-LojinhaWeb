package modulos.login;

import org.openqa.selenium.chrome.ChromeDriver;

import paginas.ListaDeProdutosPage;
import paginas.LoginPage;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.accessibility.AccessibleHypertext;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LojinhaTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ListaDeProdutosPage listaDeProdutosPage;

    @BeforeEach
    public void setUp(){
        loginPage = new LoginPage(driver);
        listaDeProdutosPage = new ListaDeProdutosPage(driver);
        driver = loginPage.abrirNavegador();
        driver.get("http://165.227.93.41/lojinha-web/");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    
    @DisplayName("Login com credencias validas")
    @Test
    public void testLoginComSucesso(){
        String mensagemBoasVindas = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .capturaTituloDaListaDeProdutos();
        assertEquals("Lista de Produtos", mensagemBoasVindas);
    }

    @Disabled
    @DisplayName("Login sem sucesso, campos em branco")
    @Test
    public void testLoginSemSucessoCamposVazios(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("")
            .informarSenha("")
            .submeterFormularioLoginComErro()
            .esperarPorMensagem();
        assertEquals("Falha ao fazer o login", mensagemApresentada);
    }

    @Disabled
    @DisplayName("Sem sucesso, campo usuario incorreto")
    @Test
    public void testLoginSemSucessoUsuarioIncorreto(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("##$$%%")
            .informarSenha("admin")
            .submeterFormularioLoginComErro()
            .esperarPorMensagem();
        assertEquals("Falha ao fazer o login", mensagemApresentada);
    }

    @Disabled
    @DisplayName("Sem sucesso, campo senha incorreto")
    @Test
    public void testLoginSemSucessoSenhaIncorreta(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("##$$%%")
            .submeterFormularioLoginComErro()
            .esperarPorMensagem();
        assertEquals("Falha ao fazer o login", mensagemApresentada);
    }

    @Disabled
    @DisplayName("Sem sucesso, campo usuario e senha incorreto")
    @Test
    public void testLoginSemSucessoUsuarioESenhaIncorreta(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("##$$%%")
            .informarSenha("##$$%%")
            .submeterFormularioLoginComErro()
            .esperarPorMensagem();
        assertEquals("Falha ao fazer o login", mensagemApresentada);
    }

    @Disabled
    @DisplayName("Sem sucesso, espaços extras em ambos campos")
    @Test
    public void testLoginSemSucessoEspacosExtras(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("  admin")
            .informarSenha("  admin")
            .submeterFormularioLoginComErro()
            .esperarPorMensagem();
        assertEquals("Falha ao fazer o login", mensagemApresentada);   
    }

    @Disabled
    @DisplayName("Valida o cabeçalho da pagina de Lista de Produtos")
    @Test
    public void testVisualizarCabecalhoComLogoTextoEBotaoSair(){
        String saudacao = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            // .verificarExibicaoCabecalhoComLogo()
            .verificarExibicaoCabecalhoComSaudacaoESair();
        Assertions.assertTrue(saudacao.contains("Boas vindas, admin!"), "O cabeçalho não contém a saudação esperada.");
    }
    
    @Disabled
    @DisplayName("Valida o botão de exclusão")
    @Test
    public void testValidaBotaoExclusao(){
        String msgApresentada = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .validarBotaoExclusao()
            .esperarPorMensagem();
        assertEquals("Produto removido com sucesso", msgApresentada);
    }

    @Disabled
    @DisplayName("Adicionar novo produto com valor de Um centavo")
    @Test
    public void testAdicionarProdutoComValorValidoDeUmCentavo(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .acessaFormularioAdicaoNovoProduto()
            .informarNomeDoProduto("Nintendo")
            .informarValorDoProduto("0.01")
            .informarCoresdoProduto("Black")
            .submeterFormularioAdicaoDeProdutoComAcerto()
            .esperarPorMensagem();
        assertEquals("Produto adicionado com sucesso", mensagemApresentada);  
    }

    @Disabled
    @DisplayName("Adicionar novo produto com valor de Sete Mil")
    @Test
    public void testAdicionarProdutoComValorValidoDeSeteMil(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .acessaFormularioAdicaoNovoProduto()
            .informarNomeDoProduto("PlayStation")
            .informarValorDoProduto("7000.00")
            .informarCoresdoProduto("Branco")
            .submeterFormularioAdicaoDeProdutoComAcerto()
            .esperarPorMensagem();
        assertEquals("Produto adicionado com sucesso", mensagemApresentada);  
    }

    @Disabled
    @DisplayName("Adicionar novo produto com componente")
    @Test
    public void testAdicionarProdutoComComponente(){
        String mensagemApresentada = new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .acessaFormularioAdicaoNovoProduto()
            .informarNomeDoProduto("Iphone")
            .informarValorDoProduto("4999.90")
            .informarCoresdoProduto("Branco")
            .submeterFormularioAdicaoDeProdutoComAcerto()
            .cliqueBotaoAdicionarComponente()
            .informarNomeComponente("Carregador")
            .informarQuantComponente("1")
            .salvarComponenteEEsperarFechamentoModal()
            .retonarListaDeProdutos()
            .acessaFormularioAdicaoNovoProduto()
            .informarNomeDoProduto("Bolsa")
            .informarValorDoProduto("199.99")
            .informarCoresdoProduto("Prata")
            .submeterFormularioAdicaoDeProdutoComAcerto()
            .salvarEdicaoDeProdutos()
            .esperarPorMensagem();

        assertEquals("Produto alterado com sucesso", mensagemApresentada);  
    }

    
}
