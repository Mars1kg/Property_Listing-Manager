# Property_Listing-Manager

## Student: Zhyldyzbekov Sultan 



## Description:

The Property Listing Manager is a Java-based application designed to manage property listings efficiently. It allows users to add, view, update, delete, and analyze property listings such as rentals and sales. All data is stored in a text file for persistence, making it easy to manage property records seamlessly.

## Objectives:

#### 1. Efficiently manage property listings (sale and rental).

# 2. Store property data in a text file for easy access and persistence.

# 3. Allow users to add new properties with unique IDs.

# 4. Enable updates to existing property information.

# 5. Provide functionality to delete property records by ID.

# 6. Display all property listings in a user-friendly format.

# 7. Show statistics about the number of properties for sale and for rent.

# 8. Ensure data is consistently saved and loaded from a text file.

# 9. Validate user input to prevent errors and maintain data integrity.

# 10. Handle exceptions gracefully to prevent application crashes.

    

## Project Requirement List:

# 1. Add new property listings with unique IDs.

# 2. Display all property listings.

# 3. Modify existing property information.

# 4. Delete property listings by ID.

# 5. Show statistics for properties for sale and for rent.

# 6. Load data from a text file at startup.

# 7. Save data to a text file after every modification.

# 8. Validate price inputs to be greater than zero.

# 9. Prevent duplicate IDs when adding new properties.

10. Gracefully handle exceptions during file operations and user input.
    

## Documentation:

The application uses the following main components:

1. Data Structures:

ArrayList<Property>: To store the list of properties in memory.

2. File Handling:

Scanner: For reading data from the file.

PrintWriter: For writing data to the file.

3. Modules/Functions:

loadFromFile(): Loads existing properties from the text file.

saveToFile(): Saves current properties to the text file.

addNew(): Adds a new property after validating the ID.

showAll(): Displays all properties in a readable format.

change(): Modifies the details of an existing property.

delete(): Removes a property from the list and updates the file.

stats(): Displays statistics of properties available for sale and rent.

4. Error Handling:

Uses try-catch blocks to handle exceptions like FileNotFoundException and InputMismatchException.


## Code:

The code is structured with modular functions for each action.

Follows best practices for clean and readable code.

Uses meaningful variable names and consistent formatting.

Input validation is performed to prevent incorrect entries.

## Files:

properties.txt: Used to store property data persistently. This file is read at application startup and updated after every modification.


## Screenshots:
![1](https://github.com/Mars1kg/Property_Listing-Manager/blob/master/1.1.png)
![1](https://github.com/Mars1kg/Property_Listing-Manager/blob/master/1.2.png)
![1](https://github.com/Mars1kg/Property_Listing-Manager/blob/master/1.3.png)
![1](https://github.com/Mars1kg/Property_Listing-Manager/blob/master/1.4.png)
![1](https://github.com/Mars1kg/Property_Listing-Manager/blob/master/1.5.png)
