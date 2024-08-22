package paginas;

import java.time.Duration;
import java.util.NoSuchElementException;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaDeProdutosPage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ListaDeProdutosPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String verificarExibicaoCabecalhoComLogo(){
        return driver.findElement(By.id("logo-container")).getText();
    }

    public String verificarExibicaoCabecalhoComSaudacaoESair(){
        return driver.findElement(By.cssSelector("ul li a")).getText();
        
    }

    public String capturaTituloDaListaDeProdutos(){
       return driver.findElement(By.cssSelector("div h3")).getText();
    }

    public FormularioAdicaoDeProdutosPage acessaFormularioAdicaoNovoProduto(){
        driver.findElement(By.cssSelector("a.waves-effect.waves-light.btn.right")).click();

        return new FormularioAdicaoDeProdutosPage(driver);
    }
    public ListaDeProdutosPage validarBotaoExclusao(){
        driver.findElement(By.cssSelector("a.secondary-content i.material-icons")).click();

        return this;
    }

    
}
