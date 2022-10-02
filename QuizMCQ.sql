create schema projects;
	
use projects;
 	
	 
CREATE TABLE `projects`.`question` (
  `QNumber` INT NOT NULL,
  `Question` VARCHAR(200) NOT NULL,
  `AnsA` VARCHAR(200) NOT NULL,
  `AnsB` VARCHAR(200) NOT NULL,
  `AnsC` VARCHAR(200) NOT NULL,
  `AnsD` VARCHAR(200) NOT NULL,
  `CorrectAns` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`QNumber`),
  UNIQUE INDEX `QNumber_UNIQUE` (`QNumber` ASC) VISIBLE,
  UNIQUE INDEX `Question_UNIQUE` (`Question` ASC) VISIBLE);
  
 
 	 
create table question(
QNumber int not null primary key,
Question text,
AnsA text,
AnsB text,
AnsC text, 
AnsD text,
CorrectAns text
);

insert into question (QNumber, Question, AnsA, AnsB, AnsC, AnsD, CorrectAns) values (1,
"Which of the following option leads to the portability and security of Java?",
 "Bytecode is executed by JVM",
 "The applet makes the Java code secure and portable",
 "Dynamic binding between objects",
 "Use of exception handling",
 "a) Bytecode is executed by the JVM.") ,
 
 (2,
"Which of the following is not a Java features?",
"Dynamic",
"Architecture Neutral",
"Use of pointers",
"Object-oriented",
"c) Use of pointers"),
 
(3,
"The \u0021 article referred to as a __________",
"Unicode escape sequence",
"Octal escape",
"Hexadecimal",
"Line feed",
"a) Unicode escape sequence"),

(5,
 "Which of the following is a valid long literal?",
 "ABH8097",
 "L990023",
 "904423",
 "0xnf029L",
 "d) 0xnf029L"),
 
 (6,
 "String is ___in java",
 "Interface",
 "Mutable",
 "Method",
 "Immutable",
 "d) Immutable"),

 
 (8,
 "Which of these keywords is used to manually throw an exception?",
 "Try",
 "Finally",
 "Catch",
 "Throw",
 "d) Throw keyword"),
 
 (9,
 "Which of these classes is not part of Java’s collection framework?",
 "Maps",
 "Array",
 "Stack",
 "Queue",
 "a) Maps"),
 
 (10,
 "Which of these methods deletes all the elements from invoking collection?",
 "clear()",
 "reset()",
 "delete()",
 "refresh()",
 "a) clear()"),
 
 (11,
 "Which collection allows indexed access to its elements, but its methods are not synchronized?",
 "Vector",
 "TreeMap",
 "HashSet",
 "ArrayList",
 "d) ArrayList"),
 
 (12,
 "If there occurs any exception in thread, then other threads",
 "gets impacted",
 "doesn't gets impacted",
 "stop executing",
 "daemon thread starts executing",
 "b) doesn't gets impacted"),

(13,
 "Which polymorphism concept is applied to inheritance relationship in java programming?",
 "Method overloading",
 "Constructor overloading",
 "Method overriding",
 "None",
 "a) Method overriding"),
 
 (14,
 "Which of this method of class String is used to obtain a length of String object?",
 "get( )",
 "Sizeof( )",
 "length of( ) ",
 "length( )",
 "d) length( )"),
 
(15,
 " Which among the following is not a method of Throwable class?",
 "public String getMessage()",
 "public Throwable getCause()",
 "public Char toString()",
 "public void printStackTrace()",
 "c) public Char toString()"),
 
 (7,
 "Which are the two blocks that are used to check error and handle the error?",
 "Try and catch",
 "Trying and catching",
 "Do and while",
 "TryDo and Check",
 "a) try and catch"),
 
 (4,
 "___ is used to find and fix bugs in the Java programs",
 "JVM",
 "JDK",
 "JRE",
 "JDB",
 "d) JDB");
 
  create table student_info (
roll_num int not null primary key,
name text,
marks int,
grade varchar(50),
result varchar(50)
);
 
select * from question;

select * from student_info; 
	 
create user mcqsql identified by 'mcqsql123' ;
 
grant all privileges on question to mcqsql;
grant all privileges on projects.student_info to mcqsql;
flush privileges;