package by.training.finalproject.connectionPool;

import java.sql.Connection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static ConnectionPool instance = null;
    private LinkedBlockingQueue<Connection> availableConnections = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Connection> usedConnections = new LinkedBlockingQueue<>();
    private static Lock lock = new ReentrantLock();
    private ConnectionCreator connectionCreator = new ConnectionCreator();

    private ConnectionPool(int initConnection) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < initConnection; i++) {
            availableConnections.offer(connectionCreator.createConnection());
        }
    }

    public static ConnectionPool getInstance() {
        lock.lock();
        try {
            if (instance == null){
                instance = new ConnectionPool(21);
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public Connection retrieveConnection() {
        Connection connection = null;
        try {
            if (availableConnections.size() > 0) {
                connection = availableConnections.take();
            } else {
                availableConnections.offer(connectionCreator.createConnection());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        usedConnections.offer(connection);
        return connection;
    }

    public void putbackConnection(Connection connection) {
        try {
            if (connection != null) {
                if (usedConnections.remove(connection)) {
                    availableConnections.put(connection);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfAvailableConnections() {
        return availableConnections.size();
    }
}