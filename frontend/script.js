const API_URL = "http://localhost:8080";

async function loadTasks() {
    const res = await fetch(`${API_URL}/tasks`);
    const tasks = await res.json();
    const tasksDiv = document.getElementById("tasks");
    tasksDiv.innerHTML = "";
    tasks.forEach(task => {
        const div = document.createElement("div");
        div.className = "task";
        div.innerHTML = `<strong>${task.name}</strong><br>${task.deadline}`;
        tasksDiv.appendChild(div);
    });
}

async function addTask() {
    const name = document.getElementById("name").value;
    const deadline = document.getElementById("deadline").value;
    if (!name || !deadline) {
        alert("Please fill out both fields!");
        return;
    }
    await fetch(`${API_URL}/tasks`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, deadline })
    });
    loadTasks();
}

async function clearTasks() {
    await fetch(`${API_URL}/tasks`, { method: "DELETE" });
    loadTasks();
}

// Load tasks on page load
loadTasks();
