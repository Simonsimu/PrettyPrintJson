# PrettyPrintJson

## 1. Description:

PrettyPrintJSON is a command line utility Given a JSON document, pretty print it - either in-place or output to the console.

eg:

$ cat sample.json

[{

"name": "Nico Williams",

"parents": ["Bob",

"Wilma"

], "student": true

}, {"name": "Nico Williams",

"parents": ["Carl","Carly"

],"student": true

}

]

When we run PrettyPrintJSON on it,

## $ java PrettyPrintJSON.java --from-file=sample.json

    [

        {

            "name": "Nico Williams",

            "parents": [

                "Bob",

                "Wilma"

            ],

            "student": true

        },

        {

            "name": "Nico Williams",

            "parents": [

                "Carl",

                "Carly"

            ],

            "student": true

        }

    ]

It pretty prints the given JSON.

## 2 API

PrettyPrintJSON should support the following operations (ideally as command line parameters):

So, for ex: I should be able to call

$ java PrettyPrintJSON --replace --indent=3 --from-file=file.json

or,

$ java PrettyPrintJSON --compact --from-file=file.json

### 2.1 --from-file:
    Read from file.

### 2.2 --compact-output:

    By default, PrettyPrintJSON pretty-prints JSON output. Using this option will result in more compact

    output by outputting everything on a single line.

### 2.3 --tab:

    Use a tab for each indentation level instead of the default of two spaces.

### 2.4 --indent n:

    Use the given number of spaces(or tabs) (no more than 8) for indentation.

### 2.5 --replace:

    Replace the contents of the given json file instead of outputting it to the console.


**How to use:**

Before running the code you should add an external jar i.e json.simple.1.1.1.jar file which is used to read the json file and convert it into a json object

**How to add jar file in eclipse ide**

open java project in eclipse ide right click on the project name --> right click on JRE System Library--> choose build path --> configure build path --> in libraries choose option of Add external jars
then select the json.simple.1.1.1.jar file and then it will be added to it, then click apply

once the jar file is added create a java class "JsonFormatter" inside src folder (sorce code for JsonFormatter.java is available in this repository)

Once you have added jar file and created JsonFormatter class you can use the project by passing command line arguments

**passing the command line arguments**

you can pass the commands given above based on your requirement in any order in the command line arguments

For Example command line arguments are: 

**--from-c:\sample.json --compact --prettyprint --indent-4 --replaceprettyprint**

if you tested the code with above arguments

firstly it will make the indent as 4 since it is the only integer

file path ="c:\sample.json"

since Iam passing --compact , --prettyprint , --replace
firstly it print compact form and prettyprint form in the console and fillany the pretty print formate is replaced with the original file
