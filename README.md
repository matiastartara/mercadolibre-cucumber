

# mercadolibre-cucumber

Example project that automates searches on MercadoLibre using Cucumber, TestNG and Selenium WebDriver.

Checklist of changes included in this README:

- [x] Rewritten and structured README in English
- [x] Installation and run instructions for IDE and terminal
- [x] Documented execution parameters (browser, headless, tags)
- [x] Location of reports and troubleshooting tips

## Requirements

- Java 17
- Maven 3.x
- (Optional) IntelliJ IDEA with TestNG and Cucumber for Java plugins for easier execution/debug
- Browsers: Google Chrome and/or Microsoft Edge
- Corresponding WebDriver binaries (chromedriver / msedgedriver) available in your PATH or installed on the system. The project instantiates ChromeDriver/EdgeDriver directly, so make sure the drivers are compatible with your browser versions.

Note: To avoid managing driver binaries manually consider integrating WebDriverManager into the project.

## Key project structure

- `src/main/java/pages` - Page Objects
- `src/main/java/utils/Driver.java` - WebDriver helper (reads TestNG parameters)
- `src/test/java/suite/allTests.xml` - TestNG suite with parameters (browser, headless, cucumber.filter.tags)
- `src/test/resources/features` - Cucumber feature files

## Installation / Setup

1. Clone the repository:

```bash
git clone <repo-url>
```

2. Import the project in IntelliJ as a Maven project or resolve dependencies from the command line:

```bash
mvn -U -q dependency:resolve
```

3. Make sure `chromedriver` and/or `msedgedriver` are accessible in your PATH or placed in a known location.

## Running the tests

Common options:

- From IntelliJ (recommended during development):
  - Open `src/test/java/suite/allTests.xml`, right-click and select Run. The suite contains `browser` and `headless` parameters.

- From the terminal with Maven:
  - Run all tests (default configuration):

```bash
mvn clean test
```

  - Run the TestNG `TestRunner` class directly:

```bash
mvn -Dtest=TestRunner test
```

  - You can pass Cucumber/TestNG properties as system properties. For example, to filter by tags:

```bash
mvn -Dcucumber.filter.tags="@smoke" clean test
```

Note: Depending on Surefire configuration, passing TestNG XML parameters from the command line may require setting system properties or creating an explicit XML suite.

### Important parameters

- `browser` (defined in `allTests.xml`): "chrome" or "edge" (default: `chrome`).
- `headless` (defined in `allTests.xml`): "true" or "false" to run browsers in headless mode.
- `cucumber.filter.tags` (defined in `allTests.xml`): controls which scenarios to run (e.g. `@smoke`, `@All`).

To change the browser or headless mode, edit `src/test/java/suite/allTests.xml` or create a new TestNG XML suite with different parameters.

## Reports

- The project generates an HTML Cucumber report at `target/cucumberReport.html`.
- Detailed HTML reports are available under `target/cucumber-report-html/cucumber-html-reports/` (for example, `All.html`).

## Troubleshooting

- If you get an error like "driver executable needs to be available in the path", install the appropriate driver (chromedriver/msedgedriver) and add it to your PATH.
- If the browser launches but selectors fail, verify that MercadoLibre page structure hasn't changed and update selectors in `src/main/java/pages` accordingly.
- For dependency/build issues, run with verbose output to see the full stacktrace:

```bash
mvn -U clean test -e
```

## Contributing

If you want to contribute:

1. Fork the repository and create a feature branch.
2. Keep code style consistent and ensure tests pass: `mvn clean test`.
3. Open a Pull Request describing your changes.

## Contact

Project by matiastartara.

[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/matiastartara/mercadolibre-cucumber)




