package br.edu.utfpr.exemplomaven;


import br.edu.utfpr.PageObjects.TestaCadastro;
import br.edu.utfpr.PageObjects.TestaCriarProjeto;
import br.edu.utfpr.PageObjects.TestaCriarTarefa;
import br.edu.utfpr.PageObjects.TestaEditarTarefa;
import br.edu.utfpr.PageObjects.TestaEntrar;
import br.edu.utfpr.PageObjects.TestaSair;
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
    /* Usuário já Cadastrado. */
    @Ignore
    @Test
    public void testCadastrase() {   
        //  Button - Cadastra-se
        TestaCadastro testaCadastro = new TestaCadastro();
        assertEquals("Your account has been activated. You can now log in.", 
                    testaCadastro.cadastrar("usuario", "1234", "teste", "teste","edsonsampy@hotmail.com")
                    );
    }
    
    /* Login através do Before */
    @Ignore
    @Test
    public void testEntrar() {  
        // Button - Entrar
        TestaEntrar testaEntrar = new TestaEntrar();     
        assertEquals("Página inicial", 
                testaEntrar.entrar("usuarioTesteUTFPR","1234")
        );
    }
    
    /* Projeto já Criado */
    @Ignore
    @Test
    public void testCriarProjeto() {  
        // Button - Projetos
        TestaCriarProjeto testaCriarProjeto = new TestaCriarProjeto();           
        assertEquals("Criado com sucesso.", 
                testaCriarProjeto.criarProjeto("testeProjeto", "Projeto de Teste")
        );
    }
    
    /* Aumentar o ID da tarefa para +1 */
    @Test
    public void testCriarTarefa() {  
        // Select - Projeto
        TestaCriarTarefa testaCriarTarefa = new TestaCriarTarefa();
        assertEquals("Tarefa #227144 criada.", 
                testaCriarTarefa.criarTarefa("Projeto Tested", "tarefa1", "descricao")
        );
        
    }
    
    /* Aumentar o ID da tarefa para +1 */
    @Test
    public void testEdiatrTarefa() {  
        // Select - Projeto
        TestaEditarTarefa editarTarefa = new TestaEditarTarefa();        
        assertEquals("Alterado com sucesso.", 
                editarTarefa.editarTarefa("Projeto Teste")
        );
    }
    
    @Test
    public void testSair() { 
        // Button - Sair
        TestaSair sair = new TestaSair();       
        assertEquals("Home", sair.sair());
    }
}
