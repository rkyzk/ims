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
With this Inventory Management System shops can keep product information, look at the product list, update and delete data.  

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

can't say 'where update_at = *{updatedAt}' need to convert datetime to string



when no image is added, get 'file not found exception'
if(!Objects.isNull(product.getMultipartFile())) not working.

update page:
When I click 'cancel,' message 'the product has been updated' appears.



## Todo 
make check box to remove the image
compare update time when updating & deleting

## Credit