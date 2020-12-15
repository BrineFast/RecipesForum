window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const price = searchString.get('price');
    $.ajax({
        url: "http://localhost:8080/recipes/cheaper_then/" + price,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/recipe.html?id=" + value.id.toString() + "'";
                var recipe =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.id +"</td>" +
                    "<td class=\"cell100 column4\">" + value.calories + "</td>" +
                    "</tr>>";
                $("#recipes_table").append(recipe);
            })
        }
    });
};