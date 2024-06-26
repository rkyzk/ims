# Inventory Management System

Link to the deployed site:

### Contents
- [Overview](#overview)
- [Main Technologies Used](#main-technologies-used)
- [Functions](#functions)
- [User Stories](#user-stories)
- [Data Modeling](#data-modeling)
- [Each Page in Detail](#each-page-in-detail)
- [Deployment Process](#deployment-process)
- [Automated Testing](#automated-testing)
- [Manual Testing](#manual-testing)
- [Bugs](#bugs)
- [Features to be Included in the Future](#features-to-be-included-in-the-future)
- [Credit](#credit)

### Overview
With this Inventory Management System, shop owners can register product information,
look at the product list, update and delete data.
The app comes with functions such as input validation, delete confirmation,
success/error messages upon registering, updating and deleting products.

### Main Technologies Used
HTML5, CSS3, Java (Spring Boot), Bootstrap5, jquery, PostgreSQL

### Functions
**Main functions**
- Register product data including images
- Display Product List
- Update products data
- Delete products

**Supplementary functions**
- Display success messages when products have been registered, updated or deleted.
- Validate input data while registering and updating products and show error messages
  if validation fails.
- Display a confirmation modal before deleting products.


### User Stories

*As user I...*

|Nr.| User Stories                               | How they are achieved |
| - | :----------------------------------------- | --------------------- |
| 1 | can register product information.          | register product page |
| 2 | can upload product image.                  | image can be uploaded on register & update pages |
| 3 | get notified if input data is inappropriate| validation messages  |
| 4 | can look at the product list               | product list page     |
| 5 | can find out how many products are registered. | total number of items is displayed above the table on the right side on product list page     |
| 6 | can update product information             | update product page   |
| 7 | can delete product                         | product list page     |
| 8 | get confirmation before deleting product   | product list   page   |
| 9 | can easily navigate through all pages      | navigation links, update buttons on list page |

### Data Modeling

The app uses the following 'Product' entity:<br>
<br>
<img style="width: 500px;"src="./src/main/resources/media/data-modeling-ims.jpg" alt="data modeling for the product" />

### Each Page in Detail

1.Product Registration page<br>
2.Product List page<br>
3.Update page<br>

### Deployment Process

### Automated Testing
Automated Testing is documented [here](./documents/AUTOMATED-TESTING.md).

### Manual Testing
Manual Testing is documented [here](./documents/MANUAL-TESTING.md).

### Bugs
1. 'getProductList' and 'getProduct' methods were not getting values stored in variables filePath and updatedAt.  That happened because snake cased variables in postgreSQL were not converted into camel-cased variables.  I resolved the issue by adding the following line in application.properties.<br>
`mybatis.configuration.map-underscore-to-camel-case=true`

2. Sensitive data I wrote in application-local.properties were not imported in application.properties.
I was missing "${}" around the variables.  I added it, and that solved the issue.

3. delete confirmation

Things to fix:
registration page
int can't be null
quantity min = 1, so don't allow the counter to go below 1.
also in case of "", fill in 1 onBlur with JS

### Features to be Included in the Future
- When products are deleted, I want to add a function to delete correponding images from S3 Bucket.
- It'd be nice to have search and filter functions for products.

### Credit

- On JUnit tests<br>
https://www.vogella.com/tutorials/JUnit/article.html
https://www.digitalocean.com/community/tutorials/junit-setup-maven
https://stackoverflow.com/questions/57465271/how-to-create-objects-for-all-junit-tests
https://stackoverflow.com/questions/29069956/how-to-test-validation-annotations-of-a-class-using-junit
https://stackoverflow.com/questions/58207609/java-mock-multipartfile-in-unit-test
https://ziqoo.com/cms/Java/MyBatis/生成されたMapperの動作確認

mock multipart files
https://www.baeldung.com/java-convert-byte-array-to-multipartfile

parameterResolver
https://www.baeldung.com/junit-5-parameterresolutionexception
