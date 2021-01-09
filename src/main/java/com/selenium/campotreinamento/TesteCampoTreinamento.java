package com.selenium.campotreinamento;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.Assert;

public class TesteCampoTreinamento {

	@Test
	public void devePreencherTextFieldNome() {
		// Informar a localizacao do driver caso ele nao exista no firefox
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		// Inicializa o driver
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");

		Assert.hasText("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		// Fecha o driver
		driver.quit();
	}

	@Test
	public void devePreencherTextAreaSucestoes() {
		// Informar a localizacao do driver caso ele nao exista no firefox
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		// Inicializa o driver
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Colocando sugestao");

		Assert.hasText("Colocando sugestao", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		// Fecha o driver
		driver.quit();
	}

	@Test
	public void deveSelecionarRadioButtonSexo() {
		// Informar a localizacao do driver caso ele nao exista no firefox
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		// Inicializa o driver
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();

		Assert.isTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		// Fecha o driver
		driver.quit();
	}
	
	@Test
	public void deveSelecionarCheckboxComidaFavorita() {
		// Informar a localizacao do driver caso ele nao exista no firefox
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		// Inicializa o driver
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

		Assert.isTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		// Fecha o driver
		driver.quit();
	}
	
}
