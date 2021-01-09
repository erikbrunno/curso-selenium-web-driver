package com.selenium.campotreinamento;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {

	@Test
	public void teste() {
		// Informar a localizacao do driver caso ele nao exista no firefox
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		// Inicializa o driver
		WebDriver driver = new FirefoxDriver();

		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/web/componentes.html");		
		
		// Fecha o driver
		driver.quit();
	}
	
}
