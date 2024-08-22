package paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioEdicaoDeProdutosPage extends BasePage{
    private WebDriver driver;
    private WebDriverWait wait;

    public FormularioEdicaoDeProdutosPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public ListaDeProdutosPage salvarEdicaoDeProdutos(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("action"))).click();
        return new ListaDeProdutosPage(driver);
    }
    public ListaDeProdutosPage retonarListaDeProdutos(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.waves-effect.waves-light.btn.grey"))).click();
        return new ListaDeProdutosPage(driver);
    }
    public FormularioAdicaoDeComponentePage cliqueBotaoAdicionarComponente(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.waves-effect.waves-light.btn.right.pink.modal-trigger"))).click();
        return new FormularioAdicaoDeComponentePage(driver);
    }
    
    
}
