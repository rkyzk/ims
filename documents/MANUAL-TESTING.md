# Manual Testing

Machine: MacOS
Screen width:

1. Registration Page
|Nr|Feature tested|Test content|Expected Results|Pass/Fail|Date|
|--|--------------|-----------------------------------------------------------|-|--------|
|1|layout|check if all elements on the page are displayed fine for screen size between 1000px and 1300px|All elements are displayed fine in the range of specified screen sizes.|p|2024/4/7|
|2|link|click the link to product list page|redirected to product list page|p|2024/4/7|


Test function to register product data and validation.
Enter the following product data, click 'register.'

|Nr|Feature tested|name|category|manufacturer|qty. per pack|price|stock|descrip|img|expected result|Pass/Fail|Date|
|--|--------------|----------------------------|-------------------------------|-|--------|
|3 | normality(category: tulips)|test1|tulips|test1|1|10.50|10|test item|test.jpg|the data will be inserted in the DB|||
|4 | normality(category: crocus)|test2|crocus|test2|1|10.50|10|test item|test.jpg|the data will be inserted in the DB|||
|5 | normality(category: hyacinth)|test3|hyacinth|test3|1|10.50|10|test item|test.jpg|the data will be inserted in the DB|||
|6 | normality(category: others)|test4|others|test4|1|10.50|10|test item|test.jpg|the data will be inserted in the DB|||
|7 | validation name 'not blank') |(leave blank)|tulips|test5|1|10.50|10|-|-|message 'must not be blank' will be displayed.|||
|8 | validation name size max=40) |aaaaabbbbbcccccdddddeeeeefffffggggghhhhh1|tulips|test6|1|10.50|10|-|-|message '' will be displayed.|||