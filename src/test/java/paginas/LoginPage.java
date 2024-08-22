package paginas;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private WebDriver driver;
    private WebDriverWait wait;
    
    

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver abrirNavegador(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chocolatey\\bin\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        return driver;
    }

    public LoginPage informarUsuario(String usuario){
        driver.findElement(By.cssSelector("label[for='usuario']")).click();
        driver.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }
    public LoginPage informarSenha(String senha){
        driver.findElement(By.cssSelector("label[for='senha']")).click();
        driver.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioLogin(){
        driver.findElement(By.id("entrar")).click();

        return new ListaDeProdutosPage(driver);
    }

    public LoginPage submeterFormularioLoginComErro(){
        driver.findElement(By.id("entrar")).click();

        return this;
    }
}
