# Exception Handling for Cosmetics Shop

## Description
You are given a software system for managing a cosmetics shop. The system is already implemented and works. It supports one type of products that can be grouped in categories. The user can:
- Create a category;
- Create a product;
- Add a product to a category;
- Show a category;

## Task
Your **task** is to improve the solution by adding proper **exception handling**
which serves the need to validate the user input and provide informative and useful messages.
The user input should meet the following requirements.

### 1. Category                                     
- Name should be between 3 and 10 symbols.    //DONE
- Name should be unique in the system.        //DONE

### 2. Product
- Name should be between 3 and 10 symbols.     //DONE
- Name should be unique in the system.
- Brand should be between 2 and 10 symbols.    //DONE
- Price cannot be negative.                    //DONE       
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**. 

### 3. Commands
- Each command expects exact number of parameters.
- Each command expects correct parameters in correct format.

## Constraints
- All classes and methods should remain as they are.
- You can define your own exceptions.
- You can add try-catch blocks.
- You should throw proper exceptions with proper messages.

## Additional notes
- Follow the exception handling best practices.
- Throw exceptions where the program can not continues its normal flow.
- Handle exceptions where you can address the problem in the best way.

## Step by step guide

**Hint** There are **TODOs** in the code to help you.

**1.** Define your type of exception(s) that will serve your needs.

- You can start with one custom exception and later add more if you need.

**2.** Implement models fields validation.

**3.** Implement command arguments validations (arguments count and value).

**4.** Add exception handling to `CommandFactoryImpl` class.

- What should happen if the user enters an invalid command?
- What should happen if the enum `CommandType` has commands that don't have a command class?

**5.** Add exception handling to the `EngineImpl` class.

## Input example

```
SomeCommand
CreateCategory S
CreateCategory Shampoos
CreateCategory Shampoos
CreateProduct MyMan 10.99 Men
CreateProduct MyMan N 10.99 Men
CreateProduct MyMan Nivea price Men
CreateProduct MyMan Nivea -5.99 Men
CreateProduct MyMan Nivea 10.99 Gender
CreateProduct MyMan Nivea 10.99 Men
CreateProduct MyMan Nivea 10.99 Men
AddProductToCategory Shampo MyMan
AddProductToCategory Shampoos MyBoy
AddProductToCategory Shampoos MyMan
CreateProduct MyWoman Nivea 17.99 Women
AddProductToCategory Shampoos MyWoman
ShowCategory Shampo
ShowCategory Shampoos
Exit
```

## Output Example

```
Command SomeCommand is not supported.
Category name should be between 3 and 10 symbols.
Category with name Shampoos was created!
Category Shampoos already exist.
CreateProduct command expects 4 parameters.
Product brand should be between 2 and 10 symbols.
Third parameter should be price (real number).
Price can't be negative.
Forth parameter should be one of Men, Women or Unisex.
Product with name MyMan was created!
Product MyMan already exist.
Category Shampo does not exist.
Product MyBoy does not exist.
Product MyMan added to category Shampoos!
Product with name MyWoman was created!
Product MyWoman added to category Shampoos!
Category Shampo does not exist.
#Category: Shampoos
#MyMan Nivea
 #Price: $10,99
 #Gender: Men
 ===
#MyWoman Nivea
 #Price: $17,99
 #Gender: Women
 ===
```