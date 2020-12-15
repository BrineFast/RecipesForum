window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/recipe_types/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            var type =
                "<tr class =\"row100 body\">" +
                "<td class=\"cell100 column1\">" + data.id +"</td>" +
                "<td class=\"cell100 column2\">" + data.name + "</td>" +
                "</tr>>";
            $("#products_table").append(type);
        }
    });
};