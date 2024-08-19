package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListaDeProdutosPage {
    private WebDriver driver;

    public ListaDeProdutosPage(WebDriver driver) {
        this.driver = driver;
    }

    public ListaDeProdutosPage verificarExibicaoCabecalhoComLogo(){
        WebElement logo = driver.findElement(By.id("logo-container"));
        String texto = logo.getText();
        Assertions.assertEquals("Lojinha", texto); 

        return this;
    }

    public ListaDeProdutosPage verificarExibicaoCabecalhoComSaudacaoESair(){
        WebElement elemento = driver.findElement(By.cssSelector("ul li a"));
        String texto = elemento.getText();

        Assertions.assertEquals("Boas vindas, admin!", texto);

        return this;
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
