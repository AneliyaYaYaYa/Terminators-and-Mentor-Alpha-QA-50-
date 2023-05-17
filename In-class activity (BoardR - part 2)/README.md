# BoardR - Task Organizing System

_Part 2_

## 1. Description

**BoardR** is a task-management system which will evolve in the next several weeks. During the course of the project, we will follow the best practices of `Object-Oriented Programming` and `Design`.

## 2. Goals

Your goals for this part of the project are to properly encapsulate **BoardItem** and **Board**.

You will also enhance individual board items and the board with the ability to **keep track of the history of their changes**.

## 3. Encapsulate the BoardItem Class

### Issues

Currently, the BoardItem class works well, but may be **misused**. All the members of the class are available outside the class, which may lead to mistakes. For example, the **status** can be freely changed:

```java
BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
item.advanceStatus(); // properly changing the status
item.advanceStatus();
System.out.println(item.viewInfo()); // Status: InProgress

item.status = Status.OPEN; // ??
System.out.println(item.viewInfo());; // Status: Open
```

> **Note**: Developers will not intentionally break code like in the example above; however, a new developer on the team will not be aware that we are not supposed to directly manipulate the **status** field. This can lead to subtle bugs.
We can solve the issue with the **status** field by restricting who can access it.

```java
private Status status;
```

To let the outside code read this value, we can create a getter:

```java
public Status getStatus() {
   // return the value of the status field
      return status;
   }
```

### Description

We are done with the status field, but there are two more fields - **dueDate** and **title**. They are still public and can be freely changed. Let's encapsulate those fields.

- dueDate - can be changed, but the new value should not be in the past.
- title - can be changed, but the new title must be at least 5 characters long, and no more than 30.

You can use setters to perform the validations:

> Note: Always start off with `private` setters. If the need arises, you can change them later.

```java
public String getTitle() {
     return title;
 }

public void setTitle(String title) {
   // perform validations
   if (title.length() < 5 || title.length() > 30) {
       throw new IllegalArgumentException("Please provide a title with length between 5 and 30 chars");
   }

   // set only if valid, otherwise throw exception with some meaningful message
   this.title = title;
}
```

After the changes, test with the following code:

```java
BoardItem item = new BoardItem("Rewrite everything", LocalDate.now().plusDays(2));

// compilation error if you uncomment the next line:
// item.title = "Rewrite everything immediately!!!";
// we made title private so it cannot be accessed directly anymore

item.setTitle("Rewrite everything ASAP!!!"); // properly changing the title
System.out.println(item.getTitle()); // properly accessing the title
item.setTitle("Huh?"); // Exception thrown: Please provide a title with length between 5 and 30 chars

```

Perform the same encapsulations for the dueDate field. Ensure that an exception is thrown if the new date is before LocalDate.now().

## 4. EventLog class

### Description

In order to keep track of each operation that we perform on an item or in the board, we need a proper model. At the very least, we need a description of **what** happened - a `String`, and a record of **when** it happened - a `LocalDateTime`.  

An EventLog instance records an event that took place at a specific time. We can't go back in time and change that, so you must find a way to design the class to be effectively **immutable**. ([Hint]('https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/readonly#readonly-field-example))

### Constructor

- **description**: _String_; should not be empty

### Properties

- **description**: _String_ - description of the event that happened
- **timestamp**: _LocalDateTime_ - when it happened

> Note: For more precise date time formatting you can explore the [DateTimeFormatter class](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

### Methods

- **viewInfo**: - should return a displayable string representation of the event, for example `[TimeStamp] Description` e.g. `[15-September-2020 11:36:32] Created task`

#### Example

```java
EventLog log = new EventLog("An important thing happened");
System.out.println(log.getDescription());
System.out.println(log.viewInfo());

EventLog log2 = new EventLog();
```

> Note: Since `description` and `timestamp` are `final`, they cannot be changed, i.e. they do not need setters.

#### Output

```none
An important thing happened
[15-September-2020 11:39:25] An important thing happened
Exception in thread "main" java.lang.IllegalArgumentException: Description cannot be empty
```

> **Notes**  
> In the EventLog class, we have bundled data (_description, timestamp_) with methods that can access the data (_viewInfo()_)  
> This process of 'bundling' is also known as **Encapsulation**.
>
> In addition, each instance of type EventLog is **ensured** to be valid:
>
> 1) The only constructor forces you and other developers to provide non-empty strings
> 2) The timestamp is calculated inside the constructor, which means that it will be valid
> 3) There is no way to change the values of these properties, since they are final.
>
> This is a fairly easy example of how we apply Encapsulation to ensure that each instance has a **valid state**  
> Let's take a look at the BoardItem class and how it manages its eventlog history

## 5. BoardItem class

### Extended functionality

On each of these operations, you should add a new EventLog to the item's history

- When Constructed - `Item created: 'Refactor this mess', [15-September-2020 11:36:32]`
- When Property changed - `{Property} changed from {previous} to {new}`
- When Revert/AdvanceStatus - `Status changed from {previous} to {next}` or some error message if the status cannot be changed.  

Add a new method:  
**string displayHistory()** - returns the history for this item instance; display **info** about each event log on a new line in chronological order.

View the example below to get a better idea.

Some things to consider:

