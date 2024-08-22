package paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioAdicaoDeProdutosPage extends BasePage{
    private WebDriver driver;
    private WebDriverWait wait;

    public FormularioAdicaoDeProdutosPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public FormularioAdicaoDeProdutosPage informarNomeDoProduto(String produtoNome){
        WebElement nomeProduto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("produtonome")));
        nomeProduto.sendKeys(produtoNome);
        return this;
    }
    public FormularioAdicaoDeProdutosPage informarValorDoProduto(String produtoValor){
        driver.findElement(By.id("produtovalor")).sendKeys(produtoValor);
        return this;
    }
    public FormularioAdicaoDeProdutosPage informarCoresdoProduto(String produtoCores){
        driver.findElement(By.id("produtocores")).sendKeys(produtoCores);
        return this;
    }
    public FormularioEdicaoDeProdutosPage submeterFormularioAdicaoDeProdutoComAcerto(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salvar"))).click();

        return new FormularioEdicaoDeProdutosPage(driver);
    }

    
}
