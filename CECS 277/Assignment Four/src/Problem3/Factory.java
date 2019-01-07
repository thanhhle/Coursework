package Problem3;

public interface Factory {
	public enum Type{FACULTY, STAFF, PARTIME};
	Employee createEmployee(Type type);
}
