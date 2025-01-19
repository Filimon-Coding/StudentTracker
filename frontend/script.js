const API_URL = "http://localhost:8080";

// Load tasks on page load
document.addEventListener("DOMContentLoaded", loadTasks);

// Fetch all tasks from the backend
async function loadTasks() {
    const response = await fetch(`${API_URL}/tasks`);
    const tasks = await response.json();
    const tasksDiv = document.getElementById("tasks");
    tasksDiv.innerHTML = ""; // Clear previous tasks
    tasks.forEach(task => {
        const taskElement = document.createElement("div");
        taskElement.textContent = `${task.name} - ${task.deadline}`;
        tasksDiv.appendChild(taskElement);
    });
}

// Add a new task
async function addTask() {
    const name = document.getElementById("name").value;
    const deadline = document.getElementById("deadline").value;

    if (!name || !deadline) {
        alert("Please fill out both fields!");
        return;
    }

    const response = await fetch(`${API_URL}/tasks`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, deadline })
    });

    if (response.ok) {
        loadTasks(); // Refresh tasks
    } else {
        console.error("Failed to add task:", response);
        alert("Failed to add task!");
    }
}

// Clear all tasks
async function clearTasks() {
    const response = await fetch(`${API_URL}/tasks`, { method: "DELETE" });
    if (response.ok) {
        loadTasks(); // Refresh tasks
    } else {
        console.error("Failed to clear tasks:", response);
        alert("Failed to clear tasks!");
    }
}
