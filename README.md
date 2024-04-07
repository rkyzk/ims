# Inventory Management System

Link to the deployed site:

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
With this Inventory Management System shop owners can register products information,
look at the product list, update and delete data.
The app comes with functions such as input validation, delete confirmation,
success/error messages upon registering, updating and deleting products.

## Main Technologies Used
HTML5, CSS3, Java (Spring Boot), Bootstrap5, jquery, PostgreSQL

## Funcitions
**Main functions**
- Register products data including images
- Display Product List
- Update products data
- Delete products

**Supplementary functions**
- Display success messages when products have been registered, updated or deleted.
- Validate input data while registering and updating products and show error messages
  when validation fails.
- Display a confirmation modal before deleting products.


## User Stories

|Intro |User Stories | How they are achieved |
| ------------ |-------------------------------| --------------------- |
|As user I can | register product information. | register product page |

## Data Modeling

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

public address
ec2-13-230-46-21.ap-northeast-1.compute.amazonaws.com


## Credit



https://www.flowerglossary.com/types-of-tulips/