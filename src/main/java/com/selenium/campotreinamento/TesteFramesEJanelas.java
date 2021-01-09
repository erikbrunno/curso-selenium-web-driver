package com.selenium.campotreinamento;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.Assert;

public class TesteFramesEJanelas {

	@Test
	public void deveClicarBotaoDentroDoFrame() {
		WebDriver driver  = carregarDriver();
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.hasText("Frame OK!", msg);
		alert.accept();
		
		//Traz o foco para pagina principal
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
		driver.quit();
	}
	
	@Test
	public void deveClicarBotaoAbrirPopup() {
		WebDriver driver  = carregarDriver();
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo!");
		String msg = driver.findElement(By.tagName("textarea")).getText();
		driver.close();
		
		Assert.hasText("Deu certo!", msg);
		
		driver.quit();
	}
	
	private WebDriver carregarDriver() {
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		return driver;
	}
	
}
