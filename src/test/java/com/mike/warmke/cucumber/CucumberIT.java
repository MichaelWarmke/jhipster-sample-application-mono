package com.mike.warmke.cucumber;

import com.mike.warmke.AbstractCassandraTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/features")
public class CucumberIT extends AbstractCassandraTest {}
