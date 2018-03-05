# PrettyPrint_Json

Using this project you can view, format and modify your json file


The features of the project are available by passing some commands given below:

**validate**            : This command checks wether a json file is valid or not

**compact**             : This command will print the json file without any spaces which means it is the most minimizable form of your file

**prettyprint**         : It beautifies your code and print the json file in pretty print format

**replaceprettyprint**  : It modifies the given file to prettyprint format

**replacecompact**      : It modifies the given file into compact format


**How to use:**

Before running the code you should add an external jar i.e json.simple.1.1.1.jar file which is used to read the json file and convert it into a json object

**passing the command line arguments**

the first argument should be the json file path, and then followed by any command mentioned above each command should be seperated by spaces,
you can use any integer for the indent by passing it in the command line argument
you can pass the commands given above based on your requirement in any order in the command line arguments, except the file path 


For Example command line arguments are: 

**"c:\sample.json" compact prettyprint 4 replaceprettyprint**

if you tested the code with above arguments

firstly it will make the indent as 4 since it is the only integer

args[0] is file path hence file path="c:\sample.json"

since Iam passing compact
firstly it print compact form and prettyprint form in the console and fillany the pretty print formate is replaced with the original file

you can pass the commands in any order except file path you shoukd pass the file path as the first argument

