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
public class TestaSair {
    
    WebDriver driver;
    
    public TestaSair(){
        ConfiguraDriver confg = new ConfiguraDriver();               
        driver = confg.configurarTestesRedMine();
    }
    
    public String sair(){
        WebElement SairButton = driver.findElement( By.xpath("//*[@id=\"account\"]/ul/li[2]/a") );
        SairButton.click();
        
        // Mensagem - System
        WebElement SystemMensagem = driver.findElement( By.xpath("//*[@id=\"content\"]/h2") );
        
        driver.close();
        return SystemMensagem.getText();
        
    }
}
