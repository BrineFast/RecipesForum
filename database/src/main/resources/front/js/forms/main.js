$("#createCompositionForm").submit(function (e) {
    e.preventDefault();
    let request = {
        water: document.getElementById("water").value,
        calories: document.getElementById("calories").value,
        carbohydrates: document.getElementById("carbohydrates").value,
        fats: document.getElementById("fats").value,
        protein: document.getElementById("protein").value,
    };
    $.ajax({
        url: "http://localhost:8080/compositions/create",
        method: "post",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(request),
        statusCode: {
            200: function (data) {
                window.location.replace("http://localhost:4200/composition.html?id=" + data.id);
            }
        },
        xhrFields: {
            withCredentials: true
        }
    });
});
