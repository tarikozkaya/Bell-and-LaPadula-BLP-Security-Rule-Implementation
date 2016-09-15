import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

class SecureSystem {

	static HashMap subjects	= new HashMap<String, subject> ();
	final static InstructionObject BadInstruction = new InstructionObject(InstructionObject.BAD);

	public static void main(String[] args) throws Exception
	{

		System.out.println("***Starting the very secure program***\n");
		System.out.println("Reading from file: " + args[0] + "\n");
		SecurityLevel low = new SecurityLevel(SecurityLevel.LOW);
		SecurityLevel high = new SecurityLevel(SecurityLevel.HIGH);

		ReferenceMonitor monitor = new ReferenceMonitor();

		monitor.addObject("HObj", high);
		monitor.addObject("LObj", low);

		addSubject("Hal", high);
		addSubject("Lyle", low);

		String line;
		FileReader fileReader = new FileReader(args[0]);
		BufferedReader input = new BufferedReader(fileReader);

		while((line = input.readLine()) != null)
		{
			InstructionObject instruction = BadInstruction;
			StringTokenizer token = new StringTokenizer(line);
			int tokenNumber = token.countTokens();
			boolean isbad = true;

			if (tokenNumber == 3 || tokenNumber == 4)
			{
				String action = token.nextToken();
				String subjectName = token.nextToken();
				String subjectNameLower = subjectName.toLowerCase();
				String objectName = token.nextToken();
				String objectNameLower = objectName.toLowerCase();

				if( action.equalsIgnoreCase("READ") && monitor.subjectExists(subjectNameLower) && monitor.objectExists(objectNameLower) && tokenNumber == 3)
				{
					instruction = new InstructionObject(InstructionObject.READ, subjectName, objectName);
					isbad = false;
					//			System.out.println("Debug Point 1");
				}
				else
				if(tokenNumber == 4)
				{
					//			System.out.println("Debug Point 2");
					Scanner scanValue = new Scanner (token.nextToken());

					if( action.equalsIgnoreCase("WRITE") && monitor.subjectExists(subjectNameLower) && monitor.objectExists(objectNameLower) && scanValue.hasNextInt() )
					{
						instruction = new InstructionObject(InstructionObject.WRITE, subjectName, objectName, scanValue.nextInt() );
						isbad = false;
					}
				}
			}
	//		System.out.println("Debug Point 3: isbad: " + isbad + " instruction.type: " + instruction.getType() );
			if(isbad)
				monitor.instruction(BadInstruction);
			else
				monitor.instruction(instruction);

			monitor.printState();
		}

		input.close();
		fileReader.close();



	}

	public static void addSubject(String subjectName, SecurityLevel clearance)
	{
		String subName = subjectName.toLowerCase();
		subject sub1 = new subject(subjectName, clearance);
		subjects.put( subName, sub1);
	}

}
