package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", // Integração entre Cucumber e JUnit 
tags = "@leilao")//o campo tags indica ao cucumber qual funcionalidade deve ser testada no momento
public class LeilaoCucumberRunner {

}
