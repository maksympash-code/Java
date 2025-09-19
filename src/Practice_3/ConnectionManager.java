package Practice_3;

public class ConnectionManager {
    private final Connection[] pool;
    private final boolean[] busy;

    public ConnectionManager(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("capacity must be > 0");

        this.pool = new Connection[size];
        this.busy = new boolean[size];
        for (int i = 0; i < size; i++) pool[i] = new Connection(i);
    }

    public Connection elem() {
        for (int i = 0; i < pool.length; i++) {
            if (!busy[i]) {
                busy[i] = true;
                return pool[i];
            }
        }
        throw new NoAvailableConnectionsException("No free connections in pool");
    }

    public void release(Connection c) {
        if (c == null) return;
        int id = c.id;
        if (id < 0 || id >= pool.length || pool[id] != c) {
            throw new IllegalArgumentException("Foreign connection");
        }
        if (!busy[id]) throw new IllegalStateException("Connection already released");
        busy[id] = false;
    }

    public int available() {
        int free = 0;
        for (boolean b : busy) if (!b) free++;
        return free;
    }

    public static final class Connection {
        private final int id;
        private Connection(int id) { this.id = id; }
        public int getId() { return id; }
    }

    public static class NoAvailableConnectionsException extends RuntimeException {
        public NoAvailableConnectionsException(String msg) { super(msg); }
    }

    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager(2);
        Connection a = cm.elem();
        Connection b = cm.elem();
        System.out.println("available = " + cm.available());

        try {
            cm.elem();
        } catch (NoAvailableConnectionsException e) {
            System.out.println("Expected: " + e.getMessage());
        }

        cm.release(a);
        System.out.println("available = " + cm.available());

        Connection c = cm.elem();
        System.out.println("c id = " + c.getId());
    }
}
