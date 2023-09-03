Project assignment from JetBrains Academy (www.hyperskill.org), Java Developer track.

This project deals with several propeties a natural number might have. The user can identify
specific properties of a number and a consecutive sequence of numbers. The user can also make
the program generate a sequence of numbers that satisfiy any number of properties, providing 
that the properties are not mutually exclusive (e.g. even and odd). The user can continuously
query the program until they enter 0, after which the program prints "Goodbye!" and exits.

A total of 12 properties can be identified and and used as parameters. The user can also add
a minus sign before their query (e.g. "-even"), implying that the user wants to exclude 
numbers that satisfy this property ("-even" returns a sequence of odd numbers). The input
can be in the following forms:

1. A single natural number: this displays all the 12 properties and whether the number satisfies 
the property as boolean. So if the user enters 2, the printout for even is "even: true" and
for odd is "odd: false".

2. Two natural numbers, separated by space: the first number denotes the starting number, and the 
second number denotes the number of consecutive numbers to be printed. For instance, 100 5 generates
properties for 5 numbers: 100, 101, 102, 103, and 104. All properties that the number satisfies
would be printed in the following form: number is property1, property2, property3, etc.

3. Two natural numbers, plus any number of parameters: here the user can ask the program to generate 
numbers that satisfy any number of properties. If mutually exclusive properties are specified, 
or if the user enters unknown properties, they would be given detailed error messages (details 
see Note) and the program continues. The first number specifies the starting number (which 
may or may not fulfill the specified properties), and the second number specifies how many 
numbers are to be generated. If a number does not satisfy the specified properties, the
program continues until it finds the next number that satisfies the properties. For example, if
the user enters "5 5 square", the program would return properties for 9, 16, 25, 36, and 49,
which are the next 5 square numbers after 5. Negative specifications, such as "5 5 -square
-odd", generates the next 5 non-square, non-odd numbers, thus would return properties for 6,
8, 10, 12, 14.

The following properties can be queried in both the normal and the negative format. Here are
the inputs and what the properties means:

1. even: Even numbers.
2. odd: Odd numbers.
3. buzz: the number either ends with 7 or is divisible by 7.
4. duck: except the first digit, all the digits are 0.
5. palindromic: the number reads the same forward and backward.
6. gapful: the numbers 1) contains at least three digits and 2) is divisible by the concatenation
of its first and last digit. Example: 132 is gapful because 132 is divisible by 12. 7881 is gapful
because 7881 is divisible by 71.
7. spy: the sum of all digits and the product of all digits are identical.
8. square: the number is a square number
9. sunny: the number is a square number - 1
10. jumping: all digits of the number differ by 1 to their neighboring digits. For example: 12345
and 6787656 are jumping numbers but 12354 and 67890 (9 and 0 do not differ by 1) are not jumping
numbers.
11. happy: the number reaches 1 after a sequence where the number is replaced by the sum of each
digit. 13 is a happy number because 1^2 + 3^2 = 10 and then 1^2 + 0^2 = 1.
12. sad: any number that is not happy.

Note: if the user enters invalid inputs, they are informed of their error in very specific formats. 
The following error messages are given depending on user error:
1. If the user enters a negative number or a string for the first parameter, the program prints
"The first parameter should be a natural number or zero."
2. If the user enters 0 or a negative number for the second parameter, the program prints "The
second parameter should be a natural number"
3. If the user input contains two or more unsupported property specifications, the program prints: 
"The properties [property1, property2...] are wrong.
Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING,
HAPPY, SAD]", where property1, property2, etc. are user inputs in upper case.
4. If the user input contains one unsupported property specification, the program prints:
"The property [property] is wrong.
Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING,
HAPPY, SAD]", where property is user input in upper case.
5. If the user input mutually exclusive property specifications*, the program prints:
"The request contains mutually exclusive properties: [property1, property2]
There are no numbers with these properties.", where property1, property2 are user unputs in upper case.

* If the specifications contains both "even" and "odd", "-even" and "-odd", "duck" and "spy", "sunny"
and "square", "happy" and "sad", "-happy" and "-sad", or has a property and its negation e.g.
"duck" and "-duck".

3. September, 2023--description by E. Hsu (nahandove@gmail.com)
