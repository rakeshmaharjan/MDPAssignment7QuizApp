package com.rakesh.mdpassignment7quizapp.data

import com.rakesh.mdpassignment7quizapp.constants.Constant.IS_CHECK_BOX
import com.rakesh.mdpassignment7quizapp.constants.Constant.IS_RADIO_BUTTON

class QuizSeedData {

    companion object {
        fun getQuestions(): MutableList<Quiz> {
            return mutableListOf(
                Quiz(
                    1,
                    "1. What is the fname known as in the following code: fun myFunction(fname: String)",
                    IS_RADIO_BUTTON,
                    "Any values passed in function is parameter.",
                    "c",
                    "parameter",
                    "",
                    "",
                    mutableListOf("override","range", "parameter", "inherit")
                ),
                Quiz(
                    2,
                    "2. In Kotlin, it is possible to inherit class properties and functions from one class to another.",
                    IS_RADIO_BUTTON,
                    "Kotlin is OOP langulage and it is possible to inherit class properties and functions",
                    "a",
                    "True",
                    "",
                    "",
                    mutableListOf("True","False")
                ),
                Quiz(
                    3,
                    "3. What is the correct way to create an object called myObj of MyClass?",
                    IS_RADIO_BUTTON,
                    "New keyword is not required to create object in Kotlin.",
                    "b",
                    "val myObj = MyClass()",
                    "",
                    "",
                    mutableListOf("Main myObj = new MyClass();","val myObj = MyClass()","MyClass.new myObj")
                ),
                Quiz(
                    4,
                    "4. Which keyword is used to create a class in Kotlin?",
                    IS_RADIO_BUTTON,
                    "class is the keyword.",
                    "a",
                    "class",
                    "",
                    "",
                    mutableListOf("class","MyClass","class()","className")
                ),
                Quiz(
                    5,
                    "5. How can you create a range of numbers between 5 and 15 in Kotlin?",
                    IS_RADIO_BUTTON,
                    "A variable is required.",
                    "d",
                    "for (x in 5..15)",
                    "",
                    "",
                    mutableListOf("for (5..15)","for (x in 5 to 15)","for (5 to 15)","for (x in 5..15)")
                ),
                Quiz(
                    6,
                    "6. How do you start writing a for loop in Kotlin, to loop through arrays?",
                    IS_RADIO_BUTTON,
                    "To loop through array elements, use the for loop together with the in operator.",
                    "a",
                    "for (x in y)",
                    "",
                    "",
                    mutableListOf("for (x in y)","for x","for x in y","for (x)")
                ),
                Quiz(
                    7,
                    "7. Which keyword is used to return a value inside a function?",
                    IS_RADIO_BUTTON,
                    "return keyword is used.",
                    "a",
                    "return",
                    "",
                    "",
                    mutableListOf("return","void","get", "break")
                ),
                Quiz(
                    8,
                    "8. How do you call a function in Kotlin?",
                    IS_CHECK_BOX,
                    "We can simply call function with open and closed braces.",
                    "c",
                    "myFunction()",
                    "",
                    "",
                    mutableListOf("(myFunction)","myFunction;","myFunction()","myFunction[]")
                ),
                Quiz(
                    9,
                    "9. Array indexes start with:",
                    IS_RADIO_BUTTON,
                    "Index starts with 0.",
                    "a",
                    "0",
                    "",
                    "",
                    mutableListOf("0","1")
                ),
                Quiz(
                    10,
                    "10. To create an array in Kotlin, use",
                    IS_RADIO_BUTTON,
                    "Call arrayOf() function by Kotlin.",
                    "b",
                    "The arrayOf() function",
                    "",
                    "",
                    mutableListOf("[]","The arrayOf() function","{}","None of the above")
                ),
                Quiz(
                    11,
                    "11. How can we kill an activity in android?",
                    IS_CHECK_BOX,
                    "The finish() method is used to close the activity. Whereas the finishActivity(int requestCode) also closes the activity with requestCode.",
                    "ab",
                    "Using finish() method\nUsing finishActivity(int requestCode)",
                    "",
                    "",
                    mutableListOf("Using finish() method","Using finishActivity(int requestCode)","Neither (a) nor (b)")
                ),
                Quiz(
                    12,
                    "12. How can you create a variable with the floating number 2.8?",
                    IS_RADIO_BUTTON,
                    "We can use val keyword to create a variable.",
                    "a",
                    "val num = 2.8",
                    "",
                    "",
                    mutableListOf("val num = 2.8","float num = 2.8","double num = 2.8","num = 2.8 float")
                ),
                Quiz(
                    13,
                    "13. Which keyword is used to declare a function?",
                    IS_RADIO_BUTTON,
                    "fun is the keyword used to declare function.",
                    "a",
                    "fun",
                    "",
                    "",
                    mutableListOf("fun","define","decl","function")
                ),
                Quiz(
                    14,
                    "14. How do you insert COMMENTS in Kotlin code?",
                    IS_CHECK_BOX,
                    "//",
                    "d",
                    "// This is a comment  ",
                    "",
                    "",
                    mutableListOf("/* This is a comment","-- This is a comment","# This is a comment","// This is a comment  ")
                ),
                Quiz(
                    15,
                    "15. What is a correct syntax to output \"Hello World\" in Kotlin?",
                    IS_RADIO_BUTTON,
                    "println(\"Hello World\")  ",
                    "b",
                    "println(\"Hello World\")",
                    "",
                    "",
                    mutableListOf("cout << \"Hello World\";","println(\"Hello World\")","Console.WriteLine(\"Hello World\");","System.out.printline(\"Hello World\")")
                )
            )
        }
    }
}