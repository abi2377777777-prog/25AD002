const BASE_URL = "/api/fitlog";


/* =====================================================
   LOAD ALL DATA WHEN PAGE OPENS
===================================================== */

document.addEventListener("DOMContentLoaded", function () {

    loadUsers();

    loadWorkouts();

    loadMeals();

    loadGoals();

});



/* =====================================================
   USER
===================================================== */

document.getElementById("userForm").addEventListener("submit", function (event) {

    event.preventDefault();

    const id = document.getElementById("userId").value;


    const user = {

        name: document.getElementById("userName").value,

        email: document.getElementById("userEmail").value,

        age: Number(
            document.getElementById("userAge").value
        ),

        weight: Number(
            document.getElementById("userWeight").value
        ),

        gender: document.getElementById("userGender").value,

        date: document.getElementById("userDate").value

    };


    /* ADD USER */

    if (id === "") {

        fetch(BASE_URL + "/user/create", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(user)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("User not added");
                }

                return response.text();

            })

            .then(() => {

                alert("User added successfully");

                clearUserForm();

                loadUsers();

            })

            .catch(error => {

                console.error(error);

                alert("Error adding user");

            });

    }


    /* UPDATE USER */

    else {

        fetch(BASE_URL + "/user/updateById/" + id, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(user)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("User not updated");
                }

                return response.text();

            })

            .then(() => {

                alert("User updated successfully");

                clearUserForm();

                loadUsers();

            })

            .catch(error => {

                console.error(error);

                alert("Error updating user");

            });

    }

});



/* DISPLAY USERS */

function loadUsers() {

    fetch(BASE_URL + "/user/getall")

        .then(response => {

            if (!response.ok) {
                throw new Error("Users not found");
            }

            return response.json();

        })

        .then(users => {

            const table =
                document.getElementById("userTable");

            table.innerHTML = "";


            users.forEach(user => {

                table.innerHTML += `

                    <tr>

                        <td>${user.id}</td>

                        <td>${user.name}</td>

                        <td>${user.email}</td>

                        <td>${user.age}</td>

                        <td>${user.weight}</td>

                        <td>${user.gender}</td>

                        <td>${user.date || ""}</td>

                        <td>

                            <button
                                class="edit"
                                onclick="editUser(${user.id})">

                                Edit

                            </button>


                            <button
                                class="delete"
                                onclick="deleteUser(${user.id})">

                                Delete

                            </button>

                        </td>

                    </tr>

                `;

            });

        })

        .catch(error => {

            console.error(error);

        });

}



/* EDIT USER */

function editUser(id) {

    fetch(BASE_URL + "/user/getbyid/" + id)

        .then(response => {

            if (!response.ok) {
                throw new Error("User not found");
            }

            return response.json();

        })

        .then(user => {

            document.getElementById("userId").value =
                user.id;

            document.getElementById("userName").value =
                user.name;

            document.getElementById("userEmail").value =
                user.email;

            document.getElementById("userAge").value =
                user.age;

            document.getElementById("userWeight").value =
                user.weight;

            document.getElementById("userGender").value =
                user.gender;


            if (user.date) {

                document.getElementById("userDate").value =
                    user.date.substring(0, 10);

            }


            document.getElementById("userButton").innerText =
                "Update User";

        })

        .catch(error => {

            console.error(error);

            alert("User not found");

        });

}



/* DELETE USER */

function deleteUser(id) {

    if (!confirm("Are you sure you want to delete this user?")) {

        return;

    }


    fetch(BASE_URL + "/user/deleteById/" + id, {

        method: "DELETE"

    })

        .then(response => {

            if (!response.ok) {
                throw new Error("User not deleted");
            }

            return response.text();

        })

        .then(() => {

            alert("User deleted successfully");

            loadUsers();

        })

        .catch(error => {

            console.error(error);

            alert("Error deleting user");

        });

}



/* CLEAR USER */

function clearUserForm() {

    document.getElementById("userForm").reset();

    document.getElementById("userId").value = "";

    document.getElementById("userButton").innerText =
        "Add User";

}



/* =====================================================
   WORKOUT
===================================================== */

document.getElementById("workoutForm").addEventListener("submit", function (event) {

    event.preventDefault();

    const id = document.getElementById("workoutId").value;


    const workout = {

        duration: Number(
            document.getElementById("duration").value
        ),

        caloriesburnt: Number(
            document.getElementById("caloriesburnt").value
        ),

        wktype:
        document.getElementById("wktype").value

    };


    /* ADD WORKOUT */

    if (id === "") {

        fetch(BASE_URL + "/workout/create", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(workout)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Workout not added");
                }

                return response.text();

            })

            .then(() => {

                alert("Workout added successfully");

                clearWorkoutForm();

                loadWorkouts();

            })

            .catch(error => {

                console.error(error);

                alert("Error adding workout");

            });

    }


    /* UPDATE WORKOUT */

    else {

        fetch(BASE_URL + "/workout/updateById/" + id, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(workout)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Workout not updated");
                }

                return response.text();

            })

            .then(() => {

                alert("Workout updated successfully");

                clearWorkoutForm();

                loadWorkouts();

            })

            .catch(error => {

                console.error(error);

                alert("Error updating workout");

            });

    }

});



