# PrettyPrint_Json

Using this project you can view, format and modify your json file


The features of the project are available by passing some commands given below:

**--from-file=** *filepath*   : Takes the file path of a json file from the command line argument

**--indent=** *n*             : This command is used to set the required value of indent(here n is an integer)

**--validate**                : This command checks wether a json file is valid or not

**--compact-output**          : This command will print the json file without any spaces which means it is the most minimizable form of your file

**--prettyprint**             : It beautifies your code and print the json file in pretty print format

  **--replace**               : It modifies the given file to prettyprint format

**--replacecompact**          : It modifies the given file into compact format


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
