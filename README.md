# Selenium Test

## Stack
 * Selenium
 * Java
 * Maven
 * allure-testNG
 * TestNG

## Estructure

    |--allure-report
    |
    |--allure-results
    |
    |--src
        |--main
        |--test
            |--java
                |--SwagLabs
                |--fixures
                |--pages
                |--Tests

## Allure commands

* **Generate html**:
````shell
  allure generate
````

* **Run server to show html page results**:
````shell
  allure serve
````

## main package

this package contain examples for practice the basic actions and methods in **Selenium**

the content about the TestCase examples is in the test package.

## test

this package contain the structure basic about de the testcases 

`pages` is the package about the models (pages object model) of the pages from website.

`Tests` is the package about the testcases.