/* DISPLAY WORKOUTS */

function loadWorkouts() {

    fetch(BASE_URL + "/workout/getall")

        .then(response => response.json())

        .then(workouts => {

            const table =
                document.getElementById("workoutTable");

            table.innerHTML = "";


            workouts.forEach(workout => {

                table.innerHTML += `

                    <tr>

                        <td>${workout.id}</td>

                        <td>${workout.duration}</td>

                        <td>${workout.caloriesburnt}</td>

                        <td>${workout.wktype}</td>

                        <td>

                            <button
                                class="edit"
                                onclick="editWorkout(${workout.id})">

                                Edit

                            </button>


                            <button
                                class="delete"
                                onclick="deleteWorkout(${workout.id})">

                                Delete

                            </button>

                        </td>

                    </tr>

                `;

            });

        })

        .catch(error => {

            console.error(error);

        });

}



/* EDIT WORKOUT */

function editWorkout(id) {

    fetch(BASE_URL + "/workout/getbyid/" + id)

        .then(response => response.json())

        .then(workout => {

            document.getElementById("workoutId").value =
                workout.id;

            document.getElementById("duration").value =
                workout.duration;

            document.getElementById("caloriesburnt").value =
                workout.caloriesburnt;

            document.getElementById("wktype").value =
                workout.wktype;


            document.getElementById("workoutButton").innerText =
                "Update Workout";

        })

        .catch(error => {

            console.error(error);

            alert("Workout not found");

        });

}



/* DELETE WORKOUT */

function deleteWorkout(id) {

    if (!confirm("Are you sure you want to delete this workout?")) {
        return;
    }


    fetch(BASE_URL + "/workout/deleteById/" + id, {

        method: "DELETE"

    })

        .then(response => {

            if (!response.ok) {
                throw new Error("Workout not deleted");
            }

            return response.text();

        })

        .then(() => {

            alert("Workout deleted successfully");

            loadWorkouts();

        })

        .catch(error => {

            console.error(error);

            alert("Error deleting workout");

        });

}



/* CLEAR WORKOUT */

function clearWorkoutForm() {

    document.getElementById("workoutForm").reset();

    document.getElementById("workoutId").value = "";

    document.getElementById("workoutButton").innerText =
        "Add Workout";

}



/* =====================================================
   MEAL
===================================================== */

document.getElementById("mealForm").addEventListener("submit", function (event) {

    event.preventDefault();

    const id = document.getElementById("mealId").value;


    const meal = {

        carb: Number(
            document.getElementById("carb").value
        ),

        protein: Number(
            document.getElementById("protein").value
        ),

        fibre: Number(
            document.getElementById("fibre").value
        ),

        intakecalories: Number(
            document.getElementById("intakecalories").value
        )

    };


    /* ADD MEAL */

    if (id === "") {

        fetch(BASE_URL + "/meal/create", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(meal)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Meal not added");
                }

                return response.text();

            })

            .then(() => {

                alert("Meal added successfully");

                clearMealForm();

                loadMeals();

            })

            .catch(error => {

                console.error(error);

                alert("Error adding meal");

            });

    }


    /* UPDATE MEAL */

    else {

        fetch(BASE_URL + "/meal/updateById/" + id, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(meal)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Meal not updated");
                }

                return response.text();

            })

            .then(() => {

                alert("Meal updated successfully");

                clearMealForm();

                loadMeals();

            })

            .catch(error => {

                console.error(error);

                alert("Error updating meal");

            });

    }

});



/* DISPLAY MEALS */

function loadMeals() {

    fetch(BASE_URL + "/meal/getall")

        .then(response => response.json())

        .then(meals => {

            const table =
                document.getElementById("mealTable");

            table.innerHTML = "";


            meals.forEach(meal => {

                table.innerHTML += `

                    <tr>

                        <td>${meal.id}</td>

                        <td>${meal.carb}</td>

                        <td>${meal.protein}</td>

                        <td>${meal.fibre}</td>

                        <td>${meal.intakecalories}</td>

                        <td>

                            <button
                                class="edit"
                                onclick="editMeal(${meal.id})">

                                Edit

                            </button>


                            <button
                                class="delete"
                                onclick="deleteMeal(${meal.id})">

                                Delete

                            </button>

                        </td>

                    </tr>

                `;

            });

        })

        .catch(error => {

            console.error(error);

        });

}



/* EDIT MEAL */

