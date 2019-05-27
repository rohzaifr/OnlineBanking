package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Runner file to run the scenarios from cucumber feature files
@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true
		,features = "Feature"
		,glue = {"TestCases"}
//		,dryRun = true
		,plugin = {"pretty","html:target/cucumber-html-report"}
//		,plugin = {"pretty","json:target/cucumber-json-report/report.json"}
//		,plugin = {"pretty","junit:target/cucumber-xml-report/report.json"}
		,tags = {"@Login,@Search,@Select,@Book"}
		)

public class TestRunner {

}
