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
public class TestaCriarTarefa {
    
    WebDriver driver;
    
    public TestaCriarTarefa(){
        ConfiguraDriver confg = new ConfiguraDriver();               
        driver = confg.configurarTestesRedMine();
    }
    
    public String criarTarefa(String projeto, String tarefa, String descricao){
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
        driver.close();
        return SystemMensagem.getText();
    }
    
}
