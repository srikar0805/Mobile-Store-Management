package Operations;

public abstract class Operations {
    public abstract void createTable();
    public abstract void addData(String file);
    public abstract void update(String S,String A, String B);
    public abstract void updateInBulk(String file);
    public abstract void delete(String S);
    public abstract void printAll();
    public abstract void printByAttribute(String S, String A);
    public abstract void search(String S, String A);
}
