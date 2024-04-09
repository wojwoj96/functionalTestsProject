@test
Feature: Get all product from list

  Scenario: I can get all product names from store

    given Get all products from store
    then  Response with 200 is returned