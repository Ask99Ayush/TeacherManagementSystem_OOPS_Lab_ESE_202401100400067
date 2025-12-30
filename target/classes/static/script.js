const API_URL = "http://localhost:8090/teachers";

// Load teachers on page load
window.onload = fetchTeachers;

// CREATE Teacher
function addTeacher() {
    const name = document.getElementById("name").value;
    const subject = document.getElementById("subject").value;

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, subject })
    })
    .then(() => {
        clearForm();
        fetchTeachers();
    });
}

// READ Teachers
function fetchTeachers() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const table = document.getElementById("teacherTable");
            table.innerHTML = "";

            data.forEach(teacher => {
                table.innerHTML += `
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.subject}</td>
                        <td>
                            <button onclick="deleteTeacher(${teacher.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}

// DELETE Teacher
function deleteTeacher(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    }).then(() => fetchTeachers());
}

// Clear input fields
function clearForm() {
    document.getElementById("name").value = "";
    document.getElementById("subject").value = "";
}
