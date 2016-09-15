class subject {


	private String name;
	private int temp;
	private SecurityLevel clearance;

	public subject(String subName, SecurityLevel clearanceLevel)
	{
		this.name = subName;
		this.temp = 0;
		this.clearance = clearanceLevel;
	}

	public SecurityLevel getClearanceLevel()
	{
		return clearance;
	}

	public void printValues () // for debugging
	{
		//System.out.println("Debugging point 3");
		System.out.println("Subject Name: " + name + " - Temp: " + temp + " - Clearance: " + ( clearance.securityLevel() == 1 ? "High" : "Low") );
	}

	public int getTemp()
	{
		return temp;
	}

	public String getName()
	{
		return name;
	}

	public int read(int value) // read object
	{
		temp = value;
		return temp;
	}
}
