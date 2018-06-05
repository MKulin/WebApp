function send() {
    var message = {};
    message.text = $("#message").val();
    message.author = $("#author").val();
    /*$.ajax({
        url: "/profile",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(message),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function () {
            $("#chatHistory").html(message.author + " : " + message.text + "\n");
            alert("success");
        },
        error: function() {
            alert("error");
        },
        done: function () {
            alert("done");
        }
    });*/
    $.post("/profile", message, function () {
        $("#chatHistory").append().html(message.author + " : " + message.text + "\n");
    });
}