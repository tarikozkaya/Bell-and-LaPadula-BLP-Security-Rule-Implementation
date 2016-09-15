import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class ObjectManager {

	HashMap objects;

	public ObjectManager()
	{
		objects	= new HashMap<String, object>();
	}

	public void addObject(String objectName, SecurityLevel sensitivity)
	{
		String objName = objectName.toLowerCase();
		object obj1 = new object(objectName, sensitivity);
		objects.put( objName, obj1);
	}

	public void printObjectValues (String objName) // for debugging & Assumes object already exists
	{
		object obj1 = (object) objects.get(objName);
		obj1.printValues();
	}

	public int read (String objName) // for debugging & Assumes object already exists
	{
		object obj1 = (object) objects.get(objName);
		return obj1.getValue();
	}

	public int write (String objName, int newValue) // for debugging & Assumes object already exists
	{
		object obj1 = (object) objects.get(objName);
		return obj1.setValue(newValue);
	}

	public void printStateObjects ()
	{
		for( String name :  (Set<String>) objects.keySet())
		{
			object objTemp = (object) objects.get(name);
    	System.out.println( "\t" +  objTemp.getName() + " has value: " + objTemp.getValue() );
		}

	}

	public SecurityLevel getSensitivityLevel(String objName)
	{
		object obj1 = (object) objects.get(objName);
		return obj1.getSensitivity();
	}

	public boolean objectExists (String name)
	{
		object value = (object) objects.get(name);
		if (value == null && !objects.containsKey(name))
			 return false;
		return true;
	}

}
