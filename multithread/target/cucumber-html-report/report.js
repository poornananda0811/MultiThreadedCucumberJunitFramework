$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/FeatureFile1.feature");
formatter.feature({
  "name": "Navigate to the Google.com",
  "description": "  Navigate to the Google.com",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "I want to navigate to google",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@firsttest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open the Browser and Navigate to the URL \"https://www.Google.com/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs.i_open_the_Browser_and_Navigate_to_the_URL(String)"
});
formatter.write("Opened the Browser with URL: https://www.Google.com/");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User enters the text in search field",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.user_enters_the_text_in_search_field()"
});
formatter.write("Entered text Hello");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.uri("features/FeatureFile2.feature");
formatter.feature({
  "name": "Navigate to the amazon.in",
  "description": "  Navigate to the amazon.in",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "I want to navigate to amazon",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@firsttest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open the Browser and Navigate to the URL \"https://www.amazon.in/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs.i_open_the_Browser_and_Navigate_to_the_URL(String)"
});
formatter.write("Opened the Browser with URL: https://www.amazon.in/");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the link",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.user_clicks_on_the_link()"
});
formatter.write("User clicks on Orders link");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
});