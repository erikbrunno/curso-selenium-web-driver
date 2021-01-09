package com.selenium.campotreinamento;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.Assert;

public class TestAlert {
	
	@Test
	public void deveClicarNoAlert() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		Assert.hasText("Alert Simples", alert.getText());
		
		String texto = alert.getText();
		
		//Clica no botao Ok
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
		driver.quit();
	}
	
	@Test
	public void deveClicarNoConfirm_Confirmado() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.hasText("Confirm Simples", alert.getText());
		alert.accept();
		Assert.hasText("Confirmado", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void deveClicarNoConfirm_Negado() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.hasText("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.hasText("Negado", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void deveClicarNoPrompt() {
		WebDriver driver = carregarDriver();
		
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.hasText("Digite um numero", alert.getText());
		
		alert.sendKeys("12");
		alert.accept();
		
		Assert.hasText("Era 12?", alert.getText());
		alert.accept();
		
		Assert.hasText(":D", alert.getText());
		
		driver.quit();
	}
	
	private WebDriver carregarDriver() {
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		return driver;
	}
	
}
