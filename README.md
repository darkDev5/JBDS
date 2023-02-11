# JBDS
Java better data structure is a library contains features you can use to upgrade language base functionality.
New features to work with Strings,Numbers,Characters and some new data structures.


## Usage
There are lots of classes and methods you can use.
Here is sample code for create instance of NumberList class that can hold numbers only and you can manipulate them easily.
All classes hav documents on the **doc** folder

```java
var numberList = new NumberList<Integer>();

numberList.add(12);
numberList.add(25);
numberList.add(64);

numberList.sort(new NumberListComparator(true));
numberList.printToConsole(true, true);

System.out.println(StringUtils.reverse("mohammad mehdi"));

```
