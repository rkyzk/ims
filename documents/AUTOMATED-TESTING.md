# Automated Testing

1.Features common to all pages
navigation links

2. Registration Controller<br>

|No.|Tested features                          |Pass/Fail|Image|Date        |
|:--|:----------------------------------------|:--------|:----|:-----------|
| 1 |Method getProductRegistration will get product registration page.|P        |--   |2024/4/16   |
| 2 |Method postProduct will redirect to the list page if the product is valid.|P        |--   |2024/4/16   |
| 3 |Message 'The product has been registered' will be displayed on the list page upon successful registration.|P        |--   |2024/4/16   |
biding results
image upload

**Tests on Validation**
|No.|Tested Validation|Test Content                          |Pass/Fail|Image|Date      |
|:--|:----------------|:-------------------------------------|:--------|:----|:---------|
| 4 |NotBlank for name|Value null for name causes a validation error.|P   |--   |2024/4/16 |
| 5 |max size=40 for name|40 characters for name pass validation.|P      |--   |2024/4/16 |
| 6 |max size=40 for name|41 characters for name fail validation.|P        |--   |2024/4/16 |
| 7 |max size=30 for manufacturer|30 characters for manufacturer pass validation.|P  |--  |2024/4/16 |
| 8 |max size=30 for manufacturer|31 characters for manufacturer fail validation.|P  |--   |2024/4/16 |
| 9 |min=1 & max =9999 for qty|Value 1 & 9999 for qty pass validation.|P     |--   |2024/4/16 |
| 10|min=1 & max =9999 for qty|Values 0 & 10000 for qty fail validation.|P    |--  |2024/4/16   |
| 11|NotNull for price|Values 'null' for price fails validation.|P      |--   |2024/4/16 |
| 12|DecimalMin=0.00 for price|0.00 for price passes validation.|P      |--   |2024/4/16 |
| 13|DecimalMin=0.00 for price|-0.50 for price fails validation.|P      |--   |2024/4/16 |
| 14|Digits constraint for prc|5 digits and 2 fraction for price passes validation.|P        |--   |2024/4/16 |
| 15|Digits constraint for prc|6 digits and 3 fraction for price fails validation.|P       |-- |2024/4/16 |
| 16|min=0 & max =99999 for stk|Values 0 and 99999 for stock pass validation.|P   |-- |2024/4/16 |
| 17|min=0 & max =99999 for stk|Values -1 and 100000 for stock fail validation.|P        |--   |2024/4/16   |

3. Product List Page

4. Update Page

5. Service class

