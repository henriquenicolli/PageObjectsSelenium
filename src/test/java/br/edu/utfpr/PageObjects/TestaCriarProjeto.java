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
public class TestaCriarProjeto {
    
    WebDriver driver;
    
    public TestaCriarProjeto(){
        ConfiguraDriver confg = new ConfiguraDriver();               
        driver = confg.configurarTestesRedMine();
    }
    
    public String criarProjeto(String nomeImput, String descricao){
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
        driver.close();
        return SystemMensagem.getText();
  
    }
}
