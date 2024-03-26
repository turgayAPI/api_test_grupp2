package com.example.api_test_grupp2;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("api_test_grupp2")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class CukesRunnerTest {
}
