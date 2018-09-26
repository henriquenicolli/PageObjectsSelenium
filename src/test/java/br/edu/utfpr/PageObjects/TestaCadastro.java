/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.PageObjects;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author henrique.soares
 */
public class TestaCadastro {
    
    WebDriver driver;
    
    public TestaCadastro(){
        ConfiguraDriver confg = new ConfiguraDriver();               
        driver = confg.configurarTestesRedMine();
    }
    
    public String cadastrar(String usuario,String senha,String nome,String sobrenome,String email){
        WebElement CadastraseButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[2]/a") );
        CadastraseButton.click();
        
        // Input - Usuário
        WebElement UsuarioInput = driver.findElement( By.xpath("//*[@id=\"user_login\"]") );
        UsuarioInput.sendKeys(usuario);

        // Input - Senha
        WebElement SenhaInput = driver.findElement( By.xpath("//*[@id=\"user_password\"]") );
        SenhaInput.sendKeys(senha);

        // Input - Confirmação Senha
        WebElement ConfirmacaoInput = driver.findElement( By.xpath("//*[@id=\"user_password_confirmation\"]") );
        ConfirmacaoInput.sendKeys(senha);

        // Input - Nome
        WebElement NomeInput = driver.findElement( By.xpath("//*[@id=\"user_firstname\"]") );
        NomeInput.sendKeys(nome);
        
        // Input - Sobrenome
        WebElement SobrenomeInput = driver.findElement( By.xpath("//*[@id=\"user_lastname\"]") );
        SobrenomeInput.sendKeys(sobrenome);//*[@id="user_mail"]
        
        // Input - E-mail
        WebElement EmailInput = driver.findElement( By.xpath("//*[@id=\"user_mail\"]") );
        EmailInput.sendKeys(email);
        
        // Select - Idioma
        Select IdiomaSelect = new Select( driver.findElement( By.xpath("//*[@id=\"user_language\"]") ) );
        IdiomaSelect.selectByVisibleText("Portuguese/Brasil (Português/Brasil)");
        
        // Button - Enviar
        WebElement EnviarButton = driver.findElement( By.xpath("//*[@id=\"new_user\"]/input[3]") );
        EnviarButton.click();
        
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"flash_notice\"]") );
        
        driver.close();
        return SystemMensagem.getText();
    }
    
    
}
