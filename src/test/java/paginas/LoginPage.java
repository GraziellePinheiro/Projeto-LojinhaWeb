package paginas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver driver;
    

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver abrirNavegador(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chocolatey\\bin\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        return driver;
    }

    // public WebElement campoUsuario(){
    //     return driver.findElement(By.cssSelector("label[for='usuario']"));
    // }
    // public WebElement campoSenha(){
    //     return driver.findElement(By.cssSelector("label[for='senha']"));
    // }
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

    @DisplayName("Valida o placeholder(texto) do elemento usuario e senha")
    public LoginPage ValidaPlaceholderUsuarioESenha(){
        WebElement placeUsuario = driver.findElement(By.cssSelector("label[for='usuario']"));
        String textoPlaceUsuario = placeUsuario.getText();
        Assertions.assertEquals("Usuário", textoPlaceUsuario);

        WebElement placeSenha = driver.findElement(By.cssSelector("label[for='senha']"));
        String textoPlaceSenha = placeSenha.getText();
        Assertions.assertEquals("Senha", textoPlaceSenha);

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

    public String capturarMsgApresentada(){
        return driver.findElement(By.cssSelector(".toast.rounded")).getText();
    }


    
}
