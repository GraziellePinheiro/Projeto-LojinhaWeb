package paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioAdicaoDeComponentePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FormularioAdicaoDeComponentePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public FormularioAdicaoDeComponentePage informarNomeComponente(String nomeComponente){
        WebElement componenteNome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("componentenomeadicionar")));
        componenteNome.sendKeys(nomeComponente);
        return this;
    }
    public FormularioAdicaoDeComponentePage informarQuantComponente(String quantComponente){
        WebElement componenteQuant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("componentequantidadeadicionar")));
        componenteQuant.sendKeys(quantComponente);
        return this;
    }
    public FormularioEdicaoDeProdutosPage salvarComponenteEEsperarFechamentoModal() {
        // Espera o botão "Salvar Componente" estar visível e clica nele
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botaoSalvarComponente = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.modal-close.waves-effect.waves-light.btn")));
        botaoSalvarComponente.click();

        // Espera até que o modal seja completamente fechado
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("a.modal-close.waves-effect.waves-light.btn")));

        return new FormularioEdicaoDeProdutosPage(driver);
    }
    
    public FormularioEdicaoDeProdutosPage cancelarComponente(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.modal-close.waves-effect.waves-light.btn grey")));
        return new FormularioEdicaoDeProdutosPage(driver);
    }


}
