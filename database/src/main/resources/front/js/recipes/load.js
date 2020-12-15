window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/recipes",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/recipe.html?id=" + value.id.toString() + "'";
                var recipe =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.name +"</td>" +
                    "<td class=\"cell100 column2\">" + value.created.substr(0, 10) + "</td>" +
                    "<td class=\"cell100 column3\">" + value.typeId.name + "</td>" +
                    "<td class=\"cell100 column4\">" + value.groupId.name + "</td>" +
                    "</tr>>";
                $("#recipes_table").append(recipe);
            })
        }
    });
};