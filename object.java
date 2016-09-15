class object {


	private String name;
	private int value;
	private SecurityLevel sensitivity;

	public object(String objName, SecurityLevel sensitivity)
	{
		this.name = objName;
		this.value = 0;
		this.sensitivity = sensitivity;
	}
	public void printValues () // for debugging

	{
		System.out.println("Object Name: " + name + " - Value: " + value + " - Sensitivity: " + ( sensitivity.securityLevel() == 1 ? "High" : "Low") );
	}

	public SecurityLevel getSensitivity()
	{
		return sensitivity;
	}

	public int getValue()
	{
		return value;
	}

	public int setValue(int newValue)
	{
		value = newValue;
		return value;
	}

	public String getName()
	{
		return name;
	}


}
