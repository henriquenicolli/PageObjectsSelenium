package br.edu.utfpr.exemplomaven;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author andreendo
 */
public class ExemploTest {

     WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); 
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.redmine.org/");
        
        // Entrar 
        // Button - Entrar
        WebElement EntrarButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[1]/a") );
        EntrarButton.click();
        
        // Input - Usuário
        WebElement UsuarioInput = driver.findElement( By.xpath("//*[@id=\"username\"]") );
        UsuarioInput.sendKeys("usuarioTesteUTFPR");

        // Input - Senha
        WebElement SenhaInput = driver.findElement( By.xpath("//*[@id=\"password\"]") );
        SenhaInput.sendKeys("1234");

        // Button - Entrar
        WebElement EntrarButton2 = driver.findElement( By.xpath("//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input") );
        EntrarButton2.click();
              
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"content\"]/h2") );
        assertEquals("Página inicial", SystemMensagem.getText());
    }
    
    @After
    public void after() {
        driver.close();
    }
    
    /* Usuário já Cadastrado. */
    @Ignore
    @Test
    public void testCadastrase() {   
        //  Button - Cadastra-se
        WebElement CadastraseButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[2]/a") );
        CadastraseButton.click();
        
        // Input - Usuário
        WebElement UsuarioInput = driver.findElement( By.xpath("//*[@id=\"user_login\"]") );
        UsuarioInput.sendKeys("usuarioTesteUTFPR");

        // Input - Senha
        WebElement SenhaInput = driver.findElement( By.xpath("//*[@id=\"user_password\"]") );
        SenhaInput.sendKeys("1234");

        // Input - Confirmação Senha
        WebElement ConfirmacaoInput = driver.findElement( By.xpath("//*[@id=\"user_password_confirmation\"]") );
        ConfirmacaoInput.sendKeys("1234");

        // Input - Nome
        WebElement NomeInput = driver.findElement( By.xpath("//*[@id=\"user_firstname\"]") );
        NomeInput.sendKeys("Usuário");
        
        // Input - Sobrenome
        WebElement SobrenomeInput = driver.findElement( By.xpath("//*[@id=\"user_lastname\"]") );
        SobrenomeInput.sendKeys("Teste");//*[@id="user_mail"]
        
        // Input - E-mail
        WebElement EmailInput = driver.findElement( By.xpath("//*[@id=\"user_mail\"]") );
        EmailInput.sendKeys("edsonsampy@live.com");
        
        // Select - Idioma
        Select IdiomaSelect = new Select( driver.findElement( By.xpath("//*[@id=\"user_language\"]") ) );
        IdiomaSelect.selectByVisibleText("Portuguese/Brasil (Português/Brasil)");
        
        // Button - Enviar
        WebElement EnviarButton = driver.findElement( By.xpath("//*[@id=\"new_user\"]/input[3]") );
        EnviarButton.click();
        
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"flash_notice\"]") );
        assertEquals("Your account has been activated. You can now log in.", SystemMensagem.getText());
    }
    
    /* Login através do Before */
    @Ignore
    @Test
    public void testEntrar() {  
        // Button - Entrar
        WebElement EntrarButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[1]/a") );
        EntrarButton.click();
        
        // Input - Usuário
        WebElement UsuarioInput = driver.findElement( By.xpath("//*[@id=\"username\"]") );
        UsuarioInput.sendKeys("usuarioTesteUTFPR");

        // Input - Senha
        WebElement SenhaInput = driver.findElement( By.xpath("//*[@id=\"password\"]") );
        SenhaInput.sendKeys("1234");

        // Button - Entrar
        WebElement EntrarButton2 = driver.findElement( By.xpath("//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input") );
        EntrarButton2.click();
              
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"content\"]/h2") );
        assertEquals("Página inicial", SystemMensagem.getText());
    }
    
    /* Projeto já Criado */
    @Ignore
    @Test
    public void testCriarProjeto() {  
        // Button - Projetos
        WebElement ProjetosButton = driver.findElement( By.xpath("//*[@id=\"top-menu\"]/ul/li[3]/a") );
        ProjetosButton.click();
        
        // Button - Novo Projeto
        WebElement NovoProjetoButton = driver.findElement( By.xpath("//*[@id=\"content\"]/div[1]/a[1]") );
        NovoProjetoButton.click();
        
        // Input - Nome
        WebElement NomeInput = driver.findElement( By.xpath("//*[@id=\"project_name\"]") );
        NomeInput.sendKeys("Projeto Tested");
        
        // TextArea - Descrição
        WebElement DescricaoTextArea = driver.findElement( By.xpath("//*[@id=\"project_description\"]") );
        DescricaoTextArea.sendKeys("Projeto para Teste");
        
        // Button - Criar
        WebElement CriarButton = driver.findElement( By.xpath("//*[@id=\"new_project\"]/input[3]") );
        CriarButton.click();
              
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"flash_notice\"]") );
        assertEquals("Criado com sucesso.", SystemMensagem.getText());
    }
    
    /* Aumentar o ID da tarefa para +1 */
    @Test
    public void testCriarTarefa() {  
        // Select - Projeto
        Select ProjetoSelect = new Select( driver.findElement( By.xpath("//*[@id=\"project_quick_jump_box\"]") ) );
        ProjetoSelect.selectByVisibleText("Projeto Teste");
        
        // Button - Nova Tarefa
        WebElement NovaTarefaButton = driver.findElement( By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/a") );
        NovaTarefaButton.click();
        
        // Input - Título
        WebElement TituloInput = driver.findElement( By.xpath("//*[@id=\"issue_subject\"]") );
        TituloInput.sendKeys("Tarefa Teste");
        
        // TextArea - Descrição
        WebElement DescricaoTextArea = driver.findElement( By.xpath("//*[@id=\"issue_description\"]") );
        DescricaoTextArea.sendKeys("Projeto para Teste");

        // Button - Criar
        WebElement CriarButton = driver.findElement( By.xpath("//*[@id=\"issue-form\"]/input[3]") );
        CriarButton.click();
              
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"flash_notice\"]") );
        assertEquals("Tarefa #227143 criada.", SystemMensagem.getText());
    }
    
    /* Aumentar o ID da tarefa para +1 */
    @Test
    public void testEdiatrTarefa() {  
        // Select - Projeto
        Select ProjetoSelect = new Select( driver.findElement( By.xpath("//*[@id=\"project_quick_jump_box\"]") ) );
        ProjetoSelect.selectByVisibleText("Projeto Teste");
        
        // Button - Tarefa
        WebElement TarefaButton = driver.findElement( By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a") );
        TarefaButton.click();
        
        // Grid - Tarefa
        WebElement TarefaGrid = driver.findElement( By.xpath("//*[@id=\"issue-227143\"]/td[2]/a") );
        TarefaGrid.click();
        
        // Button - Editar
        WebElement EditarButton = driver.findElement( By.xpath("//*[@id=\"content\"]/div[1]/a[1]") );
        EditarButton.click();
              
        // Select - Situação
        Select SituacaoSelect = new Select( driver.findElement( By.xpath("//*[@id=\"issue_status_id\"]") ) );
        SituacaoSelect.selectByVisibleText("Resolved");
        
        // Button - Enviar
        WebElement EnviarButton = driver.findElement( By.xpath("//*[@id=\"issue-form\"]/input[6]") );
        EnviarButton.click();
        
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"flash_notice\"]") );
        assertEquals("Alterado com sucesso.", SystemMensagem.getText());
    }
    
    @Test
    public void testSair() { 
        // Button - Sair
        WebElement SairButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[2]/a") );
        SairButton.click();
        
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"content\"]/h2") );
        assertEquals("Home", SystemMensagem.getText());
    }
}
