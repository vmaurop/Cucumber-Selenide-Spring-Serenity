# Google Test
Automated Tests for Google Application.

Tools: Java - Serenity - Cucumber - Selenide - SerenityAssured - Awaitility

## Getting Started
Following below instructions, automated tests can be executed locally
 
### Prerequisites
```
- Maven 3.5 or newer
- Java 1.8
```

### Execution

For local or remote (via Zalenium) execution, there are 2 CMD scripts that can be used:
```
\local-execution.cmd
```

```
\remote-execution.cmd
```

### Configuration

Before executing the tests using the above CMD scripts, arguments of the first row that contains the maven build command could be updated accordingly:
    
For the local-execution.cmd

    call mvn clean verify -Dcontext="chrome" -Dwebdriver.driver=chrome -Dinjected.tags=browser:chrome -Dcucumber.options="--tags '(not @security) and (@UI or (not @UI and not @API))'" %*
    
    :: to select browser for the execution, the possible values are: chrome OR firefox OR ie OR edge
    -Dcontext="chrome"
    -Dwebdriver.driver=chrome
    -Dinjected.tags=browser:chrome


#### IDE execution
To run the tests via IDE there is a test runner class under src/test/java/com/vmaurop/bdd/runners named TestRunner.

TestRunner can be updated with tags option as described in examples below:

    :: To run all test cases, select below tags and comment all other tags
    tags = {"(not @security) and (not @wip) and (@UI or (not @UI and not @API))"}

    :: To run all test cases for a feature file, select below tags and comment all other tags for example to run all test cases for login feature file select:
    tags = {"(not @security) and (not @wip) and (@UI or (not @UI and not @API)) and (@LOGIN)"}

    :: To run one test case, select below tags and comment all other tagsfor example to run first test case from login feature file select:
    tags = {"(not @security) and (not @wip) and (@UI or (not @UI and not @API)) and (@TC-UI-EDB-LOGIN-001)"}

Then right click on Run Test icon and run (or debug) TestRunner.

#### DRY Execution
DRY Execution is needed to generate a report with the content of the feature files without executing the tests.

Open file "serenity.properties", and update value of variable "serenity.dry.run" to "true".

    serenity.dry.run=true

After updating the above variable, an execution can be done as described above. 

### Test Results

Serenity Report is used for the test results. An HTML Report can be found after execution under /target/site/serenity/
with name index.html

## Project structure documentation
```
src\java\package\ui                 UI Pages, Page Elements
src\java\package\actions            Actions, Questions, behaviours of the SUT - for more complex should be divided in Actions and Questions.
src\java\package\configuration      Confiuration, set of classes to get environment properties, spring config classes etc.
src\java\package\stepdefs           Step definitions used by cucumber
src\resources\conf\                 environment properties in yaml
test\resources\features             Cucumber features in gherkin
```



### Other Clarifications:
- Test cases with @wip annotation are not ready yet, use tag "not @wip" in TestRunner
- All classes that have getters/setters (under src/main/java/com/vmaurop/bdd/configuration) are updated to use lombok library.
For lombok library following steps are done: maven dependency added, Intellij plugin installed and annotations @Getter @Setter are added.

