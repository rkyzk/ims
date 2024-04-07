# Inventory Management System

## Contents
Overview
Main Technologies Used
User Stories
Functions
Functions of Each Page
Data Modeling
Manual Tests
Media
Credit
Deployment Process

## Overview
With this Inventory Management System shop owners can keep products information, look at the product list, update and delete data.  

## Main Technologies Used
HTML5, CSS3, Java (Spring Boot), Bootstrap5, jquery, Postgresql

## Funcitions
Main functions
1. Register products data including images
2. Display Product List
3. Update products data
4. Delete products

other functions
- Display success messages when products have been registered, updated or deleted.
- Validate input data on register and update pages and show error messages
  when required fields are left blank,
- Display confirmation modal before deleting products.

## Register Product page

## Product List page

## 


## Bugs

can't get properties with camel-cased names from the DB(filePath, updatedAt)

mybatis.configuration.map-underscore-to-camel-case=true

registration clear button after having validation errors

when no image is added, get 'file not found exception'
if(!Objects.isNull(product.getMultipartFile())) not working.

update page:
When I click 'cancel,' message 'the product has been updated' appears.





## Credit



https://www.flowerglossary.com/types-of-tulips/