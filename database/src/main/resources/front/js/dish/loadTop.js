window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/dishes/top",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/dish.html?id=" + value.dish_id.toString() + "'";
                var dish =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.dish_id +"</td>" +
                    "<td class=\"cell100 column2\">" + value.feedback_count + "</td>" +
                    "</tr>>";
                console.log(value)
                $("#products_table").append(dish);
            })
        }
    });
};