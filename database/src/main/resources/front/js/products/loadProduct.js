window.onload = function () {
    const searchString = new URLSearchParams(window.location.search);
    const id = searchString.get('id');
    $.ajax({
        url: "http://localhost:8080/products/" + id,
        method: "get",
        dataType: "json",
        contentType: "applicationJson",
        success: function(data){
            var redirectCountryUrl = "'http://localhost:4200/country.html?id=" + data.countryId.id.toString() + "'";
            var redirectCompositionUrl = "'http://localhost:4200/composition.html?id=" + data.compositionId.id.toString() + "'";
            var redirectProductTypeUrl = "'http://localhost:4200/product_type.html?id=" + data.typeId.id.toString() + "'";
            var redirectSeasonUrl = "'http://localhost:4200/season.html?id=" + data.seasonId.id.toString() + "'";
                    $("#name_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.name +"</td>" + "</tr>>");
                    $("#price_table").append("<tr class =\"row100 body\">" + "<td class=\"cell100 column1\">" + data.price + "</td>" + "</tr>>");
                    $("#type_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectProductTypeUrl + ";\">" + "<td class=\"cell100 column1\">"  + data.typeId.name + "</td>" + "</tr>>");
                    $("#season_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectSeasonUrl + ";\">" + "<td class=\"cell100 column1\">" + data.seasonId.name + "</td>" + "</tr>>");
                    $("#country_table").append("<tr class =\"row100 body\" onclick=\"location.href=" + redirectCountryUrl + ";\">" + "<td class=\"cell100 column1\">" + data.countryId.name + "</td>" + "</tr>>");
                var composition =
                    "<tr class =\"row100 body\" onclick=\"location.href=" + redirectCompositionUrl + ";\">" +
                    "<td class=\"cell100 column1\">" + data.compositionId.calories + "</td>" +
                    "<td class=\"cell100 column2\">" + data.compositionId.carbohydrates + "</td>" +
                    "<td class=\"cell100 column3\">" + data.compositionId.fats + "</td>" +
                    "<td class=\"cell100 column4\">" + data.compositionId.protein + "</td>" +
                    "<td class=\"cell100 column5\">" + data.compositionId.water + "</td>" +
                    "</tr>>";
                    $("#composition_table").append(composition);
        }
    });
};