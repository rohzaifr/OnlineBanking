$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D_BookFlight.feature");
formatter.feature({
  "line": 1,
  "name": "Book Flight Action",
  "description": "",
  "id": "book-flight-action",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "a global webdriver is used for test",
  "keyword": "Given "
});
formatter.match({
  "location": "BookFlightTest.a_global_webdriver_is_used_for_test()"
});
formatter.result({
  "duration": 7365675408,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Book Flight",
  "description": "",
  "id": "book-flight-action;book-flight",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@Book"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User is on the book flight page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User successfully login to application",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User select flight details",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Flight booked successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "BookFlightTest.user_is_on_the_book_flight_page()"
});
formatter.result({
  "duration": 51317,
  "status": "passed"
});
formatter.match({
  "location": "BookFlightTest.user_successfully_login_to_application()"
});
formatter.result({
  "duration": 4494637181,
  "status": "passed"
});
formatter.match({
  "location": "BookFlightTest.user_select_flight_details()"
});
formatter.result({
  "duration": 3179286203,
  "status": "passed"
});
formatter.match({
  "location": "BookFlightTest.flight_booked_successfully()"
});
formatter.result({
  "duration": 940846542,
  "status": "passed"
});
});