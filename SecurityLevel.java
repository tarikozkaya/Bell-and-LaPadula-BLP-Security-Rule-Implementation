class SecurityLevel{

	public static final int HIGH = 1;
	public static final int LOW = 0;

	private int sensitivity;

	public SecurityLevel (int sensitivity)
	{
		this.sensitivity = sensitivity;
	}

	public static int dominates (SecurityLevel clearance, SecurityLevel sensitivity)
	{
		if(clearance.securityLevel() < sensitivity.securityLevel())
			return -1;
		if(clearance.securityLevel() == sensitivity.securityLevel() )
			return 0;

			return 1;
	}

	public int securityLevel ()
	{
		return this.sensitivity;
	}

}
