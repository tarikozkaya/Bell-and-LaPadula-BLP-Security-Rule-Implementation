[Program 1]
[Description]
There are 7 java files: subject.java, object.java, SecurityLevel.java, SecureSystem.java(main method is in it), ReferenceMonitor.java, ObjectMonitor.java 
subject.java and object.java are classes for subject (people) and objects(data). It stores the important information about them such as name, value, temp, and it also includes methods to reach those variables
SecurityLevel.java is the class defines LOW and HIGH security, it also includes dominates function to determine the relation
ObjectManager.java is the class which handles object I/O like a file manager. It is local to the ReferenceMonitor as described in the assignment specifications
ReferenceMonitor.java makes a security check. It allows a subject to read/write only if it has enough clearance.
SecureSystem.java is the class which has the main method. It adds subject and object and parses the input.
InstructionObject.java is the class which stores instruction information. main method parses the input and creates an InstructionObject using the daya. Then sends the instruction object to the ReferenceMonitor.

Subject and objects are stored in different hash maps. This provides an efficient look up time. Moreover, the program supports
more than two users. There are seperate addObject and addSubject methods for the subject and the objects.
Almost all classes has "getter" methods to reach its private local variables.

After parsing the input the main method (inside SecurityLevel.java) creates a new command object using InstructionObject class.
This command stores all of the necessary information about the next action: type of the command (read, write, bad), subject name, object name, value.

Then the main method also checks the argument size.
If the command is well formed, the instruction method inside the ReferenceMonitor is called which takes an InstructionObject as a parameter
If the instruction is bad, then a warning appears on the screen.
Otherwise, one of the executeRead or executeWrite method is called.
ReferenceMonitor makes a security check using the dominates method in the SecurityLevel class.
If the subject has enough clearance then, the ReferenceMonitor completes the action using read and write methods.
This process is repeated for each line of input.

To compile the program, you need to use "javac *.java". To run the program, you need to use "java SecureSystem [file which contains the instructions]"


[Test Cases]
There are five test cases 

[Input of test 1]
write Hal HObj
read Hal
write Lyle LObj 10
read Hal LObj
write Lyle HObj 20
write Hal LObj 200
read Hal HObj
read Lyle LObj
read Lyle HObj
foo Lyle LObj
Hi Lyle,This is Hal
The missile launch code is 1234567

[Output of test 1]
***Starting the very secure program***

Reading from file: InstructionList

Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle writes value 10 to LObj
The current state is:
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Hal reads LObj
The current state is:
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 10
Lyle writes value 20 to HObj
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 10
Hal writes value 200 to LObj
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 10
Hal reads HObj
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 20
Lyle reads LObj
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 10
	Hal has recently read: 20
Lyle reads HObj
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 20
Bad Instruction
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 20
Bad Instruction
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 20
Bad Instruction
The current state is:
	LObj has value: 10
	HObj has value: 20
	Lyle has recently read: 0
	Hal has recently read: 20

[Input of test 2]
This is a secure program
write Hal HObj 1453
read Lyle HObj
write Hal LObj 2453
read Lyle LObj

[Output of test 2]
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Hal writes value 1453 to HObj
The current state is:
	LObj has value: 0
	HObj has value: 1453
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle reads HObj
The current state is:
	LObj has value: 0
	HObj has value: 1453
	Lyle has recently read: 0
	Hal has recently read: 0
Hal writes value 2453 to LObj
The current state is:
	LObj has value: 0
	HObj has value: 1453
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle reads LObj
The current state is:
	LObj has value: 0
	HObj has value: 1453
	Lyle has recently read: 0
	Hal has recently read: 0


[Input of test 3]
This is a third test of the secure program
write Lyle HObj 2015
read Hal HObj
write Lyle LObj 2015
read Hal LObj
write Lyle HObj 2115
read Hal HObj
write Lyle LObj 2115
read Hal LObj

[Output of test 3]
***Starting the very secure program***

Reading from file: InstructionList

Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle writes value 2015 to HObj
The current state is:
	LObj has value: 0
	HObj has value: 2015
	Lyle has recently read: 0
	Hal has recently read: 0
Hal reads HObj
The current state is:
	LObj has value: 0
	HObj has value: 2015
	Lyle has recently read: 0
	Hal has recently read: 2015
Lyle writes value 2015 to LObj
The current state is:
	LObj has value: 2015
	HObj has value: 2015
	Lyle has recently read: 0
	Hal has recently read: 2015
Hal reads LObj
The current state is:
	LObj has value: 2015
	HObj has value: 2015
	Lyle has recently read: 0
	Hal has recently read: 2015
Lyle writes value 2115 to HObj
The current state is:
	LObj has value: 2015
	HObj has value: 2115
	Lyle has recently read: 0
	Hal has recently read: 2015
Hal reads HObj
The current state is:
	LObj has value: 2015
	HObj has value: 2115
	Lyle has recently read: 0
	Hal has recently read: 2115
Lyle writes value 2115 to LObj
The current state is:
	LObj has value: 2115
	HObj has value: 2115
	Lyle has recently read: 0
	Hal has recently read: 2115
Hal reads LObj
The current state is:
	LObj has value: 2115
	HObj has value: 2115
	Lyle has recently read: 0
	Hal has recently read: 2115

[Input of test 4]
This is a fourth test of the secure program and it tests for the Bad Instructions
write Lyle HObj
read Hal HObj 23
write Lyle LObj 2015 34 34 too many arguments
read
write
read LObj H
do not write Lyle LObj 2115
do not read Hal LObj

[Output of test 4]
***Starting the very secure program***

Reading from file: InstructionList

Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0

	[Input of test 5]
	This is the last test of the secure program
	write Lyle HObj 1
	read Lyle HObj
	write Lyle LObj 3
	write Hal LObj 2
	read Hal LObj
	write Lyle LObj 3
	read Lyle LObj
	write Hal LObj 4

	[Output of test 5]
	***Starting the very secure program***

Reading from file: InstructionList

Bad Instruction
The current state is:
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle writes value 1 to HObj
The current state is:
	LObj has value: 0
	HObj has value: 1
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle reads HObj
The current state is:
	LObj has value: 0
	HObj has value: 1
	Lyle has recently read: 0
	Hal has recently read: 0
Lyle writes value 3 to LObj
The current state is:
	LObj has value: 3
	HObj has value: 1
	Lyle has recently read: 0
	Hal has recently read: 0
Hal writes value 2 to LObj
The current state is:
	LObj has value: 3
	HObj has value: 1
	Lyle has recently read: 0
	Hal has recently read: 0
Hal reads LObj
The current state is:
	LObj has value: 3
	HObj has value: 1
	Lyle has recently read: 0
	Hal has recently read: 3
Lyle writes value 3 to LObj
The current state is:
	LObj has value: 3
	HObj has value: 1
	Lyle has recently read: 0
	Hal has recently read: 3
Lyle reads LObj
The current state is:
	LObj has value: 3
	HObj has value: 1
	Lyle has recently read: 3
	Hal has recently read: 3
Hal writes value 4 to LObj
The current state is:
	LObj has value: 3
	HObj has value: 1
	Lyle has recently read: 3
	Hal has recently read: 3