- How will you store all the EventLogs - will you need some sort of collection?
- If you choose a collection, will you make it **public/private** or something else?
- If the collection of event logs is public, will somebody be able to **modify it from outside** - perhaps adding a EventLog for **an event that never happened**?
- How do you approach this problem without breaking Encapsulation?

#### Example

```java
BoardItem item = new BoardItem("Refactor this mess", LocalDate.now().plusDays(2));
item.setDueDate(item.getDueDate().plusYears(2));
item.setTitle("Not that important");
item.revertStatus();
item.advanceStatus();
item.revertStatus();

item.displayHistory();

System.out.println("\n--------------\n");

BoardItem anotherItem = new BoardItem("Don't refactor anything",  LocalDate.now().plusDays(10));
anotherItem.advanceStatus();
anotherItem.advanceStatus();
anotherItem.advanceStatus();
anotherItem.advanceStatus();
anotherItem.advanceStatus();
anotherItem.displayHistory();
```

#### Output

```none
[15-September-2020 12:57:22] Item created: 'Refactor this mess', [Open | 2020-09-17]
[15-September-2020 12:57:22] DueDate changed from 2020-09-17 to 2022-09-17
[15-September-2020 12:57:22] Title changed from Refactor this mess to Not that important
[15-September-2020 12:57:22] Can't revert, already at Open
[15-September-2020 12:57:22] Status changed from Open to To Do
[15-September-2020 12:57:22] Status changed from To Do to Open

--------------

[15-September-2020 12:57:22] Item created: 'Don't refactor anything', [Open | 2020-09-25]
[15-September-2020 12:57:22] Status changed from Open to To Do
[15-September-2020 12:57:22] Status changed from To Do to In Progress
[15-September-2020 12:57:22] Status changed from In Progress to Done
[15-September-2020 12:57:22] Status changed from Done to Verified
[15-September-2020 12:57:22] Can't advance, already at Verified
```

## 6. Board class

Let's encapsulate the Board class, too. In the previous part, we had a **public** `ArrayList<BoardItem>` that was responsible for storing our items.  

This is convenient, but the ArrayList class has too many methods, and not all of them are useful for our Board.  

Check out this examples:

```java
BoardItem item1 = new BoardItem("Implement login/logout", LocalDate.now().plusDays(3));
BoardItem item2 = new BoardItem("Secure admin endpoints", LocalDate.now().plusDays(5));

Board board = new Board();

board.items.add(item1);
board.items.add(item2);
```

So far so good, we want to be able to add items.

```java
int count = board.items.size();
```

Also good, knowing how many items we have in total is useful.

```java
board.items.clear();
```

This looks like a problem - we don't want the allow others to `clear()` the board - this will delete all items. What about all the unfinished tasks?

```java
board.items.add(item1);
board.items.add(item2);
board.items.add(item1);
board.items.add(item1);

int count = board.items.size(); // count: 4
```

The `add()` method was useful, but it doesn't prevent you from adding duplicate items.

```java
board.items.set(0, new BoardItem("Just replaced the first item with a random one.", LocalDate.now()));
```

This is also something that we want to prevent, the original first item is now gone.

There are more than 30 methods that the `ArrayList` class provides - like removing, sorting, reversing, replacing. The Board class exposes all of them through the Items property which is of **type ArrayList**.  
In other words, _the design of the Board class does not reflect the problems that we are trying to solve._

The first step is to fix the main problem - the list is **public**. You should consider hiding it from the outside world.  

Now the Items property is no longer visible outside the class, but we are no longer able to do anything with the Board. We should be able to at least add items. We can achieve that by introducing a new method to the Board:  

**void аddItem(BoardItem item)** - adds to the list of items inside the Board. This method has access to the private list. However, this will all be pointless if you leave the method as it is and just add items without checking if they exist. So, you should add the necessary check and see if such an item **already exists**. _Hint_: you can use the `contains()` method to see if an item was already added.

The other useful functionality that we are missing is knowing how many items we have in the Board. You can add a property:  

**int totalItems** - returns the count of items inside the Board.

```java
BoardItem item1 = new BoardItem("Implement login/logout", LocalDate.now().plusDays(3));
BoardItem item2 = new BoardItem("Secure admin endpoints", LocalDate.now().plusDays(5));

Board board = new Board();

board.addItem(item1); // add item1
board.addItem(item2); // add item2
board.addItem(item1); // do nothing - item1 already in the list
board.addItem(item2); // do nothing - item2 already in the list

System.out.println(board.totalItems()); // count: 2
```

Let's focus on the following code:

```java
board.addItem(item1); // add item1
board.addItem(item2); // add item2
board.addItem(item1); // do nothing - item1 already in the list
board.addItem(item2); // do nothing - item2 already in the list
```

While the **addItem()** method is successful in adding only unique items, when a duplicate is detected the method invocation does **nothing**. Developers should be notified when an operation they perform goes wrong - for example, when you are accessing an index out of range in an array, you get an exception.

**Refactor** the code to throw an IllegalArgumentException when a duplicate is added.

```java
board.addItem(item1);
board.addItem(item2);
board.addItem(item1);
```

Output:

```java
Exception in thread "main" java.lang.IllegalArgumentException: Item already in the list
```

> **Notes**  
> The developers, using our board will now be aware of this exceptional case and will handle it. You will also handle it in a future part of the workshop.
