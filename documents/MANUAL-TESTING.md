# Manual Testing

Machine: MacOS
Screen width:

1. Registration Page
1-1 Check the layout and the link
|Nr|Feature tested|Test content|Expected Results|Pass/Fail|Date|
|:-|:--------------|:-----------------------------------------------------------|:-|:--------|
|1|layout|check if all elements on the page are displayed fine for screen size between 1000px and 1300px|All elements are displayed fine in the range of specified screen sizes.|p|2024/4/7|
|2|link|click the link to product list page|redirected to product list page|p|2024/4/7|


1-2 Test function to register product data.
- Enter the following product data, and click 'register.'

|Nr|Feature tested|name|category|manufacturer|qty. per pack|price|stock|descrip|img|expected result|Pass/Fail|image|Date|
|:-|:-------------------|:--------|:--------|:--------|:-|:-------|:---|:--------|:--------|:-----------|:--|:--|:--|
|3 | normality(category: tulips)|test1|tulips|test1|1|10.50|10|test item|test.jpg|The data will be inserted in the DB||||
|4 | normality(category: crocus)|test2|crocus|test2|1|10.50|10|test item|test.jpg|the data will be inserted in the DB||||
|5 | normality(category: hyacinth)|test3|hyacinth|test3|1|10.50|10|test item|test.jpg|the data will be inserted in the DB||||
|6 | normality(category: others)|test4|others|test4|1|10.50|10|test item|test.jpg|the data will be inserted in the DB||||
|7 | normality file path|test|others|test|1|10.50|10|test item|test.jpg|'others/test.jpg' will be inserted as file_path. ||||
|8 | normality file name|test|others|test|1|10.50|10|test item|test.jpg|'test.jpg' will be inserted as file_name. ||||
|9 | normality created at|test|others|test|1|10.50|10|test item|test.jpg|The time the product was registered will be inserted as created_at  ||||
|10 | normality updated at|test|others|test|1|10.50|10|test item|test.jpg|The time the product was registered will be inserted as updated_at  ||||
|11 | normality del flg|test|others|test|1|10.50|10|test item|test.jpg|The del_flg value will be set 0.||||

1-3 Test validation
|Nr|Feature tested|name|category|manufacturer|qty. / pack|price|stock|descrip|img|expected result|Pass/Fail|image|Date|
|:-|:-------------------|:--------|:--------|:--------|:-|:-------|:---|:--------|:--------|:-----------|:--|:--|:--|
|12 | validation name 'not blank' |(leave blank)|tulips|test5|1|10.50|10|-|-|message 'must not be blank' will be displayed.||||
|13 | validation name size max=40 |aaaaabbbbbcccccdddddeeeeefffffggggghhhhh|tulips|test6|1|10.50|10|-|-|the data will be registered in the DB.||||
|14 | validation name size max=40 |aaaaabbbbbcccccdddddeeeeefffffggggghhhhh1|tulips|test6|1|10.50|10|-|-|message '' will be displayed.||||
|15 | validation manufaturer 'not blank' |test|tulips|(leave blank)|1|10.50|10|-|-|message 'must not be blank' will be displayed.||||
|16 | validation manufaturer size max=30 |test|tulips|aaaaabbbbbcccccdddddeeeeefffff|1|10.50|10|-|-|the data will be registered in the DB.||||
|17 | validation manufaturer size max=31 |test|tulips|aaaaabbbbbcccccdddddeeeeefffff1|1|10.50|10|-|-|message '' will be displayed.||||
|18 | validation quantity min=1|test|tulips|test|1|10.50|10|-|-|message '' will be displayed.||||
|19 | validation quantity min=1|test|tulips|test|0|10.50|10|-|-|message '' will be displayed.||||
|20 | validation quantity max=9999|test|tulips|test|9999|10.50|10|-|-|the data will be registered in the DB.||||
|21 | validation quantity max=9999|test|tulips|test|10000|10.50|10|-|-|message '' will be displayed.||||
|22 | validation quantity not null|test|tulips|test|(delete 0 and leave blank)|10.50|10|-|-|message 'must not be blank' will be displayed.||||
|23 | validation price not null|test|tulips|test|1|(leave blank)|10|-|-|message 'must not be blank' will be displayed.||||
|24 | validation price decimal min=0.00|test|tulips|test|1|0.00|10|-|-|the data will be registered in the DB.||||
|25 | validation price decimal min=0.00|test|tulips|test|1|-0.01|10|-|-|message '' will be displayed.||||
|26 | validation price digits(integer=5, fraction=2)|test|tulips|test|1|12345.12|10|-|-|the data will be registered in the DB.||||
|27 | validation price digits(integer=5, fraction=2)|test|tulips|test|1|1.111|10|-|-|message '' will be displayed.||||
|28 | validation stock min=0|test|tulips|test|1|10.50|0|-|-|the data will be registered in the DB.||||
|29 | validation stock min=0|test|tulips|test|1|10.50|-1|-|-|message '' will be displayed.||||
|30 | validation stock max=99999|test|tulips|test|1|10.50|99999|-|-|The data will be registered.||||
|31 | validation stock max=100000|test|tulips|test|1|10.50|100000|-|-|message '' will be displayed.||||
|32 | validation stock default=0|test|tulips|test|1|10.50|(leave blank)|-|-|Stock will be set 0 in the DB.||||
|33 | validation description size max=200|test|tulips|test|1|10.50|1|(enter 200 characters)|-|the data will be inserted in the DB.||||
|34 | validation description size max=200|test|tulips|test|1|10.50|1|(enter 201 characters)|-|message '' will be displayed.||||
|35 | validation description not required|test|tulips|test|1|10.50|1|(leave blank)|-|The data will be inserted in the DB.||||
|36 | validation image normality|test|tulips|test|1|10.50|1|-|upload test.jpg|The image data will be inserted in the DB.||||
|37 | validation image file type|test|tulips|test|1|10.50|1|-|upload test.doc|message '' will be displayed.||||
|38 | validation image file max size = 819200|test|tulips|test|1|10.50|1|-|upload test2.jpg with size |message '' will be displayed.||||
|39 | validation image file name length = 30|test|tulips|test|1|10.50|1|-|upload 1234567890123456778901234567890.doc|the data 
will be inserted in the DB.||||
|40 | validation image file name length = 30|test|tulips|test|1|10.50|1|-|upload test.doc|messge 'File name length must not exceed 30' will be displayed.||||
|41 | validation multiple fields|(leave blank)|tulips|(leave blank)|-1|10.501||-|upload test.doc|messge 'File name length must not exceed 30' will be displayed.||||
