package modulos.login;

import org.openqa.selenium.chrome.ChromeDriver;

import paginas.LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        loginPage = new LoginPage(driver);
        driver = loginPage.abrirNavegador();
        driver.get("http://165.227.93.41/lojinha-web/");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @DisplayName("Valida o PlaceHolder do elemento")
    @Test
    public void testValidarPlaceholderDosElementosUsuarioESenha(){
        
        new LoginPage(driver)
            .ValidaPlaceholderUsuarioESenha();
        
    }
    @DisplayName("Login com credencias validas")
    @Test
    public void testLoginComSucesso(){
        new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin();
    }
    @DisplayName("Login sem sucesso, campos em branco")
    @Test
    public void testLoginSemSucessoCamposVazios(){
        new LoginPage(driver)
            .informarUsuario("")
            .informarSenha("")
            .submeterFormularioLoginComErro()
            .capturarMsgApresentada();
    }
    @DisplayName("Sem sucesso, campo usuario incorreto")
    @Test
    public void testLoginSemSucessoUsuarioIncorreto(){
        new LoginPage(driver)
            .informarUsuario("##$$%%")
            .informarSenha("admin")
            .submeterFormularioLoginComErro();
    }
    @DisplayName("Sem sucesso, campo senha incorreto")
    @Test
    public void testLoginSemSucessoSenhaIncorreta(){
        new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("##$$%%")
            .submeterFormularioLoginComErro();
    }
    @DisplayName("Sem sucesso, campo usuario e senha incorreto")
    @Test
    public void testLoginSemSucessoUsuarioESenhaIncorreta(){
        new LoginPage(driver)
            .informarUsuario("##$$%%")
            .informarSenha("##$$%%")
            .submeterFormularioLoginComErro();
    }
    @DisplayName("Sem sucesso, espaços extras em ambos campos")
    @Test
    public void testLoginSemSucessoEspacosExtras(){
        new LoginPage(driver)
            .informarUsuario("  admin")
            .informarSenha("  admin")
            .submeterFormularioLoginComErro();
    }

    @DisplayName("Valida o cabeçalho da pagina de Lista de Produtos")
    @Test
    public void testVisualizarCabecalhoComLogoTextoEBotaoSair(){
        new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .verificarExibicaoCabecalhoComLogo()
            .verificarExibicaoCabecalhoComSaudacaoESair();
    }
    @DisplayName("Valida o botão de Adicionar Produto")
    @Test
    public void testValidaBotaoAdicionaProduto(){
        new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .verificarExibicaoCabecalhoComLogo()
            .verificarExibicaoCabecalhoComSaudacaoESair()
            .acessaFormularioAdicaoNovoProduto();
    }
    @DisplayName("Valida o botão de exclusão")
    @Test
    public void testValidaBotaoExclusao(){
        new LoginPage(driver)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioLogin()
            .verificarExibicaoCabecalhoComLogo()
            .verificarExibicaoCabecalhoComSaudacaoESair()
            .validarBotaoExclusao();
    }



    

    
}
