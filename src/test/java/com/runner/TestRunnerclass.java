package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature/Login.feature",dryRun=true,glue="com.stepdefinition",plugin= {"pretty","html:target/Htmlreports"})


public class TestRunnerclass {

	
	
	
	
}
