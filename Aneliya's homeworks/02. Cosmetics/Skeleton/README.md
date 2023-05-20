## OOP Workshop - Principles (Cosmetics shop)

### Description
The shop already has a working Engine. You do not have to touch anything in it. Just use it.

There should be three types of products, Shampoos, Creams and Toothpastes. 
- Each Shampoo has **name, brand, price, gender, milliliters, usage**. 
- Each Toothpaste has **name, brand, price, gender, ingredients**.
- Each Cream has **name, brand, price, gender**.

### Task
Your **task** is to **design an object-oriented class hierarchy** to model the cosmetics shop, **using the best practices for object-oriented programming** (OOP). Encapsulate correctly all fields and use validation whenever needed.

#### 1. ShampooImpl 
- Extends ProductBase
- It has name, brand, price, gender, milliliters, usage
- Minimum shampoo name’s length is 3 symbols and maximum is 10 symbols.
- Minimum shampoo brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**.
- Milliliters are not negative number
- Usage type can be **"EveryDay"** or **"Medical"**

#### 2. ToothpasteImpl
- Extends ProductBase
- It has name, brand, price, gender, ingredients
- Minimum toothpaste name’s length is 3 symbols and maximum is 10 symbols.
- Minimum toothpaste brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**.

#### 3. CreamImpl
- Extends ProductBase
- It has name, brand, price, gender, scent
- Minimum cream name’s length is 3 symbols and maximum is 10 symbols.
- Minimum cream brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**.
- Scent type can be **"Rose"**, **"Lavender"** or **"Vanilla"**.

### Constraints
- Look into the example below to get better understanding of the printing format.
- All double number type fields should be printed with formatting **0.00** as in the example output.
- If a null value is passed to some mandatory property, your program should throw a proper exception.

### Additional notes
- To simplify your work you are given an already built execution engine that executes a sequence of commands read from the console using the classes and interfaces in your project (see the Cosmetics-Skeleton folder).
- Please, look the classes in **cosmetics.models** package. You do not need to create new classes!

### Input example

```
CreateShampoo MyMan Nivea 10.99 Men 1000 EveryDay
CreateCream MyCream Nivea 12.99 Men Lavender 
CreateToothpaste White Colgate 10.99 Men calcium,fluorid
CreateCategory Shampoos
CreateCategory Toothpastes
CreateCategory Creams
AddToCategory Shampoos MyMan
AddToCategory Creams MyCream
AddToCategory Toothpastes White
AddToShoppingCart MyMan
AddToShoppingCart White
AddToShoppingCart MyCream
ShowCategory Shampoos
ShowCategory Toothpastes
ShowCategory Creams
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Output Example

```
Shampoo with name MyMan was created!
Cream with name MyCream was created!
Toothpaste with name White was created!
Category with name Shampoos was created!
Category with name Toothpastes was created!
Category with name Creams was created!
Product MyMan added to category Shampoos!
Product MyCream added to category Creams!
Product White added to category Toothpastes!
Product MyMan was added to the shopping cart!
Product White was added to the shopping cart!
Product MyCream was added to the shopping cart!
#Category: Shampoos
#MyMan Nivea
 #Price: $10.99
 #Gender: Men
 #Milliliters: 1000
 #Usage: EveryDay
 ===
#Category: Toothpastes
#White Colgate
 #Price: $10.99
 #Gender: Men
 #Ingredients: [calcium, fluorid]
 ===
#Category: Creams
#MyCream Nivea
 #Price: $12.99
 #Gender: Men
 #Scent: Lavender
 ===
$34.97 total price currently in the shopping cart!
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
$23.98 total price currently in the shopping cart!
```

### Unit Tests

You are given unit tests to keep track of your progress.

## Step by step guide

#### **Hint**: You don't need to take care of the Engine class and the Main method but of course you could try to understand how they work.



**1.** You are given a skeleton of the Cosmetics shop.
 Please take a look at it carefully before you try to do anything. 
 Try to understand all the classes and interfaces in **cosmetics.models** package and how they work. (You should not touch the other packages at all).

**2.** Build the project and run some commands. The following exceptions will tell you where features 
should be implemented.

**3.** Validate all the fields. Yes, again :)

**4.** Did you notice the repeating code in the ShampooImpl, CreamImpl and ToothpasteImpl classes. What should you do in ProductBase class?

**5.** Implement **print()** methods (there are print() methods in the Product and Category interfaces).

#### **Hint**: Use the Unit tests when you finish the task.
