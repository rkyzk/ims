# Inventory Management System

Link to the deployed site:

## Contents
[Overview](#overview).<br>
Main Technologies Used.
[Functions]
User Stories
Data Modeling
Details about Each Page
Deployment Process
Manual Testing
Bugs
Features to be Included in the Future
Credit


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

| Intro         | User Stories                           | How they are achieved |
| :------------ | :------------------------------------- | --------------------- |
| As user I can | register product information.          | register product page |
|               | upload product image.                  | image can be uploaded on register & update pages |
|               | find out if input data is inappropriate.| validation messages  |
|               | 

## Data Modeling

## Details about Each Page

### Product Registration page
### Product List page
### Update page

## Deployment Process

## Manual Testing 

## Bugs
1. 'getProductList' and 'getProduct' methods were not getting camel-cased variables from the DB.(filePath, updatedAt)
I resolved the issue by adding the following line in application.properties.<br>
`mybatis.configuration.map-underscore-to-camel-case=true`

2. Clicking 'clear' didn't clear the information on registration page.
I changed the following, and the issue was resolved.<br>

3. After clicking 'cancel' on update page, success message 'The product has been updated' appeared after redirecting to the list page.  I changed the following in order to resolve the issue.<br>

## Features to be Included in the Future
- When products are deleted, I want to add a function to delete correponding images from S3 Bucket.
- I want to implement search and filter functions for products.

## Credit
