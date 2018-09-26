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
public class TestaEditarTarefa {
    
    WebDriver driver;
    
    public TestaEditarTarefa(){
        ConfiguraDriver confg = new ConfiguraDriver();               
        driver = confg.configurarTestesRedMine();
    }
    
    public String editarTarefa(String projeto){
        Select ProjetoSelect = new Select( driver.findElement( By.xpath("//*[@id=\"project_quick_jump_box\"]") ) );
        ProjetoSelect.selectByVisibleText(projeto);
        
        // Button - Tarefa
        WebElement TarefaButton = driver.findElement( By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a") );
        TarefaButton.click();
        
        // Grid - Tarefa
        WebElement TarefaGrid = driver.findElement( By.xpath("//*[@id=\"issue-227144\"]/td[2]/a") );
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
        driver.close();
        return SystemMensagem.getText();
    }
    
}
