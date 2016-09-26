Excel file can be downloaded <a href="https://github.com/weiyikong/Projects/raw/master/CSV%20Parsing/2.Excel%20Solution/excel%20sheets.xlsx">here</a>

<b>You are working with 3 files </b> <br>
1. Large .csv file from Big Commerce (Manage->Products->Export->"bulk edit")<br>
2. Smaller file containing all the changes <br> 
3. Excel file found here containing the VLOOKUP formula <br>


#Price Change
![](../Screenshots/excel.JPG?raw=true)

1. Copy & Paste SKU (from Big Commerce .csv) to column A<br> 
2. Copy & Paste Price (from Big Commerce .csv) to column B<br> 
3. Copy & Paste SKU (from new price excel sheet) to column D<br> 
4. Copy & Paste Price (from new price excel sheet) to column E <br>
5. Make sure the formula is extended to all rows in column C <br> 
6. Copy & Paste the new price from column C to the big .csv file

#SKU Change
![](../Screenshots/excel2.JPG?raw=true)

1. Copy & Paste SKU (from Big Commerce .csv) to column A<br> 
2. Copy & Paste SKU (from new price excel sheet) to column D<br> 
3. Copy & Paste Price (from new price excel sheet) to column E <br>
4. Make sure the formula is extended to all rows in column B<br> 
5. Copy & Paste the new SKU from column B to the big .csv file

#Deletion 
![](../Screenshots/excel3.JPG?raw=true)

1. Copy & Paste SKU (from new price excel sheet) to column A <br>
2. Copy & Paste SKU (from new price excel sheet) to column D <br>
3. Make sure the formula is extended to all rows in column B<br> 
4. Copy & Paste the new SKU from column B to the big .csv file<br>
5. SKU has a value of 0, if it needs to be deleted. <br> 
6. In big .csv file, first sort by SKU, then delete delete rows with SKU value of 0

