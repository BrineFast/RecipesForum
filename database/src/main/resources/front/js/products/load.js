window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/products",
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            $.each(data, function (key, value) {
                var redirectUrl = "'http://localhost:4200/product.html?id=" + value.id.toString() + "'";
                var product =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + value.name +"</td>" +
                    "<td class=\"cell100 column2\">" + value.price + "</td>" +
                    "<td class=\"cell100 column3\">" + value.typeId.name + "</td>" +
                    "<td class=\"cell100 column4\">" + value.seasonId.name + "</td>" +
                    "</tr>>";
                $("#products_table").append(product);
            })
        }
    });
};