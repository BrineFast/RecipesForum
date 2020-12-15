window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/seasons",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/season.html?id=" + value.id.toString() + "'";
                var season =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.id +"</td>" +
                    "<td class=\"cell100 column4\">" + value.name + "</td>" +
                    "<td class=\"cell100 column2\">" + value.start_date.substr(0, 10) + "</td>" +
                    "<td class=\"cell100 column3\">" + value.end_date.substr(0, 10) + "</td>" +
                    "</tr>>";
                $("#recipes_table").append(season);
            })
        }
    });
};