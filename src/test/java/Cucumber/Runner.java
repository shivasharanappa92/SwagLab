package Cucumber;
//main

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features={"C:\\Users\\shiva\\Desktop\\sprint2\\src\\test\\java\\Cucumber\\Property.feature"},
        glue ="StepDefinations",
        plugin={"html:target/cucumber_html_report.html"}
)

public class Runner extends AbstractTestNGCucumberTests {

}