package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LojinhaWebTest {

    private WebDriver navegador;
 
    @Before
    public void SetUp(){
        //Preparação
        System.setProperty("webdriver.chrome.driver", "/home/mkapobianco/Drivers/chromedriver");
        navegador = new ChromeDriver();
        navegador.get("http://165.227.93.41/lojinha-web/");
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Login com usuário mkapobianco e senha 123456
        navegador.findElement(By.cssSelector("#usuario")).sendKeys("mkapobianco");
        navegador.findElement(By.id("senha")).sendKeys("123456");
        navegador.findElement(By.cssSelector(".btn")).click();
    }

    @Test
    public void testValidarDadosDeUmProduto(){

        //Acessar produto PS5 Pro na lista de produtos
        //navegador.findElement(By.linkText("PS5 PRO")).click();
        //navegador.findElements(By.linkText("PS5 PRO")).get(0).click();
        navegador.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/span/a")).click();

        //Validação do nome do produto e do nome do primeiro componente
        String nomeproduto = navegador.findElement(By.id("produtonome")).getAttribute("value");
        Assert.assertEquals("PS5 PRO", nomeproduto);

        String nomecomponente = navegador.findElements(By.cssSelector(".title")).get(0).getText();
        Assert.assertEquals("Lojinha Jogo FIFA 21", nomecomponente);
    }

    @Test
    public void testValidarCadastroNovoProduto(){
        //Cadastrar novo Produto
        navegador.findElement(By.className("btn")).click();

        //Preencher formulário e salva
        navegador.findElement(By.id("produtonome")).sendKeys("Sega Saturn");
        navegador.findElement(By.id("produtovalor")).sendKeys("800,00");
        navegador.findElement(By.id("produtocores")).sendKeys("Cinza");
        //navegador.findElements(By.cssSelector(".btn")).get(0).click();
        //navegador.findElement(By.xpath("/html/body/div[2]/div/div/form/div[5]/button")).click();
        navegador.findElement(By.tagName("button")).click();

        //Validar que o produto foi adicionado

        //navegador.findElement(By.id("logo-container")).click();
        //String novoproduto = navegador.findElement(By.linkText("Sega Saturn")).getText();
        //Assert.assertEquals("Sega Saturn", novoproduto);

        String novoproduto = navegador.findElement(By.className("toast")).getText();
        Assert.assertEquals("Produto adicionado com sucesso", novoproduto);
    }

    @After
    public void tearDown(){

        //Deslogar
        navegador.findElement(By.linkText("Sair")).click();

        //Fechar o navegador
        navegador.quit();
    }
}