function editMeal(id) {

    fetch(BASE_URL + "/meal/getbyid/" + id)

        .then(response => response.json())

        .then(meal => {

            document.getElementById("mealId").value =
                meal.id;

            document.getElementById("carb").value =
                meal.carb;

            document.getElementById("protein").value =
                meal.protein;

            document.getElementById("fibre").value =
                meal.fibre;

            document.getElementById("intakecalories").value =
                meal.intakecalories;


            document.getElementById("mealButton").innerText =
                "Update Meal";

        })

        .catch(error => {

            console.error(error);

            alert("Meal not found");

        });

}



/* DELETE MEAL */

function deleteMeal(id) {

    if (!confirm("Are you sure you want to delete this meal?")) {
        return;
    }


    fetch(BASE_URL + "/meal/deleteById/" + id, {

        method: "DELETE"

    })

        .then(response => {

            if (!response.ok) {
                throw new Error("Meal not deleted");
            }

            return response.text();

        })

        .then(() => {

            alert("Meal deleted successfully");

            loadMeals();

        })

        .catch(error => {

            console.error(error);

            alert("Error deleting meal");

        });

}



/* CLEAR MEAL */

function clearMealForm() {

    document.getElementById("mealForm").reset();

    document.getElementById("mealId").value = "";

    document.getElementById("mealButton").innerText =
        "Add Meal";

}



/* =====================================================
   GOAL
===================================================== */

document.getElementById("goalForm").addEventListener("submit", function (event) {

    event.preventDefault();

    const id = document.getElementById("goalId").value;


    const goal = {

        Gweight: Number(
            document.getElementById("Gweight").value
        ),

        period:
        document.getElementById("period").value,

        pweight: Number(
            document.getElementById("pweight").value
        ),

        Rweight: Number(
            document.getElementById("Rweight").value
        )

    };


    /* ADD GOAL */

    if (id === "") {

        fetch(BASE_URL + "/goal/create", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(goal)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Goal not added");
                }

                return response.text();

            })

            .then(() => {

                alert("Goal added successfully");

                clearGoalForm();

                loadGoals();

            })

            .catch(error => {

                console.error(error);

                alert("Error adding goal");

            });

    }


    /* UPDATE GOAL */

    else {

        fetch(BASE_URL + "/goal/updateById/" + id, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(goal)

        })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Goal not updated");
                }

                return response.text();

            })

            .then(() => {

                alert("Goal updated successfully");

                clearGoalForm();

                loadGoals();

            })

            .catch(error => {

                console.error(error);

                alert("Error updating goal");

            });

    }

});



/* DISPLAY GOALS */

function loadGoals() {

    fetch(BASE_URL + "/goal/getall")

        .then(response => response.json())

        .then(goals => {

            const table =
                document.getElementById("goalTable");

            table.innerHTML = "";


            goals.forEach(goal => {

                table.innerHTML += `

                    <tr>

                        <td>${goal.id}</td>

                        <td>${goal.Gweight}</td>

                        <td>${goal.period}</td>

                        <td>${goal.pweight}</td>

                        <td>${goal.Rweight}</td>

                        <td>

                            <button
                                class="edit"
                                onclick="editGoal(${goal.id})">

                                Edit

                            </button>


                            <button
                                class="delete"
                                onclick="deleteGoal(${goal.id})">

                                Delete

                            </button>

                        </td>

                    </tr>

                `;

            });

        })

        .catch(error => {

            console.error(error);

        });

}



/* EDIT GOAL */

function editGoal(id) {

    fetch(BASE_URL + "/goal/getbyid/" + id)

        .then(response => response.json())

        .then(goal => {

            document.getElementById("goalId").value =
                goal.id;

            document.getElementById("Gweight").value =
                goal.Gweight;

            document.getElementById("period").value =
                goal.period;

            document.getElementById("pweight").value =
                goal.pweight;

            document.getElementById("Rweight").value =
                goal.Rweight;


            document.getElementById("goalButton").innerText =
                "Update Goal";

        })

        .catch(error => {

            console.error(error);

            alert("Goal not found");

        });

}



/* DELETE GOAL */

function deleteGoal(id) {

    if (!confirm("Are you sure you want to delete this goal?")) {
        return;
    }


    fetch(BASE_URL + "/goal/deleteById/" + id, {

        method: "DELETE"

    })

        .then(response => {

            if (!response.ok) {
                throw new Error("Goal not deleted");
            }

            return response.text();

        })

        .then(() => {

            alert("Goal deleted successfully");

            loadGoals();

        })

        .catch(error => {

            console.error(error);

            alert("Error deleting goal");

        });

}



/* CLEAR GOAL */

function clearGoalForm() {

    document.getElementById("goalForm").reset();

    document.getElementById("goalId").value = "";

    document.getElementById("goalButton").innerText =
        "Add Goal";

}