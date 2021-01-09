package com.selenium.google;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.Assert;


public class TesteGoogle {
	
	@Test
	public void deveVerificarTituloComSucesso() {
		//Informar a localizacao do driver caso ele nao exista no firefox
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		//Inicializa o driver
		WebDriver driver = new FirefoxDriver();
		
		//Define o tamanho do browser
//		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//Abre o browser maximizado
//		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		Assert.hasText("Google", driver.getTitle());
		
		//Fecha o driver
		driver.quit();
	}
}
