window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/compositions",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/composition.html?id=" + value.id.toString() + "'";
                var composition =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.id +"</td>" +
                    "<td class=\"cell100 column2\">" + value.calories + "</td>" +
                    "<td class=\"cell100 column3\">" + value.carbohydrates + "</td>" +
                    "<td class=\"cell100 column4\">" + value.fats + "</td>" +
                    "<td class=\"cell100 column5\">" + value.protein + "</td>" +
                    "<td class=\"cell100 column6\">" + value.water + "</td>" +
                    "</tr>>";
                $("#recipes_table").append(composition);
            })
        }
    });
};