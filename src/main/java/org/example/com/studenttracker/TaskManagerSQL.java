package org.example.com.studenttracker;

import com.google.gson.Gson;
import java.sql.*;
import java.util.*;
import static spark.Spark.*;

public class TaskManagerSQL {
    static Connection conn;

    public static void main(String[] args) {
        Gson gson = new Gson();

        // Set the port before defining routes
        port(8080);

        // Enable CORS (must be done before defining routes)
        enableCORS();

        // Initialize the database connection
        setupDatabase();

        // Define the routes
        get("/tasks", (req, res) -> {
            List<Map<String, String>> tasks = new ArrayList<>();
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");
                while (rs.next()) {
                    Map<String, String> task = new HashMap<>();
                    task.put("id", String.valueOf(rs.getInt("id")));
                    task.put("name", rs.getString("name"));
                    task.put("deadline", rs.getString("deadline"));
                    tasks.add(task);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return gson.toJson(tasks);
        });

        post("/tasks", (req, res) -> {
            Map<String, String> task = gson.fromJson(req.body(), Map.class);
            try {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO tasks (name, deadline) VALUES (?, ?)");
                stmt.setString(1, task.get("name"));
                stmt.setString(2, task.get("deadline"));
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                res.status(500);
                return "Error adding task";
            }
            return "Task added";
        });

        delete("/tasks", (req, res) -> {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("DELETE FROM tasks");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "All tasks cleared";
        });
    }

    private static void setupDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:tasks.db");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS tasks (id INTEGER PRIMARY KEY, name TEXT, deadline TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void enableCORS() {
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));
        options("/*", (req, res) -> {
            String headers = req.headers("Access-Control-Request-Headers");
            if (headers != null) {
                res.header("Access-Control-Allow-Headers", headers);
            }
            String method = req.headers("Access-Control-Request-Method");
            if (method != null) {
                res.header("Access-Control-Allow-Methods", method);
            }
            return "OK";
        });
    }
}
