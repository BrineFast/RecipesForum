window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/compositions/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            var editCompositionUrl = "'http://localhost:4200/edit_composition.html?id=" + data.id.toString() + "'";
                var product =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + editCompositionUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + data.id +"</td>" +
                    "<td class=\"cell100 column2\">" + data.calories + "</td>" +
                    "<td class=\"cell100 column3\">" + data.carbohydrates + "</td>" +
                    "<td class=\"cell100 column4\">" + data.fats + "</td>" +
                    "<td class=\"cell100 column5\">" + data.protein + "</td>" +
                    "<td class=\"cell100 column6\">" + data.water + "</td>" +
                    "</tr>>";
                $("#recipes_table").append(product);
        }
    });
};