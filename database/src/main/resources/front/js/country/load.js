window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/countries",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/country.html?id=" + value.id.toString() + "'";
                var country =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.id +"</td>" +
                    "<td class=\"cell100 column2\">" + value.name + "</td>" +
                    "</tr>>";
                $("#products_table").append(country);
            })
        }
    });
};