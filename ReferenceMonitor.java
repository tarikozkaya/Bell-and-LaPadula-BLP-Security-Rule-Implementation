import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class ReferenceMonitor{

	ObjectManager manager;

	public ReferenceMonitor()
	{
		manager = new ObjectManager();
	}

	public void addObject(String objectName, SecurityLevel sensitivity)
	{
		manager.addObject(objectName, sensitivity);
	}

	public int executeRead (String subName, String objName)
	{
		String subjectName = subName.toLowerCase();
		String objectName = objName.toLowerCase();

		subject sub1 = (subject) SecureSystem.subjects.get(subjectName);
		SecurityLevel sensitivity = manager.getSensitivityLevel(objectName);
		SecurityLevel clearance = sub1.getClearanceLevel();

		int dominate = SecurityLevel.dominates(clearance, sensitivity);

		if(dominate >= 0)
			return read(subjectName, objectName, true);

		return read(subjectName, objectName, false);
	}

	public int read(String subjectName, String objectName, boolean accessGranted)
	{
		subject sub1 = (subject) SecureSystem.subjects.get(subjectName);
		if(accessGranted)
		return sub1.read ( manager.read(objectName) );

		return sub1.read ( 0 );
	}

	public int executeWrite (String subName, String objName, int newValue)
	{
		String subjectName = subName.toLowerCase();
		String objectName = objName.toLowerCase();

		subject sub1 = (subject) SecureSystem.subjects.get(subjectName);
		SecurityLevel sensitivity = manager.getSensitivityLevel(objectName);
		SecurityLevel clearance = sub1.getClearanceLevel();

		int dominate = SecurityLevel.dominates(clearance, sensitivity);

		if(dominate <= 0)
			return write(objectName, newValue);

		return 0;
	}

	public int write(String objectName, int newValue)
	{
		return manager.write ( objectName, newValue );
	}

	public int getTemp(String subjectName)
	{
		subject sub1 = (subject) SecureSystem.subjects.get(subjectName);
		return sub1.getTemp();
	}

	public void printObjectValues (String objName) // for debugging & Assumes object already exists
	{
		manager.printObjectValues(objName);
	}

	public void printSubjectValues (String subName) // for debugging & Assumes object already exists
	{
		//System.out.println("Debugging point 1");
		subject sub1 = (subject) SecureSystem.subjects.get(subName);
		//System.out.println("Debugging point 2: subject name: " + sub1.name);
		sub1.printValues();
	}

	public void printState ()
	{
		System.out.println("The current state is: ");
		manager.printStateObjects();
		for( String name :  (Set<String>) SecureSystem.subjects.keySet())
		{
			subject subTemp = (subject) SecureSystem.subjects.get(name);
    	System.out.println( "\t" +  subTemp.getName() + " has recently read: " + subTemp.getTemp() );
		}
	}

	public int instruction(InstructionObject next)
	{
	//	System.out.println("Debug Point 4: type: " + next.getType());
		if(next.getType() == InstructionObject.READ)
		{
			System.out.println( next.getSub() + " reads " + next.getObj() );
			return executeRead ( next.getSub(), next.getObj() );
		}
		if(next.getType() == InstructionObject.WRITE)
		{
			System.out.println( next.getSub() + " writes value " + next.getVal() + " to " + next.getObj() );
			return executeWrite ( next.getSub(), next.getObj(), next.getVal() );
		}
		System.out.println("Bad Instruction");

		return 0;
	}

	public boolean subjectExists (String originalName)
	{
		String name = originalName.toLowerCase();
		subject value = (subject) SecureSystem.subjects.get(name);
		if (value == null && !SecureSystem.subjects.containsKey(name))
       return false;
    return true;
	}

	public boolean objectExists (String name)
	{
		return manager.objectExists(name);
	}

}
