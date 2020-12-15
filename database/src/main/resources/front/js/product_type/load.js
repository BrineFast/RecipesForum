window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/product_types",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/product_type.html?id=" + value.id.toString() + "'";
                var product_type =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.id +"</td>" +
                    "<td class=\"cell100 column2\">" + value.name + "</td>" +
                    "</tr>>";
                $("#products_table").append(product_type);
            })
        }
    });
};