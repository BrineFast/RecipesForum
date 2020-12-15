window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/recipes/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            var redirectDishUrl = "'http://localhost:4200/dish.html?id=" + data.dishId.id.toString() + "'";
            var redirectGroupUrl = "'http://localhost:4200/recipe_group.html?id=" + data.groupId.id.toString() + "'";
            var redirectTypeUrl = "'http://localhost:4200/recipe_type.html?id=" + data.typeId.id.toString() + "'";
            var redirectSeasonUrl = "'http://localhost:4200/season.html?id=" + data.seasonId.id.toString() + "'";
            var redirectFeedbackUrl = "'http://localhost:4200/create_recipe_feedback.html?id=" + data.id.toString() + "'";
            var editRecipeUrl = "'http://localhost:4200/edit_recipe.html?id=" + data.id.toString() + "'";
                    $("#name_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectFeedbackUrl + ";\">" + "<td class=\"cell100 column1\">" + data.name +"</td>" + "</tr>>");
                    $("#cooking_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + editRecipeUrl + ";\">" + "<td class=\"cell100 column1\">" + data.cookingTechnology + "</td>" + "</tr>>");
                    $("#type_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectTypeUrl + ";\">" + "<td class=\"cell100 column1\">" + data.typeId.name + "</td>" + "</tr>>");
                    $("#group_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectGroupUrl + ";\">" + "<td class=\"cell100 column1\">" + data.groupId.name + "</td>" + "</tr>>");
                    $("#season_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectSeasonUrl + ";\">" + "<td class=\"cell100 column1\">" + data.seasonId.name + "</td>" + "</tr>>");
                    $("#dish_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectDishUrl + ";\">" + "<td class=\"cell100 column1\">" + data.dishId.title + "</td>" + "</tr>>");
                    $("#created_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.created.substr(0, 10) + "</td>" + "</tr>>");
                    $("#updated_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.updated.substr(0, 10) + "</td>" + "</tr>>");
                    console.log(data);
            $.each(data.products, function (key, value) {
                var redirectUrl = "'http://localhost:4200/product.html?id=" + value.id.toString() + "'";
                var product =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.name +"</td>" +
                    "<td class=\"cell100 column2\">" + value.price + "</td>" +
                    "<td class=\"cell100 column3\">" + value.typeId.name + "</td>" +
                    "<td class=\"cell100 column4\">" + value.seasonId.name + "</td>" +
                    "</tr>>";
                $("#products_table").append(product);
                console.log(product);
            })
            $.each(data.country, function (key, value) {
                var redirectUrl = "'http://localhost:4200/country.html?id=" + value.id.toString() + "'";
                $("#countries_table").append(
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.name +"</td></tr>");
            })
            $.each(data.feedbacks, function (key, value) {
                var redirectUrl = "'http://localhost:4200/feedback.html?id=" + value.id.toString() + "'";
                var feedback =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.title +"</td>" +
                    "<td class=\"cell100 column2\">" + value.mark + "</td>" +
                    "<td class=\"cell100 column3\">" + value.text + "</td>" +
                    "<td class=\"cell100 column4\">" + value.created.substr(0,10) + "</td>" +
                    "</tr>>";
                $("#feedbacks_table").append(feedback);
            })
        }
    });
};