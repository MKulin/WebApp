function send() {
    var message = {};
    message.text = $("#message").val();
    message.author = $("#author").val();
    $.ajax({
        url: "/profile",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(message),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            $("#chatHistory").html(message.author + " : " + message.text + "\n");
            alert(data);
        }
    });
}