function send() {
    var message = {};
    message.text = $("#message").val();
    message.author = $("#author").val();
    $.ajax({
        url: "#",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(message),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            $("#chatHistory").append(message.author + " : " + message.text);
            alert(data);
        }
    });
}