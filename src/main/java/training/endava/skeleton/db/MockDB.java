package training.endava.skeleton.db;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MockDB {

    private static MockDB instance;

    private static Map<Class<?>, List<?>> schema;

    private MockDB() {
    	schema = new HashMap<>();
    }

    public static MockDB getInstance() {
        if (instance == null) {
            instance = new MockDB();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	public <T> List<T> getTable(Class<T> type) {
		List<?> content = schema.get(type);
		if(content == null) throw new IllegalArgumentException("Table " + type + " not found!");
		return (List<T>) schema.get(type);
    }

	@SuppressWarnings("unchecked")
	public <T> List<T> setTable(Class<T> type, List<T> content) {
        schema.put(type, content);
        return (List<T>) schema.get(content.getClass());
    }
}
