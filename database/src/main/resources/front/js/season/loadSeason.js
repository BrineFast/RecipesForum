window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/seasons/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
                var product =
                    "<tr class =\"row100 body\">" +
                    "<td class=\"cell100 column1\">" + data.id +"</td>" +
                    "<td class=\"cell100 column4\">" + data.name + "</td>" +
                    "<td class=\"cell100 column2\">" + data.start_date.substr(0, 10) + "</td>" +
                    "<td class=\"cell100 column3\">" + data.end_date.substr(0, 10) + "</td>" +
                    "</tr>>";
                $("#recipes_table").append(product);
        }
    });
};