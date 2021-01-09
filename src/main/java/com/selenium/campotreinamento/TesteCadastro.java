package com.selenium.campotreinamento;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

public class TesteCadastro {

	@Test
	public void deveCadastrarUsuario() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Erik");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Brunno");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		new Select(driver.findElement(By.id("elementosForm:escolaridade")))
			.selectByVisibleText("Mestrado");
		new Select(driver.findElement(By.id("elementosForm:esportes")))
			.selectByVisibleText("Corrida");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.hasText("Cadastrado", driver.findElement(By.id("resultado")).getText());
		Assert.hasText("Erik", driver.findElement(By.id("descNome")).getText());
		Assert.hasText("Brunno", driver.findElement(By.id("descSobrenome")).getText());
		Assert.hasText("Masculuno", driver.findElement(By.id("descSexo")).getText());
		Assert.hasText("Carne", driver.findElement(By.id("descComida")).getText());
		Assert.hasText("Escolaridade", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.hasText("Esportes", driver.findElement(By.id("descEsportes")).getText());
		
		driver.quit();
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.hasText("Nome eh obrigatorio", alert.getText());
		driver.quit();
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Erik");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.hasText("Sobrenome eh obrigatorio", alert.getText());
		driver.quit();
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Erik");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Brunno");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.hasText("Sexo eh obrigatorio", alert.getText());
		driver.quit();
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Erik");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Brunno");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.hasText("Tem certeza que voce eh vegetariano?", alert.getText());
		driver.quit();
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Erik");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Brunno");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		Select select = new Select(driver.findElement(By.id("elementosForm:esportes")));
		select.selectByVisibleText("Corrida");
		select.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.hasText("Voce faz esporte ou nao?", alert.getText());
		driver.quit();
	}
	
	private WebDriver carregarDriver() {
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		return driver;
	}
	
}
