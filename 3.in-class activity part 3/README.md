# BoardR - Task Organizing System

_Part 3_

## 1. Description

**BoardR** is a task-management system which will evolve in the next several weeks. During the course of the project, we will follow the best practices of `Object-Oriented Programming` and `Design`.

## 2. Goals

Your task will be to further specify the **BoardItem** class into two more specialized classes: **Task** and **Issue**.
You will achieve this by applying the OOP principle of **Inheritance**.

## 3. Task class

### Description

Instances of this class will be used to describe work that needs to be done. They extend the functionality of a board item by adding an **Assignee** property.

### Constructor

- Parameters: `title` (_String_), `assignee` (_String_) and `dueDate` (_localDate_)
- A new Task should have its initial status as `To Do`
- Example:

```java
Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
System.out.println(task.getTitle());    // Test the application flow
System.out.println(task.getDueDate());  // 2020-09-16
System.out.println(task.getStatus());   // To Do
System.out.println(task.getAssignee()); // Pesho
```

### Properties

- Inherits all props from **BoardItem**
- `Assignee`: _String_, should never be empty, and its length should be between [5..30]

> **Hint**: When you implement the assignee setter, you will need to think of a way to also add an activity log. The activity log list is currently a private field inside the base class. Is there a way to expose the ability to add new activity logs **only for derived** classes?
>
> **Hint II** - You will need to find a way to reuse the `status` property and `advanceStatus()`, `evertStatus()` methods from the base class while also having the ability to start with status `TODO`. The easiest way to achieve this is to pass an 'initialStatus' value from the child to the parent when constructing a new instance.

### Methods

- Inherits all methods from **BoardItem**

#### Example

```java
Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
task.advanceStatus();
task.advanceStatus();
task.setAssignee("Gosho");
task.displayHistory();
```

#### Output

```
[15-September-2020 16:44:39] Item created: 'Test the application flow', [To Do | 2020-09-16]
[15-September-2020 16:44:39] Status changed from To Do to In Progress
[15-September-2020 16:44:39] Status changed from In Progress to Done
[15-September-2020 16:44:39] Assignee changed from Pesho to Gosho
```

## 4. Issue class

### Description

Instances of this class will be used to describe a problem that needs attention. Their status will start at `OPEN`.

### Constructor

- Parameters: `title` (_String_), `description` (_String_), dueDate (_LocalDate_)
- A new Issue should have its initial status as Open
- Example:

```java
Issue issue = new Issue(
        "App flow tests?",
        "We need to test the App!",
        LocalDate.now().plusDays(1));
System.out.println(issue.getTitle()); // App flow tests?
```

### Properties

- Inherit all properties from BoardItem
  `description`: _String_ - if someone tries to assign an empty string to it, set to `No description`
  - Description can't be changed once set.

### Methods

- Inherits all methods from BoardItem

#### Example

```java
Issue issue = new Issue(
        "App flow tests?",
        "We need to test the App!",
        LocalDate.now().plusDays(1));
issue.advanceStatus();
issue.setDueDate(issue.getDueDate().plusDays(1));
issue.displayHistory();
```

#### Output

```
[15-September-2020 16:52:28] Item created: 'App flow tests?', [Open | 2020-09-16]
[15-September-2020 16:52:28] Status changed from Open to To Do
[15-September-2020 16:52:28] DueDate changed from 2020-09-16 to 2020-09-17
```

## 5. Board class

The board class should continue to work as before without any changes.

```java
LocalDate tomorrow = LocalDate.now().plusDays(1);
Issue issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
Task task = new Task("Test the application flow", "Pesho", tomorrow);

Board board = new Board();

board.addItem(issue);
board.addItem(task);
System.out.println(board.totalItems()); // 2
```

> Remarks:
>
> You must have noticed that we can treat two distinct types (Issue and Task) as similar and add them into a collection of a more general type (BoardItem). This feature is another OOP principle supported by Java. We'll study more about this principle in the next sessions.
