$(document).ready(function(){
    $('#products_table tr').click(function(){
        window.location = $(this).data('href');
        return false;
    });
});