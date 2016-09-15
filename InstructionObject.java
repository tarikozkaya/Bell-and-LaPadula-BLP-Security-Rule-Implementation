class InstructionObject {

    public static final int BAD = 0;
    public static final int READ = 1;
    public static final int WRITE = -1;

    private int type;
    private String subjectName;
    private String objectName;
    private int value;

    public InstructionObject(int type)
    {
      this.type = BAD;
    }

    public InstructionObject(int type, String subjectName, String objectName)
    {
      this.type = READ;
      this.subjectName = subjectName;
      this.objectName = objectName;
    }

    public InstructionObject(int type, String subjectName, String objectName, int newValue)
    {
      this.type = WRITE;
      this.subjectName = subjectName;
      this.objectName = objectName;
      this.value = newValue;
    }

    public int getType()
    {
      return type;
    }

    public String getSub()
    {
      return subjectName;
    }

    public String getObj()
    {
      return objectName;
    }

    public int getVal()
    {
      return value;
    }
}
