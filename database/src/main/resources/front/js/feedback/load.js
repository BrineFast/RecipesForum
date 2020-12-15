window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/feedbacks",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/feedback.html?id=" + value.id.toString() + "'";
                var dish =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.title + "</td>" +
                    "<td class=\"cell100 column2\">" + value.mark +"</td>" +
                    "<td class=\"cell100 column3\">" + value.text + "</td>" +
                    "<td class=\"cell100 column4\">" + value.created.substr(0, 10) + "</td>" +
                    "<td class=\"cell100 column5\">" + value.updated.substr(0, 10) + "</td>" +
                    "</tr>>";
                $("#feedback_table").append(dish);
            })
        }
    });
};