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

/**
 *
 * @author henrique.soares
 */
public class TestaEntrar {
    
    WebDriver driver;
    
    public TestaEntrar(){
        ConfiguraDriver confg = new ConfiguraDriver();               
        driver = confg.configurarTestesRedMine();
    }
    
    public String entrar(String nome, String senha){
        WebElement EntrarButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[1]/a") );
        EntrarButton.click();
        
        // Input - Usuário
        WebElement UsuarioInput = driver.findElement( By.xpath("//*[@id=\"username\"]") );
        UsuarioInput.sendKeys(nome);

        // Input - Senha
        WebElement SenhaInput = driver.findElement( By.xpath("//*[@id=\"password\"]") );
        SenhaInput.sendKeys(senha);

        // Button - Entrar
        WebElement EntrarButton2 = driver.findElement( By.xpath("//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input") );
        EntrarButton2.click();
              
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"content\"]/h2") );
        driver.close();
        return SystemMensagem.getText();
    }
    
    
    
}
