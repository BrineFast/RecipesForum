window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/dishes/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            var redirectUrl = "'http://localhost:4200/create_dish_feedback.html?id=" + data.id.toString() + "'";
            var dish =
                "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                "<td class=\"cell100 column1\">" + data.title + "</td>" +
                "</tr>>";
            $("#products_table").append(dish);
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