package com.selenium.campotreinamento;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

public class TesteCampoTreinamento {

	@Test
	public void devePreencherTextFieldNome() {
		WebDriver driver = carregarDriver();

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");

		Assert.hasText("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		// Fecha o driver
		driver.quit();
	}

	@Test
	public void devePreencherTextAreaSucestoes() {
		WebDriver driver = carregarDriver();
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Colocando sugestao");

		Assert.hasText("Colocando sugestao", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		// Fecha o driver
		driver.quit();
	}

	@Test
	public void deveSelecionarRadioButtonSexo() {
		WebDriver driver = carregarDriver();
		driver.findElement(By.id("elementosForm:sexo:0")).click();

		Assert.isTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		// Fecha o driver
		driver.quit();
	}
	
	@Test
	public void deveSelecionarCheckboxComidaFavorita() {
		WebDriver driver = carregarDriver();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

		Assert.isTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		// Fecha o driver
		driver.quit();
	}
	
	@Test
	public void deveSelecionarSegundoGrauCompletoPorIndexNoCombo() {
		WebDriver driver = carregarDriver();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select select = new Select(element);
		select.selectByIndex(2);
		
		Assert.hasText("2o grau completo", select.getFirstSelectedOption().getText());
		
		//Fecha o driver
		driver.quit();
	}
	
	@Test
	public void deveSelecionarMestradoPorValueNoCombo() {
		WebDriver driver = carregarDriver();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select select = new Select(element);
		select.selectByValue("mestrado");
		
		Assert.hasText("Mestrado", select.getFirstSelectedOption().getText());
		
		//Fecha o driver
		driver.quit();
	}
	
	@Test
	public void deveSelecionarPrimeiroGrauCompletoPorTextoNoCombo() {
		WebDriver driver = carregarDriver();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select select = new Select(element);
		select.selectByVisibleText("1o grau completo");
		
		Assert.hasText("1o grau completo", select.getFirstSelectedOption().getText());
		
		//Fecha o driver
		driver.quit();
	}
	
	@Test
	public void deveVerificarSeExisteMestradoNoCombo() {
		WebDriver driver = carregarDriver();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select select = new Select(element);
		boolean foundElement = false;
		for (WebElement option : select.getOptions()) {
			if(option.getAttribute("value").equalsIgnoreCase("mestrado")) {
				foundElement = true;
				break;
			}
		}
		
		Assert.isTrue(foundElement);
		
		// Fecha o driver
		driver.quit();
	}

	@Test
	public void deveMarcarEDesmacarNoComboMultiplo() throws InterruptedException {
		WebDriver driver = carregarDriver();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));

		Select select = new Select(element);
		select.selectByVisibleText("Natacao");
		select.selectByVisibleText("Corrida");
		select.selectByVisibleText("O que eh esporte?");

		boolean hasThreeSelected = select.getAllSelectedOptions().size() == 3;
		Assert.isTrue(hasThreeSelected);

		select.deselectByVisibleText("Corrida");
		hasThreeSelected = select.getAllSelectedOptions().size() == 2;
		Assert.isTrue(hasThreeSelected);

		// Fecha o driver
		driver.quit();
	}
	
	private WebDriver carregarDriver() {
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");
		return driver;
	}
	
	
}
