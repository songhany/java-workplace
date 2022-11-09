package udacity.designPattern.singleton;

import java.util.Objects;

public final class Database {  // class is 'final' which means it Can't be Extend
    private static Database database;

    // a Private Constructor means other classes can't create new databases
    private Database() {}  // Database class has private constructor. This make sense for Singleton Pattern. Because the whole point is to ensure there is only ever one instance of database.

    public static Database getInstance() {  // Lazy Initialization: the database connection is only established ONCE the getInstance() method is actually called. But this is not the best way to do lazy initialization in a multi-thread program, because it does not use 'Synchronization'
        if (database == null) {
            database = new Database();
            database.connect("/usr/local/data/users.db");
        }
        return database;
    }

    // Connects to the remote database
    private void connect(String url) {
        Objects.requireNonNull(url);
    }

    public static void main(String[] args) {
        Database a = Database.getInstance();
        Database b = Database.getInstance();

        System.out.println(a == b);  // TRUE. This proves that when you call the getInstance() method twice, the exact same instance is returned.
    }
}
