package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish=true

        /**
         * publish will enable a functionality from cucumber to generate a public link for the report of our final execution of our code
         *     --> the link will be automatically generated and printed in the console
         *     --> it will be ready to share with anyone, if we don't want to share, change it to false
        */

        //mvn test -Dcucumber.filter.tags="@smoke" to run from "run anything" option
)


public class CukesRunner {


}
