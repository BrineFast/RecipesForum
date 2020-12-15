window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/feedbacks/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
                $("#title_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.title +"</td>" + "</tr>>");
                $("#mark_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.mark +"</td>" + "</tr>>");
                $("#text_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.text + "</td>" + "</tr>>");
                $("#created_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.created.substr(0, 10) + "</td>" + "</tr>>");
                $("#updated_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.updated.substr(0, 10) + "</td>" + "</tr>>");
        }
    });
};